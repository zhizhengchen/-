package com.zhiyou.Game.LotteryTicket;

import java.util.ArrayList;
import java.util.HashMap;



/**
 *双色球规则红球33选6，蓝球16选1，不允许重复
 *使用Math类的random()方法在1到33内随机产生6个红球号码，每产生一个判断是否已经在数组中存在 ，不存在则保存于数组，否则重选
 *从1到16间随机产生一个蓝球号码
 * 结果储存在HashMap中 用key值存储篮球,红球用ArrayList<Integer> 存储在value中
 */
public class Number {
    private Integer BlueNumber ;
    private ArrayList<Integer> RedNumbers ;
    private HashMap<Integer,ArrayList<Integer>> numbers;


    public Number() {
    }

    public Number(Integer BlueNumber, ArrayList<Integer> RedNumbers, HashMap<Integer, ArrayList<Integer>> numbers) {
        this.BlueNumber = BlueNumber;
        this.RedNumbers = RedNumbers;
        this.numbers = numbers;
    }

    /**
     * 获取
     * @return BlueNumber
     */
    public Integer getBlueNumber() {
        return BlueNumber;
    }

    /**
     * 设置
     */
    public void setBlueNumber() {
        System.out.print("开始选择蓝球号码" + "\t");
        this.BlueNumber = (int) (Math.random() * 16) + 1;
        System.out.println(toShowBlueNumber());
    }

    /**
     * 获取
     * @return RedNumbers
     */
    public ArrayList<Integer> getRedNumbers() {
        return RedNumbers;
    }

    /**
     * 设置
     */
    public void setRedNumbers() {
        ArrayList<Integer> tempRedNumbers = new ArrayList<>();
        System.out.print("开始选择红球号码" + "\t");
        for (int i = 0; i <6 ;) {
            Integer TempNumber = (int) (Math.random() * 33) + 1;
            if (! tempRedNumbers.contains(TempNumber)) {
                tempRedNumbers.add(TempNumber);
                i++;
            }
        }
        this.RedNumbers = tempRedNumbers;
        System.out.println(toShowRedNumber());
    }
    /**
     * 设置
     */
    public void setNumbers() {
        HashMap<Integer,ArrayList<Integer>> tempNumbers = new HashMap<>();
        setRedNumbers();
        setBlueNumber();

        tempNumbers.put(getBlueNumber(),getRedNumbers());
        this.numbers = tempNumbers;
    }

    public String toString() {
        return "Number{BlueNumber = " + BlueNumber + ", RedNumbers = " + RedNumbers + ", numbers = " + numbers + "}";
    }
    public String toShowRedNumber() {
        return "红球号码为: " +
                this.RedNumbers.get(0) + "\t" + this.RedNumbers.get(1)  + "\t" +this.RedNumbers.get(2) + "\t" +
                this.RedNumbers.get(3) + "\t" + this.RedNumbers.get(4)  + "\t" +this.RedNumbers.get(5);
    }
    public String toShowBlueNumber() {
        return "篮球号码为: " + this.BlueNumber;
    }
    public String toShow() {
        return toShowRedNumber() + "\n" + toShowBlueNumber();
    }
}
