package cl.uchile.dcc.scrabble.model.exceptions;

/**
 * An exception in case the variable not found
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/08/08 14:14
 */
public class VariableNotFoundException extends Exception {

    /**
     * Constructor.
     *
     * @param message a message.
     */
    public VariableNotFoundException(String message) {
        super(message);
    }

}
