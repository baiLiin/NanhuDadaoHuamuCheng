package com.cs37.regexdemo;

public class RegexDemo1 {
    //is 13311224567 ?
    //is 0553-2324242 ?
    //is 876232919@qq.com ?
    //is 21:12:49 ?
    //is 3426261995122400182213
    static void main() {
        String str = "13311224567";
        System.out.println(str.matches("[1][3-9]\\d{9}"));

        String str1 = "0553-2324242";
        System.out.println(str1.matches("[0]\\d{3}-?[1-9]\\d{4,9}"));

        String str2 = "876232919@qq.com";
        System.out.println(str2.matches("\\w+@[\\w&&[^_]]{2,6}(\\.[a-zA-Z]{2,3}){1,2}"));

        String str3 = "23:12:49";
        System.out.println(str3.matches("(2[0-3]|[01]\\d)(:[0-5]\\d){2}"));

        String str4 = "342626199512242212";
        System.out.println(str4.matches("[1-9]\\d{5}(18|19|20)\\d{2}([0][1-9]|[1][0-2])([0][1-9]|[12]\\d|3[01])\\d{3}(\\d|X|x)"));
    }

}
