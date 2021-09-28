/*
 * HanoiTower.java
 *
 * Copyright (c) 2000-2019 MotionPoint Corporation. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of
 * MotionPoint Corp. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with MotionPoint.
 */
package com.coding_interview_book.dynamic;

import java.util.Stack;

public class HanoiTower {
    public static void main(String[] args) {

    }

    class Tower {
        private Stack<Integer> disks;
        private int index;

        public Tower(int aIndex) {
            disks = new Stack<>();
            index = aIndex;
        }

        public int getIndex() {
            return index;
        }

        public void add(int d){
            if (!disks.isEmpty() && disks.peek() <= d) {
                throw new IllegalArgumentException("Can't place this disk on this Tower!");
            } else {
                disks.push(d);
            }
        }

        public void moveToTop(Tower aTower) {
            int top = disks.pop();
            aTower.add(top);
        }




    }
}
