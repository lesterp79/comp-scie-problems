/*
 * Vertex.java
 *
 * Copyright (c) 2000-2018 MotionPoint Corporation. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of
 * MotionPoint Corp. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with MotionPoint.
 */
package com.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Vertex {
    public int val;
    public List<Vertex> neighbors;

    public Vertex(int val, List<Vertex> neighbors) {
        this.val = val;
        this.neighbors = neighbors;
    }

    public Vertex(int val) {
        this.val = val;
        this.neighbors = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Vertex vertex = (Vertex) o;
        return val == vertex.val;
    }

    @Override
    public int hashCode() {
        return Objects.hash(val);
    }
}
