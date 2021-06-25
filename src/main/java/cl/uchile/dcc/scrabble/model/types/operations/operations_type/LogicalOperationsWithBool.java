package cl.uchile.dcc.scrabble.model.types.operations.operations_type;

import cl.uchile.dcc.scrabble.model.types.TypeBool;
import cl.uchile.dcc.scrabble.model.types.interface_types.SLogical;

/**
 * TODO: DOCUMENTAR
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/24 21:53
 */
public interface LogicalOperationsWithBool {
    /**
     * Returns the disjunction between the current type and a Bool Type.
     * @param typeBool A Bool type who will be disjunct to the current type.
     * @return The disjunction between the Bool type and the other type.
     */
    SLogical andWithBool(TypeBool typeBool);

    /**
     * Returns the conjunction between the current type and a Bool Type.
     * @param typeBool A Bool type who will be conjunct to the current type.
     * @return The conjunction between the Bool type and the other type.
     */
    SLogical orWithBool(TypeBool typeBool);
}
