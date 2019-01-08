package netease.homework.bean;

import java.math.BigDecimal;

public class Product {
    private Integer productId;

    private String title;

    private String description;

    private String content;

    private String picture;

    private Integer salerId;

    private BigDecimal price;

    private Integer saleCounts;

    public Product(Integer productId, String title, String description, String content, String picture, Integer salerId, BigDecimal price, Integer saleCounts) {
        this.productId = productId;
        this.title = title;
        this.description = description;
        this.content = content;
        this.picture = picture;
        this.salerId = salerId;
        this.price = price;
        this.saleCounts = saleCounts;
    }

    public Product() {
        super();
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

    public Integer getSalerId() {
        return salerId;
    }

    public void setSalerId(Integer salerId) {
        this.salerId = salerId;
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
}