package com.cs37.shop;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Case {

    //顾客不要随机商品的随机事件
    public static void giveUp(ArrayList<Goods> guestOrder) {
        Random r = new Random();
        int index = r.nextInt(guestOrder.size());
        Goods hand = guestOrder.get(index);
        System.out.println("顾客不想要: " + hand.getTag() + " id: " + hand.getId() + "了");
    }

    //为顾客随机优惠的事件
    public static double getCheap(double charge){
        double cheapPrice = charge;
        Random r = new Random();
        int cheapNum = r.nextInt(10);
        if(cheapNum % 2 == 0){
            System.out.println("本单优惠2%");
            cheapPrice = cheapPrice * 0.98;
        } else if (cheapNum % 3 == 0){
            System.out.println("本单优惠5%");
            cheapPrice = cheapPrice * 0.95;
        } else if (cheapNum % 5 == 0){
            System.out.println("本单优惠8%");
            cheapPrice = cheapPrice * 0.92;
        } else {
            System.out.println("很遗憾,没有优惠!");
        }
        return cheapPrice;
    }



}
