package com.coding_problems_book.strings;

public class ShrinkString {
    public static void main(String[] args) {
        String str = "a aa   babbbbbb bbbbbbb";
        System.out.printf("[%s]%n", shrink(str));
    }

    public static String shrink(String str) {
        if (str == null || str.length() <= 2) {
            return str;
        } else { //string is at least 2 chars long
            var buffer = new StringBuffer();
            int count = 0;
            for (int i = 0; i < str.length(); i++) {
                count++;
                if (Character.isWhitespace(str.charAt(i))) {
                    buffer.append(str.charAt(i));
                    count = 0;
                } else if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                    buffer.append(str.charAt(i)).append(count);
                    count = 0;
                }
            }
            return buffer.length() < str.length() ? buffer.toString() : str;
        }
    }
}