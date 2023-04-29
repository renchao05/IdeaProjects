package com.chaoren.lambda;

@FunctionalInterface
public interface MyFunc<T> {
    public T getValue(T t);
}
