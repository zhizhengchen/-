package com.zhiyou.Game.ManMachineBoxing.Plus2;

import java.util.Scanner;

public class Computer {
    private String name ;
    private int score;

    public int showFist(){
        int fist  = (int) (Math.random() * 3)+1;
        String choice = String.valueOf(fist);
        switch (choice){
            case "1":
                System.out.println(name + "出拳:  剪刀");
                return 1;
            case "2":
                System.out.println(name + "出拳:  石头");
                return 2;
            case "3":
                System.out.println(name + "出拳:  布");
                return 3;
            default:
                System.out.println("输入有误，请重新输入");
                return showFist();
        }
    }

    public Computer() {
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
    public String setName() {
        String PCName;
        System.out.println("请选择对方角色(1. 刘备 2. 孙权 3. 张飞 )");
        String roleName = new Scanner(System.in).next();
        switch (roleName) {
            case "1":
                PCName = "刘备";
                break;
            case "2":
                PCName = "孙权";
                break;
            case"3":
                PCName = "张飞";
                break;
            default:
                System.out.println("输入错误");
                PCName = setName();
        }
        this.name = PCName;
        return this.name;
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
        return "Computer{name = " + name + ", score = " + score + "}";
    }
}
