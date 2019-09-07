package com.dzg.LeetCode.链表.环形链表;

import java.util.HashSet;

public class Solution {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    //哈希表法空间复杂度为O(n)
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> nodes = new HashSet<>();
        while (head != null) {
//            nodes.add(head);
//            head = head.next;
//            if (head != null && nodes.contains(head)) return true;
            if (nodes.contains(head)) return true;
            else nodes.add(head);
            head = head.next;

        }
        return false;

    }

    //    快慢指针法：空间复杂度为O(test1)
    public boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

}
