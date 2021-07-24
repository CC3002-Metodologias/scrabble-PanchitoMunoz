package cl.uchile.dcc.scrabble.model.types.interface_types;

import cl.uchile.dcc.scrabble.model.builders.interfaces.NumberASTBuilder;
import cl.uchile.dcc.scrabble.model.types.TypeFloat;

/**
 * An interface for the sole purpose of representing a number.
 *
 * @author Francisco Muñoz Guajardo
 */
public interface SNumber extends SType, NumberASTBuilder {

    /**
     * Returns the value as {@code double}.
     *
     * @return the current value as {@code double}
     */
    double getValueAsDouble();

    /**
     * Transforms the current type to a {@code TypeFloat}.
     *
     * @return {@code TypeFloat} with a value equivalent to the current type.
     */
    TypeFloat toTypeFloat();
}
