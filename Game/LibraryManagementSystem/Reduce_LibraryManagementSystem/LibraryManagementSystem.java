package com.zhiyou.Game.LibraryManagementSystem.Reduce_LibraryManagementSystem;

import java.util.Scanner;

public class LibraryManagementSystem {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        String[] bookNames = {"挪威森林", "孙子兵法", "百年孤独", "编程思想", null, null};
        String[] authors = {" 村上春树 ", " 孙膑 ", " 高斯林 ", " 詹姆斯 ", null, null};
        int[] status = {0, 0, 1, 0, 0, 0};
        int[] dates = {0, 0, 7, 0, 0, 0};
        int[] returnDates = {0, 0, 0, 0, 0, 0};
        int[] counts = {0, 1, 2, 3, 4, 5};
        System.out.println("欢迎来到图书管理系统");
        System.out.println("==================");
        System.out.println("1. 查看所有图书");
        System.out.println("2. 根据名字查看图书");
        System.out.println("3. 图书借阅");
        System.out.println("4. 图书归还");
        System.out.println("5. 图书上架");
        System.out.println("6. 图书下架");
        System.out.println("0. 系统退出");
        System.out.println("请选择");
        int choice = input.nextInt();
        switch (choice) {
            case 1:
                System.out.println("书名" + "\t" + "作者" + "\t" + "借出日期" + "\t" + "归还日期" + "\t" + "状态" + "\t" + "借出次数");
                for (int i = 0; i < bookNames.length; i++) {
                    if (bookNames[i] == null) {
                        break;
                    }
                    if (status[i] == 0) {
                        System.out.println(bookNames[i] + "\t" + authors[i] + "\t" + dates[i] + "\t" + returnDates[i] + "\t" + " 可借 " + "\t" + counts[i]);
                    } else if (status[i] == 1) {
                        System.out.println(bookNames[i] + "\t" + authors[i] + "\t" + dates[i] + "\t" + returnDates[i] + "\t" + " 不可借 " + "\t" + counts[i]);
                    }
                }
                break;
            case 2:
                System.out.println("请输入图书名字");
                String bookName  = input.next();
                for (int i = 0; i < bookNames.length; i++) {
                    if (bookNames[i].equals(bookName)) {
                        System.out.println("书名" + "\t" + "作者" + "\t" + "借出日期" + "\t" + "归还日期" + "\t" + "状态" + "\t" + "借出次数");
                        if (status[i] == 0) {
                            System.out.println(bookNames[i] + "\t" + authors[i] + "\t" + dates[i] + "\t" + returnDates[i] + "\t" + " 可借 " + "\t" + counts[i]);
                        } else if (status[i] == 1) {
                            System.out.println(bookNames[i] + "\t" + authors[i] + "\t" + dates[i] + "\t" + returnDates[i] + "\t" + " 不可借 " + "\t" + counts[i]);
                        }
                        break;
                    }
                    else if (i == bookNames.length - 1) {
                        System.out.println("没有找到该书籍");
                    }
                }
                break;
            case 3:
                System.out.println("请输入图书名字");
                bookName  = input.next();
                for (int i = 0; i < bookNames.length; i++) {
                    if (bookNames[i].equals(bookName)) {
                        System.out.println("书名" + "\t" + "作者" + "\t" + "借出日期" + "\t" + "归还日期" + "\t" + "状态" + "\t" + "借出次数");
                        if (status[i] == 0) {
                            System.out.println(bookNames[i] + "\t" + authors[i] + "\t" + dates[i] + "\t" + returnDates[i] + "\t" + " 可借 " + "\t" + counts[i]);
                            System.out.println("图书未借出，可借");
                            System.out.println("请输入借书日期");
                            dates[i] = input.nextInt();
                            status[i] = 1;
                            counts[i]++;
                            System.out.println(bookNames[i] + "\t" + authors[i] + "\t" + dates[i] + "\t" + returnDates[i] + "\t" + " 不可借 " + "\t" + counts[i]);
                        } else if (status[i] == 1) {
                            System.out.println("图书借出，不可借");
                            System.out.println(bookNames[i] + "\t" + authors[i] + "\t" + dates[i] + "\t" + returnDates[i] + "\t" + " 不可借 " + "\t" + counts[i]);
                        }
                        break;
                    }
                    else if (i == bookNames.length - 1) {
                        System.out.println("没有找到该书籍");
                    }
                }
                break;
            case 4:System.out.println("请输入图书名字");
                bookName  = input.next();
                for (int i = 0; i < bookNames.length; i++) {
                    if (bookNames[i].equals(bookName)) {
                        System.out.println("书名" + "\t" + "作者" + "\t" + "借出日期" + "\t" + "归还日期" + "\t" + "状态" + "\t" + "借出次数");
                        if (status[i] == 0) {
                            System.out.println(bookNames[i] + "\t" + authors[i] + "\t" + dates[i] + "\t" + returnDates[i] + "\t" + " 可借 " + "\t" + counts[i]);
                            System.out.println("图书未借出，不可还");
                            System.out.println(bookNames[i] + "\t" + authors[i] + "\t" + dates[i] + "\t" + returnDates[i] + "\t" + " 可借 " + "\t" + counts[i]);
                        } else if (status[i] == 1) {
                            System.out.println(bookNames[i] + "\t" + authors[i] + "\t" + dates[i] + "\t" + returnDates[i] + "\t" + " 不可借 " + "\t" + counts[i]);
                            System.out.println("请输入归还日期");
                            returnDates[i] = input.nextInt();
                            System.out.println("租金是" + Math.abs(returnDates[i] - dates[i]));
                            dates[i] = 0;
                            returnDates[i] = 0;
                            status[i] = 0;
                            status[i] = 0;System.out.println("图书归还成功");
                            System.out.println(bookNames[i] + "\t" + authors[i] + "\t" + dates[i] + "\t" + returnDates[i] + "\t" + " 可借 " + "\t" + counts[i]);
                        }
                        break;
                    }
                    else if (i == bookNames.length - 1) {
                        System.out.println("没有找到该书籍");
                    }
                }
                break;
            case 5:
                boolean flag = false;
                int index = -1;
                for (int i = 0; i < bookNames.length; i++) {
                    if (bookNames[i] == null){
                        index = i;
                        flag = true;
                    }
                }
                if (flag){
                    System.out.println("请输入要上架的图书的名字");
                    bookName = input.next();
                    for (int i = 0; i < bookNames.length ; i++) {
                        if (bookNames[i]==null){
                            continue;
                        }else if (bookNames[i].equals(bookName)){
                            System.out.println("图书已存在,不可上架");
                            flag = false;
                            index = i;
                        }
                    }
                    if (flag){
                        System.out.println("请输入作者名字");
                        bookNames[index] = bookName;
                        authors[index] = input.next();
                        status[index] = 0;
                        dates[index] = 0;
                        returnDates[index]  = 0;
                        counts[index] = 0;
                        System.out.println("上架成功");
                    }
                }else{
                    System.out.println("没有空位置，书架已满");
                }
                break;
            case 6:
                flag = false;
                index = -1;
                System.out.println("请输入要下架的图书的名字");
                bookName = input.next();
                for (int i = 0; i < bookNames.length ; i++) {
                    if (bookNames[i] == null){
                        continue;
                    }else if (bookNames[i].equals(bookName)){
                        flag = true;
                        index = i;
                    }
                }
                if (flag){
                    if (status[index] == 1){
                        System.out.println("图书已借出,不能下架");
                    }else if (status[index] == 0){
                        bookNames[index] = null;
                        authors[index] = null;
                        status[index] = 0;
                        dates[index] = 0;
                        returnDates[index]  = 0;
                        counts[index] = 0;
                        System.out.println("下架成功");
                    }
                }else{
                    System.out.println("图书不存在，不能下架");
                }
                break;
            case 0:
                System.exit(0);
                break;
            default:
                break;
        }
    }
}
