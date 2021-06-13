package cl.uchile.dcc.scrabble.model.types.operations.and;

import cl.uchile.dcc.scrabble.model.types.TypeBinary;
import cl.uchile.dcc.scrabble.model.types.interface_types.SLogical;

/**
 * Interface for the logic 'and' operation. It is in case a Binary is operated with any type.
 * Currently this interface is for the other types.
 * @author Francisco Muñoz Guajardo
 */
public interface IAndWithBinary {
    /**
     * Returns the disjunction between the current type and a Binary Type.
     * @param typeBinary A Binary type who will be disjunct to the current type.
     * @return The disjunction between the Binary type and the other type.
     */
    SLogical andWithBinary(TypeBinary typeBinary);
}
