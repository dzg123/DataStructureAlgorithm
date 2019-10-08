package com.dzg.$360.连续最长的数字串;

/**
 * @author shz
 * @Description: ${todo}
 * @date 2019/9/16
 */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String res = "";
        int count;
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if ('0' <= arr[i] && '9' >= arr[i]) {
                count = 1;
                int index = i;
                for (int j = i + 1; j < arr.length; j++) {
                    if ('0' <= arr[j] && '9' >= arr[j]) {
                        count++;
                        index = j;
                    } else {
                        break;
                    }
                }
                if (count > res.length()) {
                    res = s.substring(i, index + 1);
                }
            }
        }

        System.out.println(res.length() + "/" + res);
    }
}

