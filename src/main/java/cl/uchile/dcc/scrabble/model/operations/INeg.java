package cl.uchile.dcc.scrabble.model.operations;

/**
 * Interface for the unary operation 'negation'.
 * @author Francisco Muñoz Guajardo
 */
public interface INeg {
    /**
     * Returns the negative of the current instance.
     * @return The opposite of the current instance.
     */
    INeg negative();
}
