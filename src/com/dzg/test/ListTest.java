package com.dzg.test;

import java.util.ArrayList;

/**
 * @author shz
 * @Description: ${todo}
 * @date 2019/8/16
 */
public class ListTest {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(1);
        list.add(2);
        for (int i = 0; i <3; i++) {
            list.remove(i);
        }
        System.out.println(list.toString());
    }
}
