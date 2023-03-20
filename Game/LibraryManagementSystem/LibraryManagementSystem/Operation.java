package com.zhiyou.Game.LibraryManagementSystem.LibraryManagementSystem;

import java.util.Scanner;

public class Operation {
        Menu menu = new Menu();
        Book book = new Book();
    static Scanner input = new Scanner(System.in);
    public void operation(String name, String password,AccountNumber a) {
//        String[] bookNames = {"挪威森林", "孙子兵法", "百年孤独", "编程思想",null,null};
//        String[] authors = {" 村上春树 ", " 孙膑 ", " 高斯林 ", " 詹姆斯 ",null,null};
//        int[] status = {0,0,1,0,0,0};
//        int[] dates = {0,0,7,0,0,0};
//        int[] returnDates = {0,0,0,0,0,0};
        if (name.equals("admin")){
            AdminOperation(book, a);
        }else{
            UserOperation(book, a);
        }
    }
    public void AdminOperation(Book book,AccountNumber a){

        System.out.println("==================");
        System.out.println("1. 查看所有图书");
        System.out.println("2. 根据名字查看图书");
        System.out.println("3. 图书借阅");
        System.out.println("4. 图书归还");
        System.out.println("5. 图书上架");
        System.out.println("6. 图书下架");
        System.out.println("7. 返回菜单");
        System.out.println("8. 系统退出");
        System.out.println("请选择");
        switch (input.nextInt()){
            case 1:
                ViewAllBooks(book);
                AdminOperation(book, a);
                break;
            case 2:
                QueryBooks(book);
                AdminOperation(book, a);
                break;
            case 3:
                BookBorrowing(book);
                AdminOperation(book, a);
                break;
            case 4:
                BookReturn(book);
                AdminOperation(book, a);
                break;
            case 5:
                AddBooks(book);
                AdminOperation(book, a);
                break;
            case 6:
                DelBooks(book);
                AdminOperation(book, a);
                break;
            case 7:
                Menu.Menu(a);
                break;
            case 8:
                System.exit(0);
                break;
            default:
                AdminOperation(book, a);
        }
    }
    public void UserOperation(Book book,AccountNumber a){
        System.out.println("==================");
        System.out.println("1. 查看所有图书");
        System.out.println("2. 根据名字查看图书");
        System.out.println("3. 图书借阅");
        System.out.println("4. 图书归还");
        System.out.println("5. 返回菜单");
        System.out.println("6. 系统退出");
        System.out.println("请选择");
        switch (input.nextInt()){
            case 1:
                ViewAllBooks(book);
                UserOperation(book, a);
                break;
            case 2:
                QueryBooks(book);
                UserOperation(book, a);
                break;
            case 3:
                BookBorrowing(book);
                UserOperation(book, a);
                break;
            case 4:
                BookReturn(book);
                UserOperation(book, a);
                break;
            case 5:
                Menu.Menu(a);
            case 6:
                System.exit(0);
                break;
            default:
                AdminOperation(book, a);
        }
    }
    public void ViewAllBooks(Book book){
        System.out.println(" 书名"+"\t\t\t"+" 作者"+"\t\t"+" 状态"+"\t\t\t"+" 借出日期"+"\t\t"+" 归还日期");
        for (int i = 0; i < book.getBookNames().length; i++) {
            if (book.getBookNames()[i]==null){
                continue;
            }
            System.out.println(book.getBookNames()[i] + "\t\t" + book.getAuthors()[i] + "\t\t\t" + book.getStatus()[i] + "\t\t\t" + book.getDates()[i] + "\t\t\t" + book.getReturnDates()[i]);
        }
    }
    public boolean QueryBooks(Book book){
        boolean flag = false;
        int index = -1;
        System.out.println("请输入要查询的书籍名称");
        String name = input.next();
        for (int i = 0; i < book.getBookNames().length; i++) {
            if (name.equals(book.getBookNames()[i])){
                index = i;
                flag = true;
            }
        }
        if (flag){
            System.out.println(" 书名"+"\t\t\t"+" 作者"+"\t\t"+" 状态"+"\t\t\t"+" 借出日期"+"\t\t"+" 归还日期");
            System.out.println(book.getBookNames()[index] + "\t\t" + book.getAuthors()[index] + "\t\t\t" + book.getStatus()[index] + "\t\t\t" + book.getDates()[index] + "\t\t\t" + book.getReturnDates()[index]);
            return true;
        }else{
            System.out.println("没有找到 《"+name+"》 图书");
            return false;
        }
    }
    public int QueryBooksStatusBorrowing(Book book){
        boolean flag = false;
        int index = -1;
        System.out.println("请输入要借出的书籍名称");
        String name = input.next();
        for (int i = 0; i < book.getBookNames().length; i++) {
            if (name.equals(book.getBookNames()[i])){
                index = i;
                flag = true;
            }
        }
        if (flag){
            if (book.getStatus()[index]==0){
                System.out.println(" 书名"+"\t\t\t"+" 作者"+"\t\t"+" 状态"+"\t\t\t"+" 借出日期"+"\t\t"+" 归还日期");
                System.out.println(book.getBookNames()[index] + "\t\t" + book.getAuthors()[index] + "\t\t\t" + book.getStatus()[index] + "\t\t\t" + book.getDates()[index] + "\t\t\t" + book.getReturnDates()[index]);
                return index;
            }else{
                System.out.println(book.getBookNames()[index] + "不可借");
                return -1;
            }
        }else{
            System.out.println("没有找到 《"+name+"》 图书");
            return -1;
        }
    }
    public void BookBorrowing(Book book){
        ViewAllBooks(book);
        int index = QueryBooksStatusBorrowing(book);
        if (index!= -1){
            System.out.println("请输入借出的日期");
            int date = input.nextInt();
            book.getDates()[index] = date;
            book.setDates(book.getDates());
            book.getStatus()[index]=1;
            book.setStatus(book.getStatus());
        }
    }
    public int QueryBooksStatusReturn(Book book){
        boolean flag = false;
        int index = -1;
        System.out.println("请输入要归还的书籍名称");
        String name = input.next();
        for (int i = 0; i < book.getBookNames().length; i++) {
            if (name.equals(book.getBookNames()[i])){
                index = i;
                flag = true;
            }
        }
        if (flag){
            if (book.getStatus()[index]==1){
                System.out.println(" 书名"+"\t\t\t"+" 作者"+"\t\t"+" 状态"+"\t\t\t"+" 借出日期"+"\t\t"+" 归还日期");
                System.out.println(book.getBookNames()[index] + "\t\t" + book.getAuthors()[index] + "\t\t\t" + book.getStatus()[index] + "\t\t\t" + book.getDates()[index] + "\t\t\t" + book.getReturnDates()[index]);
                return index;
            }else{
                System.out.println(book.getBookNames()[index] + "未借出");
                return -1;
            }
        }else{
            System.out.println("没有找到 《"+name+"》 图书");
            return -1;
        }
    }
    public void BookReturn(Book book){
        ViewAllBooks(book);
        int index = QueryBooksStatusReturn(book);
        if (index!= -1){
            System.out.println("请输入归还的日期");
            int date = input.nextInt();
            int rent = book.getReturnDates()[index]-book.getDates()[index];
            book.getReturnDates()[index] = date;
            book.setReturnDates(book.getReturnDates());
            System.out.println("租金为"+rent);
            System.out.println("归还成功");
            book.getReturnDates()[index] = 0;
            book.getDates()[index] = 0;
            book.getStatus()[index] = 0;
            book.setStatus(book.getStatus());

        }
    }
    public void AddBooks(Book book){
        boolean flag = false;
        int index = -1;
        for (int i = 0; i < book.getBookNames().length; i++) {
            if (book.getBookNames()[i] == null){
                flag = true;
                index = i;
            }
        }
        if (flag){
            System.out.println("请输入要添加的书籍名称");
            String bookName = input.next();
            for (int i = 0; i < book.getBookNames().length; i++) {
                if (bookName.equals(book.getBookNames()[i])){
                    flag = false;
                }
            }
            if (flag){
                book.getBookNames()[index] = bookName;
                System.out.println("请输入要添加的书籍的作者");
                book.getAuthors()[index] = input.next();
                book.setAuthors(book.getAuthors());
                book.getStatus()[index] = 0;
                book.setStatus(book.getStatus());
                book.getDates()[index] = 0;
                book.setDates(book.getDates());
                book.getReturnDates()[index] = 0;
                book.setReturnDates(book.getReturnDates());
                System.out.println("添加成功");
                ViewAllBooks(book);
            }else{
                System.out.println("书名重复，添加失败");
            }
        }else{
            System.out.println("书架已满，添加失败");
        }
    }
    public void DelBooks(Book book){
        boolean flag = false;
        int index = -1;
        System.out.println("请输入要下架的书籍名称");
        String bookName = input.next();
        for (int i = 0; i < book.getBookNames().length; i++) {
            if (bookName.equals(book.getBookNames()[i])){
                flag = true;
                index = i;
            }
        }
        if (flag){
            book.getBookNames()[index] = bookName;
            if (book.getStatus()[index] == 0){
                book.getBookNames()[index]=null;
                book.setBookNames(book.getBookNames());
                book.getAuthors()[index]=null;
                book.setAuthors(book.getAuthors());
                book.getStatus() [index]=0;
                book.setStatus(book.getStatus());
                book.getDates()[index]=0;
                book.setDates(book.getDates());
                book.getReturnDates()[index]=0;
                book.setReturnDates(book.getReturnDates());
                System.out.println("下架成功");
                ViewAllBooks(book);
            }else{
                System.out.println("下架失败，状态为借出状态");
            }
        }else{
            System.out.println("没有找到 《"+bookName+"》 这本书");
        }
    }
}
