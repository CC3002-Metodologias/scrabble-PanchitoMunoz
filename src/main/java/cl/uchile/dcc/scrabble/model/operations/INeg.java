package cl.uchile.dcc.scrabble.model.operations;

import cl.uchile.dcc.scrabble.model.types.interface_types.SLogical;
import cl.uchile.dcc.scrabble.model.types.interface_types.SType;

/**
 * Interface for the unary operation 'negation'.
 * @author Francisco Muñoz Guajardo
 */
public interface INeg {
    /**
     * Returns the negation of the current instance.
     * @return The negation of the current instance.
     */
    SLogical negation();
}
