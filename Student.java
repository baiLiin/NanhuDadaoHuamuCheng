package com.tg.arraysdemo1;

public class Student {
    private String name;
    private int age;
    private double height;

    public Student(){

    }

    public Student(String name,int age,double height){
        this.name = name;
        this.age = age;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "学生姓名:" + getName() + "年龄" + getAge() + "身高" + getHeight();
    }
}

