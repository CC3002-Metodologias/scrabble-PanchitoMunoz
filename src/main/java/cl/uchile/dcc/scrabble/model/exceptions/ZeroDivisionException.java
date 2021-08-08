package cl.uchile.dcc.scrabble.model.exceptions;

/**
 * A class for zero division exception
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/08/08 13:08
 */
public class ZeroDivisionException extends Exception {

    /**
     * Constructor.
     *
     * @param message a message
     */
    public ZeroDivisionException(String message) {
        super(message);
    }

}
