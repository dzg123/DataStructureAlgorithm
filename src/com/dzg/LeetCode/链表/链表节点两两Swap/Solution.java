package com.dzg.LeetCode.链表.链表节点两两Swap;


import com.dzg.LeetCode.链表.ListNode;

/**
 * @author shz
 * @Description: ${todo}
 * @date 2019/8/13
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = head;
        ListNode cur = head.next;
        ListNode next;
        ListNode dummy = cur;
        while (cur != null) {
            next = cur.next;
            if (next == null) {
                cur.next = pre;
                pre.next = null;
                break;
            }
            pre.next = next.next == null ? next : next.next;
            cur.next = pre;
            pre = next;
            cur = next.next;
        }
        return dummy;
    }

    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;


        return dummy.next;
    }
}
