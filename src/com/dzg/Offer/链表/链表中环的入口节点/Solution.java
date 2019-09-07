package com.dzg.Offer.链表.链表中环的入口节点;

import java.util.HashSet;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Solution {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null) return null;

        HashSet<ListNode> set = new HashSet<>();
        while (pHead != null) {
            if (set.contains(pHead)) return pHead;
            else set.add(pHead);
            pHead = pHead.next;
        }
        return null;
    }

    public ListNode EntryNodeOfLoop2(ListNode pHead) {
        if (pHead == null || pHead.next == null || pHead.next.next == null) return null;
        ListNode slow = pHead.next;
        ListNode fast = slow.next;
        while (fast != slow) {
            if (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            } else return null;
        }
        slow = pHead;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}
