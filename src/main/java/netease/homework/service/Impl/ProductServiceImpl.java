package netease.homework.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import netease.homework.bean.Product;
import netease.homework.common.ResponseCode;
import netease.homework.common.ServerResponse;
import netease.homework.dao.OrderItemMapper;
import netease.homework.dao.ProductMapper;
import netease.homework.service.IProductService;
import netease.homework.vo.ProductDetailVo;
import netease.homework.vo.ProductInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Author SMJ
 */
@Service("iProductService")
public class ProductServiceImpl implements IProductService{

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private OrderItemMapper orderItemMapper;
    /**
     * 发布和更新商品
     * @param product
     * @return
     */
    public ServerResponse saveOrUpdateProduct(Product product){
        if (product!=null){
            if (product.getProductId()!=null){
                int rowCount=productMapper.updateByPrimaryKey(product);
                if (rowCount>0){
                    return ServerResponse.createBySuccess("更新产品成功");
                }
                return ServerResponse.createByErrorMsg("更新产品失败");
            }else {
                int rowCount=productMapper.insert(product);
                if (rowCount>0){
                    return ServerResponse.createBySuccess("新增产品成功");
                }
                return ServerResponse.createByErrorMsg("新增产品失败");
            }
        }
        return ServerResponse.createByErrorMsg("新增或者更新产品参数不正确");
    }

