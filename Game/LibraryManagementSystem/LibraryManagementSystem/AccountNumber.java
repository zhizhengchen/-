package com.zhiyou.Game.LibraryManagementSystem.LibraryManagementSystem;

public class AccountNumber {
    private String[] userName = new String[7];
    private String[] password = new String[7];
    public void accountNumber(String[] userName,String[] password){
        this.userName = userName;
        this.password = password;
    }
    public void setPassword(String[] password) {
        this.password = password;
    }
    public String[] getPassword() {
        return password;
    }
    public void setUserName(String[] userName) {
        this.userName = userName;
    }
    public String[] getUserName() {
        return userName;
    }
}
