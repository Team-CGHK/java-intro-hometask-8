package ru.ifmo.ctddev.katunina.Main;

import java.math.BigInteger;


public abstract class ConstFactory<T> {

    public abstract Const<T> makeConst(String s, int pos, boolean negativeAllowed);

    public abstract T getNeutral();

    int lastConstLength;
}

class IntegerConstFactory extends ConstFactory<Integer> {

    @Override
    public Const<Integer> makeConst(String s, int pos, boolean negativeAllowed) {
        int initialPos = pos;
        if (s.charAt(pos) == '-') {
            ++pos;
            if (pos < s.length() && !Character.isDigit(s.charAt(pos)))
                return null;
            if (!negativeAllowed) return null;
        }

        while (pos < s.length() && Character.isDigit(s.charAt(pos)))
            ++pos;
        if (pos == initialPos)
            return null;
        lastConstLength = pos - initialPos;

        return new Const<Integer>(Integer.parseInt(s.substring(initialPos, pos)));
    }

    @Override
    public Integer getNeutral() {
        return 0;
    }
}

class DoubleConstFactory extends ConstFactory<Double> {

    @Override
    public Const<Double> makeConst(String s, int pos, boolean negativeAllowed) {
        int initialPos = pos;
        if (s.charAt(pos) == '-') {
            ++pos;
            if (pos < s.length() && !Character.isDigit(s.charAt(pos)))
                return null;
            if (!negativeAllowed) return null;
        }
        boolean point = false,
                E = false;
        while (pos < s.length()) {
            if (Character.isDigit(s.charAt(pos)))
                pos++;
            else if (s.charAt(pos) == '.' && !E)
                if (!point) {
                    point = true;
                    pos++;
                } else return null;
            else if (s.charAt(pos) == 'E')
                if (!E) {
                    E = true;
                    ++pos;
                    if (s.charAt(pos) == '-')
                        ++pos;
                } else return null;

            else
                break;
        }
        if (pos == initialPos || pos < s.length() && s.charAt(pos) == '.')
            return null;
        lastConstLength = pos - initialPos;
        return new Const<Double>(Double.parseDouble(s.substring(initialPos, pos)));
    }

    @Override
    public Double getNeutral() {
        return .0;
    }
}

class BigIntegerConstFactory extends ConstFactory<BigInteger> {

    @Override
    public Const<BigInteger> makeConst(String s, int pos, boolean negativeAllowed) {
        int initialPos = pos;
        if (pos < s.length() && s.charAt(pos) == '-') {
            ++pos;
            if (pos < s.length() && !Character.isDigit(s.charAt(pos)))
                return null;
            if (!negativeAllowed) return null;
        }
        while (pos < s.length() && Character.isDigit(s.charAt(pos)))
            pos++;
        if (pos == initialPos)
            return null;
        lastConstLength = pos - initialPos;
        return new Const<BigInteger>(new BigInteger(s.substring(initialPos, pos)));
    }

    @Override
    public BigInteger getNeutral() {
        return BigInteger.ZERO;
    }
}