package ru.ifmo.ctddev.katunina.Main;

public class NoBracketException extends ParsingException {
    // String wrong_index;
   // boolean closingBracketsNotEnough;

    public NoBracketException(String expr, int wrongIndex, boolean closingBracketsNotEnough) {
        super(expr,wrongIndex, closingBracketsNotEnough? "There is not enough closing brackets":
                "There is not enough opening brackets");
        //this.closingBracketsNotEnough = closingBracketsNotEnough;
        //wrong_index=String.format("There is no closing bracket.");
    }

    /*public void printNotification() {
        if (closingBracketsNotEnough)
            System.out.println("Closing brackets are not enough.");
        else
            System.out.println("Opening brackets are not enough.");
    }  */
}
