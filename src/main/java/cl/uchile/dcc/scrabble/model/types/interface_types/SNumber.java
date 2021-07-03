package cl.uchile.dcc.scrabble.model.types.interface_types;

import cl.uchile.dcc.scrabble.model.ast.builders.interfaces.NumberASTBuilder;
import cl.uchile.dcc.scrabble.model.types.TypeFloat;
import cl.uchile.dcc.scrabble.model.types.operations.operations_type.ArithmeticOperationsWithFloat;
import cl.uchile.dcc.scrabble.model.types.operations.operations_type.ArithmeticOperationsWithInt;

/**
 * An interface for the sole purpose of representing a number.
 *
 * @author Francisco Muñoz Guajardo
 */
public interface SNumber
    extends SType, ArithmeticOperationsWithInt, ArithmeticOperationsWithFloat, NumberASTBuilder {

    /**
     * Transforms the current type to a {@code TypeFloat}.
     *
     * @return {@code TypeFloat} with a value equivalent to the current type.
     */
    TypeFloat toTypeFloat();
}
