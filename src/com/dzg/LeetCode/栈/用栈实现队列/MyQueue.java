package com.dzg.LeetCode.栈.用栈实现队列;

import java.util.Stack;

class MyQueue {
    private Stack<Integer> stack;
    private Stack<Integer> stack2;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        this.stack = new Stack<>();
        this.stack2 = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    //两个栈相互倒置输入输出
    public void push(int x) {
        stack.clear();
        while (!stack2.isEmpty()) {
            stack.push(stack2.pop());
        }
        stack2.push(x);
        while (!stack.isEmpty()) stack2.push(stack.pop());

    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        return stack2.pop();

    }

    /**
     * Get the front element.
     */
    public int peek() {
        return stack2.peek();

    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return stack2.isEmpty();

    }
}
