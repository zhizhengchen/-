package com.zhiyou.Game.LibraryManagementSystem.Plus02_LibraryManagementSystem;

import javax.xml.crypto.Data;

public class Book {
    private int id;
    private String name;
    private String author;
    private String date;
    private double price;
    private int sum;

    public Book() {
    }

    public Book(int id, String name, String author, String date, double price, int sum) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.date = date;
        this.price = price;
        this.sum = sum;
    }

    /**
     * 获取
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(int id) {
        this.id = id;
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
     * @return author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * 设置
     * @param author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * 获取
     * @return date
     */
    public String getDate() {
        return date;
    }

    /**
     * 设置
     * @param date
     */
    public void setDate(String date) {
        this.date = date;
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

    /**
     * 获取
     * @return sum
     */
    public int getSum() {
        return sum;
    }

    /**
     * 设置
     * @param sum
     */
    public void setSum(int sum) {
        this.sum = sum;
    }

    public String toString() {
        return id + "\t\t" + name + "\t\t" + author + "\t\t" + date + "\t\t" + price + "\t\t" + sum;
    }
}
