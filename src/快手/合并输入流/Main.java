package 快手.合并输入流;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        s = s.replaceAll(" ", "");
        String s2 = sc.nextLine();
        s2 = s2.replaceAll(" ", "");
        int l = s.length();
        int l2 = s2.length();
        int count = 0;
        if (l <= 4) {
            System.out.println(s + s2);
            System.exit(0);
        } else {
            count = l % 4 > 0 ? l / 4 : l / 4 - 1;
        }
        if (count > 0 && count >= l2) {
            for (int i = 0; i < l2; i++) {
                s = s.substring(0, (i + 1) * 4 + i) + s2.charAt(i) + s.substring((i + 1) * 4 + i, l + i);

            }
        } else if (count < l2) {
            for (int i = 0; i < count; i++) {
                s = s.substring(0, (i + 1) * 4 + i) + s2.charAt(i) + s.substring((i + 1) * 4 + i, l + i);
            }
            s += s2.substring(count, l2);
        }
        String newS = "";
        for (int i = 0; i < s.length(); i++) {
            newS += s.substring(i, i + 1);
            if (i != s.length() - 1) newS += " ";
        }
        System.out.println(newS);
    }
}
