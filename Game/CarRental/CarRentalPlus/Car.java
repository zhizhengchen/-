package com.zhiyou.Game.CarRental.CarRentalPlus;

import java.io.Serializable;
import java.util.Calendar;

public class Car implements Serializable {
    private String carID;
    private String brand;
    private String type;
    private Integer money;
    private Calendar borrowdata;
    private Calendar returndata;
    private Status status;

    public Car() {
    }

    public Car(String carID, String brand, String type, Integer money, Calendar borrowdata, Calendar returndata, Status status) {
        this.carID = carID;
        this.brand = brand;
        this.type = type;
        this.money = money;
        this.borrowdata = borrowdata;
        this.returndata = returndata;
        this.status = status;
    }

    /**
     * 获取
     * @return carID
     */
    public String getCarID() {
        return carID;
    }

    /**
     * 设置
     * @param carID
     */
    public void setCarID(String carID) {
        this.carID = carID;
    }

    /**
     * 获取
     * @return brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * 设置
     * @param brand
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * 获取
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * 设置
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取
     * @return money
     */
    public Integer getMoney() {
        return money;
    }

    /**
     * 设置
     * @param money
     */
    public void setMoney(Integer money) {
        this.money = money;
    }

    /**
     * 获取
     * @return borrowdata
     */
    public Calendar getBorrowdata() {
        return borrowdata;
    }

    /**
     * 设置
     * @param borrowdata
     */
    public void setBorrowdata(Calendar borrowdata) {
        this.borrowdata = borrowdata;
    }

    /**
     * 获取
     * @return returndata
     */
    public Calendar getReturndata() {
        return returndata;
    }

    /**
     * 设置
     * @param returndata
     */
    public void setReturndata(Calendar returndata) {
        this.returndata = returndata;
    }

    /**
     * 获取
     * @return status
     */
    public Status getStatus() {
        return status;
    }

    /**
     * 设置
     * @param status
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    public String toString() {
        return "Car{carID = " + carID + ", brand = " + brand + ", type = " + type + ", money = " + money + ", borrowdata = " + borrowdata + ", returndata = " + returndata + ", status = " + status + "}";
    }
}
