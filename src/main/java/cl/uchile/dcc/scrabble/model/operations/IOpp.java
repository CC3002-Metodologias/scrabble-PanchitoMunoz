package cl.uchile.dcc.scrabble.model.operations;

import cl.uchile.dcc.scrabble.model.types.interface_types.SType;

/**
 * Interface for the unary operation 'negation'.
 * @author Francisco Muñoz Guajardo
 */
public interface IOpp {
    /**
     * Returns the negative of the current instance.
     * @return The opposite of the current instance.
     */
    SType opposite();
}
