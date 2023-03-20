package com.zhiyou.Game.LibraryManagementSystem.LibraryManagementSystem;

public class Test {
    static AccountNumber a = new AccountNumber();
    static Menu menu = new Menu();

    public static void main(String[] args) {
        String[] userName = new String[7];
        String[] password = new String[7];
        userName[0] = "admin";
        password[0] = "admin";
        userName[1] = "user";
        password[1] = "user";
        userName[2] = "123";
        password[2] = "123";
        //a.accountNumber(userName, password);
        a.setUserName(userName);
        a.setPassword(password);
        menu.Menu(a);
    }
}
