package cl.uchile.dcc.scrabble.model.operations.division;

import cl.uchile.dcc.scrabble.model.types.TypeInt;
import cl.uchile.dcc.scrabble.model.types.interface_types.SNumber;

/**
 * Interface for the division operation. It is in case an Int is divided by any type.
 * Currently this interface is for the other types.
 * @author Francisco Muñoz Guajardo
 */
public interface IDivWithInt {
    /**
     * Returns the division between the current type and an Int Type.
     *
     * @param typeInt An Int type who will be divided to the current type.
     * @return The division between the Int type and the other type.
     */
    SNumber divWithInt(TypeInt typeInt);
}
