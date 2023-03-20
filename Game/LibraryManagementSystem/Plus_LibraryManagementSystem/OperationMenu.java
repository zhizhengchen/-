package com.zhiyou.Game.LibraryManagementSystem.Plus_LibraryManagementSystem;

import java.util.Date;
import java.util.Scanner;

public class OperationMenu {
    static Scanner  input = new Scanner(System.in);
    static DateTest data = new DateTest();
    public void operationMenu(Account[] accounts, Book[] book) {
        operationAccount(accounts,book);
    }

    public void operationBook(Account[] accounts, Account account, Book[] book) {
        if (account.getStatus().equals("admin")){
            boolean flag = true;
            while(flag){
                System.out.println("请选择要进行的操作");
                System.out.println("1. 查看所有图书");
                System.out.println("2. 查询图书");
                System.out.println("3. 借阅图书");
                System.out.println("4. 归还图书");
                System.out.println("5. 上架图书");
                System.out.println("6. 下架图书");
                System.out.println("7. 重新登录");
                System.out.println("8. 退出");
                int choice = input.nextInt();
                switch (choice){
                    case 1:
                        System.out.println("查看所有图书");
                        showAllBookInfo(book);
                        break;
                    case 2:
                        System.out.println("查询图书");
                        System.out.println("请输入图书名字");
                        String bookName = input.next();
                        findBookInfo(book,bookName);
                        break;
                    case 3:
                        System.out.println("借阅图书");
                        borrowBook(book);
                        break;
                    case 4:
                        System.out.println("归还图书");
                        returnBook(book);
                        break;
                    case 5:
                        System.out.println("上架图书");
                        addBook(book);
                        showAllBookInfo(book);
                        break;
                    case 6:
                        System.out.println("下架图书");
                        delBook(book);
                        showAllBookInfo(book);
                        break;
                    case 7:
                        System.out.println("返回菜单");
                        operationAccount(accounts,book);
                        break;
                    case 8:
                        System.out.println("程序结束");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("输入错误");
                }
            }
        }else{
            boolean flag = true;
            while(flag){
                System.out.println("请选择要进行的操作");
                System.out.println("1. 查看所有图书");
                System.out.println("2. 查询图书");
                System.out.println("3. 借阅图书");
                System.out.println("4. 归还图书");
                System.out.println("5. 重新登录");
                System.out.println("6.退出");
                int choice = input.nextInt();
                switch (choice){
                    case 1:
                        System.out.println("查看所有图书");
                        showAllBookInfo(book);
                        break;
                    case 2:
                        System.out.println("查询图书");
                        System.out.println("请输入图书名字");
                        String bookName = input.next();
                        findBookInfo(book,bookName);
                        break;
                    case 3:
                        System.out.println("借阅图书");
                        borrowBook(book);
                        break;
                    case 4:
                        System.out.println("归还图书");
                        returnBook(book);
                        break;
                    case 5:
                        System.out.println("返回菜单");
                        operationAccount(accounts,book);
                        break;
                    case 6:
                        System.out.println("程序结束");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("输入错误");
                }
            }
        }
    }

    public void operationAccount(Account[] accounts, Book[] book) {
        boolean flag = true;
        while (flag) {

        System.out.println("请选择您的操作");
        System.out.println("1. 登录");
        System.out.println("2. 注册");
        System.out.println("3. 退出");
        int choice = input.nextInt();
        switch (choice) {
            case 1:
                login(accounts,book);
                break;
            case 2:
                register(accounts,book);
                break;
            case 3:
                System.out.println("感谢使用");
                System.exit(0);
            default:
                System.out.println("输入错误");
            }
        }
    }

