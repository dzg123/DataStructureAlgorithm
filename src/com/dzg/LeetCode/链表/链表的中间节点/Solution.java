package com.dzg.LeetCode.链表.链表的中间节点;

public class Solution {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
//快慢指针
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null) {
            if (fast.next == null) return slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
