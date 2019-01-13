package netease.homework.service;

import netease.homework.bean.Product;
import netease.homework.common.ServerResponse;
import netease.homework.vo.ProductDetailVo;
import netease.homework.vo.ProductInfoVo;

/**
 * Author SMJ
 */
public interface IProductService {
    ServerResponse saveOrUpdateProduct(Product product);

    ServerResponse<String> updateSaleCount(Integer productId,Integer count);

    ServerResponse<ProductDetailVo> getSellerProductDetail(Integer productId);

    ServerResponse<ProductDetailVo> getBuyerProductDetail(Integer userId, Integer productId);

    ServerResponse<ProductDetailVo> getProductDetail(Integer productId);

    ServerResponse<ProductInfoVo> getAllProductList(int pageNum, int pageSize);

    ServerResponse getSellerProductList(int userId,int pageNum,int pageSize);

    ServerResponse getNotBuyProductList(int userId,int pageNum,int pageSize);

    ServerResponse getBuyerProductList(int userId,int pageNum,int pageSize);
}
