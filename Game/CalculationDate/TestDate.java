package com.zhiyou.Game.CalculationDate;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

//请假自动除去节假日和周六周日
//bug 存在周六周日需上班得情况
//bug计算两个时间之间得差(不能无视年)
//2022-12-1减去2023-1-1 = 一共 -333 天.
 // 2023-1-1减去2022-1-1 = 一共 1 天.
public class TestDate {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Calendar begin = Calendar.getInstance();
        System.out.print("请输入开始日期(yyyy-MM-dd): ");
        String strDate1 = input.next();

        String[] dates1 = strDate1.split("-");

        begin.set(Integer.parseInt(dates1[0]), Integer.parseInt(dates1[1]) - 1, Integer.parseInt(dates1[2]));

        Calendar end = Calendar.getInstance();
        System.out.print("请输入结束日期(yyyy-MM-dd): ");
        String strDate2 = input.next();

        String[] dates2 = strDate2.split("-");

        end.set(Integer.parseInt(dates2[0]), Integer.parseInt(dates2[1]) - 1, Integer.parseInt(dates2[2]));
        int day = getWeekendDays(begin, end);
        System.out.println(day);
        isVacation(end);
    }

    public static int getWeekendDays(Calendar begin, Calendar end) {
        int day = end.get(Calendar.DAY_OF_YEAR) - begin.get(Calendar.DAY_OF_YEAR) + 1;
        System.out.println("一共 " + day + " 天.");
        Calendar temp = begin;
        int weekendDays = 0;
        for (int i = 0; i < day; i++) {
            //System.out.println(temp.get(Calendar.YEAR)+" "+(temp.get(Calendar.MONTH)+1)+" "+temp.get(Calendar.DAY_OF_MONTH));
            if (temp.get(Calendar.DAY_OF_WEEK) == 7 || temp.get(Calendar.DAY_OF_WEEK) == 1) {
                System.out.println(temp.get(Calendar.YEAR) + " " + (temp.get(Calendar.MONTH) + 1) + " " + temp.get(Calendar.DAY_OF_MONTH));
                weekendDays++;
            } else if (isVacation(temp)) {
                System.out.println(temp.get(Calendar.YEAR) + " " + (temp.get(Calendar.MONTH) + 1) + " " + temp.get(Calendar.DAY_OF_MONTH));
                weekendDays++;
            }
            //天数 加 一
            temp.setTimeInMillis(temp.getTimeInMillis() + 24 * 60 * 60 * 1000);
            //temp.set(temp.get(Calendar.YEAR),temp.get(Calendar.MONTH),temp.get(Calendar.DAY_OF_MONTH)+1);
        }
        return weekendDays;
    }

    public static boolean isVacation(Calendar temp) {
        ArrayList<Calendar> list = new ArrayList<>();
        Calendar a1 = Calendar.getInstance();
        Calendar a2 = Calendar.getInstance();
        Calendar a3 = Calendar.getInstance();
        Calendar a4 = Calendar.getInstance();
        Calendar a5 = Calendar.getInstance();
        Calendar a6 = Calendar.getInstance();
        Calendar a7 = Calendar.getInstance();
        Calendar a8 = Calendar.getInstance();
        Calendar a9 = Calendar.getInstance();
        Calendar a10 = Calendar.getInstance();
        Calendar a11 = Calendar.getInstance();
        Calendar a12 = Calendar.getInstance();
        Calendar a13 = Calendar.getInstance();
        Calendar a14 = Calendar.getInstance();
        Calendar a15 = Calendar.getInstance();
        Calendar a16 = Calendar.getInstance();
        Calendar a17 = Calendar.getInstance();
        Calendar a18 = Calendar.getInstance();
        Calendar a19 = Calendar.getInstance();
        Calendar a20 = Calendar.getInstance();
        Calendar a21 = Calendar.getInstance();
        Calendar a22 = Calendar.getInstance();

        a1.set(2023, 12 - 1, 3);
        a2.set(2023, 1 - 1, 1);
        a3.set(2023, 1 - 1, 2);
        a4.set(2023, 1 - 1, 28);
        a5.set(2023, 1 - 1, 29);
        a6.set(2023, 4 - 1, 5);
        a7.set(2023, 4 - 1, 29);
        a8.set(2023, 4 - 1, 30);
        a9.set(2023, 5 - 1, 1);
        a10.set(2023, 5 - 1, 2);
        a11.set(2023, 5 - 1, 3);
        a12.set(2023, 6 - 1, 22);
        a13.set(2023, 6 - 1, 23);
        a14.set(2023, 6 - 1, 24);
        a15.set(2023, 9 - 1, 29);
        a16.set(2023, 9 - 1, 30);
        a17.set(2023, 10 - 1, 1);
        a18.set(2023, 10 - 1, 2);
        a19.set(2023, 10 - 1, 3);
        a20.set(2023, 10 - 1, 4);
        a21.set(2023, 10 - 1, 5);
        a22.set(2023, 10 - 1, 6);

        list.add(a1);
        list.add(a2);
        list.add(a3);
        list.add(a4);
        list.add(a5);
        list.add(a6);
        list.add(a7);
        list.add(a8);
        list.add(a9);
        list.add(a10);
        list.add(a11);
        list.add(a12);
        list.add(a13);
        list.add(a14);
        list.add(a15);
        list.add(a16);
        list.add(a17);
        list.add(a18);
        list.add(a19);
        list.add(a20);
        list.add(a21);
        list.add(a22);


        for (int i = 0; i < list.size(); i++) {
            if ((temp.get(Calendar.MONTH) + 1) == ((list.get(i).get(Calendar.MONTH)) + 1) && temp.get(Calendar.DAY_OF_MONTH) == list.get(i).get(Calendar.DAY_OF_MONTH)) {
                return true;
            }
        }
        return false;
    }
}
