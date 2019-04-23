/*
 * PostOrderTraversal.java
 *
 * Copyright (c) 2000-2019 MotionPoint Corporation. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of
 * MotionPoint Corp. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with MotionPoint.
 */
package com.leetcode.problems.easy.btrees.traversal;

import com.util.BTreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrderTraversal {

    public List<Integer> postOrderTraversalIterative(BTreeNode<Integer> root) {

        List<Integer> inOrderList = new ArrayList<>();

        Stack<BTreeNode<Integer>> stack = new Stack<>();

        BTreeNode<Integer> current = root;


        while (current != null || !stack.isEmpty()) {

            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.peek().right;

            if (current == null) {
                current = stack.pop();
                inOrderList.add(current.val);
            } else {
                stack.push(current);
            }
        }

        return inOrderList;
    }
}
