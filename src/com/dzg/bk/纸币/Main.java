package com.dzg.bk.纸币;

import java.util.Scanner;

/**
 * @author shz
 * @Description: ${todo}
 * @date 2019/8/8
 */
//人民币有很多不同面值的纸币，在本题中，只考虑以下7种面值的纸币，它们分别为：1 元、2元、5元、 10元、20元、50元、100元。
// 你知道凑出n元最少需要多少张纸币吗？
// 输入描述: 第一行输入一个数T（1<=T<=10000），表示数据组数。接下来有T行，每行一个数n（1<=n<=100000）。
// 输出描述： 每组数据输出一行，最少需要的纸币数。
// 输入样例：
// 5
// 3
// 4
// 5
// 9
// 99
//
// 输出样例：
// 2
// 2
// 1
// 3
// 6
// 样例解释： 样例中第一行为5，表示一共有5组数据。 第一组数据为3，答案为：1张1元+1张2元，一共2张纸币。
// 第二组数据为4，答案为：2张2元，一共2张纸币。 第三组数据为5，答案为：1张5元，一共1张纸币。 第四组数据为9，答案为：2张2元+1张5元，一共3张纸币。
// 第五组数据为99，答案为：2张2元+1张5元+2张20元+1张50元，一共6张纸币
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] coins = {1, 2, 5, 10, 20, 50, 100};
        int num = sc.nextInt();
        for (int i = 0; i < num; i++) {
            int money = sc.nextInt();
            int[] dp = new int[money + 1];
            dp[0] = 0;
            for (int j = 1; j < dp.length; j++) {
                dp[j] = money + 1;
            }
            for (int j = 1; j <= money; j++) {
                for (int k = 0; k < coins.length; k++) {
                    if (j >= coins[k]) {
                        dp[j] = Math.min(dp[j], dp[j - coins[k]] + 1);
                    }
                }
            }
            int res = dp[money] > money ? -1 : dp[money];
            System.out.println(res);
        }
    }
}
