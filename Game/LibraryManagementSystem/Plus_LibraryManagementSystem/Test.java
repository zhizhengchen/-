package com.zhiyou.Game.LibraryManagementSystem.Plus_LibraryManagementSystem;

public class Test {
    /**
     * 图书管理系统
     * 账号和图书两个对象
     * 菜单分为账号菜单和图书菜单
     * 账号菜单
     *      登录
     *      注册
     * 图书菜单
     *      查看全部图书
     *      查询某一图书
     *      借出图书
     *      归还图书
     *      上架图书
     *      下架图书
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("=====图书管理系统=====");
        Initialization initialization = new Initialization();
        initialization.initialize();
    }

}
