package ru.ifmo.ctddev.katunina.Main;

public class IncorrectPositionException extends ParsingException {
    public IncorrectPositionException(String expr, int wrongIndex) {
        super(expr,wrongIndex,"mistake in expression");
    }
}
