package com.other.trees;

import com.util.BTreeNode;
import com.util.BTreePrinter;
import java.util.List;
import org.junit.Test;

import static com.other.trees.ShuntingYard.constructTree;
import static com.other.trees.ShuntingYard.shuntingYard;
import static com.other.trees.ShuntingYard.toTokenList;

public class DeMorgansTest {

    @Test
    public void applyDeMorgansAndsAndOrs() {
        String exp = "not(not ( a and b ) or not (not a or b))";
        final List<String> postfixTokenList = shuntingYard(toTokenList(exp));

        printPostFix(postfixTokenList);

        System.out.println("Expression Tree Before De Morgans: ");
        BTreeNode<String> x = constructTree(postfixTokenList);
        BTreePrinter.printNode(x);

        System.out.println("Expression Tree After De Morgans: ");
        BTreeNode<String> y = DeMorgans.applyDeMorgans(x, false);
        BTreePrinter.printNode(y);
    }

    @Test
    public void applyDeMorgansNegation() {
        String exp = "not ( a and b )";
        final List<String> postfixTokenList = shuntingYard(toTokenList(exp));

        printPostFix(postfixTokenList);

        System.out.println("Expression Tree Before De Morgans: ");
        BTreeNode<String> x = constructTree(postfixTokenList);
        BTreePrinter.printNode(x);

        System.out.println("Expression Tree After De Morgans: ");
        BTreeNode<String> y = DeMorgans.applyDeMorgans(x, false);
        BTreePrinter.printNode(y);
    }

    @Test
    public void applyDeMorgansInnerNegation() {
        String exp = "not ( not a and b )";
        final List<String> postfixTokenList = shuntingYard(toTokenList(exp));

        printPostFix(postfixTokenList);

        System.out.println("Expression Tree Before De Morgans: ");
        BTreeNode<String> x = constructTree(postfixTokenList);
        BTreePrinter.printNode(x);

        System.out.println("Expression Tree After De Morgans: ");
        BTreeNode<String> y = DeMorgans.applyDeMorgans(x, false);
        BTreePrinter.printNode(y);
    }

    @Test
    public void applyDeMorgansEvenNegationCancels() {
        String exp = "not ( not ( a and b ) )";
        final List<String> postfixTokenList = shuntingYard(toTokenList(exp));

        printPostFix(postfixTokenList);

        System.out.println("Expression Tree Before De Morgans: ");
        BTreeNode<String> x = constructTree(postfixTokenList);
        BTreePrinter.printNode(x);

        System.out.println("Expression Tree After De Morgans: ");
        BTreeNode<String> y = DeMorgans.applyDeMorgans(x, false);
        BTreePrinter.printNode(y);
    }

    @Test
    public void applyDeMorgansTripleNegation() {
        String exp = "not( not ( not ( a and b ) ) )";
        final List<String> postfixTokenList = shuntingYard(toTokenList(exp));

        printPostFix(postfixTokenList);

        System.out.println("Expression Tree Before De Morgans: ");
        BTreeNode<String> x = constructTree(postfixTokenList);
        BTreePrinter.printNode(x);

        System.out.println("Expression Tree After De Morgans: ");
        BTreeNode<String> y = DeMorgans.applyDeMorgans(x, false);
        BTreePrinter.printNode(y);
    }

    @Test
    public void applyDeMorgansComplicatedOne() {
        String exp = "not a and not (not b and not ( not ( c and d ) ) )";
        final List<String> postfixTokenList = shuntingYard(toTokenList(exp));

        printPostFix(postfixTokenList);

        System.out.println("Expression Tree Before De Morgans: ");
        BTreeNode<String> x = constructTree(postfixTokenList);
        BTreePrinter.printNode(x);

        System.out.println("Expression Tree After De Morgans: ");
        BTreeNode<String> y = DeMorgans.applyDeMorgans(x, false);
        BTreePrinter.printNode(y);
    }


    private void printPostFix(List<String> aPostfixTokenList) {
        if (aPostfixTokenList == null) {
            System.out.println("Invalid token sequence!");
        } else {
            aPostfixTokenList.stream().forEach((token) -> {
                System.out.print(token + " ");
            });

            System.out.println();
        }
    }
}