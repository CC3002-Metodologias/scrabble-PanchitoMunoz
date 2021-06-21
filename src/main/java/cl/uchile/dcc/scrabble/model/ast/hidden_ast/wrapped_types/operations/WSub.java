package cl.uchile.dcc.scrabble.model.ast.hidden_ast.wrapped_types.operations;

import cl.uchile.dcc.scrabble.model.ast.hidden_ast.wrapped_types.WType;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.wrapped_types.WrappedBinary;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.wrapped_types.WrappedBool;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.wrapped_types.WrappedFloat;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.wrapped_types.WrappedInt;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.wrapped_types.WrappedString;

/**
 * Interface to implements the subtraction in wrapped classes.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/13 0:16
 */
public interface WSub {

    /**
     * Returns the subtraction between numbers
     *
     * @param wType another number
     * @return the subtraction
     */
    WType sub(WType wType);

    /**
     * To use double dispatch in {@code sub}
     */
    WType subWithString(WrappedString wrappedString);

    /**
     * To use double dispatch in {@code sub}
     */
    WType subWithBool(WrappedBool wrappedBool);

    /**
     * To use double dispatch in {@code sub}
     */
    WType subWithBinary(WrappedBinary wBinary);

    /**
     * To use double dispatch in {@code sub}
     */
    WType subWithFloat(WrappedFloat wFloat);

    /**
     * To use double dispatch in {@code sub}
     */
    WType subWithInt(WrappedInt wInt);
}
