package com.java_coding_problems_book.functional.factory_pattern;

@FunctionalInterface
public interface TriFunction<T, U, V, R> {
    R apply(T t, U u, V v);
}