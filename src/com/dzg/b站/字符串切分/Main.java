package com.dzg.b站.字符串切分;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author shz
 * @Description: ${todo}
 * @date 2019/9/10
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int count = 0;
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        String[] split = s.split(" ");
        String[] keyValues = split[2].split(split[0]);
        for (String kv : keyValues) {
            String[] split1 = kv.split(split[1]);
            if (split1.length != 2) continue;
            if (!split1[0].isEmpty() && !split1[1].isEmpty()) {
                count++;
                map.put(split1[0], split1[1]);
            }
        }
        System.out.println(count);
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

    }
}
