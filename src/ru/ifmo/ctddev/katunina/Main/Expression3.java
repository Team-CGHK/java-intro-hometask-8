package ru.ifmo.ctddev.katunina.Main;


   public interface Expression3<T> {
    //int evaluate (Evaluable varValue1, Evaluable varValue2);
    //int evaluate(int varValue);
    public T evaluate(T x, T y, T z);
}
