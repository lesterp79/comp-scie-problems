package com.coding_interview_book.recursion;

import java.util.ArrayList;
import java.util.List;

public class LegalParentheses {
    List<String> results = new ArrayList<>();

    private void generateParenthesis(int left, int right, char[] curr, int pos) {
        if (right == 0) {
            results.add(new String(curr));
        } else {
            if (left > 0) {
                curr[pos] = '(';
                generateParenthesis(left - 1, right, curr, pos + 1);
            }

            if (right > 0) {
                curr[pos] = ')';
                generateParenthesis(left, right - 1, curr, pos + 1);
            }

        }
    }
}
