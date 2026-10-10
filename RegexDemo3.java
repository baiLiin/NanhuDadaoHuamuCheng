package com.cs37.regexdemo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo3 {
    static void main() {
        String str =
                "电话:18511216758，18512501907\n" +
                        "或者联系邮箱:boniu@itcast.cn\n" +
                        "座机电话:01036577895，010-98911256\n" +
                        "邮箱:bohti@itcat.cn,\n" +
                        "热线电话:400-688-9090，400-618-4700，4006184500，4006189010" ;
        String regex = "(1[3-9]\\d{9})" + "|(\\w+@[[^_]&&\\w]{2,6}(?:\\.[a-zA-Z]{2,3}){1,2})" + "|(0\\d{2,3}-?[1-9]\\d{7})" + "|(400-?\\d{3}-?\\d{4})" ;
        Pattern p1 = Pattern.compile(regex);
        Matcher m1 = p1.matcher(str);
        while (m1.find()) {
            if (m1.group(1) != null) {
                System.out.println("捕捉手机号" + m1.group(1));
            } else if (m1.group(2) != null) {
                System.out.println("捕捉到邮箱" + m1.group(2));
            } else if (m1.group(3) != null) {
                System.out.println("捕捉到座机" + m1.group(3));
            } else if (m1.group(4) != null) {
                System.out.println("捕捉到专线" + m1.group(4));
            }
        }
    }
}
