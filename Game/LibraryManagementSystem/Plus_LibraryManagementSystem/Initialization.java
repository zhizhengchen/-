package com.zhiyou.Game.LibraryManagementSystem.Plus_LibraryManagementSystem;

import java.util.Date;

public class Initialization {
    public void initialize(){
        Book[] books = new Book[10];

        Book book1 = new Book("123","123","不可借",new Date(2023,3,1),null,3);
        Book book2 = new Book("丰乳肥臀","莫言","可借",new Date(2023,3,3),null,4);
        Book book3 = new Book("世界无敌","我编的","可借",null,null,5);

        books[0] = book1;
        books[1] = book2;
        books[2] = book3;

        Account[] accounts = new Account[10];

        Account account1 = new Account("123","123","admin");
        Account account2 = new Account("Lily","123","admin");
        Account account3 = new Account("Tom","123","user");

        accounts[0] = account1;
        accounts[1] = account2;
        accounts[2] = account3;

        OperationMenu opMenu = new OperationMenu();

        //进入菜单
        opMenu.operationMenu(accounts,books);
    }
}
