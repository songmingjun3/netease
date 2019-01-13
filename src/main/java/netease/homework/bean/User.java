package netease.homework.bean;

public class User {
    private Integer userId;

    private String username;

    private String password;

    private Integer salerorbuyer;

    public User(Integer userId, String username, String password, Integer salerorbuyer) {
        this.userId = userId;
        this.username = username;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
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