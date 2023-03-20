package com.zhiyou.Game.LibraryManagementSystem.LibraryManagementSystem;

public class Book {
    private String[] bookNames = {"挪威森林", "孙子兵法", "百年孤独", "编程思想",null,null};
    private String[] authors = {" 村上春树 ", " 孙膑 ", " 高斯林 ", " 詹姆斯 ",null,null};
    private int[] status = {0,0,1,0,0,0};
    private int[] dates = {0,0,7,0,0,0};
    private int[] returnDates = {0,0,0,0,0,0};

    public Book() {
    }

    public Book(String[] bookNames, String[] authors, int[] status, int[] dates, int[] returnDates) {
        this.bookNames = bookNames;
        this.authors = authors;
        this.status = status;
        this.dates = dates;
        this.returnDates = returnDates;
    }
    /**
     * 获取
     * @return bookNames
     */
    public String[] getBookNames() {
        return bookNames;
    }

    /**
     * 设置
     * @param bookNames
     */
    public void setBookNames(String[] bookNames) {
        this.bookNames = bookNames;
    }

    /**
     * 获取
     * @return authors
     */
    public String[] getAuthors() {
        return authors;
    }

    /**
     * 设置
     * @param authors
     */
    public void setAuthors(String[] authors) {
        this.authors = authors;
    }

    /**
     * 获取
     * @return status
     */
    public int[] getStatus() {
        return status;
    }

    /**
     * 设置
     * @param status
     */
    public void setStatus(int[] status) {
        this.status = status;
    }

    /**
     * 获取
     * @return dates
     */
    public int[] getDates() {
        return dates;
    }

    /**
     * 设置
     * @param dates
     */
    public void setDates(int[] dates) {
        this.dates = dates;
    }

    /**
     * 获取
     * @return returnDates
     */
    public int[] getReturnDates() {
        return returnDates;
    }

    /**
     * 设置
     * @param returnDates
     */
    public void setReturnDates(int[] returnDates) {
        this.returnDates = returnDates;
    }

    public String toString() {
        return "Book{bookNames = " + bookNames + ", authors = " + authors + ", status = " + status + ", dates = " + dates + ", returnDates = " + returnDates + "}";
    }
}
