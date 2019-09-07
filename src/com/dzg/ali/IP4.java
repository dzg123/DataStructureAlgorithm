package com.dzg.ali;

/**
 * @author shz
 * @Description: ${todo}
 * @date 2019/9/7
 */
//实现一个方法，接收一个字符串，验证其是否为 IPv4 格式地址
public class IP4 {
    public static boolean isIPv4Address(String address) {
        if (address == null || address.length() == 0) {
            return false;
        }
        String[] s = address.split("\\.");
        if (s.length != 4) return false;
        for (int i = 0; i < s.length; i++) {
            char[] array = s[i].toCharArray();
            for (char c : array) {
                if (c<'0' || c >'9') return false;
            }
            if (s[i].length() > 1 && s[i].startsWith("0")) return false;
            int num = Integer.parseInt(s[i]);
            if (num < 0 || num > 255) {
                return false;
            }

        }
        return true;
    }

    public static void main(String[] args) {
       // true
//        System.out.println(isIPv4Address("192.6.254.1"));
//        System.out.println(isIPv4Address("192.06.254.1"));
//        System.out.println(isIPv4Address("192.6.256.1"));
//        System.out.println(isIPv4Address("blah blah"));
        System.out.println(isIPv4Address("a.6.256.1"));
//    isIPv4Address("192.06.254.1"); // false
//    isIPv4Address("192.6.256.1"); // false
//  isIPv4Address("blah blah"); // false
    }
}
