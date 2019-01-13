package netease.homework.vo;

import java.math.BigDecimal;

/**
 * Author SMJ
 * 商品展示页面的VIEW OBJECT
 */
public class ProductInfoVo {
    private Integer productId;

    private String title;

    private String picture;

    private BigDecimal price;

    private Integer saleCounts;  //用于判断是否出售

    private boolean hasBuyed; //用于标记是否购买


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
        this.title = title;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getSaleCounts() {
        return saleCounts;
    }

    public void setSaleCounts(Integer saleCounts) {
        this.saleCounts = saleCounts;
    }

    public boolean isHasBuyed() {
        return hasBuyed;
    }

    public void setHasBuyed(boolean hasBuyed) {
        this.hasBuyed = hasBuyed;
    }

}
