package ru.ifmo.ctddev.katunina.Main;


public class NumberFormatException extends ParsingException {
    public NumberFormatException(String msg, int incorrectIndex) {
        super(msg, incorrectIndex, "wrong number format");
    }
}
