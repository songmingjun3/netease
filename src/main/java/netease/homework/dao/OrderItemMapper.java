package netease.homework.dao;

import netease.homework.bean.OrderItem;

public interface OrderItemMapper {
    int deleteByPrimaryKey(Integer orderItemId);

    int insert(OrderItem record);

    int insertSelective(OrderItem record);

    OrderItem selectByPrimaryKey(Integer orderItemId);

    int updateByPrimaryKeySelective(OrderItem record);

    int updateByPrimaryKey(OrderItem record);
}