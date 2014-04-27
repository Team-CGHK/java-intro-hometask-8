package ru.ifmo.ctddev.katunina.Main;

public class OverflowException extends ArithmeticException {
    protected OverflowException() {
        super("Overflow.");
    }
}
