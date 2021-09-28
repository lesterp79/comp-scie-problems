package com.coding_interview_book.stack_queues;

import java.util.Stack;

public class QueueWithStacks {

    public static void main(String[] args) {
        QueueWithStacks queueWithStacks = new QueueWithStacks();

        queueWithStacks.add(1);
        queueWithStacks.add(2);
        System.out.println(queueWithStacks.poll());

        queueWithStacks.add(3);
        System.out.println(queueWithStacks.poll());
        System.out.println(queueWithStacks.poll());
        queueWithStacks.add(4);
        queueWithStacks.add(5);
        queueWithStacks.add(6);
        System.out.println(queueWithStacks.poll());
        System.out.println(queueWithStacks.poll());
        System.out.println(queueWithStacks.poll());

    }

    Stack<Integer> head = new Stack<>();
    Stack<Integer> tail = new Stack<>();



    public void add(Integer elem) {
        tail.push(elem);
    }

    public Integer poll() {
        if (head.isEmpty()) {
            while (!tail.isEmpty()) {
                head.push(tail.pop());
            }
        }

        return head.pop();
    }


}
