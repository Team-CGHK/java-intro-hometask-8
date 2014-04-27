package ru.ifmo.ctddev.katunina.Main;

import java.math.BigInteger;
import java.util.HashMap;

public class GenericParser {

    public static void main(String[] args) throws ParsingException {
        Expression3<Integer>  parsedInteger = null;
        Expression3<Double> parsedDouble = null;
        Expression3<BigInteger> parsedBigInteger = null;

        try {
            //parsed = ExpressionParser.parse("(2+2)-0/(--2)*(555");
            if (args[0].equals("-i"))
                 parsedInteger = ExpressionParser.parse(args[1], new IntegerConstFactory(), integerArithmetics);
            else
                if (args[0].equals("-d"))
                    parsedDouble = ExpressionParser.parse(args[1], new DoubleConstFactory(), doubleArithmetics);
            else
                    if (args[0].equals("-bi"))
                        parsedBigInteger = ExpressionParser.parse(args[1], new BigIntegerConstFactory(), bigIntegerArithmetics);
        } catch (Throwable e) {
            System.out.println("error");
            return;
        }
        try {
            for (int x=-100; x<=100;x++)
                for (int y=-100;y<=100;y++)
                    if (args[0].equals("-i"))
                System.out.println(parsedInteger.evaluate(x,y,0));
            else
                if (args[0].equals("-d"))
                    System.out.println(parsedDouble.evaluate((double)x,(double)y,0.0));
            else
                    if (args[0].equals("-bi"))
                            System.out.println(parsedBigInteger.evaluate(BigInteger.valueOf(x),BigInteger.valueOf(y),BigInteger.ONE));
        } catch (Throwable e) {
            System.out.println("error");
            return;
        }
    }

    static HashMap<String, Arithmetics<Integer>> integerArithmetics = new HashMap<String, Arithmetics<Integer>>() {
        { // anonymous initializer
          for(IntegerArithmetics a:IntegerArithmetics.values()   )
              put(a.sign,a);
        }
    };

    static HashMap<String, Arithmetics<Double>> doubleArithmetics = new HashMap<String, Arithmetics<Double>>() {
        { // anonymous initializer
            for(DoubleArithmetics a:DoubleArithmetics.values()   )
                put(a.sign,a);
        }
    };

    static HashMap<String, Arithmetics<BigInteger>> bigIntegerArithmetics = new HashMap<String, Arithmetics<BigInteger>>() {
        { // anonymous initializer
            for(BigIntegerArithmetics a:BigIntegerArithmetics.values()   )
                put(a.sign,a);
        }
    };
}

