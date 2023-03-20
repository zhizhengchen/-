package com.zhiyou.Game.LibraryManagementSystem.Plus_LibraryManagementSystem;

import java.util.Date;

public class DateTest {
    public int calculateDayGap(int[] beginDay,int[] endDay){

        Date date1 = new Date();
        date1.setYear(beginDay[0]);
        date1.setMonth(beginDay[1]);
        date1.setDate(beginDay[2]);

        Date date2 = new Date();
        date2.setYear(endDay[0]);
        date2.setMonth(endDay[1]);
        date2.setDate(endDay[2]);

        long millions = (date2.getTime()-date1.getTime());
        System.out.println(millions);
        long seconds = millions / 1000;
        long minutes = seconds / 60;
        long hours = minutes /60;
        long days = hours / 24;
        System.out.println(days);

        return (int)days;
    }
    public int calculateDayGap(Date beginDay,Date endDay){
        long millions = (endDay.getTime()-beginDay.getTime());
        System.out.println(millions);
        long seconds = millions / 1000;
        long minutes = seconds / 60;
        long hours = minutes /60;
        long days = hours / 24;
        return (int)days;
    }
}
