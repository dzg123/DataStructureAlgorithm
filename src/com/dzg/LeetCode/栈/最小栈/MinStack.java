package com.dzg.LeetCode.栈.最小栈;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
//底层用数组来实现，同时用一个栈来保存当前最小值
class MinStack {
    private List<Integer> list;
    private Stack<Integer> minNumStack;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        this.list = new ArrayList<>();
        this.minNumStack = new Stack<>();

    }

    public void push(int x) {
        if (minNumStack.isEmpty()) minNumStack.push(x);
        else if (x <= minNumStack.peek()) minNumStack.push(x);
        list.add(x);
    }

    public void pop() {
        Integer pop = list.get(list.size() - 1);
        if (pop.equals(minNumStack.peek())) minNumStack.pop();
        list.remove(list.size() - 1);

    }

    public int top() {
        return list.get(list.size() - 1);
    }

    public int getMin() {
        return minNumStack.peek();

    }
}
