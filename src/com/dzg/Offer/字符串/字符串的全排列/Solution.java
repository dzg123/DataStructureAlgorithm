package com.dzg.Offer.字符串.字符串的全排列;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
/**
 * test1、递归算法
 * <p>
 * 解析：http://www.cnblogs.com/cxjchen/p/3932949.html  (感谢该文作者！)
 * <p>
 * 对于无重复值的情况
 * <p>
 * 固定第一个字符，递归取得首位后面的各种字符串组合；
 * 再把第一个字符与后面每一个字符交换，并同样递归获得首位后面的字符串组合；
 * *递归的出口，就是只剩一个字符的时候，递归的循环过程，就是从每个子串的第二个字符开始依次与第一个字符交换，然后继续处理子串。
 * <p>
 * 假如有重复值呢？
 * *由于全排列就是从第一个数字起，每个数分别与它后面的数字交换，我们先尝试加个这样的判断——如果一个数与后面的数字相同那么这两个数就不交换了。
 * 例如abb，第一个数与后面两个数交换得bab，bba。然后abb中第二个数和第三个数相同，就不用交换了。
 * 但是对bab，第二个数和第三个数不 同，则需要交换，得到bba。
 * 由于这里的bba和开始第一个数与第三个数交换的结果相同了，因此这个方法不行。
 * <p>
 * 换种思维，对abb，第一个数a与第二个数b交换得到bab，然后考虑第一个数与第三个数交换，此时由于第三个数等于第二个数，
 * 所以第一个数就不再用与第三个数交换了。再考虑bab，它的第二个数与第三个数交换可以解决bba。此时全排列生成完毕！
 **/
public class Solution {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<>();
        if (str != null && str.length() > 0) {
            PermutationHelper(str.toCharArray(), 0, list);
            Collections.sort(list);
        }
        return list;
    }

    private void PermutationHelper(char[] chars, int i, ArrayList<String> list) {
        if (i == chars.length - 1) list.add(String.valueOf(chars));
        else {
            Set<Character> charSet = new HashSet<Character>();
            for (int j = i; j < chars.length; j++) {
                if (j == i || !charSet.contains(chars[j])) {
                    charSet.add(chars[j]);
                    swap(chars,i,j);
                    PermutationHelper(chars,i+1,list);
                    swap(chars,j,i);
                }
            }
        }

    }

    private void swap(char[] cs, int i, int j) {
        if (i == j) return;
        char temp = cs[i];
        cs[i] = cs[j];
        cs[j] = temp;
    }
}


//这一段就是回溯法，这里以"abc"为例

//递归的思想与栈的入栈和出栈是一样的,某一个状态遇到return结束了之后，会回到被调用的地方继续执行

//test1.第一次进到这里是ch=['a','b','c'],list=[],i=0，我称为 状态A ，即初始状态
//那么j=0，swap(ch,0,0)，就是['a','b','c']，进入递归，自己调自己，只是i为1，交换(0,0)位置之后的状态我称为 状态B
//i不等于2，来到这里，j=test1，执行第一个swap(ch,test1,test1)，这个状态我称为 状态C1 ,再进入fun函数，此时标记为T1，i为2，那么这时就进入上一个if，将"abc"放进list中
/////////////-------》此时结果集为["abc"]

//2.执行完list.add之后，遇到return，回退到T1处，接下来执行第二个swap(ch,test1,test1)，状态C1又恢复为状态B
//恢复完之后，继续执行for循环，此时j=2,那么swap(ch,test1,2),得到"acb"，这个状态我称为C2,然后执行fun，此时标记为T2,发现i+test1=2,所以也被添加进结果集，此时return回退到T2处往下执行
/////////////-------》此时结果集为["abc","acb"]
//然后执行第二个swap(ch,test1,2)，状态C2回归状态B,然后状态B的for循环退出回到状态A

//             a|b|c(状态A)
//               |
//               |swap(0,0)
//               |
//             a|b|c(状态B)
//             /  \
//   swap(test1,test1)/    \swap(test1,2)  (状态C1和状态C2)
//           /      \
//         a|b|c   a|c|b

//3.回到状态A之后，继续for循环，j=test1,即swap(ch,0,test1)，即"bac",这个状态可以再次叫做状态A,下面的步骤同上
/////////////-------》此时结果集为["abc","acb","bac","bca"]

//             a|b|c(状态A)
//               |
//               |swap(0,test1)
//               |
//             b|a|c(状态B)
//             /  \
//   swap(test1,test1)/    \swap(test1,2)  (状态C1和状态C2)
//           /      \
//         b|a|c   b|c|a

//4.再继续for循环，j=2,即swap(ch,0,2)，即"cab",这个状态可以再次叫做状态A，下面的步骤同上
/////////////-------》此时结果集为["abc","acb","bac","bca","cab","cba"]

//             a|b|c(状态A)
//               |
//               |swap(0,2)
//               |
//             c|b|a(状态B)
//             /  \
//   swap(test1,test1)/    \swap(test1,2)  (状态C1和状态C2)
//           /      \
//         c|b|a   c|a|b

//5.最后退出for循环，结束。

//交换数组的两个下标的元素


