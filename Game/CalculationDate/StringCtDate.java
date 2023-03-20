package com.zhiyou.Game.CalculationDate;

import java.util.Calendar;

public class StringCtDate {
    public Calendar StringConvertedToDate(String date) throws NullPointerException{
        String str = "[0-9]{4}[-]{1}[0-9]{1,2}[-]{1}[0-9]{1,2}";
        if (date.matches(str)) {
            String[] dates = date.split("-");
            Calendar Date = Calendar.getInstance();
            Date.set(Integer.parseInt(dates[0]), Integer.parseInt(dates[1]), Integer.parseInt(dates[2]));
            return Date;
        }else{
            System.err.println("格式错误!");
            return null;
        }
    }
}
