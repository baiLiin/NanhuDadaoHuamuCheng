package com.cs37.stringdemo;

import java.util.Scanner;

public class MoneyChange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num;
        while(true){
            System.out.println("请输入金额");
            num = sc.nextInt();
            if(num > 0 && num < 99999999){
                break;
            } else{
                System.out.println("金额无效请检查");
            }
        }

        String moneyStr = "";
        while(true){
            int ge = num % 10;
            String capitalNum = getCapitalNum(ge);
            moneyStr = moneyStr + capitalNum;
            num = num / 10;
            if(num == 0){
                break;
            }
        }


        int count = 7 - moneyStr.length();
        for (int i = 0; i < count; i++) {
            moneyStr = "零" + moneyStr;
        }

        String result = "";
        String[] arr = {"仟","佰","拾","萬","仟","佰","拾","圆"};
        for (int i = 0; i < moneyStr.length(); i++) {
            char a = moneyStr.charAt(i);
            result = result + a + arr[i];
        }

        System.out.println(result);


    }

    public static String getCapitalNum(int num){
        String[] arr = {"零","壹","贰","仨","肆","伍","陆","柒","捌","玖"};
        return arr[num];
    }
}
