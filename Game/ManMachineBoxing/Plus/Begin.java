package com.zhiyou.Game.ManMachineBoxing.Plus;

import java.util.Random;
import java.util.Scanner;

public class Begin {
    static Random random = new Random();
    static Scanner input = new Scanner(System.in);
    static Exc exc = new Exc();
    public void begin() {
        String personName, PCName = null;
        System.out.println("====== 游戏开始 ======");
        System.out.println("选择对手角色");
        PCName = selectRole();
        personName = getName();
        System.out.println(personName + " VS " + PCName);
        Game(personName,PCName);
    }

    public String selectRole(){
        int number = 0;
        String name = null;
        System.out.println("请选择角色");
        System.out.println("1. 刘备" +
                "2. 张飞" +
                "3. 关羽");
        while(number == 0){
            try {
                number = exc.getNumber();
            }catch (Exception e){
                System.out.println(e);
            }
        }
        switch (number){
            case 1:
                name = "刘备";
                break;
            case 2:
                name = "张飞";
                break;
            case 3:
                name = "关羽";
                break;
        }
        return name;
    }

    public String getName(){
        String personName = null;
        System.out.println("请输入您的名称");
        personName = input.next();
        return personName;
    }

    public String personGesture(){
        int number = 0;
        String gesture = null;
        System.out.println("请选择");
        System.out.println("1. 剪刀" +
                "2. 石头" +
                "3. 布");
        while(number == 0){
            try {
                number = exc.getNumber();
            }catch (Exception e){
                System.out.println(e);
            }
        }
        switch (number){
            case 1:
                gesture = "剪刀";
                break;
            case 2:
                gesture = "石头";
                break;
            case 3:
                gesture = "布";
                break;
        }
        return gesture;
    }

    public String PCGesture(){
        int number = 0;
        String gesture = null;
        number =random.nextInt(3) + 1;
        switch (number){
            case 1:
                gesture = "剪刀";
                break;
            case 2:
                gesture = "石头";
                break;
            case 3:
                gesture = "布";
                break;
        }
        return gesture;
    }

    public void Game(String personName, String PCName) {

        int PCScore=0,personScore=0,count = 0;
        while(count <3){
            System.out.println("====== 第" + (count+1) + "次对局 ======");
            int num = isWin();
            if (num == 1){
                System.out.println(personName + "胜利");
                personScore++;
            }else if (num == 2){
                System.out.println(PCName + "胜利");
                PCScore++;
            }else if (num == 0){
                System.out.println("平局");
            }
            System.out.println("====== 积分 ======");
            System.out.println(personName + "\t积分\t" + personScore);
            System.out.println(PCName + "\t积分\t" + PCScore);
            count++;
        }
        if (personScore == PCScore){
            System.out.println("平局");
        }else{String winer = personScore > PCScore? personName : PCName;
            System.out.println("====== " + winer + "胜利 ======");
        }
    }

    public int isWin(){
        int num = 0;
        String personGesture,PCGesture = null;

        personGesture = personGesture();
        PCGesture = PCGesture();

        System.out.println("你选择出: " + personGesture);
        System.out.println("机器人出: " + PCGesture);

        if (personGesture.equals(PCGesture)){
            num = 0;
        }else if ((personGesture.equals("剪刀") && PCGesture.equals("布"))
        ||(personGesture.equals("石头") && PCGesture.equals("剪刀"))
        ||(personGesture.equals("布") && PCGesture.equals("石头"))){
            num = 1;
        }else if ((PCGesture.equals("剪刀") && personGesture.equals("布"))
                ||(PCGesture.equals("石头") && personGesture.equals("剪刀"))
                ||(PCGesture.equals("布") && personGesture.equals("石头"))){
            num = 2;
        }
        return num;
    }
}
