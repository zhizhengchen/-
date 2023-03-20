package com.zhiyou.Game.LibraryManagementSystem.Plus02_LibraryManagementSystem;

public class ShopCar {
    private Book book;
    private int bookNum;
    private Gift gift;
    private int giftNum;

    public ShopCar() {
    }

    public ShopCar(Book book, int bookNum, Gift gift, int giftNum) {
        this.book = book;
        this.bookNum = bookNum;
        this.gift = gift;
        this.giftNum = giftNum;
    }

    public String toString() {
        return book.getName() + "\t\t" + book.getPrice() + "\t\t" + bookNum + "\n" +
                gift.getName() + "\t\t" + gift.getPrice() + "\t\t"  + giftNum;
    }

    /**
     * 获取
     * @return book
     */
    public Book getBook() {
        return book;
    }

    /**
     * 设置
     * @param book
     */
    public void setBook(Book book) {
        this.book = book;
    }

    /**
     * 获取
     * @return bookNum
     */
    public int getBookNum() {
        return bookNum;
    }

    /**
     * 设置
     * @param bookNum
     */
    public void setBookNum(int bookNum) {
        this.bookNum = bookNum;
    }

    /**
     * 获取
     * @return gift
     */
    public Gift getGift() {
        return gift;
    }

    /**
     * 设置
     * @param gift
     */
    public void setGift(Gift gift) {
        this.gift = gift;
    }

    /**
     * 获取
     * @return giftNum
     */
    public int getGiftNum() {
        return giftNum;
    }

    /**
     * 设置
     * @param giftNum
     */
    public void setGiftNum(int giftNum) {
        this.giftNum = giftNum;
    }
}
