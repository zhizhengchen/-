package com.zhiyou.Game.LibraryManagementSystem.Plus02_LibraryManagementSystem;

public class User {
    private String name;
    private String password;
    private String root;

    public User() {
    }

    public User(String name, String password, String root) {
        this.name = name;
        this.password = password;
        this.root = root;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
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
     * @return root
     */
    public String getRoot() {
        return root;
    }

    /**
     * 设置
     * @param root
     */
    public void setRoot(String root) {
        this.root = root;
    }

    public String toString() {
        return "com.zhiyou.Game.Plus02_LibraryManagementSystem.User{name = " + name + ", password = " + password + ", root = " + root + "}";
    }
}
