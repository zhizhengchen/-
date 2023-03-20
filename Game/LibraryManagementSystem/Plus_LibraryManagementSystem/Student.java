package com.zhiyou.Game.LibraryManagementSystem.Plus_LibraryManagementSystem;

public class Student {
    private String name;
    private int age;
    private double score;

    public Student(){};
    public Student(String name, int age,double score){
        this.age = age;
        this.name = name;
        this.score = score;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age = age;
    }
    public double getScore(){
        return score;
    }
    public void setScore(double score){
        this.score = score;
    }
    public String showInfo(){
        return "名字"+name+"年龄"+age+"分数"+score;
    }

}
