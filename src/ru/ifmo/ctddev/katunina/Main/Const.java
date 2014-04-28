package ru.ifmo.ctddev.katunina.Main;


public class Const<T> implements Expression3<T> {
    T value;

    public Const(T value) {
        this.value = value;
    }

    public T evaluate(T x, T y, T z) {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
