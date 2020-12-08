/*
 * YearMaxProducts.java
 *
 * Copyright (c) 2000-2019 MotionPoint Corporation. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of
 * MotionPoint Corp. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with MotionPoint.
 */
package com.other;

import java.util.Random;

public class YearMaxProducts {

    public static void main(String[] args) {
        Random random = new Random();

        Product[] products = new Product[100];

        for (int i = 0; i < 100; i++) {
            int year1 = random.nextInt((CURRENT_YEAR - FOUNDATION_YEAR + 1)) + FOUNDATION_YEAR;
            int year2 = random.nextInt((CURRENT_YEAR - FOUNDATION_YEAR + 1)) + FOUNDATION_YEAR;
            if (year1 <= year2) {
                products[i] = new Product(year1, year2);
            } else {
                products[i] = new Product(year2, year1);

            }

            System.out.println("products = " + products[i]);
        }

        System.out.println(new YearMaxProducts().getYearMaxProductsRegistered(products));

    }

    static final int FOUNDATION_YEAR = 1998;
    static final int CURRENT_YEAR = 2019;

    public int getYearMaxProductsRegistered(Product[] aProducts) {
        // each value in the array represents the number of products registered in year = FOUNDATION_YEAR + i. i.e. value in pos 3
        // represents the number of products registered in year 2001
        int[] productsInYears = new int[CURRENT_YEAR - FOUNDATION_YEAR + 1];

        if (aProducts == null || aProducts.length == 0) {
            return 0;
        }

        for (Product product : aProducts) {
            final int signInYear = product.getSignInYear();
            final int start = signInYear - FOUNDATION_YEAR;
            final int signOffYear = product.getSignOffYear();
            final int end = signOffYear - FOUNDATION_YEAR;
            for (int i = start; i <= end; i++) {
                productsInYears[i]++;
            }

        }

        int max = 0;
        for (int i = 0; i < productsInYears.length; i++) {
            if (productsInYears[i] > max) {
                max = productsInYears[i];
            }
        }

        return max;
    }


    static class Product{
        final int signInYear;
        final int signOffYear;

        public Product(int aSignInYear, int aSignOffYear) {
            signInYear = aSignInYear;
            signOffYear = aSignOffYear;
        }

        public int getSignInYear() {
            return signInYear;
        }

        public int getSignOffYear() {
            return signOffYear;
        }

        @Override
        public String toString() {
            return "Product{" + "signInYear=" + signInYear + ", signOffYear=" + signOffYear + '}';
        }
    }
}
