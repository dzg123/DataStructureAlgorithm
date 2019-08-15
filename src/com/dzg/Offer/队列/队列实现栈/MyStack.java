package com.dzg.Offer.队列.队列实现栈;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author shz
 * @Description: ${todo}
 * @date 2019/8/14
 */
public class MyStack {
    /**
     * Initialize your data structure here.
     */
    private Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();

    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        queue.add(x);
        int size = queue.size();
        while (size-- > 1) {
            queue.add(queue.remove());
        }
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return queue.poll();

    }

    /**
     * Get the top element.
     */
    public int top() {
        return queue.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
            return queue.isEmpty();
    }
}
