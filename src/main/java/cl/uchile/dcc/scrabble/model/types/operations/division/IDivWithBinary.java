package cl.uchile.dcc.scrabble.model.types.operations.division;

import cl.uchile.dcc.scrabble.model.types.TypeBinary;
import cl.uchile.dcc.scrabble.model.types.interface_types.SInteger;

/**
 * Interface for the division operation. It is in case a Binary is divided by any type.
 * Currently this interface is for the other types.
 * @author Francisco Muñoz Guajardo
 */
public interface IDivWithBinary {
    /**
     * Returns the division between the current type and a Binary Type.
     *
     * @param typeBinary A Binary type who will be divided to the current type.
     * @return The division between the Binary type and the other type.
     */
    SInteger divWithBinary(TypeBinary typeBinary);
}
