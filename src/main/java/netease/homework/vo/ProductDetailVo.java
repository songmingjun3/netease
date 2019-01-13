package netease.homework.vo;

import java.math.BigDecimal;

/**
 * Author SMJ
 * 商品详情VIEW OBJECT
 */
public class ProductDetailVo {
    private Integer productId;

    private String title;

    private String description;

    private String content;

    private String picture;

    private BigDecimal price;

    private boolean hasBuyed;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public boolean isHasBuyed() {
        return hasBuyed;
    }

    public void setHasBuyed(boolean hasBuyed) {
        this.hasBuyed = hasBuyed;
    }

    public BigDecimal getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(BigDecimal buyPrice) {
        this.buyPrice = buyPrice;
    }

    private BigDecimal buyPrice;
}
