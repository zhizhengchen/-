package com.zhiyou.Game.CarRental.CarRentalPlus;

import java.io.Serializable;

public class User implements Serializable {
    private String userName;
    private String password;
    private Role role;

    public User() {
    }

    public User(String userName, String password, Role role) {
        this.userName = userName;
        this.password = password;
        this.role = role;
    }

    /**
     * 获取
     * @return userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取
     * @return role
     */
    public Role getRole() {
        return role;
    }

    /**
     * 设置
     * @param role
     */
    public void setRole(Role role) {
        this.role = role;
    }

    public String toString() {
        return "User{userName = " + userName + ", password = " + password + ", role = " + role + "}";
    }
}
