package com.zhiyou.Game.LibraryManagementSystem.Plus02_LibraryManagementSystem;

import java.util.ArrayList;

public class Init {
    public static void init(){
        Menu menu = new Menu();
        ArrayList<User> users = new ArrayList<>();
        ArrayList<Book> books = new ArrayList<>();
        ArrayList<Gift> gifts = new ArrayList<>();
        users.add(new User("Tom", "Tom", "OC"));
        users.add( new User("John", "John", "OC"));
        users.add( new User("Jane", "Jane", "OC"));
        users.add(new User("123","123","VIP"));
        users.add(new User("1","1","OC"));
        books.add(new Book(10001, "鬼吹灯","天下霸唱","2008-7-1",27.8,80));
        books.add(new Book(10002, "魔戒","莫尔斯","2005-3-14",54.0,50));
        books.add(new Book(10003, "哈利波特","罗琳","2003-2-14",43.5,30));
        books.add(new Book(10004, "时间机器","威尔","1965-3-3",21.3,5));
        books.add(new Book(10005, "宇宙奥秘","霍金","2003-12-23",87.3,30));
        gifts.add(new Gift("CD", 27.5));
        gifts.add(new Gift("包装", 2.7));
        gifts.add(new Gift("钢笔", 10));
        gifts.add(new Gift("不需要",0));
        menu.displayMenu(users,books,gifts);
    }
}
