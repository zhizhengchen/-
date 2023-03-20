package com.zhiyou.Game.LibraryManagementSystem.Plus02_LibraryManagementSystem;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class Menu {
    static Scanner input = new Scanner(System.in);
    public void displayMenu(ArrayList<User> users, ArrayList<Book> books,ArrayList<Gift> gifts) {
        System.out.println("====== 欢迎使用图书书店 ======");
        account(users,books,gifts);
    }
    //图书菜单
    public void menu(ArrayList<User> users, ArrayList<Book> books,ArrayList<Gift> gifts,User user){


        if (user.getRoot().equals("OC")){
            System.out.println("书号\t\t书名\t\t作者\t\t发布日期\t\t价格\t\t库存");
            viewBook(books);
            System.out.println("请选择进行的操作：1.查看图书   2.结账   3.退出");
            String choice = input.next();
            do {
                switch (choice){
                    case "1":
                        viewBook(books);
                        break;
                    case "2":
                        ArrayList<ShopCar> shopCars = new ArrayList<>();
                        boolean flag = true;
                        while (flag){
                            shopCars = shoppingCart(books,gifts,shopCars);
                            System.out.println("是否继续购买（N去结算）");
                            String choice2 = input.next();
                            if (choice2.equals("N")||choice2.equals("n")){
                                flag = false;
                            }
                        }
                        pay(shopCars);
                        menu(users,books,gifts,user);
                        break;
                    case "3":
                        account(users,books,gifts);
                        break;
                    default:
                        System.out.println("输入错误请重新输入");
                        menu(users,books,gifts,user);
                }
                System.out.println("请选择进行的操作：1.查看图书   2.结账   3.退出");
                choice = input.next();
            }while (!choice.equals("3"));
            account(users,books,gifts);
        }else{
            System.out.println("请选择进行的操作：1.图书入库     2.图书出库     3.查询全部图书     4.新增图书     5.退出");
            String choice = input.next();
            do {
                switch (choice){
                    case "1":
                        returnBook(books);
                        break;
                    case "2":
                        borrowBook(books);
                        break;
                    case "3":
                        viewBook(books);
                        break;
                    case "4":
                        addBook(books);
                        break;
                    case "5":
                        account(users,books,gifts);
                        break;
                    default:
                        System.out.println("输入错误请重新输入");
                        menu(users,books,gifts,user);
                }
                System.out.println("请选择进行的操作：1.图书入库     2.图书出库     3.查询全部图书     4.新增图书     5.退出");
                choice = input.next();
            }while (!choice.equals("5"));
            account(users,books,gifts);

        }
    }

    //账号操作
    public void account(ArrayList<User> users, ArrayList<Book> books,ArrayList<Gift> gifts) {
        boolean flag = true;
        System.out.println("1. 登录");
        System.out.println("2. 注册");
        System.out.println("3. 退出");
        String choice = input.next();
        do {
            switch (choice){
                case "1":
                    login(users,books,gifts);
                    flag = false;
                    break;
                case "2":
                    register(users,books,gifts);
                    flag = false;
                    break;
                case "3":
                    System.exit(0);
                    return;
                default:
                    System.out.println("输入错误，请重新输入");
            }
        }while (flag);
    }

    //图书入库
    public void returnBook(ArrayList<Book> books){
        System.out.println("请输入图书ID");
        int bookId = input.nextInt();
        for (Book book:books){
            if (book.getId()==bookId){
                System.out.println("请输入要入库的数量");
                int num = input.nextInt();
                System.out.println("入库成功");
                book.setSum(book.getSum()+num);
                viewBook(books);
                return;
            }
        }
        System.out.println("没找到相关图书");
    }
    //图书出库
    public void borrowBook(ArrayList<Book> books){
        System.out.println("请输入图书ID");
        int bookId = input.nextInt();
        for (Book book:books){
            if (book.getId()==bookId){
                System.out.println("请输入要出库的数量");
                int num = input.nextInt();
                if (num<=book.getSum()&& num >= 0){
                    System.out.println("出库成功");
                    book.setSum(book.getSum()-num);
                    viewBook(books);
                    return;
                }
            }
        }
        System.out.println("没找到相关图书");
    }
    // 新增图书
    public void addBook(ArrayList<Book> books){
        System.out.println("请输入图书名称");
        String bookName = input.next();
        System.out.println("作者");
        String author = input.next();
        System.out.println("发布日期");
        String data = input.next();
        System.out.println("价格");
        double price = input.nextDouble();
        System.out.println("库存");
        int num = input.nextInt();
        books.add(new Book((books.get(books.size()-1).getId()+1),bookName,author,data,price,num));
        viewBook(books);
    }

    //查看图书
    public void viewBook(ArrayList<Book> books){
        for (Book book : books) {
            System.out.println(book);
        }
    }
    //添加商品
    public ArrayList<ShopCar> shoppingCart(ArrayList<Book> books,ArrayList<Gift> gifts,ArrayList<ShopCar> shopCars){
        System.out.println("请输入欲购买的图书信息:");
        System.out.println("请输入图书ID：");
        int bookId = input.nextInt();
        for (Book book : books) {
            if (book.getId() == bookId) {
                System.out.println("请输入购买数量：");
                int bookNum = input.nextInt();
                if (bookNum <= book.getSum() && bookNum >= 0) {
                    book.setSum(book.getSum()-bookNum);
                    System.out.println("请选择输入购买的赠品");
                    System.out.println("CD\t\t27.50元      \n包装\t\t2.70元       \n钢笔\t\t10元     \n不需要");
                    String name = input.next();
                    for (Gift gift : gifts) {
                        if (name.equals(gift.getName())) {
                            System.out.println("请输入需要购买的附赠品的数量");
                            int giftNum = input.nextInt();
                            shopCars.add(new ShopCar(book, bookNum, gift, giftNum));
                            return shopCars;
                        }
                    }
                    System.out.println("没有找到相关赠品");
                    System.out.println("默认为不需要");
                    shopCars.add(new ShopCar(book, bookNum, gifts.get(3), 0));
                }else {
                    System.out.println("数量不足或输入数量有误");
                }
                return shopCars;
            }
        }
        System.out.println("没有找到Id为:" + bookId + " 的图书");
        return shopCars;
    }
    //结算
    public void pay(ArrayList<ShopCar> shopCars){
        double totalPrice = 0;
        System.out.println("====== 账单如下 ======");
        System.out.println("名称\t\t价格\t\t数量");
        for (ShopCar shopcar : shopCars) {
            System.out.println(shopcar);
            totalPrice = totalPrice + shopcar.getBook().getPrice() * shopcar.getBookNum() +
                    shopcar.getGift().getPrice() * shopcar.getGiftNum();
        }
        System.out.println("总金额为: " + totalPrice);
        System.out.println("请支付");
        System.out.print("支付中");
        for (int i = 0; i < 5; i++) {
            try {
                System.out.print("·");
                sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        System.out.println();
        System.out.println("支付成功");
    }
    //注册
    private void register(ArrayList<User> users, ArrayList<Book> books,ArrayList<Gift> gifts) {
        System.out.print("请输入账号:");
        String username = input.next();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getName().equals(username)){
                System.out.println("账号已存在，请重新注册");
                register(users,books,gifts);
                return;
            }
        }
        System.out.print("请输入密码:");
        String password1 = input.next();
        System.out.print("请再次输入密码:");
        String password2 = input.next();
        if (password1.equals(password2)) {
            System.out.println("注册成功");
            users.add(new User(username, password1,"OC"));
            System.out.println(users.get(users.size() - 1));
            login(users,books,gifts);
        }else{
            System.out.println("账号密码不一样，注册失败。");
            register(users,books,gifts);
        }
    }
    //登录
    public void login(ArrayList<User> users, ArrayList<Book> books,ArrayList<Gift> gifts){
        System.out.print("请输入账号:");
        String username = input.next();
        System.out.print("请输入密码:");
        String password = input.next();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i) == null){
                break;
            }
            if (users.get(i).getName().equals(username) && users.get(i).getPassword().equals(password)){
                System.out.println("====== 欢迎回来 " + users.get(i).getName() + " ======");
                menu(users,books,gifts,users.get(i));
                return;
            }
        }
        System.out.println("账户或用户名错误，请重新输入");
        login(users,books,gifts);
    }

}
