package com.zhiyou.Game.CarRental.CarRental;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Menu {
    static Scanner input  =  new Scanner(System.in);
    static Info info = new Info();
    public void OperationMenu() throws Exception{
        System.out.println("--------    1.增加  --------");
        System.out.println("--------    2.删    --------");
        System.out.println("--------    3.查    --------");
        System.out.println("--------    4.改    --------");
        System.out.println("--------    5.租赁  --------");
        System.out.println("--------    6.归还  --------");
        System.out.println("--------    7.退出  --------");
        String choice = input.next();
        switch (choice) {
            case "1":
                addCar();
                break;
            case "2":
                delCar();
                break;
            case "3":
                findCar();
                break;
            case "4":
                modifyCar();
                break;
            case "5":
                borrowCar();
                break;
            case "6":
                returnCar();
                break;
            case "7":
                System.exit(0);
                break;
            default:
                break;
        }
        OperationMenu();
    }
    //根据车牌或者车名查看汽车是否存在
    private int isExit(String str)  throws Exception{
        ArrayList<Car> list = info.Read();
        for (int i = 0; i <list.size() ; i++) {
            //输入车牌或者车名检查汽车是否存在  存在返回索引值,否则返回-1;
            if (str.equals(list.get(i).getLicensePlate())|| str.equals(list.equals(list.get(i).getVehicleModel()))){
                return i;
            }
        }
        return -1;
    }
    //根据车牌或者车名查看汽车租借状态

    private int isBorrow(String str) throws Exception{
        //检查汽车是否可以租借
        int index = isExit(str);
        ArrayList<Car> list = info.Read();
        //存在并且可租返回索引值,否则返回-1;
        if (index != -1 && list.get(index).getLeaseOutDate() == null){
            return index;
        }
        return -1;
    }
    //车牌正则 正确返回车牌 错误返回null

    private String isLicensePlate() throws Exception{
        boolean falge = false;
        System.out.println("请输入车牌号(车牌必须唯一[例如 豫A12345])");
        String LicensePlate = input.next();//车牌
        int count  = 0;
        while (!falge){
            count++;
            falge = LicensePlate.matches("" +
                    "([京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼]{1}" +
                    "(([A-HJ-Z]{1}[A-HJ-NP-Z0-9]{5})|" +
                    "([A-HJ-Z]{1}(([DF]{1}[A-HJ-NP-Z0-9]{1}[0-9]{4})|" +
                    "([0-9]{5}[DF]{1})))|" +
                    "([A-HJ-Z]{1}[A-D0-9]{1}[0-9]{3}警)))|" +
                    "([0-9]{6}使)|" +
                    "((([沪粤川云桂鄂陕蒙藏黑辽渝]{1}A)|鲁B|闽D|蒙E|蒙H)[0-9]{4}领)|" +
                    "(WJ[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼·•]{1}[0-9]{4}[TDSHBXJ0-9]{1})|([VKHBSLJNGCE]{1}[A-DJ-PR-TVY]{1}[0-9]{5})\n");;
            if (falge){
                break;
            }else if (count >= 3){
                System.out.println("错误次数过多,程序返回主菜单");
                OperationMenu();
                return null;
            }else {
                System.out.println("不合规");
            }
            System.out.println("请输入车牌号(车牌必须唯一[例如 豫A12345])");
            LicensePlate = input.next();
        }
        return LicensePlate;
    }
    //添加汽车信息 检验汽车车牌是否合理 检验汽车是否存在


    private void addCar()  throws Exception{
        ArrayList<Car> list = info.Read();
        System.out.println("开始修改");
        String LicensePlate = isLicensePlate();
        if (LicensePlate != null){
            int index = isExit(LicensePlate);
            if (index == -1 ){
                System.out.println("请输入汽车品牌");
                String AutomobileBrand = input.next();//汽车品牌
                System.out.println("请输入汽车颜色");
                String CarColor = input.next();//汽车颜色
                System.out.println("请输入汽车型号");
                String VehicleModel = input.next();//汽车型号
                Calendar LeaseOutDate = null;//租出日期
                Calendar ReturnDate = null;//归还日期
                System.out.println("请输入汽车租金(xxxx/天)");
                Integer Rent = input.nextInt();//租金
                Car c = new Car(LicensePlate,AutomobileBrand,CarColor,VehicleModel,LeaseOutDate,ReturnDate,Rent);
                list.add(c);
                info.Write(list);
                System.out.println("添加成功");
            }else{
                System.out.println("车牌已存在,不可添加");
                return;
            }
        }else{
            return;
        }
    }
    //添加汽车信息到指定索引处
    private void addCar(int num) throws Exception {
        ArrayList<Car> list = info.Read();
        String LicensePlate = isLicensePlate();
        System.out.println("请输入汽车品牌");
        String AutomobileBrand = input.next();//汽车品牌
        System.out.println("请输入汽车颜色");
        String CarColor = input.next();//汽车颜色
        System.out.println("请输入汽车型号");
        String VehicleModel = input.next();//汽车型号
        Calendar LeaseOutDate = null;//租出日期
        Calendar ReturnDate = null;//归还日期
        System.out.println("请输入汽车租金(xxxx/天)");
        Integer Rent = input.nextInt();//租金
        Car c = new Car(LicensePlate,AutomobileBrand,CarColor,VehicleModel,LeaseOutDate,ReturnDate,Rent);
        list.remove(num);
        list.add(num,c);
        info.Write(list);
        System.out.println("修改成功");
    }
    //删除汽车信息 检验汽车车牌是否合理 检验汽车是否存在 检查汽车租借状态
    private void delCar() throws Exception {
        ArrayList<Car> list = info.Read();
        String LicensePlate = isLicensePlate();
        if (LicensePlate != null){
            int index = isExit(LicensePlate);
            if (index != -1 ){
                index = isBorrow(LicensePlate);
                if (index !=-1){
                    list.remove(index);
                    info.Write(list);
                    System.out.println("删除成功");
                }else{
                    System.out.println("");
                }
            }else{
                System.out.println("车牌不存在,不可删除");
                return;
            }
        }else{
            return;
        }
    }
    //输出所有汽车信息
    private void findCar() throws Exception {
        ArrayList<Car> list = new ArrayList<>();
        list = info.Read();
        for (Car c:list) {
            if (c.getLeaseOutDate() == null){
                System.out.println(
                        "车牌" + "\t" + c.getLicensePlate() + "\t" +
                                "汽车品牌" + "\t" + c.getAutomobileBrand() + "\t" +
                                "汽车颜色" + "\t" + c.getCarColor() + "\t" +
                                "汽车型号" + "\t" + c.getVehicleModel() + "\t" +
                                "租出日期" + "\t" + c.getLeaseOutDate()+ "\t" +
                                "归还日期" + "\t" + c.getReturnDate()+ "\t" +
                                "租金" + "\t" + c.getRent() + "/天");
            }else{
                System.out.println(
                        "车牌" + "\t" + c.getLicensePlate() + "\t" +
                                "汽车品牌" + "\t" + c.getAutomobileBrand() + "\t" +
                                "汽车颜色" + "\t" + c.getCarColor() + "\t" +
                                "汽车型号" + "\t" + c.getVehicleModel() + "\t" +
                                "租出日期" + "\t" + c.getLeaseOutDate().getTime()+ "\t" +
                                "归还日期" + "\t" + c.getReturnDate()+ "\t" +
                                "租金" + "\t" + c.getRent() + "/天");
            }

        }
    }
    //修改汽车信息
    private void modifyCar() throws Exception {
        String LicensePlate = isLicensePlate();
        if (LicensePlate != null){
            int index = isExit(LicensePlate);
            if (index != -1 ){
                index = isBorrow(LicensePlate);
                if (index !=-1){
                    addCar(index);
                }else{
                    System.out.println("车已被租,修改失败");
                }
            }else{
                System.out.println("车牌已存在,不可修改");
                return;
            }
        }else{
            return;
        }
    }

    private void borrowCar() throws Exception {
        ArrayList<Car> list = info.Read();
        String LicensePlate = isLicensePlate();
        if (LicensePlate != null){
            int index = isExit(LicensePlate);
            if (index != -1 ){
                index = isBorrow(LicensePlate);
                if (index !=-1){
                    Calendar date = Calendar.getInstance();
                    list.get(index).setLeaseOutDate(date);
                    System.out.println("借出成功");
                    info.Write(list);
                }else{
                    System.out.println("车已被租");
                }
            }else{
                System.out.println("车牌不存在");
                return;
            }
        }else{
            return;
        }
    }
    private void returnCar() throws Exception {
        ArrayList<Car> list = info.Read();
        String LicensePlate = isLicensePlate();
        if (LicensePlate != null){
            int index = isExit(LicensePlate);
            if (index != -1 ){
                if (list.get(index).getLeaseOutDate() == null){
                    System.out.println("车未租");
                }else{
                    Car c = list.get(index);
                    Calendar date = Calendar.getInstance();
                    c.setReturnDate(date);
                    int day = 2 + c.getReturnDate().get(Calendar.DAY_OF_YEAR) - c.getLeaseOutDate().get(Calendar.DAY_OF_YEAR);
                    int rent = c.getRent();
                    System.out.println("租金为:" + (day*rent));
                    System.out.println("归还成功");
                    c.setLeaseOutDate(null);
                    c.setReturnDate(null);
                    info.Write(list);
                }
            }else{
                System.out.println("车牌不存在");
                return;
            }
        }else{
            return;
        }
    }
}
