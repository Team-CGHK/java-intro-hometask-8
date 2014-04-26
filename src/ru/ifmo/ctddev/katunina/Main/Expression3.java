package ru.ifmo.ctddev.katunina.Main;

/**
 * Created with IntelliJ IDEA.
 * User: Евгения
 * Date: 18.03.14
 * Time: 13:35
 * To change this template use File | Settings | File Templates.
 */
   public interface Expression3<T> {
    //int evaluate (Evaluable varValue1, Evaluable varValue2);
    //int evaluate(int varValue);
    public T evaluate(T x, T y, T z);
}
