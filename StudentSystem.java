package com.tg.arraylisttest;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentSystem {
    //添加学生的方法
    public static void addStudent(ArrayList<Student> list) {
        //用户录入id;
        Scanner sc = new Scanner(System.in);
        String id = "";
        //使用循环检查id是否重复
        while (true) {
            System.out.println("请输入需要添加的学生id");
            id = sc.next();
            if (isIdExist(id, list)) {
                break;//无重复,跳出循环
            } else {
                System.out.println("id已存在,请重新输入");
            }
        }

        //检查完成后开始添加学生
        System.out.println("正在为您添加学生");
        Student s = new Student();
        s.setId(id);
        System.out.println("请输入需要添加的学生姓名");
        String name = sc.next();
        s.setName(name);
        System.out.println("请输入需要添加的学生年龄");
        int age = sc.nextInt();
        s.setAge(age);
        System.out.println("请输入需要添加的学生住址");
        String address = sc.next();
        s.setAddress(address);

        //将对象加入集合
        list.add(s);
        System.out.println("添加成功!");
    }


    //删除学生的方法
    public static void delStudent(ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);
        String id = null;
        System.out.println("请输入需要删除的学生id");
        id = sc.next();
        //先判断id是否存在
        if (isIdExist(id, list)) {
            System.out.println("id不存在,请检查!");
            return;
        } else {
            //id存在,调用方法删除学生;
            list.remove(getStudent(id, list));
            System.out.println("已成功删除学生");
        }
    }


    //修改学生的方法
    public static void resStudent(ArrayList<Student> list) {
        //输入旧的学生id查询学生,存在直接修改,不存在就返回
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入需要修改的学生id");
        String id = sc.next();
        if (isIdExist(id, list)) {
            System.out.println("id不存在!请检查");
            return;
        } else {
            //调用方法寻找学生对象
            Student s = getStudent(id, list);
            System.out.println("找到学生, id:" + s.getId());

            System.out.println("请输入新id");
            String newId = sc.next();
            System.out.println("请输入新姓名");
            String newName = sc.next();
            System.out.println("请输入新年龄");
            String newAge = sc.next();
            System.out.println("请输入新住址");
            String newAddress = sc.next();

            //添加新变量进对象
            s.setId(newId);
            s.setName(newName);
            s.setAddress(newAddress);

            System.out.println("已成功修改,新的id" + s.getId() + "年龄:" + s.getAge() +
                    "姓名" + s.getName() + "住址" + s.getAddress());

        }
    }


    //查询学生的方法
    public static void searchStudent(ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入需要查找的id");
        String id = sc.next();
        //调用方法获取学生对象
        Student s = getStudent(id, list);
        //为空返回提示
        if (s == null) {
            System.out.println("暂时没有查询到学生");
            //查询到直接打印
        } else {
            System.out.println("查询到学生id" + s.getId() + "年龄:" + s.getAge() +
                    "姓名" + s.getName() + "住址" + s.getAddress());
        }
    }


    //检查id是否存在的方法
    private static boolean isIdExist(String id, ArrayList<Student> list) {
        for (int i = 0; i < list.size(); i++) {
            Student s = list.get(i);
            if (s.getId().equals(id)) {
                return false;
            }
        }
        //等检查全部完成,都没有发现id重复,再返回ture;
        return true;
    }


    //寻找学生对象的方法,返回一个对象
    private static Student getStudent(String id, ArrayList<Student> list) {
        for (int i = 0; i < list.size(); i++) {
            Student s = list.get(i);
            if (s.getId().equals(id)) {
                return s;
            }
        }
        return null;
    }
}
