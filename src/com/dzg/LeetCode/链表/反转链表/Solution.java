package com.dzg.LeetCode.链表.反转链表;

import java.util.ArrayList;

public class Solution {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //头插法，迭代实现
    public ListNode reverseList(ListNode head) {
        ListNode newHead = new ListNode(-1);
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead.next;
            newHead.next = head;
            head = next;
        }
        return newHead.next;
    }

    //    递归实现
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode next = head.next;
        ListNode node = reverseList2(next);
        next.next = head;
        head.next = null;
        return node;
    }
}
