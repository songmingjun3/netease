package netease.homework.bean;

import java.math.BigDecimal;
import java.util.Date;

public class Order {
    private Integer orderNo;

    private Integer userId;

    private Date createTime;

    private BigDecimal totalPrice;

    private Date updateTime;

    public Order(Integer orderNo, Integer userId, Date createTime, BigDecimal totalPrice, Date updateTime) {
        this.orderNo = orderNo;
        this.userId = userId;
        this.createTime = createTime;
        this.totalPrice = totalPrice;
        this.updateTime = updateTime;
    }

    public Order() {
        super();
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}