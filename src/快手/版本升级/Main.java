package 快手.版本升级;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int min;
        for (int i = 0; i < count; i++) {
            String s = sc.next();
            String s2 = sc.next();
            int[] v1 = tranStringtoArr(s.split("\\."));
            int[] v2 = tranStringtoArr(s2.split("\\."));
            min = v1.length < v2.length ? v1.length : v2.length;
            for (int j = 0; j < min; j++) {
                if (v2[j] - v1[j] > 0) {
                    System.out.println("true");
                    break;
                } else if (v2[j] - v1[j] < 0) {
                    System.out.println("false");
                    break;
                }
            }
            if (v1.length != v2.length && min == v1.length) {
                for (int j = min; j < v2.length; j++) {
                    if (v2[j] > 0) {
                        System.out.println("true");
                        break;
                    }
                    if (j == v2.length-1) System.out.println("false");
                }

            }
            if (v1.length != v2.length && min == v2.length) {
                for (int j = min; j < v1.length; j++) {
                    if (v1[j] >= 0) {
                        System.out.println("false");
                        break;
                    }
                }
            }
        }
    }

    private static int[] tranStringtoArr(String[] strings) {
        return Arrays.stream(strings).mapToInt(Integer::parseInt).toArray();

    }

}
//2
//        6.6.6 6.6.7
//        1 1.0
