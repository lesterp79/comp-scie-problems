/*
 * ShuntingYard.java
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
import com.util.BTreePrinter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class ShuntingYard {

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

    /**
     * The name of OR operator.
     */
    public static final String LEFT_PAR = "(";
    /**
     * The name of OR operator.
     */
    public static final String RIGHT_PAR = ")";

    /**
     * Exit command.
     */
    public static final String QUIT = "quit";

    /**
     * The default operator precedence: NOT, AND, OR.
     */
    private static final Map<String, Integer> defaultPrecedenceMap;

    static {
        defaultPrecedenceMap = new HashMap<>();
        defaultPrecedenceMap.put(NOT, 1);
        defaultPrecedenceMap.put(AND, 2);
        defaultPrecedenceMap.put(OR, 3);
    }

    /**
     * Calls for Shunting Yard algorithm with default operator precedence.
     *
     * @param tokens the tokens in infix notation.
     *
     * @return the list of tokens in postfix notation, or <code>null</code> if the input token list is invalid.
     */
    public static List<String> shuntingYard(final Deque<String> tokens) {
        return shuntingYard(tokens, defaultPrecedenceMap);
    }

    /**
     * Returns a list of tokens in postfix notation. If the input list of tokens is invalid (by having, say, incorrect
     * parenthesization),
     * <code>null</code> is returned.
     *
     * @param tokens the tokens in infix notation.
     * @param precedenceMap the operator precedence map.
     *
     * @return the list of tokens in postfix notation, or <code>null</code> if the input token list is invalid.
     */
    public static List<String> shuntingYard(final Deque<String> tokens, final Map<String, Integer> precedenceMap) {
        final Deque<String> operatorStack = new LinkedList<>();
        final Deque<String> outputQueue = new LinkedList<>();
        while (!tokens.isEmpty()) {
            final String currentToken = tokens.removeFirst();

            if (isVariableOrConstantName(currentToken)) {
                outputQueue.add(currentToken);
            } else if (isBinaryOperator(currentToken)) {
                while (!operatorStack.isEmpty() && (isOperator(operatorStack.peek()) && hasGreaterPrecedence(operatorStack.peek(), currentToken, precedenceMap))) {
                    outputQueue.add(operatorStack.pop());
                }
                operatorStack.push(currentToken);
            } else if (isUnaryOperator(currentToken)) {
                operatorStack.push(currentToken);
            } else if (currentToken.equals(LEFT_PAR)) {
                operatorStack.push(LEFT_PAR);
            } else if (currentToken.equals(RIGHT_PAR)) {
                while (!operatorStack.isEmpty() && !operatorStack.peek().equals(LEFT_PAR)) {
                    outputQueue.add(operatorStack.pop());
                }

                if (operatorStack.isEmpty()) {
                    // Parenthesis structure is invalid.
                    return null;
                } else {
                    // remove left parenthesis '('
                    operatorStack.pop();
                }
            } else {
                throw new IllegalStateException("Could not recognize a token: " + currentToken);
            }
        }

        while (!operatorStack.isEmpty()) {
            final String operator = operatorStack.pop();

            // Parenthesis structure is invalid.
            if (operator.equals(LEFT_PAR) || operator.equals(RIGHT_PAR)) {
                return null;
            }

            outputQueue.add(operator);
        }

        return new ArrayList<>(outputQueue);
    }

    private static boolean hasSamePrecedenceAndLeftAssociative(Map<String, Integer> precedenceMap, Deque<String> aOperatorStack) {
        return precedenceMap.get(aOperatorStack.peek()) == precedenceMap.get(aOperatorStack.peek()) && isLeftAssociative(
                        aOperatorStack.peek());
    }

    private static boolean isLeftAssociative(String aPeek) {
        return aPeek.equals(NOT);
    }

    /**
     * Compares <code>stackTopToken</code> and <code>token</code> by their precedences.
     *
     * @param stackTopToken the token at the top of operator stack.
     * @param token the token to compare against.
     * @param precedenceMap the operator precedence map.
     *
     * @return <code>true</code> if the token at the top of the stack precedes
     * <code>token</code>.
     */
    private static boolean hasGreaterPrecedence(final String stackTopToken, final String token,
                    final Map<String, Integer> precedenceMap) {
        return precedenceMap.get(stackTopToken) <= precedenceMap.get(token);
    }


    /**
     * Checks whether the input token is a variable or constant name.
     *
     * @param token the token to check.
     *
     * @return <code>true</code> if and only if <code>token</code> is a constant
     * (such as "0" or "1") or any other token that cannot be recognized as an operator, parenthesis, or a constant.
     */
    private static boolean isVariableOrConstantName(final String token) {
        if (isOperator(token)) {
            return false;
        }

        if (token.equals("(")) {
            return false;
        }

        if (token.equals(")")) {
            return false;
        }

        return !token.isEmpty();
    }

    /**
     * Checks whether the input token denotes an operator such as AND, NOT, OR.
     *
     * @param token the token to check.
     *
     * @return <code>true</code> if and only if <code>token</code> is an
     * operator.
     */
    private static boolean isOperator(final String token) {
        switch (token) {
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
     * @param token the token to check.
     *
     * @return <code>true</code> if and only if <code>token</code> is an
     * operator.
     */
    private static boolean isBinaryOperator(final String token) {
        switch (token) {
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
     * @param token the token to check.
     *
     * @return <code>true</code> if and only if <code>token</code> is an
     * operator.
     */
    private static boolean isUnaryOperator(final String token) {
        switch (token) {
            case NOT:
                return true;

            default:
                return false;
        }
    }


    /**
     * Splits the input text into a list of tokens.
     *
     * @param text the text to split.
     *
     * @return the list of tokens.
     */
    static Deque<String> toTokenList(final String text) {
        final Deque<String> tokenList = new ArrayDeque<>();

        int index = 0;

        while (index < text.length()) {
            if (text.substring(index).startsWith(AND)) {
                index += AND.length();
                tokenList.add(AND);
            } else if (text.substring(index).startsWith(OR)) {
                index += OR.length();
                tokenList.add(OR);
            } else if (text.substring(index).startsWith(NOT)) {
                index += NOT.length();
                tokenList.add(NOT);
            } else if (text.charAt(index) == '(') {
                ++index;
                tokenList.add("(");
            } else if (text.charAt(index) == ')') {
                ++index;
                tokenList.add(")");
            } else {
                int index2 = index;

                while (index2 < text.length() && !Character.isWhitespace(text.charAt(index2)) && text.charAt(index2) != '('
                                && text.charAt(index2) != ')') {
                    ++index2;
                }

                final String variableName = text.substring(index, index2);
                index += variableName.length();
                tokenList.add(variableName);
            }

            index = advancePastWhitespace(text, index);
        }

        return tokenList;
    }

    /**
     * Advances the input index to a position with non-whitespace character.
     *
     * @param text the text.
     * @param index the index.
     *
     * @return the index no less than <code>index</code> at which text contains a non-whitespace character.
     */
    private static int advancePastWhitespace(final String text, int index) {
        while (index < text.length() && Character.isWhitespace(text.charAt(index))) {
            ++index;
        }

        return index;
    }

    /**
     * The demo program.
     *
     * @param args ignored.
     */
    public static void main(final String... args) {

        //String line = "not ( not D or B and ( not ( not A or B ) ) )";
        String line = "not(not(a and b))";

        Deque<String> tokens = toTokenList(line);
        final List<String> postfixTokenList = shuntingYard(tokens);

        if (postfixTokenList == null) {
            System.out.println("Invalid token sequence!");
        } else {
            postfixTokenList.stream().forEach((token) -> {
                System.out.print(token + " ");
            });

            System.out.println();
        }
        BTreeNode<String> x = constructTree(postfixTokenList);
        BTreePrinter.printNode(x);
        BTreeNode<String> y = DeMorgans.applyDeMorgans(x, false);
        BTreePrinter.printNode(y);

    }

    // Returns root of constructed tree for given
    // postfix expression
    static BTreeNode<String> constructTree(Collection<String> tokens) {
        Stack<BTreeNode<String>> st = new Stack();
        BTreeNode<String> t, t1, t2;

        // Traverse through every character of
        // input expression
        for (String token : tokens) {

            // If operand, simply push into stack
            if (!isOperator(token)) {
                t = new BTreeNode(token);
                st.push(t);
            } else // operator
            {
                t = new BTreeNode(token);

                // Pop two top nodes
                t1 = st.pop();
                // Remove top
                t.right = t1;

                if (!token.equals(NOT)) {
                    t2 = st.pop();
                    t.left = t2;
                }

                // System.out.println(t1 + "" + t2);
                // Add this subexpression to stack
                st.push(t);
            }
        }

        //  only element will be root of expression
        // tree
        t = st.peek();
        st.pop();

        return t;
    }
}