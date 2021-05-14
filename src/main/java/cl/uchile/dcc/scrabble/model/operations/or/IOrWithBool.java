package cl.uchile.dcc.scrabble.model.operations.or;

import cl.uchile.dcc.scrabble.model.types.TypeBool;
import cl.uchile.dcc.scrabble.model.types.interface_types.SLogical;

/**
 * Interface for the logic 'or' operation. It is in case a Bool is operated with any type.
 * Currently this interface is for the other types.
 * @author Francisco Muñoz Guajardo
 */
public interface IOrWithBool {
    /**
     * Returns the conjunction between the current type and a Bool Type.
     * @param typeBool A Bool type who will be conjunct to the current type.
     * @return The conjunction between the Bool type and the other type.
     */
    SLogical orWithBool(TypeBool typeBool);
}
