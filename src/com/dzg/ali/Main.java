package com.dzg.ali;

/**
 * @author shz
 * @Description: ${todo}
 * @date 2019/9/7
 */
public class Main {
    public static void triangle(int n) {
        if (n <= 0) return;
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                arr[i][0] = 1;
            }
            for (int j = 0; j < i; j++) {
                if (j == 0 || j == i) {
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = arr[i - 1][j] + arr[i - 1][j - 1];
                }
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        triangle(10);
    }
}
