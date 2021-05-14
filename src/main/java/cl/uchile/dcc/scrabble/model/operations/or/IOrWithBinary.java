package cl.uchile.dcc.scrabble.model.operations.or;

import cl.uchile.dcc.scrabble.model.types.TypeBinary;
import cl.uchile.dcc.scrabble.model.types.interface_types.SLogical;

/**
 * Interface for the logic 'or' operation. It is in case a Binary is operated with any type.
 * Currently this interface is for the other types.
 * @author Francisco Muñoz Guajardo
 */
public interface IOrWithBinary {
    /**
     * Returns the conjunction between the current type and a Binary Type.
     * @param typeBinary A Binary type who will be conjunct to the current type.
     * @return The conjunction between the Binary type and the other type.
     */
    SLogical orWithBinary(TypeBinary typeBinary);
}
