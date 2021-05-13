package cl.uchile.dcc.scrabble.model.operations.add;

import cl.uchile.dcc.scrabble.model.types.IType;
import cl.uchile.dcc.scrabble.model.types.TypeBinary;

/**
 * Interface for the addition operation. It is in case a Binary is sum with any type.
 * Currently this interface is for the other types.
 * @author Francisco Muñoz Guajardo
 */
public interface IAddWithBinary {
    /**
     * Returns the sum between the current type and a Binary Type.
     * @param typeBinary A Binary type who will be added to the current type.
     * @return The sum between the Binary type and the other type.
     */
    IType addWithBinary(TypeBinary typeBinary);
}
