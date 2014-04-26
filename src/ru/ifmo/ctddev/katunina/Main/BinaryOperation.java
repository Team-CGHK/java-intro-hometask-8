package ru.ifmo.ctddev.katunina.Main;

/**
 * Created with IntelliJ IDEA.
 * User: Евгения
 * Date: 18.03.14
 * Time: 13:34
 * To change this template use File | Settings | File Templates.
 */
public class BinaryOperation<T> implements Expression3<T> {
    Expression3<T> leftOperand;
    Expression3<T> rightOperand;
    Arithmetics<T> calculator;

    public BinaryOperation(Expression3 leftOperand, Expression3 rightOperand, Arithmetics<T> calculator) {
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
        this.calculator = calculator;
    }

    @Override
    public T evaluate(T x, T y, T z) {
        T a = leftOperand.evaluate(x, y, z),
          b = rightOperand.evaluate(x, y, z);
        return calculator.calculate(a, b);
    }
}
