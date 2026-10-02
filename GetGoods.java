package com.cs37.shop;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class GetGoods {

    //设置初始店铺余额
    static Shop s1 = new Shop(500);


    //设置商品
    //命名规则_生活区:l 00 | 食品区:f 10 | 生鲜区:r 20|
    //序号:1-10电子 | 50-60零食 | 100-110乳品
    static ArrayList<Goods> goodsList = new ArrayList<>();
    static Goods l1 = new Goods("battery", "001", 5);
    static Goods l2 = new Goods("napkin", "002", 2.5);
    static Goods l3 = new Goods("usbLine", "003", 15);
    static Goods l4 = new Goods("zipper", "004", 9.9);
    static Goods l5 = new Goods("headPhone", "005", 20.9);
    static Goods f50 = new Goods("chips", "101", 6.3);
    static Goods f51 = new Goods("chocolate", "102", 8.9);
    static Goods f52 = new Goods("bread", "103", 6);
    static Goods f53 = new Goods("biscuit", "104", 12.5);
    static Goods f54 = new Goods("beefCan", "105", 14.9);

    //录入商品
    static {
        goodsList.add(l1);
        goodsList.add(l2);
        goodsList.add(l3);
        goodsList.add(l4);
        goodsList.add(l5);
        goodsList.add(f50);
        goodsList.add(f51);
        goodsList.add(f52);
        goodsList.add(f53);
        goodsList.add(f54);
    }

    //获取商品的方法
    public static ArrayList<Goods> getGoods() throws InterruptedException {
        ArrayList<Goods> guestOrder = new ArrayList();
        Random r = new Random();
        int index;
        int kind = r.nextInt(5);
        if (kind == 0) {
            System.out.println("顾客没有购物就离开了");
            return null;
        }
        System.out.println("本单购买" + kind + "件");
        for (int i = 0; i < kind; i++) {
            Thread.sleep(1000);
            index = r.nextInt(4);
            Goods hand = goodsList.get(index);
            System.out.println("商品: " + hand.getTag() + hand.getId() + " 价格: " + hand.getPrice());
            guestOrder.add(hand);
        }

        double countPrice = getPrice(guestOrder);
        System.out.println("您好! 本单总价" + countPrice);
        return guestOrder;
    }

    //结算的方法
    public static void getCasher(ArrayList<Goods> guestOrder) throws InterruptedException {
        Random r = new Random();
        double firstPrice = getPrice(guestOrder);
        double countPrice = Case.getCheap(firstPrice);
        double[] currency = {5, 10, 20, 50, 100, countPrice};
        int purchase = r.nextInt(6);
        int cashCount = 0;
        while (true) {
            cashCount++;
            if (cashCount > 1) {
                int againPurchase = r.nextInt(6);
                if (currency[againPurchase] < countPrice) {
                    Thread.sleep(1000);
                    System.out.println("顾客拿出了" + currency[againPurchase] + " ,但还是不够");
                    continue;
                }
                Thread.sleep(1000);
                System.out.println("顾客重新支付: " + currency[againPurchase]);
                Thread.sleep(1000);
                System.out.println("找零" + (currency[againPurchase] - countPrice));
                break;
            }
            Thread.sleep(1000);
            System.out.println("顾客支付: " + currency[purchase]);
            //确保钱变货不变,且钱变了找零时也要跟着变
            if (currency[purchase] < countPrice) {
                System.out.println("非常抱歉,本单的价格是" + countPrice);
                continue;//钱不够让顾客再找
            }
            Thread.sleep(1000);
            System.out.println("找零" + (currency[purchase] - countPrice));
            break;//钱够了跳出结算循环
        }

        //店铺账户结算
        Thread.sleep(1000);
        double inAccount = countPrice + s1.getMoney();
        System.out.println("当前余额" + inAccount);
        s1.setMoney(inAccount);

    }

    //修改订单的方法
    public static void changeOrder(ArrayList<Goods> guestOrder) {
        while (true) {
            System.out.println("修改功能可随时退出,0继续1结束");
            boolean changeChoice = Casher.commonChoice();
            if (changeChoice) {
                System.out.println("0增加1删除");
                boolean changeControl = Casher.commonChoice();
                if (changeControl) {
                    addOrder(guestOrder);
                } else {
                    delOrder(guestOrder);
                }
            } else {
                break;
            }
        }
    }

    //增加商品的方法
    public static void addOrder(ArrayList<Goods> guestOrder) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入需要增加的商品id");
        String changeId = sc.next();
        //搜索商品
        Goods target = searchGoods(changeId, goodsList);
        if (target != null) {
            guestOrder.add(target);
            System.out.println("添加成功!" + target.getTag() + target.getId() + "价格" + target.getPrice());
            double countPrice = getPrice(guestOrder);
            System.out.println("您好! 本单总价" + countPrice);
        }
    }

    //减少商品的方法
    public static void delOrder(ArrayList<Goods> guestOrder) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入需要删除的商品id");
        String changeId = sc.next();
        Goods target = searchGoods(changeId, guestOrder);
        if (target != null) {
            guestOrder.remove(target);
            System.out.println("删除成功!" + target.getTag() + target.getId() + "价格" + target.getPrice());
            double countPrice = getPrice(guestOrder);
            System.out.println("您好! 本单总价" + countPrice);
        }
    }

    //寻找商品的方法
    public static Goods searchGoods(String changeId, ArrayList<Goods> targetList) {
        for (int i = 0; i < targetList.size(); i++) {
            Goods hand = targetList.get(i);
            if (hand.getId().equals(changeId)) {
                return hand;
            }
        }
        System.out.println("没有找到这个商品");
        return null;
    }

    //计算总价的方法
    public static double getPrice(ArrayList<Goods> guestOrder) {
        double countPrice = 0;
        Goods hand = null;
        for (int i = 0; i < guestOrder.size(); i++) {
            hand = guestOrder.get(i);
            countPrice = hand.getPrice() + countPrice;
        }
        return countPrice;
    }
}





