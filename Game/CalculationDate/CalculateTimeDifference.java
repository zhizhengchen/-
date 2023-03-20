package com.zhiyou.Game.CalculationDate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

//计算两个时间之间得差(无视年)
//2023-3-17  ---  2023-3-18  差距一天
public class CalculateTimeDifference {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c2.set(2023,(3-1),17);
        System.out.println(calculateTimeDifference(c1, c2));
    }
    //空参直接调用方法;
    public static int calculateTimeDifference(){
        StringCtDate sctd = new StringCtDate();

        System.out.println("请输入开始日期(YYYY-MM-DD)");
        String begindate = sc.next();
        Calendar beginDate = sctd.StringConvertedToDate(begindate);

        System.out.println("请输入结束日期(YYYY-MM-DD)");
        String enddate = sc.next();
        Calendar endDate = sctd.StringConvertedToDate(enddate);

        //计算
        return calculateTimeDifference(beginDate,endDate);
    }

    //对 Calendar 对象进行处理,获取毫秒数并进行运算得到天数
    public static int calculateTimeDifference(Calendar beginDate,Calendar endDate){
        long beginDay = beginDate.getTimeInMillis()/1000/60/60/24;
        long endDay = endDate.getTimeInMillis()/1000/60/60/24;
        int day = (int)(endDay-beginDay);
        return day;
    }

    //对 SimpleDateFormat 对象进行处理,获取毫秒数并进行运算得到天数
    public static int calculateTimeDifference(SimpleDateFormat format,String begin,String end){
        Date beginDate = null;
        Date endDate = null;

        try {
            beginDate = format.parse("begin");
            endDate = format.parse("end");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        long beginDay = beginDate.getTime()/1000/60/60/24;
        long endDay = endDate.getTime()/1000/60/60/24;
        int day = (int)(endDay-beginDay);
        return day;
    }

    //对Date对象进行处理,获取毫秒数并进行运算得到天数
    public int calculateTimeDifference(Date beginDate,Date endDate){
        long beginDay = (beginDate.getTime()/1000/60/60/24);
        long endDay = (endDate.getTime()/1000/60/60/24);
        return (int) (endDay - beginDay);
    }

    //对String类型日期进行截取并处理,获取毫秒数并进行运算得到天数
    public int calculateTimeDifference(String begin,String end){
        String str = "/d{4}[-]{1}/d{4}[-]{1,2}/d{1,2}";
        if (begin.matches(str) && end.matches(str)){
            String beginDates[] = begin.split("-");
            Date beginDate = new Date();

            beginDate.setYear(Integer.parseInt(beginDates[0])-1900);
            beginDate.setMonth(Integer.parseInt(beginDates[1])-1);
            beginDate.setDate(Integer.parseInt(beginDates[2]));
            long beginDay = (beginDate.getTime()/1000/60/60/24);

            String endDates[] = end.split("-");
            Date endDate = new Date();
            endDate.setYear(Integer.parseInt(endDates[0])-1900);
            endDate.setMonth(Integer.parseInt(endDates[1])-1);
            endDate.setDate(Integer.parseInt(endDates[2]));
            long endDay = (endDate.getTime()/1000/60/60/24);


            return (int)(endDay - beginDay);
        }else{
            System.err.println("格式错误!(YYYY-MM-DD)");
            return 9999999;
        }
    }
}