    /**
     *更新商品销售数量
     * @param productId
     * @param count，为本此卖出的数量
     * @return
     */
    public ServerResponse<String> updateSaleCount(Integer productId,Integer count){
        if (productId==null||count==null){
            return ServerResponse.createByErrorCodeMsg(ResponseCode.ILLEGAL_ARGUMENT.getCode(),
                    ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        Product product = new Product();
        product.setProductId(productId);
        int oldCount = productMapper.selectSaleCountByProductId(productId);
        int newCount = oldCount+count;
        product.setSaleCounts(newCount);
        int result = productMapper.updateByPrimaryKeySelective(product);
        if (result>0){
            return ServerResponse.createBySuccess("更新商品销售量成功");
        }else{
            return ServerResponse.createByErrorMsg("更新商品销售量失败");
        }
    }

    /**
     * 获得商品详情
     * @param productId
     * @return
     */
     public ServerResponse<ProductDetailVo> getProductDetail(Integer productId){
         if (productId==null){
             return ServerResponse.createByErrorCodeMsg(ResponseCode.ILLEGAL_ARGUMENT.getCode(),
                     ResponseCode.ILLEGAL_ARGUMENT.getDesc());
         }
         Product product=productMapper.selectByPrimaryKey(productId);
         if (product==null){
             return ServerResponse.createByErrorMsg("商品已删除或者下架");
         }
         ProductDetailVo productDetailVo = assembleProductDetailVo(product);
         return ServerResponse.createBySuccess(productDetailVo);
     }

    /**
     * 卖家查看商品详情
     * @param productId
     * @return
     */
    public ServerResponse<ProductDetailVo> getSellerProductDetail(Integer productId){
        if (productId==null){
            return ServerResponse.createByErrorCodeMsg(ResponseCode.ILLEGAL_ARGUMENT.getCode(),
                    ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        Product product=productMapper.selectByPrimaryKey(productId.intValue());
        if (product==null){
            return ServerResponse.createByErrorMsg("商品已删除或者下架");
        }
        ProductDetailVo productDetailVo = assembleProductDetailVo(product);
        return ServerResponse.createBySuccess(productDetailVo);
    }

    /**
     * 买家查看商品详情
     * @param productId
     * @return
     */
    public ServerResponse<ProductDetailVo> getBuyerProductDetail(Integer userId,Integer productId){
        if (productId==null|| userId==null){
            return ServerResponse.createByErrorCodeMsg(ResponseCode.ILLEGAL_ARGUMENT.getCode(),
                    ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        Product product=productMapper.selectByPrimaryKey(productId);
        if (product==null){
            return ServerResponse.createByErrorMsg("商品已删除或者下架");
        }
        ProductDetailVo productDetailVo = assembleProductDetailVo(product);
        BigDecimal buyPrice = orderItemMapper.selectPriceByUserIdAndProductId(userId,productId);
        //如果在订单项中存在，则说明已经购买该商品，则设置购买价格
        if (buyPrice!=null){
            productDetailVo.setHasBuyed(true);
            productDetailVo.setBuyPrice(buyPrice);
        }
        return ServerResponse.createBySuccess(productDetailVo);
    }
    /**
     * 拷贝Product bean 到ProductDetailVo
     * @param product
     * @return
     */
    private ProductDetailVo assembleProductDetailVo(Product product){
        ProductDetailVo productDetailVo = new ProductDetailVo();
        //购买价格默认为商品当前价格
        productDetailVo.setBuyPrice(product.getPrice());
        productDetailVo.setPrice(product.getPrice());
        productDetailVo.setProductId(product.getProductId());
        productDetailVo.setTitle(product.getTitle());
        productDetailVo.setDescription(product.getDescription());
        productDetailVo.setContent(product.getContent());
        productDetailVo.setPicture(product.getPicture());
        //默认未购买
        productDetailVo.setHasBuyed(false);
        return productDetailVo;
    }

    /**
     * 拷贝Product bean 到ProductInfoVo
     * @param product
     * @return
     */
    private ProductInfoVo assembleProductInfoVo(Product product){
        ProductInfoVo productInfoVo = new ProductInfoVo();
        productInfoVo.setProductId(product.getProductId());
        productInfoVo.setTitle(product.getTitle());
        productInfoVo.setPicture(product.getPicture());
        productInfoVo.setPrice(product.getPrice());
        productInfoVo.setSaleCounts(product.getSaleCounts());
        //默认未购买商品
        productInfoVo.setHasBuyed(false);
        return productInfoVo;
    }

    /**
     * 首页商品列表
     * @param pageNum
     * @param pageSize
     * @return
     */
    public ServerResponse getAllProductList(int pageNum,int pageSize){
        List<Product> productList = productMapper.selectAllProductList();
        return beanToVo(productList,pageNum,pageSize);
    }

    /**
     * 买家商品列表，包括已购买列表和未购买列表
     * @param pageNum
     * @param pageSize
     * @return
     */
    public ServerResponse getBuyerProductList(int  userId,int pageNum,int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<ProductInfoVo> productInfoVos = new ArrayList<>();
        //查询已购买清单并添加到列表
        List<Product>  products= productMapper.selectHasBuyProductByUserId(userId);
        for (Product product:products){
            ProductInfoVo productInfoVo = assembleProductInfoVo(product);
            productInfoVo.setHasBuyed(true);
            productInfoVos.add(productInfoVo);
        }

        //查询未购买的商品并添加到列表
        List<Product> productList = productMapper.selectNoBuyProductList(userId);
        for (Product productItem :productList){
            productInfoVos.add(assembleProductInfoVo(productItem));
        }

        PageInfo pageResult = new PageInfo(productInfoVos);
        return ServerResponse.createBySuccess(pageResult);
    }

    /**
     * 买家未购买商品列表
     * @param pageNum
     * @param pageSize
     * @return
     */
    public ServerResponse getNotBuyProductList(int userId,int pageNum,int pageSize){
        List<Product> productList = productMapper.selectNoBuyProductList(userId);
        return beanToVo(productList,pageNum,pageSize);
    }

    /**
     * 卖家商品列表，显示已经出售标记
     * @param pageNum
     * @param pageSize
     * @return
     */
    public ServerResponse getSellerProductList(int userId,int pageNum,int pageSize){
        List<Product> productList = productMapper.selectSellerProductList(userId);
        return beanToVo(productList,pageNum,pageSize);
    }

    /**
     * 内部函数，用于将bean列表封装成VO列表
     * @param productList
     * @param pageNum
     * @param pageSize
     * @return
     */
    private ServerResponse beanToVo(List<Product> productList,int pageNum,int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<ProductInfoVo> productInfoVos = new ArrayList<>();
        for (Product productItem:productList){
            productInfoVos.add(assembleProductInfoVo(productItem));
        }
        PageInfo pageResult = new PageInfo(productInfoVos);
        return ServerResponse.createBySuccess(pageResult);
    }
}
