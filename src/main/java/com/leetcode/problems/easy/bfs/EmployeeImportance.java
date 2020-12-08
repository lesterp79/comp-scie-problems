/*
 * EmployeeImportance.java
 *
 * Copyright (c) 2000-2019 MotionPoint Corporation. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of
 * MotionPoint Corp. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with MotionPoint.
 */
package com.leetcode.problems.easy.bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;

public class EmployeeImportance {

    public static void main(String[] args) {
        Employee emp1 = new Employee();
        emp1.id = 1;
        emp1.importance = 5;

        emp1.subordinates = new ArrayList<Integer>();
        emp1.subordinates.add(2);
        emp1.subordinates.add(3);

        Employee emp2 = new Employee();
        emp2.id = 2;
        emp2.importance = 3;

        emp2.subordinates = new ArrayList<Integer>();


        Employee emp3 = new Employee();
        emp3.id = 3;
        emp3.importance = 3;

        emp3.subordinates = new ArrayList<Integer>();

        List<Employee> employees = new ArrayList<>();
        employees.add(emp1);
        employees.add(emp2);
        employees.add(emp3);

        System.out.println(new EmployeeImportance().getImportance(employees, 1));


    }

    public int getImportance(List<Employee> employees, int id) {
        if (employees == null || employees.isEmpty()) {
            return 0;
        }

        Map<Integer, Employee> map = new HashMap<>();
        for (Employee k : employees) {
            map.put(k.id, k);
        }

        Employee leader = map.get(id);

        if (leader == null) {
            return 0;
        }

        Deque<Employee> queue = new ArrayDeque<>();

        queue.push(leader);

        int total = 0;
        while (!queue.isEmpty()) {
            Employee curr = queue.poll();
            total += curr.importance;
            if (curr.subordinates != null) {
                for (Integer anId : curr.subordinates) {
                    Employee sub = map.get(anId);
                    queue.add(sub);
                }
            }
        }

        return total;
    }

    // Employee info
    static class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;
    };
}
