package netease.homework.bean;

import java.math.BigDecimal;

public class OrderItem {
    private Integer orderItemId;

    private Integer productId;

    private String title;

    private String picture;

    private BigDecimal price;

    private Integer buyCounts;

    private Integer orderNo;

    private Integer userId;

    private Integer status;

    public OrderItem(Integer orderItemId, Integer productId, String title, String picture, BigDecimal price, Integer buyCounts, Integer orderNo, Integer userId, Integer status) {
        this.orderItemId = orderItemId;
        this.productId = productId;
        this.title = title;
        this.picture = picture;
        this.price = price;
        this.buyCounts = buyCounts;
        this.orderNo = orderNo;
        this.userId = userId;
        this.status = status;
    }

    public OrderItem() {
        super();
    }

    public Integer getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Integer orderItemId) {
        this.orderItemId = orderItemId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getBuyCounts() {
        return buyCounts;
    }

    public void setBuyCounts(Integer buyCounts) {
        this.buyCounts = buyCounts;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}