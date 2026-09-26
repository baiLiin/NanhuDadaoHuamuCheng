package com.tg.stringdemo;

import java.util.Random;

public class CodeCreator {
    static void main() {
        String str = getStr();
        String result = getNum(str);
        System.out.println("您的验证码为" + result);
    }

    public static String getStr() {
        String str = "";
        String arr = "abcdefghigklmnopqrstuvwxyzABCDEFGHIGKLMNOPQRSTUVWXYZ";
        Random r = new Random();
        for (int i = 0; i < 4; i++) {
            int index = r.nextInt(5);
            char c = arr.charAt(index);
            str = str + c;
        }
        return str;
    }

    public static String getNum(String str) {
        Random r = new Random();
        int num = r.nextInt(11) - 1;
        str = str + num;
        char[] arr = str.toCharArray();
        int index = r.nextInt(arr.length);
            char temp = arr[index];
            arr[index] = arr[4];
            arr[4] = temp;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}
