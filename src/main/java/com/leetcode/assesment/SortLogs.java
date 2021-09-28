package com.leetcode.assesment;

import java.util.ArrayList;
import java.util.Comparator;

public class SortLogs {
    public String[] reorderLogFiles(String[] logs) {
        if (logs == null) {
            return null;
        } else if (logs.length <= 1) {
            return logs;
        } else {
            var letters = new ArrayList<String>();
            var digits = new ArrayList<String>();

            for (String log : logs) {
                String[] tokens = log.split("\\s");
                if (Character.isDigit(tokens[1].charAt(0))) {
                    digits.add(log);
                } else {
                    letters.add(log);
                }
            }

            letters.sort(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    int firstCrit = getFirstCrit(o1, o2);
                    if (firstCrit == 0) {
                        return o1.split("\\s")[0].compareTo(o2.split("\\s")[0]);
                    } else {
                        return firstCrit;
                    }
                }

                private int getFirstCrit(String o1, String o2) {
                    return o1.substring(getFirstWhitespace(o1) + 1).compareTo(o2.substring(getFirstWhitespace(o2) + 1));
                }

                public int getFirstWhitespace(String s) {
                    for (int i = 0; i < s.length(); i++) {
                        if (Character.isWhitespace(s.charAt(i))) {
                            return i;
                        }
                    }
                    return -1;
                }
            });

            letters.addAll(digits);
            return letters.toArray(new String[logs.length]);

        }
    }


}
