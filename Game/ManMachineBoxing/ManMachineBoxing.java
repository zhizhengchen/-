package com.zhiyou.Game.ManMachineBoxing;

import java.util.Scanner;

/**
 * 人机猜拳
 * 五局三胜
 * 每局五小局
 * 可以选择对手角色，输入自己的名字
 * 游戏可以重复运行
 */
public class ManMachineBoxing {
    Scanner input = new Scanner(System.in);

    //游戏
    public void playGame() {
        //选择对手角色
        String computerName = selectRole();
        //设置自己名字
        String personName = setRoleName();
        //游戏是否开始
        startGame(personName, computerName);
    }

    //选择对手角色
    public String selectRole() {
        String computerName = "";
        System.out.println("请选择出战人（1.刘备 2.孙权 3.曹操）");
        int choice = input.nextInt();
        switch (choice) {
            case 1:
                computerName = "刘备";
                break;
            case 2:
                computerName = "孙权";
                break;
            case 3:
                computerName = "曹操";
                break;
        }
        System.out.println("对手名字：" + computerName);
        return computerName;
    }

    //输入名字
    public String setRoleName() {
        System.out.println("请输入自己的名字");
        String personName = input.next();
        System.out.println("你的名字:" + personName);
        return personName;
    }

    //开始游戏
    public void startGame(String personName, String computerName) {
        System.out.println("是否开始新游戏(Y/N)");
        String con = input.next();
        if ("y".equals(con) || "Y".equals(con)) {
            System.out.println(personName + " VS " + computerName);
            //记录总分数
            int[] totalScore = {0, 0};
            //对战多少局
            for (int i = 1; i <= 5; i++) {
                System.out.println("开始第" + i + "局游戏");
                //每一局初始化得分，记录每局分数
                int[] score = {0, 0};
                //每局对战多少次
                for (int j = 1; j <= 5; j++) {
                    System.out.println("开始第" + i + " - " + j + "局游戏");
                    //进入游戏主体，返回得分
                    score = Game(personName, computerName, score);
                }
                System.out.println("========================");
                if (score[0] > score[1]) {
                    totalScore[0]++;
                    System.out.println(personName + "小局胜");
                } else if (score[0] < score[1]) {
                    totalScore[1]++;
                    System.out.println(computerName + "小局胜");
                } else {
                    System.out.println("小局平局");
                }
            }
            System.out.println("========================");
            if (totalScore[0] > totalScore[1]) {
                System.out.println(personName + "大局胜");
            } else if (totalScore[0] < totalScore[1]) {
                System.out.println(computerName + "大局胜");
            } else {
                System.out.println("大局平局");
            }
            //游戏循环
            startGame(personName, computerName);
        } else {
            System.out.println("程序结束");
        }
    }

    //游戏主体，判断胜负
    public int[] Game(String personName, String computerName, int[] score) {
        System.out.println("请出拳 1.剪刀 2.石头 3.布");
        int personChoice = input.nextInt();
        int computerChoice = ((int) (Math.random() * 3) + 1);
        switch (personChoice) {
            case 1:
                System.out.println(personName + "出拳：剪刀");
                break;
            case 2:
                System.out.println(personName + "出拳：石头");
                break;
            case 3:
                System.out.println(personName + "出拳：布");
                break;
        }
        switch (computerChoice) {
            case 1:
                System.out.println(computerName + "出拳：剪刀");
                break;
            case 2:
                System.out.println(computerName + "出拳：石头");
                break;
            case 3:

                System.out.println(computerName + "出拳：布");
                break;
        }
        if (personChoice == 1 && computerChoice == 3 ||
                personChoice == 2 && computerChoice == 1 ||
                personChoice == 3 && computerChoice == 2) {
            score[0]++;
            System.out.println(personName + "胜利");
        } else if (personChoice == computerChoice) {
            System.out.println("平局");
        } else {
            score[1]++;
            System.out.println(computerName + "胜利");
        }
        return score;
    }
}
