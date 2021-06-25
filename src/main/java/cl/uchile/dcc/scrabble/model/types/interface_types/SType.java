package cl.uchile.dcc.scrabble.model.types.interface_types;

import cl.uchile.dcc.scrabble.model.ast.interfaces.AST;
import cl.uchile.dcc.scrabble.model.types.TypeString;
import cl.uchile.dcc.scrabble.model.types.operations.operations_type.ArithmeticOperationsWithString;

/**
 * An interface for the sole purpose of representing any type.
 *
 * @author Francisco Muñoz Guajardo
 */
public interface SType extends AST, ArithmeticOperationsWithString {

    /**
     * Transforms the current type to a {@code TypeString}.
     *
     * @return {@code TypeString} with a value equivalent to the current type.
     */
    TypeString toTypeString();
}
