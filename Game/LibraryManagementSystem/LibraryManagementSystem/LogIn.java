package com.zhiyou.Game.LibraryManagementSystem.LibraryManagementSystem;

import java.util.Scanner;

public class LogIn {
    static Scanner input = new Scanner(System.in);
    static Operation Op = new Operation();
    static Menu Menu = new Menu();
    public static void LogIn(AccountNumber a) {
        boolean flag = false;
        int index = -1;
        System.out.println("请输入账号");
        String tempUserName = input.next();

        System.out.println("请输入密码");
        String tempPassword = input.next();

        for (int i = 0; i < a.getUserName().length; i++) {
            if ((tempUserName.equals(a.getUserName()[i])) && (tempPassword.equals(a.getPassword()[i]))) {
                index = i;
                flag = true;
            }
        }
        if (flag) {
            System.out.println("登录成功");
            System.out.println(" 欢迎回来 ");
            System.out.println("尊敬的 " + a.getUserName()[index]);
            Op.operation(a.getUserName()[index],a.getPassword()[index],a);
        } else {
            System.out.println("登录失败");
            Menu.Menu(a);
        }
    }
}
