/*
 * ShuntingYardDemo.java
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
import java.util.ArrayList;
import java.util.Collection;
import java.util.Stack;

/**
 * A simple demonstration of the Shunting-Yard algorithm. It's easy to extend
 * this code to handle arbitrary operators/functions (including unary ones)
 * and to validate input.
 *
 * @author Kelly Littlepage
 */
public class ShuntingYardDemo {

    /***
     * Evaluates the calculation encoded in the given abstract syntax tree.
     * This method uses recursion to keep things clean. If you needed to
     * evaluate a very deep tree you might need to rewrite this method to use
     * depth first search and evaluate the tree using an explicit stack.
     *
     * @param tree The {@link ASTNode} to evaluate.
     *
     * @return The result of the computation.
     */
    private static double evaluateAST(ASTNode tree) {
        switch(tree.getValue()) {
            case '^':
                return Math.pow(evaluateAST(tree.getLeftASTNode()),
                                evaluateAST(tree.getRightASTNode()));
            case '*':
                return evaluateAST(tree.getLeftASTNode()) * evaluateAST(tree.
                                getRightASTNode());
            case '/':
                return evaluateAST(tree.getLeftASTNode()) / evaluateAST(tree.
                                getRightASTNode());
            case '+':
                return evaluateAST(tree.getLeftASTNode()) + evaluateAST(tree.
                                getRightASTNode());
            case '-':
                return evaluateAST(tree.getLeftASTNode()) - evaluateAST(tree.
                                getRightASTNode());
            default:
                return Double.valueOf(Character.toString(
                                tree.getValue()));
        }
    }

    /***
     * Evaluates the expression given in Reverse Polish notation.
     *
     * @param rpn The expression, in reverse polish notation.
     *
     * @return The result of the calculation.
     */
    private static double evaluateRPN(String rpn) {
        final Stack<String> computation = new Stack<>();
        final char[] chars = rpn.toCharArray();
        for(char c : chars) {
            final String v1;
            final String v2;
            switch(c) {
                case '^':
                    v2 = computation.pop();
                    v1 = computation.pop();
                    computation.push(Double.toString(
                                    Math.pow(Double.valueOf(v1), Double.valueOf(v2))));
                    break;
                case '*':
                    v2 = computation.pop();
                    v1 = computation.pop();
                    computation.push(Double.toString(
                                    Double.valueOf(v1) * Double.valueOf(v2)));
                    break;
                case '/':
                    v2 = computation.pop();
                    v1 = computation.pop();
                    computation.push(Double.toString(
                                    Double.valueOf(v1) / Double.valueOf(v2)));
                    break;
                case '+':
                    v2 = computation.pop();
                    v1 = computation.pop();
                    computation.push(Double.toString(
                                    Double.valueOf(v1) + Double.valueOf(v2)));
                    break;
                case '-':
                    v2 = computation.pop();
                    v1 = computation.pop();
                    computation.push(Double.toString(
                                    Double.valueOf(v1) - Double.valueOf(v2)));
                    break;
                case ' ':
                    break;
                default:
                    computation.push(Character.toString(c));
            }
        }
        return Double.valueOf(computation.pop());
    }

    /***
     * A simple demonstration of parsing an infix expression and converting it
     * to either Reverse Polish Notation or an abstract syntax tree.
     *
     */
    public static void main(String[] args) {
        // Define our basic operators for arithmetic.
        final Collection<Operator> operators = new ArrayList<>();
        operators.add(new BaseOperator('^', true, 4));
        operators.add(new BaseOperator('*', false, 3));
        operators.add(new BaseOperator('/', false, 3));
        operators.add(new BaseOperator('+', false, 2));
        operators.add(new BaseOperator('-', false, 2));

        final ShuntingYardParser parser = new ShuntingYardParser(operators);
        final String input = "3 + 4 * 2 / ( 1 - 5 ) ^ 2 ^ 3";
        System.out.println(input);
        final String rpn = parser.convertInfixNotationToRPN(input);
        System.out.println("RPN expression: " + rpn);
    }


}
