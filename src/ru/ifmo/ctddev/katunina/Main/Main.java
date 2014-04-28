package ru.ifmo.ctddev.katunina.Main;

/**
 * Created by Sergey.
 */
public class Main {
    public static void main(String[] args) throws ParsingException {
        Expression3 e = ExpressionParser.parse("y * abs( y * abs( x - 72.90632831348964 ) ) / - abs( y / 7.272478163038775E9 + x * - - 6.461461498288857E-11 ) / - x / - - x",
                               new DoubleConstFactory(), GenericParser.doubleArithmetics);

        System.out.println(e.toString());
        double i = (double) e.evaluate(-100., 0., 0.);
    }
}
