package ru.ifmo.ctddev.katunina.Main;

/**
 * Created with IntelliJ IDEA.
 * User: Евгения
 * Date: 14.04.14
 * Time: 23:31
 * To change this template use File | Settings | File Templates.
 */
public class ParsingException extends Exception {

    public ParsingException(String msg, int incorrectIndex, String cause) {
        super(String.format("Expression \"%s\" is illegal at position %d: %s. ", msg,incorrectIndex,cause));
    }
}
