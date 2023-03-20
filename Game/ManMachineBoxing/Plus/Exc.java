package com.zhiyou.Game.ManMachineBoxing.Plus;

import java.util.Scanner;

public class Exc {

    static Scanner input = new Scanner(System.in);
    public int getNumber() throws Exception {
        int choice = input.nextInt();
        if (choice >= 1 && choice <= 3){
            return choice;
        }else{
            throw new Exception("输入错误,只能选择1-3");
        }
    }
}
