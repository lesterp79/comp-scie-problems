/*
 * MinStackTwoQueues.java
 *
 * Copyright (c) 2000-2018 MotionPoint Corporation. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of
 * MotionPoint Corp. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with MotionPoint.
 */
package com.leetcode.problems.easy.stacks;

import java.util.ArrayList;
import java.util.List;

class MinStackTwoQueues {

    public static void main(String[] args) {
        //["MinStack","push","push","push","top","pop","getMin","pop","getMin","pop","push","top","getMin","push","top","getMin","pop","getMin"]
        //[[],[2147483646],[2147483646],[2147483647],[],[],[],[],[],[],[2147483647],[],[],[-2147483648],[],[],[],[]]
        //


        MinStackTwoQueues  obj = new MinStackTwoQueues ();
        obj.push(2147483646);
        System.out.println(obj.top());
        System.out.println(obj.getMin());

        obj.push(2147483646);
        System.out.println(obj.top());
        System.out.println(obj.getMin());

        obj.push(2147483647);
        System.out.println(obj.top());
        System.out.println(obj.getMin());

        obj.pop();
        System.out.println(obj.top());
        System.out.println(obj.getMin());

        obj.pop();
        System.out.println(obj.top());
        System.out.println(obj.getMin());

        obj.pop();
        System.out.println(obj.top());
        System.out.println(obj.getMin());

        obj.push(2147483647);
        System.out.println(obj.top());
        System.out.println(obj.getMin());

    }
    private List<Integer> data;
    private List<Integer> mins;

    /**
     * initialize your head structure here.
     */
    public MinStackTwoQueues() {
        data = new ArrayList<>();
        mins = new ArrayList<>();
    }

    public void push(int x) {
        data.add(x);

        if (mins.isEmpty() || x <= mins.get(mins.size() - 1)) {
            mins.add(x);
        }
    }

    public void pop() {
        if (data.isEmpty()) {
            return;
        }

        int x = data.get(data.size() - 1);
        data.remove(data.size() - 1);

        if (mins.get(mins.size() - 1) == x) {
            mins.remove(mins.size() - 1);
        }
    }

    public int top() {
        if (data.isEmpty()) {
            return 0;
        }
        return data.get(data.size() - 1);
    }

    public int getMin() {
        if (mins.isEmpty()) {
            return 0;
        }
        return mins.get(mins.size() - 1);
    }
}