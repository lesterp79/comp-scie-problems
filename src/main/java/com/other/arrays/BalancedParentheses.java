/*
 * BalancedParentheses.java
 *
 * Copyright (c) 2000-2019 MotionPoint Corporation. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of
 * MotionPoint Corp. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with MotionPoint.
 */
package com.other.arrays;

import java.util.ArrayList;
import java.util.List;

public class BalancedParentheses {
    public static void main(String[] args) {
        System.out.println(isValidExpression("NOT desitin AND NOT (NOT pages OR (NOT whatever)) NOT"));

    }

    /**
     * Utility function to check if a given character is an arithmetic operator
     *
     * @return true if operator, false if not
     */
    public static boolean isBinaryOperator(String c) {
        return (c.equals("OR") || c.equals("AND"));
    }

    /**
     * Checks position and placement of (, ), and operators in a string to make sure it is a valid arithmetic expression
     *
     * @return true if the string is a valid arithmetic expression, false if not
     */
    private static boolean isValidExpression(String expression) {

        List<String> tokens = tokenize(expression);

        //TEST 1: False if expression starts or ends with an operator
        if (isBinaryOperator(tokens.get(0)) || isBinaryOperator(tokens.get(tokens.size() - 1)) || tokens.get(tokens.size() - 1)
                        .equals("NOT")) {
            System.out.println("Does not start or end with operator");
            return false;
        }

        //TEST 2: False if test has mismatching number of opening and closing parantheses
        int unclosedParenthesis = 0;
        //System.out.println("Parentheses counter initialized to 0");

        for (int i = 0; i < tokens.size(); i++) {
            //System.out.println("For loop count: " + i);
            if (tokens.get(i).equals("(")) {
                //System.out.println("( found");
                unclosedParenthesis++;

                //SUBTEST: False if expression ends with '('
                if (i == tokens.size() - 1)
                    return false;
            }
            if (tokens.get(i).equals(")")) {
                unclosedParenthesis--;
                //System.out.println(") found");
                //SUBTEST: False if expression starts with ')'
                if (i == 0)
                    return false;

            }
            if (isBinaryOperator(tokens.get(i))) {

                //                System.out.println("Found an Operator");
                //TEST 3: False if operator is preceded by an operator or opening paranthesis
                //or followed by closing paranthesis
                if (tokens.get(i - 1).equals("(") || tokens.get(i + 1).equals(")") || isBinaryOperator(tokens.get(i + 1))) {
                    System.out.println("Incorrect placement of OR or AND operator");
                    return false;
                }

            }

            if (tokens.get(i).equals("NOT")) {
                if ((i > 0 && (!(isBinaryOperator(tokens.get(i - 1)) || tokens.get(i).equals("NOT") || tokens.get(i - 1)
                                .equals("(")) || tokens.get(i - 1).equals(")"))) || isBinaryOperator(tokens.get(i + 1)) || tokens
                                .get(i + 1).equals(")")) {
                    System.out.println("Incorrect placement of NOT operator");
                    return false;
                }
            }

        }
        return (unclosedParenthesis == 0);
    }

    private static List<String> tokenize(String anExp) {

        List<String> tokens = new ArrayList<>();
        int i = 0;
        while (i < anExp.length()) {
            // find the first digit of a number "expression"
            if (Character.isWhitespace(anExp.charAt(i))) {
                i++;
            } else if (anExp.charAt(i) == '(' || anExp.charAt(i) == ')') {
                tokens.add(Character.toString(anExp.charAt(i++)));
            } else if (anExp.charAt(i) == ',') {
                tokens.add("OR");
                i++;
            } else { // build the token
                StringBuilder tokenBuilder = new StringBuilder();
                while (i < anExp.length() && anExp.charAt(i) != '(' && anExp.charAt(i) != ')' && !Character
                                .isWhitespace(anExp.charAt(i))) {

                    tokenBuilder.append(anExp.charAt(i++));
                }
                tokens.add(tokenBuilder.toString());
            }
        }
        return tokens;
    }
}
