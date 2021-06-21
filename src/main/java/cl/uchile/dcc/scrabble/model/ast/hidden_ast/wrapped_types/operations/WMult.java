package cl.uchile.dcc.scrabble.model.ast.hidden_ast.wrapped_types.operations;

import cl.uchile.dcc.scrabble.model.ast.hidden_ast.wrapped_types.WType;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.wrapped_types.WrappedBinary;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.wrapped_types.WrappedBool;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.wrapped_types.WrappedFloat;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.wrapped_types.WrappedInt;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.wrapped_types.WrappedString;

/**
 * Interface to implements the multiplication in wrapped classes.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/13 0:22
 */
public interface WMult {

    /**
     * Returns the multiplication between numbers
     *
     * @param wType another number
     * @return the multiplication
     */
    WType mult(WType wType);

    /**
     * To use double dispatch in {@code mult}
     */
    WType multWithString(WrappedString wrappedString);

    /**
     * To use double dispatch in {@code mult}
     */
    WType multWithBool(WrappedBool wrappedBool);

    /**
     * To use double dispatch in {@code mult}
     */
    WType multWithBinary(WrappedBinary wBinary);

    /**
     * To use double dispatch in {@code mult}
     */
    WType multWithFloat(WrappedFloat wFloat);

    /**
     * To use double dispatch in {@code mult}
     */
    WType multWithInt(WrappedInt wInt);
}
