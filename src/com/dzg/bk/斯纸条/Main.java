package com.dzg.bk.斯纸条;

import java.util.Scanner;

/**
 * @author shz
 * @Description: ${todo}
 * @date 2019/8/7
 */
//小B正处于百无聊赖中，提不起干活的兴趣。看到桌面上的一条带着方格纸带，于是随手拿起一支笔，在 纸带的每个方格中写上一个随机想起的数字。然后把纸带折起来撕成两半，她突然发现两半中各个数值加 起来的和竟然是一样的。小B一下子有了一点精神，她想知道可以有多少种方式把纸带撕成两半，仍然使 得两边的数值之和是相等的。你能帮她吗？
// 输入描述： 测试数据有多组，每组测试数据的第一行为一个整数 n（1=< n <=100000），为纸带上的方格数，第二 行为n个空格分隔的数值，为小B写入方格的数值，所有的数都是绝对值不超过10000的整数。
// 输出描述： 对每组测试数据，在单独的行中输出不同撕法的总数，使得两边纸带中的数值之和相等。将纸带撕成两半 时，只能沿方格的边缘撕开。
// 输入样例：
// 3
//            1 1 1
//            9
//            1 5 -6 7 9 -16 0 -2 2
//            2
//            0 0
//
// 输出样例： 0
//           3
//           1
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int count = 0;
            int sum = 0;
            int num = scanner.nextInt();
            int[] arr = new int[num];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = scanner.nextInt();
                sum += arr[i];
            }
            if (sum % 2 != 0) {
                System.out.println(count);
                break;
            }
            int temp = 0;
            for (int i = 0; i < arr.length; i++) {
                temp += arr[i];
                if (i != arr.length - 1 && temp == sum / 2) count++;
            }
            System.out.println(count);
        }
    }
}
