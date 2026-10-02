package com.cs37.shop;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ScheduledExecutorService;

public class Casher {
    public static void main(String[] args) throws InterruptedException {

        GetGoods saler = new GetGoods();

        System.out.println("要开始营业吗,0开始1结束");
        boolean mainControl = commonChoice();
        long start = System.currentTimeMillis();
        int orderCount = 0;


        while (mainControl) {
            Thread.sleep(1000);
            LocalDateTime today = LocalDateTime.now();
            System.out.println("营业开始后可随时取消,0继续1结束");
            mainControl = commonChoice();
            if (mainControl) {
                System.out.println("当前订单" + orderCount + " 时间" + today);
                Thread.sleep(1000);
                ArrayList<Goods> guestOrder = saler.getGoods();
                if(guestOrder == null){
                    System.out.println("请接待下一位顾客");
                    Thread.sleep(1000);
                    continue;
                }
                else {
                    Thread.sleep(1000);
                System.out.println("要结算订单吗,0结算1修改");
                Random r = new Random();
                int button = r.nextInt(10);
                if(button % 3 == 0){
                Case.giveUp(guestOrder);
                }
                boolean cashControl = commonChoice();
                //结算或取消
                if (cashControl) {
                    Thread.sleep(1000);
                    System.out.println("正在为您结算");
                    saler.getCasher(guestOrder);
                    //取得订单和总价后看看要不要修改或取消
                } else {
                    Thread.sleep(1000);
                    System.out.println("要修改订单吗,0修改1取消");
                    boolean changeControl = commonChoice();
                    //修改后再次结算
                    if (changeControl) {
                        saler.changeOrder(guestOrder);
                        saler.getCasher(guestOrder);
                        //或者选择取消
                    } else {
                        System.out.println("订单已取消");
                    }
                    Thread.sleep(1000);
                }
                }
                //不营业了就结束循环
            } else {
                break;
            }
            Thread.sleep(1000);
            orderCount++;
        }
        long end = System.currentTimeMillis();
        System.out.println("下班喵");
        System.out.println("今日打卡" + ((end - start) / 1000) + "秒");

    }

    //通用选项方法
    public static boolean commonChoice() {
        System.out.println("请输入您的选择");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        if (choice == 0) {
            return true;
        } else {
            return false;
        }
    }


}
