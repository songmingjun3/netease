package netease.homework.dao;

import netease.homework.bean.Product;

import java.util.List;

public interface ProductMapper {
    int deleteByPrimaryKey(int productId);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer productId);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

    //查询销售量
    int selectSaleCountByProductId(Integer productId);

    //查询所有商品列表
    List<Product> selectAllProductList();

    //查询卖家商品列表
    List<Product> selectSellerProductList(int userId);

    //查询买家未购买的商品列表
    List<Product> selectNoBuyProductList(int userId);

    //查询买家已经购买的商品列表
    List<Product> selectHasBuyProductByUserId(int userId);
}