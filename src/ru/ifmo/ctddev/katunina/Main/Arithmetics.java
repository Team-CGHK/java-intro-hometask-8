package ru.ifmo.ctddev.katunina.Main;

import java.math.BigInteger;

/**
 * Created by Sergey.
 */
public interface Arithmetics<T> {
    T calculate(T a, T b);
}

enum IntegerArithmectics implements Arithmetics<Integer> {
    ADD {
        @Override
        public Integer calculate(Integer a, Integer b) {
            return a + b;
        }
    },
    SUBTRACT {
        @Override
        public Integer calculate(Integer a, Integer b) {
            return a - b;
        }
    },
    MULTIPLY {
        @Override
        public Integer calculate(Integer a, Integer b) {
            return a * b;
        }
    },
    DIVIDE {
        @Override
        public Integer calculate(Integer a, Integer b) {
            return a / b;
        }
    },
    MODULO {
        @Override
        public Integer calculate(Integer a, Integer b) {
            return a % b;
        }
    }
}

enum DoubleArithmectics implements Arithmetics<Double> {
    ADD {
        @Override
        public Double calculate(Double a, Double b) {
            return a+b;
        }
    },
    SUBTRACT {
        @Override
        public Double calculate(Double a, Double b) {
            return a - b;
        }
    },
    MULTIPLY {
        @Override
        public Double calculate(Double a, Double b) {
            return a * b;
        }
    },
    DIVIDE {
        @Override
        public Double calculate(Double a, Double b) {
            return a/b;
        }
    },
    MODULO {
        @Override
        public Double calculate(Double a, Double b) {
            return a % b;
        }
    }
}

enum BigIntegerArithmectics implements Arithmetics<BigInteger> {
    ADD {
        @Override
        public BigInteger calculate(BigInteger a, BigInteger b) {
            return a.add(b);
        }
    },
    SUBTRACT {
        @Override
        public BigInteger calculate(BigInteger a, BigInteger b) {
            return a.subtract(b);
        }
    },
    MULTIPLY {
        @Override
        public BigInteger calculate(BigInteger a, BigInteger b) {
            return a.multiply(b);
        }
    },
    DIVIDE {
        @Override
        public BigInteger calculate(BigInteger a, BigInteger b) {
            return a.divide(b);
        }
    },
    MODULO {
        @Override
        public BigInteger calculate(BigInteger a, BigInteger b) {
            return a.mod(b);
        }
    }
}
