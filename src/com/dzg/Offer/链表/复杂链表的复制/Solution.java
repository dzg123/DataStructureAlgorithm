package com.dzg.Offer.链表.复杂链表的复制;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}

public class Solution {
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) return null;
        RandomListNode current = pHead;
        RandomListNode dummyNode = new RandomListNode(-1);
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        while (current != null) {
            RandomListNode node = new RandomListNode(current.label);
            map.put(current, node);
            current = current.next;
            dummyNode.next = node;
            dummyNode = node;
        }
        Set<Map.Entry<RandomListNode, RandomListNode>> set = map.entrySet();
        Iterator<Map.Entry<RandomListNode, RandomListNode>> it = set.iterator();
        while (it.hasNext()){
            Map.Entry<RandomListNode, RandomListNode> next = it.next();
            next.getValue().random = map.get(next.getKey().random);
        }
        return map.get(pHead);
    }
}
