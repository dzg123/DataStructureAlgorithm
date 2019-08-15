package com.dzg.bk.打字;

import java.util.Scanner;

/**
 * @author shz
 * @Description: ${todo}
 * @date 2019/8/8
 */

//小明同学刚刚学习打字，现在老师叫他输入一个英文字符串。小明发现，这个英文字符串只由大写和小写 的英文字母构成。
// 小明同学只会使用 Caps Lock 键来切换大小写输入。最开始，大写锁定处于关闭状态， 小明的电脑只能输入小写英文字母。
// 当大写锁定关闭时，按一下Caps Lock键可以打开大写锁定，之后只 能输入大写字母；当大写锁定打开时，按一下 Caps Lock 键可以关闭大写锁定，之后只能输入小写字母。 现在小明想知道输入这个字符串最少需要按键多少次。
// 输入描述： 输入只有一行，一个字符串，字符串中只有大写字母和小写字母，字符串长度不超过100000。 输出描述： 输出一行，最少的按键次数。
// 输入样例： aAAbB 输出描述： 8 样例解释：按键方式为：a+Caps Lock+A+A+Caps Lock+b+Caps Lock+B。
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        if (s == null) System.out.println(0);
        if (s.length() <= 1) System.out.println(s.length());
        int count = 0;

        for (int i = 1; i < s.length(); i++) {
            if (smallLetter(s.charAt(i)) - smallLetter(s.charAt(i - 1)) != 0) count++;
        }
        System.out.println(count + s.length());
    }

    private static int smallLetter(char a) {
        if ('a' <= a && a <= 'z') return 0;
        else return 1;
    }

}


