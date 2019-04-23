/*
 * DoublyLinkedTreeNode.java
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

public class DoublyLinkedTreeNode<T extends Comparable<?>> extends BTreeNode<T> {

    private DoublyLinkedTreeNode<T> parent;

    public DoublyLinkedTreeNode(T aData, DoublyLinkedTreeNode<T> aParent) {
        super(aData);
        this.parent = aParent;
    }

    public boolean isRightChild() {
        return this.parent != null && this.parent.right == this;
    }

    public boolean isLeftChild() {
        return this.parent != null && this.parent.left == this;
    }

    public DoublyLinkedTreeNode<T> getRight() {
        return (DoublyLinkedTreeNode<T>) this.right;
    }

    public DoublyLinkedTreeNode<T> getLeft() {
        return (DoublyLinkedTreeNode<T>) this.left;
    }

    public DoublyLinkedTreeNode<T> getParent() {
        return parent;
    }
}
