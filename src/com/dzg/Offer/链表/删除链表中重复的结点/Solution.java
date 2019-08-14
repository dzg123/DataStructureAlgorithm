package com.dzg.Offer.链表.删除链表中重复的结点;

import java.util.*;

public class Solution {
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) return pHead;
        HashMap<Integer, ListNode> map = new LinkedHashMap<>();
        HashSet<Integer> set = new HashSet<>();
        while (pHead != null) {
            if (!set.contains(pHead.val) && !map.containsKey(pHead.val)) map.put(pHead.val, pHead);
            else if (map.containsKey(pHead.val)) map.remove(pHead.val);
            set.add(pHead.val);
            pHead = pHead.next;
        }
        ArrayList<ListNode> listNodes = new ArrayList<>(map.values());
        if (listNodes.isEmpty()) return null;
        for (int i = 0; i < listNodes.size() - 1; i++) {
            listNodes.get(i).next = listNodes.get(i + 1);
        }
        listNodes.get(listNodes.size() - 1).next = null;
        return listNodes.get(0);
    }
}
