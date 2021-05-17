package cl.uchile.dcc.scrabble.model.operations.subtraction;

import cl.uchile.dcc.scrabble.model.types.interface_types.SNumber;
import cl.uchile.dcc.scrabble.model.types.TypeFloat;

/**
 * Interface for the subtraction operation. It is in case a Float is subtracted with any type.
 * Currently this interface is for the other types.
 * @author Francisco Muñoz Guajardo
 */
public interface ISubWithFloat {
    /**
     * Returns the subtraction between the current type and a Float Type.
     * @param typeFloat A Float type who will be subtracted to the current type.
     * @return The subtraction between the Float type and the other type.
     */
    SNumber subWithFloat(TypeFloat typeFloat);
}
