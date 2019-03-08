package lesson35.model;

import lesson35.enums.UserType;

public class User {
    private long id;
    private String userName;
    private String password;
    private String country;
    private UserType userType;


    public User(long id) {
        this.id = id;
    }

    public User(long id, String userName, String password, String country, UserType userType) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.country = country;
        this.userType = userType;
    }

    public User(String userName, String password, String country, UserType userType) {
        this.userName = userName;
        this.password = password;
        this.country = country;
        this.userType = userType;
    }

    public long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getCountry() {
        return country;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return id + "," + userName + "," + password + "," + country + "," + userType;
    }
}
