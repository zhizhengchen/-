package com.zhiyou.Game.ManMachineBoxing.Plus2;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Person person = new Person();
        Computer computer = new Computer();

        System.out.println("\t\t******************\t\t");
        System.out.println("\t\t****** 猜拳 开始 ******\t\t");
        System.out.println("\t\t******************\t\t");
        System.out.println("出拳规则: 1. 剪刀 2. 石头 3. 布 (1-3请输入相应数字)");

        System.out.println("请选择角色");
        computer.setName();
        person.setName();

        System.out.println(person.getName() + " VS " + computer.getName());
        System.out.println("准备好了吗？---------(Y/N)");
        String con = input.next();
        if ("y".equals(con)||"Y".equals(con)) {
            do {

                compare(person,computer);
                System.out.println("是否开始下一局？---------(Y/N)");
                con = input.next();
            }while ("y".equals(con)||"Y".equals(con));

            System.out.println(person.getName() + " 的积分: " + person.getScore());
            System.out.println(computer.getName() + " 的积分: " + computer.getScore());
            if (person.getScore() > computer.getScore()) {
                System.out.println("结果是: " + person.getName() + " 赢了 ");
            }else if (person.getScore() < computer.getScore()) {
                System.out.println("结果是: " + computer.getName() + " 赢了 ");
            }else{
                System.out.println("结果是: 平局");
            }
        }else {
            System.out.println("程序结束");
            System.exit(0);
        }
    }
    public static void compare(Person person,Computer computer) {

        int personFist = person.showFist();
        int computerFist = computer.showFist();

        if (personFist == computerFist) {
            System.out.println("这局是平局");
        }else if ((personFist==1 && computerFist==3)
        || (personFist==2 && computerFist == 1)
        || (personFist==3 && computerFist == 2)){
            person.setScore(person.getScore() + 1);
            System.out.println("恭喜你，你赢了");
        }else if ((personFist==3 && computerFist==1)
        || (personFist==1 && computerFist==2)
        || (personFist==2 && computerFist == 3)){
            System.out.println("很遗憾，你输了");
            computer.setScore(person.getScore() + 1);
        }
    }
}
