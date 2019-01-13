package netease.homework.dao;

import netease.homework.bean.OrderItem;
import netease.homework.bean.Product;

import java.math.BigDecimal;
import java.util.List;

public interface OrderItemMapper {
    int deleteByPrimaryKey(int orderItemId);

    int insert(OrderItem record);

    int insertSelective(OrderItem record);

    OrderItem selectByPrimaryKey(int orderItemId);

    int updateByPrimaryKeySelective(OrderItem record);

    int updateByPrimaryKey(OrderItem record);

    BigDecimal selectPriceByUserIdAndProductId(Integer userId, Integer productId);

    //查询某个用户已经购买的商品清单
    List<OrderItem> selectOrderItemByUserId(int userId);

    //List<Product> selectHasBuyProductByUserId(int userId);
}