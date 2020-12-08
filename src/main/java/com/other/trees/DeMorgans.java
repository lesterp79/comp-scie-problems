/*
 * DeMorgans.java
 *
 * Copyright (c) 2000-2019 MotionPoint Corporation. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of
 * MotionPoint Corp. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with MotionPoint.
 */
package com.other.trees;

import com.util.BTreeNode;

public class DeMorgans {

    /**
     * The name of AND operator.
     */
    public static final String AND = "and";

    /**
     * The name of NOT operator.
     */
    public static final String NOT = "not";

    /**
     * The name of OR operator.
     */
    public static final String OR = "or";

    public static BTreeNode<String> applyDeMorgans(BTreeNode<String> aNode, boolean apply) {
        if (aNode == null) { // for null root only
                return null;
            } else if (isBinaryOperator(aNode)) { // AND, OR
                if (apply) {
                    aNode.val = aNode.val.equals(OR) ? AND : OR; // if we are transforming, switch from AND to OR and from OR to AND
                }
            aNode.left = applyDeMorgans(aNode.left, apply); // apply DeMorgans recursively to the left
            aNode.right = applyDeMorgans(aNode.right, apply);  // apply DeMorgans recursively to the right
            return aNode;
        } else if (isUnaryOperator(aNode)) { // we encounter a negation operator
            if (apply) { // double negation, do not keep propagating the transformation
                return applyDeMorgans(aNode.right, false);
            } else { // start transformation
                return applyDeMorgans(aNode.right, true); // apply recursively to child neg node
            }
        } else { // this is a primitive value
            if (apply) { // if we are transforming, create a NOT node, make it the parent of current node and return it
                BTreeNode<String> unaryNode = new BTreeNode<>(NOT);
                unaryNode.right = aNode;
                return unaryNode;
            } else {
                return aNode;
            }
        }
    }

    /**
     * Checks whether the input token denotes an operator such as AND, NOT, OR.
     *
     * @param aNode the node
     *
     * @return <code>true</code> if and only if <code>token</code> is an
     * operator.
     */
    private static boolean isOperator(BTreeNode<String> aNode) {
        switch (aNode.val) {
            case AND:
            case OR:
            case NOT:
                return true;

            default:
                return false;
        }
    }

    /**
     * Checks whether the input token denotes an operator such as AND, NOT, OR.
     *
     * @param aNode the node
     *
     * @return <code>true</code> if and only if <code>token</code> is an
     * operator.
     */
    private static boolean isBinaryOperator(BTreeNode<String> aNode) {
        switch (aNode.val) {
            case AND:
            case OR:
                return true;

            default:
                return false;
        }
    }

    /**
     * Checks whether the input token denotes an operator such as AND, NOT, OR.
     *
     * @param aNode the node
     *
     * @return <code>true</code> if and only if <code>token</code> is an
     * operator.
     */
    private static boolean isUnaryOperator(BTreeNode<String> aNode) {
        switch (aNode.val) {
            case NOT:
                return true;

            default:
                return false;
        }
    }

    /**
     * Checks whether the input token is a variable or constant name.
     *
     * @param aNode the node
     *
     * @return <code>true</code> if and only if <code>token</code> is a constant
     * (such as "0" or "1") or any other token that cannot be recognized as an operator, parenthesis, or a constant.
     */
    private static boolean isPrimitive(BTreeNode<String> aNode) {
        return !isOperator(aNode);

    }
}
