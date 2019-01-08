package netease.homework.bean;

public class User {
    private Integer userId;

    private String name;

    private String password;

    private Integer salerorbuyer;

    public User(Integer userId, String name, String password, Integer salerorbuyer) {
        this.userId = userId;
        this.name = name;
        this.password = password;
        this.salerorbuyer = salerorbuyer;
    }

    public User() {
        super();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getSalerorbuyer() {
        return salerorbuyer;
    }

    public void setSalerorbuyer(Integer salerorbuyer) {
        this.salerorbuyer = salerorbuyer;
    }
}