package com.zhiyou.Game.CarRental.CarRentalPlus;

import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class CarUtil {
    static Scanner sc = new Scanner(System.in);

    public  void init() throws  Exception{
        File f = new File("D:\\Temp\\Cars.txt");
        if (!f.exists()){
            Status lend = Status.LEND;
            Status notLend = Status.NOTLEND;
            Calendar Date1 = Calendar.getInstance();
            Calendar Date2 = Calendar.getInstance();
            Date1.set(2023,(3-1),15);
            Date2.set(2023,(3-1),1);
            Car car1 = new Car("豫A66666","雪铁龙","C6",300,Date1,null,lend);
            Car car2 = new Car("豫A12345","奥迪","A6",500,Date2,null,lend);
            Car car3 = new Car("豫A88888","马自达","马3",300,null,null,notLend);
            List<Car> list = new ArrayList<>();
            list.add(car1);
            list.add(car2);
            list.add(car3);
            saveObject(list);
        }
    }

    public void saveObject(List<Car> list) throws Exception{
        File f = new File("D:\\Temp\\Cars.txt");
        FileOutputStream fos = new FileOutputStream(f);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(list);
        oos.close();
    }

    public List<Car> getCarList() throws Exception{
        File f = new File("D:\\Temp\\Cars.txt");
        FileInputStream fis = new FileInputStream(f);
        ObjectInputStream ois = new ObjectInputStream(fis);
        List<Car> list = (List<Car>) ois.readObject();
        ois.close();
        return list;
    }

    //打印汽车信息
    public void printCar()throws Exception{
        String CarId = setGetId();
        Car car = isExits(CarId);
        if (car!=null){
            System.out.println(
                "车牌" + "\t\t" + car.getCarID() + "\t" +
                "汽车品牌" + "\t" + car.getBrand() + "\t" +
                "汽车型号" + "\t" + car.getType() + "\t" +
                "租出状态" + "\t" + car.getStatus().getStatusDesc() +
                "租金" + "\t\t" + car.getMoney() + "/天");
        }else{
            System.out.println("车牌: " + CarId + " 不存在");
        }

    }

    //打印所有汽车信息
    public void printCars()throws Exception{
    List<Car> list =getCarList();
        for (Car c:list) {
            System.out.println(
            "车牌" + "\t" + c.getCarID() + "\t" +
            "汽车品牌" + "\t" + c.getBrand() + "\t" +
            "汽车型号" + "\t" + c.getType() + "\t" +
            "租出状态" + "\t" + c.getStatus().getStatusDesc() + "\t" +
            "租金" + "\t" + c.getMoney() + "/天");
        }

    }

    //查看索引
    public int indexOf(Car car) throws Exception{
        int index = -1;
        List<Car> list = getCarList();
        for (int i = 0; i < list.size(); i++) {
            if (car.getCarID().equals(list.get(i).getCarID())){
                index = i;
                return index;
            }
        }
        return index;
    }
    //查看车牌是否存在 存在返回Car对象否则返回null
    public Car isExits(String CarId)throws Exception{
        List<Car> list =getCarList();
        for (Car car : list) {
            if (car.getCarID().equals(CarId)){
                return car;
            }
        }
        return null;
    }

    //输入车牌输出车牌
    public String setGetId(){
        System.out.println("请输入车牌");
        String CarId = sc.next();
        return CarId;
    }

    //租赁汽车
    public void BorrowCar()throws Exception{
        List<Car> list = getCarList();
        String CarId = setGetId();
        //获取对象是否存在 从内从中读取数据
        Car car = isExits(CarId);
        if (car!=null){
            //获取所在索引值
            int index = indexOf(car);
            System.out.println(list.get(index).getStatus().getStatusDesc());
            if (car.getStatus().getStatus().equals("未租")){


                //输入借出日期
                Calendar borrowDate  = Calendar.getInstance();
                System.out.println("请输入借出年");
                int year = sc.nextInt();
                System.out.println("请输入借出月");
                int month = sc.nextInt();
                System.out.println("请输入借出日");
                int day = sc.nextInt();
                borrowDate.set(year,(month-1),day);
                list.get(index).setBorrowdata(borrowDate);

                list.get(index).setStatus(Status.LEND);
                System.out.println("借出成功");

                //输出信息 从内存向硬盘写入数据
                saveObject(list);

            }else{
            }
        }else{
            System.out.println("车牌 "+CarId+ " 不存在");
        }
        printCars();
    }

    //归还汽车
    public void ReturnCar()throws Exception{
        List<Car> list = getCarList();
        String CarId = setGetId();
        //获取对象是否存在  从内从中读取数据
        Car car = isExits(CarId);
        if (car!=null){
            int index = indexOf(car);
            System.out.println(list.get(index).getStatus().getStatusDesc());
            if (car.getStatus().getStatus().equals("已租")){
                Calendar returnDate  = Calendar.getInstance();
                //输入归还日期
                System.out.println("请输入归还年");
                int year = sc.nextInt();
                System.out.println("请输入归还月");
                int month = sc.nextInt();
                System.out.println("请输入归还日");
                int day = sc.nextInt();
                returnDate.set(year,(month-1),day);
                list.get(index).setReturndata(returnDate);
                int useDay = (returnDate.get(Calendar.DAY_OF_YEAR)-list.get(index).getBorrowdata().get(Calendar.DAY_OF_YEAR)) + 1;
                int rent = useDay*list.get(index).getMoney();

                String borrowDay = list.get(index).getBorrowdata().get(Calendar.YEAR) + "-" + (list.get(index).getBorrowdata().get(Calendar.MONTH)+1) + "-" + (list.get(index).getBorrowdata().get(Calendar.DAY_OF_MONTH));
                String returnDay = list.get(index).getReturndata().get(Calendar.YEAR) + "-" + (list.get(index).getReturndata().get(Calendar.MONTH)+1) + "-" + (list.get(index).getReturndata().get(Calendar.DAY_OF_MONTH));
                //打印相关信息
                System.out.println("账目信息");
                System.out.println("===========");
                System.out.println("车牌号" + list.get(index).getCarID());
                System.out.println("车辆类型" + list.get(index).getType());
                System.out.println("车辆使用开始时间" + borrowDay);
                System.out.println("车辆使用结束时间" + returnDay);
                System.out.println("车辆使用时间" + useDay);
                System.out.println("车辆租金" + rent);

                //清空归还日期
                list.get(index).setBorrowdata(null);
                list.get(index).setReturndata(null);
                //获取设置车辆状态
                list.get(index).setStatus(Status.NOTLEND);
                System.out.println("归还成功");

                //输出信息  从内存向硬盘写入数据
                saveObject(list);
            }else{
            }
        }else{
            System.out.println("车牌 "+CarId+ " 不存在");
        }
        printCars();
    }

    //上架汽车
    public void AddCar()throws Exception{
        List<Car> list = getCarList();
        String carId = setGetId();
        Car car = isExits(carId);
        if ( car == null){
            System.out.println("请输入汽车品牌");
            String brand = sc.next();
            System.out.println("请输入汽车型号");
            String type = sc.next();
            System.out.println("请输入汽车租金");
            Integer money = sc.nextInt();
            list.add(new Car(carId,brand,type,money,null,null,Status.NOTLEND));
            saveObject(list);
            System.out.println("添加成功");
        }else{
            System.out.println("车牌: " +carId+ "已存在");
        }
        printCars();
    }

    //下架汽车
    public void DelCar()throws Exception{
        List<Car> list = getCarList();
        String carId = setGetId();
        Car car = isExits(carId);
        if ( car != null){
            System.out.println(car.getStatus().getStatusDesc());
            if (car.getStatus().getStatus().equals("未租")) {
                list.remove(indexOf(isExits(carId)));
                saveObject(list);
                System.out.println("删除成功");
            }else{
                System.out.println("删除失败");
            }
        }else{
            System.out.println("车牌: " +carId+ "不存在");
        }
        printCars();
    }
}
