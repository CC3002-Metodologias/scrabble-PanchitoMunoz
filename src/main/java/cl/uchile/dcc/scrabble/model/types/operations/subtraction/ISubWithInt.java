package cl.uchile.dcc.scrabble.model.types.operations.subtraction;

import cl.uchile.dcc.scrabble.model.types.TypeInt;
import cl.uchile.dcc.scrabble.model.types.interface_types.SNumber;

/**
 * Interface for the subtraction operation. It is in case an Int is subtracted with any type.
 * Currently this interface is for the other types.
 * @author Francisco Muñoz Guajardo
 */
public interface ISubWithInt {
    /**
     * Returns the subtraction between the current type and an Int Type.
     * @param typeInt An Int type who will be subtracted to the current type.
     * @return The subtraction between the Int type and the other type.
     */
    SNumber subWithInt(TypeInt typeInt);
}
