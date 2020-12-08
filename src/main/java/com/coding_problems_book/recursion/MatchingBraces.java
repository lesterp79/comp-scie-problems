package com.coding_problems_book.recursion;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class MatchingBraces {

    public static void main(String[] args) {
        embrace(2).forEach(System.out::println);
    }

    public static List<String> embrace(int n) {
        List<String> results = new ArrayList<>();
        for (int i = 0; i < n; i++) {

            char[] current = new char[2 * (i + 1)];

            var stack = new ArrayDeque<State>();
            stack.push(new State(0, i, i, '{'));


            while (!stack.isEmpty()) {
                var state = stack.pop();
                if (state.nl == 0 && state.nr == 0) {
                    results.add(String.valueOf(current));
                } else if (state.nr >= state.nl && state.nl >= 0) {
                    var val = state.val;
                    current[state.i] = val;
                    stack.push(new State(state.i + 1, state.nl, state.nr - 1, '}'));
                    stack.push(new State(state.i + 1, state.nl - 1, state.nr, '{'));
                }
            }
        }

        return results;
    }

    private static void embrace(char[] current, int i, int nl, int nr, List<String> results) {
        if (nl == 0 && nr == 0) {
            results.add(String.valueOf(current));
        } else if (nr >= nl && nl >= 0) {
            current[i] = '{';
            embrace(current, i + 1, nl - 1, nr, results);
            current[i] = '}';
            embrace(current, i + 1, nl, nr - 1, results);
        }
    }


}

class State {
    public int nl;
    public int nr;
    public int i;
    public char val;

    public State(int i, int nl, int nr, char val) {
        this.val = val;
        this.nl = nl;
        this.nr = nr;
        this.i = i;

    }
}