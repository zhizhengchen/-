package com.zhiyou.Game.LibraryManagementSystem.Plus_LibraryManagementSystem;

import java.util.Date;

public class Book {
    private String name;
    private String author;
    private String status;
    private Date borrwoDate;
    private Date returnDate;
    private int count;

    public Book() {
    }

    public Book(String name, String author, String status, Date borrwoDate, Date returnDate, int count) {
        this.name = name;
        this.author = author;
        this.status = status;
        this.borrwoDate = borrwoDate;
        this.returnDate = returnDate;
        this.count = count;
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
     * @return status
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 获取
     * @return borrwoDate
     */
    public Date getBorrwoDate() {
        return borrwoDate;
    }

    /**
     * 设置
     * @param borrwoDate
     */
    public void setBorrwoDate(Date borrwoDate) {
        this.borrwoDate = borrwoDate;
    }

    /**
     * 获取
     * @return returnDate
     */
    public Date getReturnDate() {
        return returnDate;
    }

    /**
     * 设置
     * @param returnDate
     */
    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    /**
     * 获取
     * @return count
     */
    public int getCount() {
        return count;
    }

    /**
     * 设置
     * @param count
     */
    public void setCount(int count) {
        this.count = count;
    }

    public String toString() {
        return "Book{name = " + name + ", author = " + author + ", status = " + status + ", borrwoDate = " + borrwoDate + ", returnDate = " + returnDate + ", count = " + count + "}";
    }
}
