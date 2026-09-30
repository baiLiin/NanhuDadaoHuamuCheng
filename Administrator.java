package com.tg.arraylisttest;

import java.lang.runtime.SwitchBootstraps;
import java.util.ArrayList;
import java.util.Scanner;

public class Administrator {
    static void main() {
        ArrayList<Student>list = new ArrayList<>();


        while (true) {
            System.out.println("------------------欢迎来到学生管理系统---------------------");
            System.out.println("请输入您的选择");
            System.out.println("1 : 添加学生");
            System.out.println("2 : 删除学生");
            System.out.println("3 : 修改学生");
            System.out.println("4 : 查询学生");
            System.out.println("5 : 退出");
            Scanner sc = new Scanner(System.in);
            int choose = sc.nextInt();

            switch (choose) {
                case 1 -> StudentSystem.addStudent(list);
                case 2 -> StudentSystem.delStudent(list);
                case 3 -> StudentSystem.resStudent(list);
                case 4 -> StudentSystem.searchStudent(list);
                case 5 -> System.exit(0);
                default -> System.out.println("请输入正确的选项!");
            }
        }
    }
}
