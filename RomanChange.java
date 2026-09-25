package com.tg.stringdemo;

import java.util.Scanner;

public class RomanChange {
    static void main() {
        String num = "";
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入一串数字");
            num = sc.next();
            if (num.length() < 10 && isNum(num)) {
                System.out.println("通过校验!");
                break;
            } else {
                System.out.println("输入有误请重试!");
            }
        }


        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            int number = c - 48;
            String str = getRoman(number);
            System.out.println(str);
        }
    }


    public static boolean isNum(String num) {
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }


    public static String getRoman(int num) {
        String[] roman = {" ", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return roman[num];
    }
}

