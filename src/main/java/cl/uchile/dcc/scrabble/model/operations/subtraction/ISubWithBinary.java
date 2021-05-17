package cl.uchile.dcc.scrabble.model.operations.subtraction;

import cl.uchile.dcc.scrabble.model.types.interface_types.SInteger;
import cl.uchile.dcc.scrabble.model.types.TypeBinary;

/**
 * Interface for the subtraction operation. It is in case a Binary is subtracted with any type.
 * Currently this interface is for the other types.
 * @author Francisco Muñoz Guajardo
 */
public interface ISubWithBinary {
    /**
     * Returns the subtraction between the current type and a Binary Type.
     * @param typeBinary A Binary type who will be subtracted to the current type.
     * @return The subtraction between the Binary type and the other type.
     */
    SInteger subWithBinary(TypeBinary typeBinary);
}
