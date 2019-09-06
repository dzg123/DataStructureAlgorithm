package com.dzg.didi.地下迷宮;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    private static int[][] arr;
    private static int[][] mark;
    private static int n, m;
    private static int remainP = 0;    // 找到路径是剩余的体力值
    private static LinkedList<String> temp = new LinkedList<>();
    private static LinkedList<String> path;
    private static boolean flag;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int p = sc.nextInt();
        arr = new int[n][m];
        mark = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        DFS(0, 0, p);
        if (flag) {
            for (int i = 0; i < path.size(); i++) {
                if (i == path.size() - 1) {
                    System.out.println(path.get(i));
                    continue;
                }
                System.out.print(path.get(i) + ",");

            }
        } else {
            System.out.print("Can not escape!");
        }
    }

    private static void DFS(int row, int col, int p) {
        if (row >= 0 && row < n && col >= 0 && col < m && arr[row][col] == 1
                && mark[row][col] == 0 && p >= 0) {
            temp.add("[" + row + "," + col + "]");
            mark[row][col] = 1;
            if (row == 0 && col == m - 1) {
                if (p >= remainP) {
                    remainP = p;
                    path = new LinkedList<>(temp);
                }
                flag = true;
                mark[row][col] = 0;
                temp.removeLast();
            } else {
//                递归
                DFS(row + 1, col, p);
                DFS(row - 1, col, p - 3);
                DFS(row, col - 1, p - 1);
                DFS(row, col + 1, p - 1);
                // 回溯
                mark[row][col] = 0;
                temp.removeLast();
            }
        }
    }
}
