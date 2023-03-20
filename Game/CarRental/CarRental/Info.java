package com.zhiyou.Game.CarRental.CarRental;

import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;

public class Info {
    String adress = "D:\\WorkeSpace\\Java\\src\\com\\zhiyou\\Game\\CarRental\\CarInfo.txt";
    public void Write( ArrayList<Car> list) throws Exception{
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(adress)));
            oos. writeObject(list);
            oos.close();
    }
    public  ArrayList<Car> Read() throws Exception{
        ArrayList<Car> list = new ArrayList<>();
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(adress)));
        list = (ArrayList<Car>) ois.readObject();

        return list;
    }
    public void Init() throws Exception{
        ArrayList<Car> list = new ArrayList<>();

        Car c1 = new Car("豫A99999","奔驰","黑色","奔驰E300",null,null,1000);
        Car c2 = new Car("豫A66666","奔驰","黑色","奔驰R350",null,null,1600);
        Car c3 = new Car("豫A88888","奥迪","黑色","奥迪A8",null,null,1800);
        Car c4 = new Car("豫A88888","奔驰","黑色","奔驰S350",null,null,2000);
        Car c5 = new Car("豫A00001","红旗","黑色","红旗H9",null,null,1500);

        Calendar calendar = Calendar.getInstance();
        calendar.set(2023,(1-1),1);
        c1.setLeaseOutDate(calendar);
        list.add(c1);
        calendar.set(2023,(2-1),2);
        c2.setLeaseOutDate(calendar);
        list.add(c2);
        list.add(c3);
        list.add(c4);
        list.add(c5);


        Write(list);
    }
}
