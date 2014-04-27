package ru.ifmo.ctddev.katunina.Main;

public class ParsingException extends Exception {

    public ParsingException(String msg, int incorrectIndex, String cause) {
        super(String.format("error", msg,incorrectIndex,cause));
    }
}
