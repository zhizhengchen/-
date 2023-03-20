package com.zhiyou.Game.ManMachineBoxing.Plus2;

import java.util.Scanner;

public class Person {
    Scanner input = new Scanner(System.in);
    private String name;
    private int score;

    public int showFist(){
        System.out.println("请出拳: 1. 剪刀 2. 石头 3. 布 (1-3请输入相应数字)");
        String choice = input.next();
        switch (choice){
            case "1":
                System.out.println("你出拳:  剪刀");
                return 1;
            case "2":
                System.out.println("你出拳:  石头");
                return 2;
            case "3":
                System.out.println("你出拳:  布");
                return 3;
            default:
                System.out.println("输入有误，请重新输入");
                return showFist();
        }
    }



    public Person() {
    }

    public Person(String name, int score) {
        this.name = name;
        this.score = score;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     */
    public void setName() {
        System.out.println("请输入你的名字");
        this.name = input.next();
    }

    /**
     * 获取
     * @return score
     */
    public int getScore() {
        return score;
    }

    /**
     * 设置
     */
    public void setScore(int score) {
        this.score = score;
    }

    public String toString() {
        return "Person{name = " + name + ", score = " + score + "}";
    }
}
