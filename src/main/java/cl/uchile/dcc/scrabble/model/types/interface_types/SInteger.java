package cl.uchile.dcc.scrabble.model.types.interface_types;

import cl.uchile.dcc.scrabble.model.operations.add.IAddWithBinary;
import cl.uchile.dcc.scrabble.model.operations.division.IDivWithBinary;
import cl.uchile.dcc.scrabble.model.operations.multiplication.IMultWithBinary;
import cl.uchile.dcc.scrabble.model.operations.subtraction.ISubWithBinary;
import cl.uchile.dcc.scrabble.model.types.TypeBinary;
import cl.uchile.dcc.scrabble.model.types.TypeInt;

/**
 * An interface for the sole purpose of representing an integer.
 *
 * @author Francisco Muñoz Guajardo
 */
public interface SInteger
    extends IAddWithBinary, ISubWithBinary, IMultWithBinary, IDivWithBinary {

    /**
     * Transforms the current type to a TypeBinary.
     *
     * @return TypeBinary with a value equivalent to the current type.
     */
    TypeBinary toTypeBinary();

    /**
     * Transforms the current type to a TypeInt.
     *
     * @return TypeInt with a value equivalent to the current type.
     */
    TypeInt toTypeInt();
}
