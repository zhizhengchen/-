package com.zhiyou.Game;

import java.util.Scanner;


public class NotSaySeven {
    public static void main(String[] args) {
        startGame();
    }
    //顺序输入，不能包含'7'，或者‘7’的倍数;
    //如果该输入得数字是包含'7'，或者‘7’的倍数,
    //只要不输入包含'7'，或者‘7’的倍数的数字即可;
    public static void startGame() {
        Scanner input = new Scanner(System.in);
        int score = 0;
        int beginNum = (int) (Math.random() * 10) + 1;
            System.out.println("游戏开始从" + beginNum + "开始输入");
            for (int i = beginNum; i > 0; i++) {
                int temp = input.nextInt();
                if (Game(i)) {
                    if (i == temp) {
                        score++;
                    } else {
                        System.out.println("输入错误");
                        break;
                        }
                } else {
                    if (i == temp) {
                        System.out.println("输入错误");
                        break;
                    }
                    score++;
                }
            }
        System.out.println("得分为" + score);
    }

    //判断是否为7的倍数或者包含7
    //是或者包含返回false否则返回true
    public static boolean Game(int a) {
        if (a % 7 == 0) {
            System.out.println(a + "为7的倍数");
            return false;
        }
        while (a > 0) {
            if (a % 10 == 7) {
                System.out.println(a + "包含7");
                return false;
            } else {
                if (a < 10) {
                    return true;
                }
                a /= 10;
            }
        }
        return true;
    }
}
