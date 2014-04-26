package ru.ifmo.ctddev.katunina.Main;

import java.math.BigInteger;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws ParsingException {
        Expression3<BigInteger> parsed = null;
        try {
            //parsed = ExpressionParser.parse("(2+2)-0/(--2)*(555");
            parsed = ExpressionParser.parse("123+456*789", new BigIntegerConstFactory(), bigIntegerArithmetics);
        } catch (ParsingException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
        try {
            BigInteger d = parsed.evaluate(BigInteger.ONE, BigInteger.ONE, BigInteger.ONE);
            System.out.println(d);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
            System.exit(2);
        }
    }

    static HashMap<String, Arithmetics<Integer>> integerArithmetics = new HashMap<String, Arithmetics<Integer>>() {
        { // anonymous initializer
            put("+", IntegerArithmectics.ADD);
            put("-", IntegerArithmectics.SUBTRACT);
            put("*", IntegerArithmectics.MULTIPLY);
            put("/", IntegerArithmectics.DIVIDE);
            put("mod", IntegerArithmectics.MODULO);
        }
    };

    static HashMap<String, Arithmetics<Double>> doubleArithmetics = new HashMap<String, Arithmetics<Double>>() {
        { // anonymous initializer
            put("+", DoubleArithmectics.ADD);
            put("-", DoubleArithmectics.SUBTRACT);
            put("*", DoubleArithmectics.MULTIPLY);
            put("/", DoubleArithmectics.DIVIDE);
            put("mod", DoubleArithmectics.MODULO);
        }
    };

    static HashMap<String, Arithmetics<BigInteger>> bigIntegerArithmetics = new HashMap<String, Arithmetics<BigInteger>>() {
        { // anonymous initializer
            put("+", BigIntegerArithmectics.ADD);
            put("-", BigIntegerArithmectics.SUBTRACT);
            put("*", BigIntegerArithmectics.MULTIPLY);
            put("/", BigIntegerArithmectics.DIVIDE);
            put("mod", BigIntegerArithmectics.MODULO);
        }
    };
}

