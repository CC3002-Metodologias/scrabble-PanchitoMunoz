package cl.uchile.dcc.scrabble.model.types.interface_types;

import cl.uchile.dcc.scrabble.model.builders.interfaces.IntegerASTBuilder;
import cl.uchile.dcc.scrabble.model.types.TypeBinary;
import cl.uchile.dcc.scrabble.model.types.TypeInt;

/**
 * An interface for the sole purpose of representing an integer.
 *
 * @author Francisco Muñoz Guajardo
 */
public interface SInteger extends SNumber, IntegerASTBuilder {

    int getValueAsInt();

    String getValueAsBinary();

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
