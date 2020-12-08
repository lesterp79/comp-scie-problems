/*
 * Cell.java
 *
 * Copyright (c) 2000-2019 MotionPoint Corporation. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of
 * MotionPoint Corp. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with MotionPoint.
 */
package com.util;

public class Cell {
    public Cell(int aX, int aY) {
        x = aX;
        y = aY;
    }

    public int x;
    public  int y;

    @Override
    public boolean equals(Object aO) {
        if (this == aO)
            return true;
        if (aO == null || getClass() != aO.getClass())
            return false;

        Cell cell = (Cell) aO;

        if (x != cell.x)
            return false;
        return y == cell.y;

    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}
