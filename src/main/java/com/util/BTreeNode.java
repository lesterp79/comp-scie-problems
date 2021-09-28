/*
 * BTreeNode.java
 *
 * Copyright (c) 2000-2018 MotionPoint Corporation. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of
 * MotionPoint Corp. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with MotionPoint.
 */
package com.util;

public class BTreeNode<T> {
    public BTreeNode<T> left, right;
    public T val;

    public BTreeNode(T val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "BTreeNode{" + "data=" + val.toString() + '}';
    }

    public boolean hasRightChild() {
        return this.right != null;
    }

    public boolean hasLeftChild() {
        return this.left != null;
    }
}
