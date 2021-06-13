package cl.uchile.dcc.scrabble.model.types.operations.and;

import cl.uchile.dcc.scrabble.model.types.TypeBool;
import cl.uchile.dcc.scrabble.model.types.interface_types.SLogical;

/**
 * Interface for the logic 'and' operation. It is in case a Bool is operated with any type.
 * Currently this interface is for the other types.
 * @author Francisco Muñoz Guajardo
 */
public interface IAndWithBool {
    /**
     * Returns the disjunction between the current type and a Bool Type.
     * @param typeBool A Bool type who will be disjunct to the current type.
     * @return The disjunction between the Bool type and the other type.
     */
    SLogical andWithBool(TypeBool typeBool);
}
