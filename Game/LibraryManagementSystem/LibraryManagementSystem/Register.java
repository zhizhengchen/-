package com.zhiyou.Game.LibraryManagementSystem.LibraryManagementSystem;

import java.util.Scanner;

public class Register {
    static LogIn SI = new LogIn();
    static Scanner input = new Scanner(System.in);
    public static AccountNumber register(AccountNumber a) {
        for (int i = 0; i <a.getUserName().length ; i++) {
            if (a.getUserName()[i]==null){
                System.out.println("请输入要注册的账号");
                String userName = input.next();
                for (int j = 0; j < a.getUserName().length; j++) {
                    if (userName.equals(a.getUserName()[j])){
                        System.out.println("账号已存在，注册失败");
                        return a;
                    }
                }
                System.out.println("请输入密码");
                String password1 = input.next();
                System.out.println("请再次输入密码");
                String password2 = input.next();
                if (password1.equals(password2)){
                    String password = password2;
                    a.getUserName()[i] = userName;
                    a.getPassword()[i] = password;
                    System.out.println("注册成功");
                    System.out.println("账号：" + a.getUserName()[i]);
                    System.out.println("密码：" + a.getPassword()[i]);
                    SI.LogIn(a);
                    return a;
                }else{
                    System.out.println("两次密码不一致");
                    register(a);
                    return a;
                }
            }
        }
        System.out.println("用户已达上限，请联系管理员");
        return a;
    }
}