    public void register(Account[] accounts, Book[] book){
        boolean flag = false;
        int index = 0;
        System.out.println("请输入用户名");
        String userName = input.next();
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] == null){
                flag = true;
                index = i;
                continue;
            }
            if (accounts[i].getAccountNumber().equals(userName)){
                System.out.println("用户名重复，不能注册");
                return;
            }
        }
        if (flag){
            System.out.println("请输入密码");
            String password = input.next();
            System.out.println("请再次输入密码");
            String password2 = input.next();
            System.out.println("默认为用户");
            if (password.equals(password2)){
                Account tempAccount = new Account(userName,password,"user");
                accounts[index] = tempAccount;
                login(accounts,book);
            }else{
                System.out.println("两次密码输入不一致，请重新注册");
                System.out.println("登录账号");
                register(accounts,book);
            }
        }else{
            System.out.println("账号已达上限，请联系管理员");
        }
    }

    public void login(Account[] accounts, Book[] book){
        System.out.println("请输入用户名：");
        String userName = input.next();
        System.out.println("请输入密码");
        String password = input.next();
        for (int i = 0; i < accounts.length; i++) {

            if (accounts[i] == null){
                continue;
            }
            if (accounts[i].getAccountNumber().equals(userName) && accounts[i].getPassword().equals(password)){
                System.out.println("登录成功！");
                operationBook(accounts,accounts[i],book);
                return;
            }
        }
        System.out.println("账号密码错误");
        operationMenu(accounts,book);
    }

    public void showAllBookInfo(Book[] book){
        System.out.println("书名"+"\t"+"作者"+"\t"+"状态"+"\t"+"借出日期"+"\t"+"归还日期"+"\t"+"借出次数");
        for (int i = 0; i < book.length; i++) {
            if (book[i]==null){
                continue;
            }
            System.out.println(book[i].toString());
        }
    }

    public int findBookInfo(Book[] book, String bookName){
        int index = -1;
        for (int i = 0; i < book.length; i++) {
            if (book[i]==null){
            continue;
            }
            if (book[i].getName().equals(bookName)){
                index = i;
                System.out.println("书名"+"\t"+"作者"+"\t"+"状态"+"\t"+"借出日期"+"\t"+"归还日期"+"\t"+"借出次数");
                System.out.println(book[index].toString());
                return index;
            }
        }
        return index;
    }

    public void borrowBook(Book[] book){
        System.out.println("请输入书名");
        String bookName = input.next();
        int index = findBookInfo(book,bookName);
        if (index == -1){
            System.out.println("《" + bookName + "》不存在");
        }else{
            if (book[index].getStatus().equals("可借")){
                System.out.println("请输入借阅的日期");
                book[index].setStatus("不可借");
                System.out.println("请输入年份");
                int year = input.nextInt();
                System.out.println("请输入月份");
                int month = input.nextInt();
                System.out.println("请输入天");
                int day = input.nextInt();

                Date borrowDate = new Date();
                borrowDate.setYear(year);
                borrowDate.setMonth(month);
                borrowDate.setDate(day);
                book[index].setBorrwoDate(borrowDate);
                book[index].setCount((book[index].getCount()+1));
            }else{
                System.out.println("《" + bookName + "》已被借出");
            }
            System.out.println("书名"+"\t"+"作者"+"\t"+"状态"+"\t"+"借出日期"+"\t"+"归还日期"+"\t"+"借出次数");
            System.out.println(book[index].toString());
        }
    }

    public void returnBook(Book[] book){
        System.out.println("请输入书名");
        String bookName = input.next();
        int index = findBookInfo(book,bookName);
        if (index == -1){
            System.out.println("《" + bookName + "》不存在");
        }else{
            if (book[index].getStatus().equals("不可借")){
                System.out.println("请输入归还的日期");

                System.out.println("请输入年份");
                int year = input.nextInt();
                System.out.println("请输入月份");
                int month = input.nextInt();
                System.out.println("请输入天");
                int day = input.nextInt();

                Date returnDate = new Date();
                returnDate.setYear(year);
                returnDate.setMonth(month);
                returnDate.setDate(day);
                book[index].setReturnDate(returnDate);
                int rent = data.calculateDayGap(book[index].getBorrwoDate(),returnDate);
                book[index].setReturnDate(null);
                book[index].setBorrwoDate(null);
                book[index].setStatus("可借");
                System.out.println("租金为:" + rent);
                System.out.println("归还成功");
            }else{
                System.out.println("《" + bookName + "》未借出");
            }
            System.out.println("书名"+"\t"+"作者"+"\t"+"状态"+"\t"+"借出日期"+"\t"+"归还日期"+"\t"+"借出次数");
            System.out.println(book[index].toString());
        }
    }

    public void addBook(Book[] book){
        boolean flag = false;
        int index = -1;
        System.out.println("请输入要添加的书名");
        String bookName = input.next();
        for (int i = 0; i < book.length; i++) {
            if (book[i] == null){
                flag = true;
                index = i;
                break;
            }
            if (book[i].getName().equals(bookName)){
                System.out.println("《"+book[index].getName()+"》已存在");
                return;
            }
        }
        if (flag){
            System.out.println("请输入作者");
            String author = input.next();
            Book tempBook = new Book(bookName,author,"可借",null,null,0);
            book[index] = tempBook;
            System.out.println("添加成功");
            showAllBookInfo(book);
        }else{
            System.out.println("书架已满");
        }
    }

    public void delBook(Book[] book){
        boolean flag = false;
        int index = -1;
        System.out.println("请输入要删除的书名");
        String bookName = input.next();
        for (int i = 0; i < book.length; i++) {
            if (book[i] == null){
                continue;
            }
            if (book[i].getName().equals(bookName)){
                flag = true;
                index = i;
            }
        }
        if (flag){
            if (book[index].getStatus().equals("不可借")){
                System.out.println("《"+bookName+"》被借出");
            }else{
                book[index] = null;
            }
        }else{
            System.out.println("《"+bookName+"》不存在");
        }
    }
}
