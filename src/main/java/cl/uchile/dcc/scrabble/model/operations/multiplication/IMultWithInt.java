package cl.uchile.dcc.scrabble.model.operations.multiplication;

import cl.uchile.dcc.scrabble.model.types.SNumber;
import cl.uchile.dcc.scrabble.model.types.TypeInt;

/**
 * Interface for the multiplication operation. It is in case an Int is multiplied by any type.
 * Currently this interface is for the other types.
 * @author Francisco Muñoz Guajardo
 */
public interface IMultWithInt {
    /**
     * Returns the multiplication between the current type and an Int Type.
     *
     * @param typeInt An Int type who will be multiplied to the current type.
     * @return The multiplication between the Int type and the other type.
     */
    SNumber multWithInt(TypeInt typeInt);
}
