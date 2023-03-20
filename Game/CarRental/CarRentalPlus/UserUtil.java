package com.zhiyou.Game.CarRental.CarRentalPlus;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserUtil implements Serializable{
    static Scanner sc = new Scanner(System.in);
    static CarUtil cu = new CarUtil();
    public void init() throws Exception{
        File f = new File("D:\\Temp\\User.txt");
        if (!f.exists()){
            Role admin = Role.Admin;
            Role user = Role.User;
            User u1 = new User("Tom","Tom123",admin);
            User u2 = new User("123","123123",admin);
            User u3 = new User("Jay","Jay123",user);
            List<User> list = new ArrayList<>();
            list.add(u1);
            list.add(u2);
            list.add(u3);
            saveUser(list);
        }
    }

    public void saveUser(List<User> list) throws Exception{
        File f = new File("D:\\Temp\\User.txt");
        FileOutputStream fos = new FileOutputStream(f);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(list);
        oos.close();
    }

    public List<User> getUserList() throws Exception{
        File f = new File("D:\\Temp\\User.txt");
        FileInputStream fis = new FileInputStream(f);
        ObjectInputStream ois = new ObjectInputStream(fis);
        List<User> list = (List<User>) ois.readObject();
        ois.close();
        return list;
    }

    public User login() throws Exception{
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名");
        String usernName = sc.next();
        System.out.println("请输入密码");
        String password = sc.next();
        List<User> list = getUserList();

        for (User user : list) {
            if (usernName.equals(user.getUserName()) && password.equals(user.getPassword())){
                return user;
            }
        }
        return null;
    }

    //==================管理员功能
    public void adminOperation() throws Exception{
        while (true) {
            System.out.println("==================管理员功能" + "\n" +
                    "1.查看所有租赁汽车信息" + "\n" +
                    "2.根据车牌号查询汽车信息" + "\n" +
                    "3.租赁汽车" + "\n" +
                    "4.归还汽车" + "\n" +
                    "5.上架汽车" + "\n" +
                    "6.下架汽车" + "\n" +
                    "7.系统退出" + "\n" +
                    "请选择(1-7)");
            String choice = sc.next();
            switch (choice){
                case "1":
                    cu.printCars();
                    break;
                case "2":
                    cu.printCar();
                    break;
                case "3":
                    cu.BorrowCar();
                    break;
                case "4":
                    cu.ReturnCar();
                    break;
                case "5":
                    cu.AddCar();
                    break;
                case "6":
                    cu.DelCar();
                    break;
                case "7":
                    System.out.println("------System End------");
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }

    //==================用户功能
    public void userOperation()  throws Exception{
        while (true) {
            System.out.println("==================用户功能" + "\n" +
                    "1.查看所有租赁汽车信息" + "\n" +
                    "2.根据车牌号查询汽车信息" + "\n" +
                    "3.租赁汽车" + "\n" +
                    "4.归还汽车" + "\n" +
                    "5.系统退出" + "\n" +
                    "请选择(1-5)");
            String choice = sc.next();
            switch (choice){
                case "1":
                    cu.printCars();
                    break;
                case "2":
                    cu.printCar();
                    break;
                case "3":
                    cu.BorrowCar();
                    break;
                case "4":
                    cu.ReturnCar();
                    break;
                case "5":
                    System.out.println("------System End------");
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }
}
