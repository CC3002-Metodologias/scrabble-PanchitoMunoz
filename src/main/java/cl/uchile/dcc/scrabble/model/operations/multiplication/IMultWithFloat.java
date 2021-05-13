package cl.uchile.dcc.scrabble.model.operations.multiplication;

import cl.uchile.dcc.scrabble.model.types.IType;
import cl.uchile.dcc.scrabble.model.types.TypeFloat;

/**
 * Interface for the multiplication operation. It is in case a Float is multiplied by any type.
 * Currently this interface is for the other types.
 * @author Francisco Muñoz Guajardo
 */
public interface IMultWithFloat {
    /**
     * Returns the multiplication between the current type and a Float Type.
     *
     * @param typeFloat A Float type who will be multiplied to the current type.
     * @return The multiplication between the Float type and the other type.
     */
    IType multWithFloat(TypeFloat typeFloat);
}
