package com.zhiyou.Game.LibraryManagementSystem.Plus02_LibraryManagementSystem;

public class Gift {
    private String name;
    private double price;

    public Gift() {
    }

    public Gift(String name, double price) {
        this.name = name;
        this.price = price;
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
     * @return price
     */
    public double getPrice() {
        return price;
    }

    /**
     * 设置
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    public String toString() {
        return "com.zhiyou.Game.Plus02_LibraryManagementSystem.Gift{name = " + name + ", price = " + price + "}";
    }
}
