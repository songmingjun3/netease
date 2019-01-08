package netease.homework.dao;

import netease.homework.bean.Order;

public interface OrderMapper {
    int deleteByPrimaryKey(Integer orderNo);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer orderNo);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
}