package com.zhiyou.Game.LibraryManagementSystem.Plus_LibraryManagementSystem;

public class Account {
    private String accountNumber;
    private String password;
    private String status;

    public Account() {
    }

    public Account(String accountNumber, String password, String status) {
        this.accountNumber = accountNumber;
        this.password = password;
        this.status = status;
    }

    /**
     * 获取
     * @return accountNumber
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * 设置
     * @param accountNumber
     */
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
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

    public String toString() {
        return "Account{accountNumber = " + accountNumber + ", password = " + password + ", status = " + status + "}";
    }
}
