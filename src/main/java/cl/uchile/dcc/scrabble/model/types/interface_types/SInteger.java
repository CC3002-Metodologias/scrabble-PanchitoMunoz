package cl.uchile.dcc.scrabble.model.types.interface_types;

import cl.uchile.dcc.scrabble.model.types.TypeBinary;
import cl.uchile.dcc.scrabble.model.types.TypeInt;
import cl.uchile.dcc.scrabble.model.types.operations.operations_type.ArithmeticOperationsWithBinary;

/**
 * An interface for the sole purpose of representing an integer.
 *
 * @author Francisco Muñoz Guajardo
 */
public interface SInteger extends ArithmeticOperationsWithBinary {

    /**
     * Transforms the current type to a {@code TypeBinary}.
     *
     * @return {@code TypeBinary} with a value equivalent to the current type.
     */
    TypeBinary toTypeBinary();

    /**
     * Transforms the current type to a {@code TypeInt}.
     *
     * @return {@code TypeInt} with a value equivalent to the current type.
     */
    TypeInt toTypeInt();
}
