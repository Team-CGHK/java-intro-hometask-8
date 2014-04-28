package ru.ifmo.ctddev.katunina.Main;

public class Variable<T> implements Expression3<T>{
    String name;

    public Variable(String name) {
        this.name = name;
    }

    @Override
    public T evaluate(T x,T y, T z) {
        if (name.equals("x") )
            return x;
        if (name.equals("y"))
            return y;
        else
            return z;
    }

    @Override
    public String toString() {
        return name;
    }
}
