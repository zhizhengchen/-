package com.zhiyou.Game.CarRental.CarRental;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class Car implements Serializable {
    private String LicensePlate;//车牌
    private String AutomobileBrand;//汽车品牌
    private String CarColor;//汽车颜色
    private String VehicleModel;//汽车型号
    private Calendar LeaseOutDate;//租出日期
    private Calendar ReturnDate;//归还日期
    private Integer Rent;//租金

    public Car() {
    }

    public Car(String LicensePlate, String AutomobileBrand, String CarColor, String VehicleModel, Calendar LeaseOutDate, Calendar ReturnDate, Integer Rent) {
        this.LicensePlate = LicensePlate;
        this.AutomobileBrand = AutomobileBrand;
        this.CarColor = CarColor;
        this.VehicleModel = VehicleModel;
        this.LeaseOutDate = LeaseOutDate;
        this.ReturnDate = ReturnDate;
        this.Rent = Rent;
    }

    /**
     * 获取
     * @return LicensePlate
     */
    public String getLicensePlate() {
        return LicensePlate;
    }

    /**
     * 设置
     * @param LicensePlate
     */
    public void setLicensePlate(String LicensePlate) {
        this.LicensePlate = LicensePlate;
    }

    /**
     * 获取
     * @return AutomobileBrand
     */
    public String getAutomobileBrand() {
        return AutomobileBrand;
    }

    /**
     * 设置
     * @param AutomobileBrand
     */
    public void setAutomobileBrand(String AutomobileBrand) {
        this.AutomobileBrand = AutomobileBrand;
    }

    /**
     * 获取
     * @return CarColor
     */
    public String getCarColor() {
        return CarColor;
    }

    /**
     * 设置
     * @param CarColor
     */
    public void setCarColor(String CarColor) {
        this.CarColor = CarColor;
    }

    /**
     * 获取
     * @return VehicleModel
     */
    public String getVehicleModel() {
        return VehicleModel;
    }

    /**
     * 设置
     * @param VehicleModel
     */
    public void setVehicleModel(String VehicleModel) {
        this.VehicleModel = VehicleModel;
    }

    /**
     * 获取
     * @return LeaseOutDate
     */
    public Calendar getLeaseOutDate() {
        return LeaseOutDate;
    }

    /**
     * 设置
     * @param LeaseOutDate
     */
    public void setLeaseOutDate(Calendar LeaseOutDate) {
        this.LeaseOutDate = LeaseOutDate;
    }

    /**
     * 获取
     * @return ReturnDate
     */
    public Calendar getReturnDate() {
        return ReturnDate;
    }

    /**
     * 设置
     * @param ReturnDate
     */
    public void setReturnDate(Calendar ReturnDate) {
        this.ReturnDate = ReturnDate;
    }

    /**
     * 获取
     * @return Rent
     */
    public Integer getRent() {
        return Rent;
    }

    /**
     * 设置
     * @param Rent
     */
    public void setRent(Integer Rent) {
        this.Rent = Rent;
    }

    public String toString() {
        return "Car{LicensePlate = " + LicensePlate + ", AutomobileBrand = " + AutomobileBrand + ", CarColor = " + CarColor + ", VehicleModel = " + VehicleModel + ", LeaseOutDate = " + LeaseOutDate + ", ReturnDate = " + ReturnDate + ", Rent = " + Rent + "}";
    }
}
