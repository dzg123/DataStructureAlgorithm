package com.dzg.Offer.链表.两个链表的第一个公共结点;

import java.util.HashSet;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int length = FindLinkedListLength(pHead1);
        int length2 = FindLinkedListLength(pHead2);
        return length < length2 ? FindFirst(pHead2, pHead1) : FindFirst(pHead1, pHead2);
    }

    private int FindLinkedListLength(ListNode node) {
        if (node == null) return 0;
        int sum = 0;
        while (node != null) {
            node = node.next;
            sum++;
        }
        return sum;
    }

    private ListNode FindFirst(ListNode pHead1, ListNode pHead2) {
        HashSet<ListNode> set = new HashSet<>();
        while (pHead1 != null) {
            if (set.contains(pHead1)) break;
            set.add(pHead1);
            pHead1 = pHead1.next;
        }
        while (pHead2 != null) {
            if (set.contains(pHead2)) return pHead2;
            pHead2 = pHead2.next;
        }
        return null;
    }

    //    双指针遍历链表环法
    public ListNode FindFirstCommonNode2(ListNode pHead1, ListNode pHead2) {
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while (p1 != p2) {
            p1 = p1 == null ? pHead2 : p1.next;
            p2 = p2 == null ? pHead1 : p2.next;
        }
        return p1;
    }
}
