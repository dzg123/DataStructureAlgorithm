package com.dzg.LeetCode.BFS.岛屿的数量;

import java.util.LinkedList;

public class Solution {
    private int rows;
    private int cols;

    public int numIslands(char[][] grid) {
        rows = grid.length;
        if (rows == 0) {
            return 0;
        }
        cols = grid[0].length;
        int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        boolean[][] marked = new boolean[rows][cols];
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!marked[i][j] && grid[i][j] == '1') {
                    count++;
                    LinkedList<Integer> queue = new LinkedList<>();
                    queue.addLast(i * cols + j);
                    marked[i][j] = true;
                    while (!queue.isEmpty()) {
                        int cur = queue.removeFirst();
                        int curX = cur / cols;
                        int curY = cur % cols;
                        for (int k = 0; k < directions.length; k++) {
                            int newX = curX + directions[k][0];
                            int newY = curY + directions[k][1];
                            if (newX >= 0 && newX < rows && newY >= 0 && newY < cols &&
                                    !marked[newX][newY] && grid[newX][newY] == '1') {
                                queue.addLast(newX * cols + newY);
                                marked[newX][newY] = true;
                            }

                        }
                    }
                }

            }

        }
        return count;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] grid1 = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};
        int numIslands1 = solution.numIslands(grid1);
        System.out.println(numIslands1);

        char[][] grid2 = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};
        int numIslands2 = solution.numIslands(grid2);
        System.out.println(numIslands2);
    }
}
