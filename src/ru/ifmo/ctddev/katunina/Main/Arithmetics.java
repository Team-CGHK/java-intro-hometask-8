package ru.ifmo.ctddev.katunina.Main;

import java.math.BigInteger;

public interface Arithmetics<T> {
    T calculate(T a, T b);
    String getSign();
}

enum IntegerArithmetics implements Arithmetics<Integer> {


    ADD("+") {
        @Override
        public Integer calculate(Integer a, Integer b) throws OverflowException {
            int result = a + b;
            if (!ArithmeticsOptions.IGNORE_OVERFLOW
                && Math.abs(Math.signum(a) + Math.signum(b) - Math.signum(result)) == 3) // overflow if 1 + 1 - (-1) OR (-1) + (-1) - (+1)
                throw new OverflowException();
            return a + b;
        }
    },
    SUBTRACT("-") {
        @Override
        public Integer calculate(Integer a, Integer b) throws OverflowException{
            final int result = a - b;
            if (!ArithmeticsOptions.IGNORE_OVERFLOW
                && Math.signum(result) != Integer.compare(a, b)) // overflow if (a<b, and a-b > 0 || a>b, and a-b < 0)
                throw new OverflowException();
            return result;
        }
    },
    MULTIPLY("*") {
        @Override
        public Integer calculate(Integer a, Integer b) {
            return a * b;
        }
    },
    DIVIDE("/") {
        @Override
        public Integer calculate(Integer a, Integer b)throws OverflowException {
            if (!ArithmeticsOptions.IGNORE_OVERFLOW
                && a==Integer.MIN_VALUE && b==-1)
                throw new OverflowException();
            return a / b;
        }
    },
    MODULO("mod") {
        @Override
        public Integer calculate(Integer a, Integer b) {
            return a % b;
        }
    } ,
    ABS("abs") {
        @Override
        public Integer calculate(Integer a, Integer b){
             return Math.abs(a);
        }
    };
    String sign;
    IntegerArithmetics(String s) {sign=s;}

    @Override
    public String getSign() {
        return sign;
    }
}

enum DoubleArithmetics implements Arithmetics<Double> {

    ADD("+") {
        @Override
        public Double calculate(Double a, Double b) {
            return a+b;
        }
    },
    SUBTRACT("-") {
        @Override
        public Double calculate(Double a, Double b) {
            return a - b;
        }
    },
    MULTIPLY ("*"){
        @Override
        public Double calculate(Double a, Double b) {
            return a * b;
        }
    },
    DIVIDE("/") {
        @Override
        public Double calculate(Double a, Double b) {
            if (Math.abs(a) < EPSILON && Math.abs(b) < EPSILON)
                return Double.NaN;
            return a/b;
        }
    },
    MODULO ("mod"){
        @Override
        public Double calculate(Double a, Double b) {
            return a % b;
        }
    },
    ABS ("abs"){
        @Override
        public Double calculate(Double a, Double b){
            return Math.abs(a);
        }
    } ;
    String sign;
    DoubleArithmetics(String s) {sign=s;}

    private static final Double EPSILON = 1E-100;

    @Override
    public String getSign() {
        return sign;
    }
}

enum BigIntegerArithmetics implements Arithmetics<BigInteger> {
    ADD("+") {
        @Override
        public BigInteger calculate(BigInteger a, BigInteger b) {
            return a.add(b);
        }
    },
    SUBTRACT("-") {
        @Override
        public BigInteger calculate(BigInteger a, BigInteger b) {
            return a.subtract(b);
        }
    },
    MULTIPLY ("*"){
        @Override
        public BigInteger calculate(BigInteger a, BigInteger b) {
            return a.multiply(b);
        }
    },
    DIVIDE("/") {
        @Override
        public BigInteger calculate(BigInteger a, BigInteger b) {
            return a.divide(b);
        }
    },
    MODULO("%") {
        @Override
        public BigInteger calculate(BigInteger a, BigInteger b) {
            return a.mod(b);
        }
    }  ,
    ABS("abs") {
        @Override
        public BigInteger calculate(BigInteger a, BigInteger b){
            return a.abs();
        }
    };
    String sign;
    BigIntegerArithmetics(String s) {sign=s;}

    @Override
    public String getSign() {
        return sign;
    }
}

class ArithmeticsOptions {
    public static boolean IGNORE_OVERFLOW = true;
}