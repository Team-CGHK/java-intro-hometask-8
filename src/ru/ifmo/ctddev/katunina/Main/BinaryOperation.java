package ru.ifmo.ctddev.katunina.Main;


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
                b = rightOperand == null ? null : rightOperand.evaluate(x, y, z);
        return calculator.calculate(a, b);
    }

    @Override
    public String toString() {
        if ("abs".equals(calculator.getSign()))
            return "abs(" + leftOperand.toString() + ")";
        String format = ("+".equals(calculator.getSign()) || "-".equals(calculator.getSign())) ? "%s" : "(%s)";
        return String.format(format, leftOperand.toString()) + " " + calculator.getSign() + " " + String.format("-".equals(calculator.getSign()) ? "(%s)" : format, rightOperand.toString());
    }
}
