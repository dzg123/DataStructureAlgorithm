package com.dzg.ali.逆序输出链表;

/**
 * @author shz
 * @Description: ${todo}
 * @date 2019/8/23
 */
class Node {
    int data;
    Node next;

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}

public class Solution {
    public void reverse(Node head) {
        if (head == null || head.next == null) {
            return;
        }
        Node pre = null;
        Node cur = head.next;
        Node next;
        while (cur != null) {
            if (cur.next == null) {
                cur.next = pre;
                break;
            }
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        head.next = cur;
        Node temp = head.next;
        while (temp != null) {
            System.out.print(temp + " ");
            temp = temp.next;
        }

    }
}
