package com.zhiyou.Game.LibraryManagementSystem.LibraryManagementSystem;

import java.util.Scanner;
public class Menu {
    static AccountNumber a = new AccountNumber();
    static Register R = new Register();
    static LogIn SI = new LogIn();
    static Scanner input = new Scanner(System.in);
    public static void Menu(AccountNumber a) {
        System.out.println("=== Welcome to LibraryManagentSystem ===");
        System.out.println(" 1.  Register");
        System.out.println(" 2.  Log On");
        System.out.println(" 3.  Contact Us");
        System.out.println(" 0.  Exit");
        System.out.println("请选择");
        switch (input.nextInt()){
            case 0:
                System.out.println("程序结束");
                System.exit(0);
            case 1:
                R.register(a);
                Menu(a);
                break;
            case 2:
                SI.LogIn(a);
                Menu(a);
                break;
            case 3:
                System.out.println("You can contact us in the following ways");
                System.out.println("QQ:" + " 467137030 \n" +
                        "VX:" + " 17633673827 \n" +
                        "Twitter" + " @Chen002436 ");
                System.out.println();
                Menu(a);
                break;
            default:
                Menu(a);
        }
    }
}
