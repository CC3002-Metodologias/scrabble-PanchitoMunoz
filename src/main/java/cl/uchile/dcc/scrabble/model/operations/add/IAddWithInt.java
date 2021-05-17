package cl.uchile.dcc.scrabble.model.operations.add;

import cl.uchile.dcc.scrabble.model.types.interface_types.SNumber;
import cl.uchile.dcc.scrabble.model.types.TypeInt;

/**
 * Interface for the addition operation. It is in case an Int is sum with any type.
 * Currently this interface is for the other types.
 * @author Francisco Muñoz Guajardo
 */
public interface IAddWithInt {
    /**
     * Returns the sum between the current type and an Int Type.
     * @param typeInt An Int type who will be added to the current type.
     * @return The sum between the Int type and the other type.
     */
    SNumber addWithInt(TypeInt typeInt);
}
