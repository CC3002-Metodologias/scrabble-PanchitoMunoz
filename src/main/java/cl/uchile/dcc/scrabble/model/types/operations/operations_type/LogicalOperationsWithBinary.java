package cl.uchile.dcc.scrabble.model.types.operations.operations_type;

import cl.uchile.dcc.scrabble.model.types.TypeBinary;
import cl.uchile.dcc.scrabble.model.types.interface_types.SLogical;

/**
 * TODO: DOCUMENTAR
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/24 21:51
 */
public interface LogicalOperationsWithBinary {
    /**
     * Returns the disjunction between the current type and a Binary Type.
     * @param typeBinary A Binary type who will be disjunct to the current type.
     * @return The disjunction between the Binary type and the other type.
     */
    SLogical andWithBinary(TypeBinary typeBinary);

    /**
     * Returns the conjunction between the current type and a Binary Type.
     * @param typeBinary A Binary type who will be conjunct to the current type.
     * @return The conjunction between the Binary type and the other type.
     */
    SLogical orWithBinary(TypeBinary typeBinary);
}
