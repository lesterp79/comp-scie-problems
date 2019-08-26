/*
 * Operator.java
 *
 * Copyright (c) 2000-2019 MotionPoint Corporation. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of
 * MotionPoint Corp. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with MotionPoint.
 */
package com.other.trees.parsing;

/**
 * A simple interface common to all operators in a grammar.
 *
 * @author Kelly Littlepage
 */
public interface Operator {

    /***
     *
     * @return <code>true</code> if the operator is right associative, and
     * <code>false</code> otherwise. By definition, any operator that isn't
     * right associative is left associative.
     */
    boolean isRightAssociative();

    /***
     * Compares the precedence of this operator against another operator.
     *
     * @param o The operator to compare against.
     *
     * @return -1 if this operator is of lower precedence, 1 if it's of greater
     * precedence, and 0 if they're of equal precedence. If two operators are of
     * equal precedence, right associativity and parenthetical groupings must be
     * used to determine precedence.
     */
    int comparePrecedence(Operator o);

    /***
     *
     * @return Gets the symbol used to denote the operator.
     */
    char getSymbol();


}