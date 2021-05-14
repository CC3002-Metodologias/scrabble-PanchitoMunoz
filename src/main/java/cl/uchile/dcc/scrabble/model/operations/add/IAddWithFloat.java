package cl.uchile.dcc.scrabble.model.operations.add;

import cl.uchile.dcc.scrabble.model.types.interface_types.SNumber;
import cl.uchile.dcc.scrabble.model.types.TypeFloat;

/**
 * Interface for the addition operation. It is in case a Float is sum with any type.
 * Currently this interface is for the other types.
 * @author Francisco Muñoz Guajardo
 */
public interface IAddWithFloat {
    /**
     * Returns the add between the current type and a Float Type.
     * @param typeFloat A Float type who will be added to the current type.
     * @return The sum between the Float type and the other type.
     */
    SNumber addWithFloat(TypeFloat typeFloat);
}
