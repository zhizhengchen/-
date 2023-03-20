package com.zhiyou.Game.CarRental.CarRentalPlus;

public enum Status {
    LEND("已租","已经租赁出去"),
    NOTLEND("未租","还未租赁出去");

    private final String status;
    private final String statusDesc;


    private Status(String status, String statusDesc) {
        this.status = status;
        this.statusDesc = statusDesc;
    }

    public String getStatus(){
        return status;
    }

    public String getStatusDesc(){
        return statusDesc;
    }

    public String toString() {
        return "Status{status = " + status + ", statusDesc = " + statusDesc + "}";
    }
}
