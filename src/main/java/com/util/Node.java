/*
 * Node.java
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

public class Node<T> {
    public Node<T> next;
    public T data;

    public Node(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Node{" + "data=" + data + '}';
    }
}
