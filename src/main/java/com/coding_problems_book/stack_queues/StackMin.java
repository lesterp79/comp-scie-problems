package com.coding_problems_book.stack_queues;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Optional;

public class StackMin<T extends Comparable<T>> {

    public static void main(String[] args) {
        StackMin<Integer> stackMin = new StackMin<>(Integer.class);
        stackMin.push(5);
        stackMin.getMin().ifPresent(System.out::println);
        stackMin.push(15);
        stackMin.getMin().ifPresent(System.out::println);
        stackMin.push(3);
        stackMin.getMin().ifPresent(System.out::println);
        stackMin.pop();
        stackMin.getMin().ifPresent(System.out::println);
        stackMin.push(1);
        stackMin.getMin().ifPresent(System.out::println);
        stackMin.pop();
        stackMin.getMin().ifPresent(System.out::println);


    }

    public static final int DEFAULT_CAPACITY = 15;

    private final T[] array;

    private final Deque<T> minStack = new ArrayDeque<>();

    private int size = 0;


    public StackMin(Class<T> c, int s) {
        // Use Array native method to create array
        // of a type only known at run time
        @SuppressWarnings("unchecked") final T[] a = (T[]) Array.newInstance(c, s);
        this.array = a;
    }


    public StackMin(Class<T> c) {
        this(c, DEFAULT_CAPACITY);
    }

    public void push(T element) {
        if (size >= array.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        array[size] = element;

        if (minStack.isEmpty() || element.compareTo(minStack.peek()) < 0) {
            minStack.push(element);
        }
        size++;
    }

    public T pop() {
        if (size <= 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        var element = array[size - 1];

        if (element.equals(minStack.peek())) {
            minStack.pop();
        }
        size--;
        return element;
    }

    public Optional<T> getMin() {
        if (minStack.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.of(minStack.peek());
        }
    }
}
