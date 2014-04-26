package ru.ifmo.ctddev.katunina.Main;

/**
 * Created with IntelliJ IDEA.
 * User: Евгения
 * Date: 18.03.14
 * Time: 13:33
 * To change this template use File | Settings | File Templates.
 */
public class Variable<T> implements Expression3<T>{
    String str;
    public Variable (String str){
        this.str=str;
    }

    @Override
    public T evaluate(T x,T y, T z) {
        if (str.equals("x") )
            return x;
        if (str.equals("y"))
            return y;
        else
            return z;
    }
}
