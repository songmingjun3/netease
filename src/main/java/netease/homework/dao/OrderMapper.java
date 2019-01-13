package netease.homework.dao;

import netease.homework.bean.Order;

import java.math.BigDecimal;

public interface OrderMapper {
    int deleteByPrimaryKey(int orderNo);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(int orderNo);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);


}