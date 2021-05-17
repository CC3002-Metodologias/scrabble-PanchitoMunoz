package cl.uchile.dcc.scrabble.model.operations.multiplication;

import cl.uchile.dcc.scrabble.model.types.interface_types.SInteger;
import cl.uchile.dcc.scrabble.model.types.TypeBinary;

/**
 * Interface for the multiplication operation. It is in case a Binary is multiplied by any type.
 * Currently this interface is for the other types.
 * @author Francisco Muñoz Guajardo
 */
public interface IMultWithBinary {
    /**
     * Returns the multiplication between the current type and a Binary Type.
     * @param typeBinary A Binary type who will be multiplied to the current type.
     * @return The multiplication between the Binary type and the other type.
     */
    SInteger multWithBinary(TypeBinary typeBinary);
}
