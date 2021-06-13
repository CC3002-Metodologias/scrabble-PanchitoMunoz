package cl.uchile.dcc.scrabble.model.types.operations.division;

import cl.uchile.dcc.scrabble.model.types.TypeFloat;
import cl.uchile.dcc.scrabble.model.types.interface_types.SNumber;

/**
 * Interface for the division operation. It is in case a Float is divided by any type.
 * Currently this interface is for the other types.
 * @author Francisco Muñoz Guajardo
 */
public interface IDivWithFloat {
    /**
     * Returns the division between the current type and a Float Type.
     *
     * @param typeFloat A Float type who will be divided to the current type.
     * @return The division between the Float type and the other type.
     */
    SNumber divWithFloat(TypeFloat typeFloat);
}
