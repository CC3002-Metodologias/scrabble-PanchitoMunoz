package cl.uchile.dcc.scrabble.model.types.operations;

import cl.uchile.dcc.scrabble.model.types.interface_types.SLogical;

/**
 * Interface for the unary operation 'negation'.
 * @author Francisco Muñoz Guajardo
 */
public interface INeg {
    /**
     * Returns the negation of the current instance.
     * @return The negation of the current instance.
     */
    SLogical neg();
}
