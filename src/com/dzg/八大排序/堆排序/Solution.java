package com.dzg.八大排序.堆排序;

/**
 * @author shz
 * @Description: ${todo}
 * @date 2019/8/20
 */
public class Solution {
    /**
     * 建堆
     *
     * @param arr        看作是完全二叉树
     * @param curRootPos 当前父节点位置
     * @param size       节点总数
     */
    private static void heapify(int[] arr, int curRootPos, int size) {
        if (curRootPos < size) {
            int left = 2 * curRootPos + 1;
            int right = 2 * curRootPos + 2;
            int max = curRootPos;
            if (left < size) {
                if (arr[left] > arr[max]) {
                    max = left;
                }
            }
            if (right < size) {
                if (arr[right] > arr[max]) {
                    max = right;
                }
            }
            if (max != curRootPos) {
                int temp = arr[max];
                arr[max] = arr[curRootPos];
                arr[curRootPos] = temp;
                //继续比较，直到完成一次建堆
                heapify(arr, max, size);
            }
        }

    }
    /**
     * 完成一次建堆，最大值在堆的顶部(根节点)
     */
    public static void maxHeapify(int[] arr, int size) {
        // 从数组的尾部开始，直到第一个元素(角标为0)
        for (int i = size - 1; i >= 0; i--) {
            heapify(arr, i, size);
        }
    }

    public static void heapSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            //每次建堆就可以排除一个元素了
            maxHeapify(arr, arr.length - i);
            int temp = arr[0];
            arr[0] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] ints = {2, 3, 1, 5, 9, 7, 3};
        heapSort(ints);
        for (int i : ints) {
            System.out.print(i + " ");
        }
    }
}
