package ru.ifmo.ctddev.katunina.Main;

import java.math.BigInteger;
import java.util.HashMap;

public class GenericParser {

    public static void main(String[] args) throws ParsingException {
        Expression3 parsed = null;
        try {
            if ("-i".equals(args[0]))
                parsed = ExpressionParser.parse(args[1], new IntegerConstFactory(), integerArithmetics);
            else if ("-d".equals(args[0]))
                parsed = ExpressionParser.parse(args[1], new DoubleConstFactory(), doubleArithmetics);
            else if ("-bi".equals(args[0]))
                parsed = ExpressionParser.parse(args[1], new BigIntegerConstFactory(), bigIntegerArithmetics);
        } catch (Throwable ignored) {
        }
        for (int x = -100; x <= 100; x++)
            for (int y = -100; y <= 100; y++) {
                if (parsed != null)
                    try {
                        if ("-i".equals(args[0]))
                            System.out.println(parsed.evaluate(x, y, 1));
                        else if ("-d".equals(args[0]))
                            System.out.println(parsed.evaluate((double)x, (double)y, 1));
                        else if ("-bi".equals(args[0]))
                            System.out.println(parsed.evaluate(BigInteger.valueOf(x), BigInteger.valueOf(y), BigInteger.ONE));
                    } catch (Throwable e) {
                        System.out.println("error");
                    }
                else
                    System.out.println("error");
            }
    }

    static HashMap<String, Arithmetics<Integer>> integerArithmetics = new HashMap<String, Arithmetics<Integer>>() {
        {
            for (IntegerArithmetics a : IntegerArithmetics.values())
                put(a.sign, a);
        }
    };

    static HashMap<String, Arithmetics<Double>> doubleArithmetics = new HashMap<String, Arithmetics<Double>>() {
        {
            for (DoubleArithmetics a : DoubleArithmetics.values())
                put(a.sign, a);
        }
    };

    static HashMap<String, Arithmetics<BigInteger>> bigIntegerArithmetics = new HashMap<String, Arithmetics<BigInteger>>() {
        {
            for (BigIntegerArithmetics a : BigIntegerArithmetics.values())
                put(a.sign, a);
        }
    };
}

