package com.dzg.小米.s2048;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static String solution(String[] input) {
        String[] split = input[0].split(" ");
        int[][] array = new int[input.length][split.length];
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < split.length; j++) {
                //为每一array[j][i]赋值
                for (int k = j; k < input.length; k++) {
                    if (array[k][i] != 0) {
                        if (k < 3) {
                            if (array[k][i] != array[k + 1][i]) {
                                int temp = array[k][i];
                                array[k][i] = 0;
                                array[j][i] = temp;
                            } else {
                                int temp = array[k][i] * 2;
                                array[k][i] = 0;
                                array[k + 1][i] = 0;
                                array[j][i] = temp;
                            }
                        } else {
                            int temp = array[k][i];
                            array[k][i] = 0;
                            array[j][i] = temp;
                        }
                        break;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < split.length; j++) {
                if (j != split.length - 1) {
                    sb.append(array[i][j]).append(" ");
                } else sb.append(array[i][j]);
            }
            sb.append("\n");
        }
        return sb.toString();

    }

    static void solution2(String[] input) {
        if (input == null)
            return;
        for (int i = 0; i < input.length; i++) {
//针对每一行单独处理：1、合并相同值；2、移动位置
            String[] chars = input[i].split(" ");
            //合并相同值
            for (int j = 0; j < chars.length - 1; j++) {
                int p1 = Integer.parseInt(chars[j]);
                int p2 = Integer.parseInt(chars[j + 1]);
                if (p1 != 0 && p1 == p2) {
                    chars[j] = String.valueOf(p1 + p2);
                    chars[j + 1] = String.valueOf(0);
                }
            }
            //移动位置
            StringBuilder builder = new StringBuilder();
            int count = 0;//记录0的个数
            for (int j = 0; j < chars.length; j++) {
                if (!chars[j].equals("0")) {
                    builder.append(chars[j]).append(" ");
                } else {
                    count++;
                }
            }
            while (count-- > 0) {
                builder.append("0").append(" ");
            }
            System.out.println(builder);
        }

    }

    /******************************结束写代码******************************/


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String res;

        int _input_size = 0;
        _input_size = Integer.parseInt(in.nextLine().trim());
        String[] _input = new String[_input_size];
        String _input_item;
        for (int _input_i = 0; _input_i < _input_size; _input_i++) {
            try {
                _input_item = in.nextLine();
            } catch (Exception e) {
                _input_item = null;
            }
            _input[_input_i] = _input_item;
        }

        res = solution(_input);
        System.out.println(res);
    }
}

