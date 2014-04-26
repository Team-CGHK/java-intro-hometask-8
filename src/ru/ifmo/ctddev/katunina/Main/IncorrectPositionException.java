package ru.ifmo.ctddev.katunina.Main;

/**
 * Created with IntelliJ IDEA.
 * User: Евгения
 * Date: 14.04.14
 * Time: 23:14
 * To change this template use File | Settings | File Templates.
 */
public class IncorrectPositionException extends ParsingException {
    public IncorrectPositionException(String expr, int wrongIndex) {
        super(expr,wrongIndex,"mistake in expression");
    }
}
