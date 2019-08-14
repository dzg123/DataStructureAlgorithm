package com.dzg;

import java.io.UnsupportedEncodingException;

public class Test {
    public static void main(String[] args) throws UnsupportedEncodingException {
        char value = (char) Integer.MAX_VALUE;
        System.out.println((int) value);//65535，char在Java中占两个字节，因为默认使用Unicode编码，内码编码为UTF-16，可以表示用两个字节表示的字符
        int length = new String("字").getBytes().length;//idea已修改为外码编码UTF-8，“字”占三个字节
        System.out.println(length);
        int length2 = new String("字").getBytes("GBK").length;//GBK编码“字”占两个字节
        System.out.println(length2);

    }
}
