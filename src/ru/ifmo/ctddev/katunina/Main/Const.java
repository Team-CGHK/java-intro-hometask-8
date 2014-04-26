package ru.ifmo.ctddev.katunina.Main;

/**
 * Created with IntelliJ IDEA.
 * User: Евгения
 * Date: 18.03.14
 * Time: 13:33
 * To change this template use File | Settings | File Templates.
 */
public class Const<T> implements Expression3<T> {
    T value;

    public Const(T value) {
        this.value = value;
    }

    public T evaluate(T x, T y, T z) {
        return value;
    }
}
