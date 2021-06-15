package cl.uchile.dcc.scrabble.model.ast.wrapped_types.operations;

import cl.uchile.dcc.scrabble.model.ast.wrapped_types.WType;
import cl.uchile.dcc.scrabble.model.ast.wrapped_types.WrappedBinary;
import cl.uchile.dcc.scrabble.model.ast.wrapped_types.WrappedBool;
import cl.uchile.dcc.scrabble.model.ast.wrapped_types.WrappedFloat;
import cl.uchile.dcc.scrabble.model.ast.wrapped_types.WrappedInt;
import cl.uchile.dcc.scrabble.model.ast.wrapped_types.WrappedString;

/**
 * Interface to implements the conjunction in wrapped classes.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/13 0:23
 */
public interface WOr {

    /**
     * Returns the conjunction between logicals
     *
     * @param wType another logical
     * @return the conjunction
     */
    WType or(WType wType);

    /**
     * To use double dispatch in {@code or}
     */
    WType orWithString(WrappedString wrappedString);

    /**
     * To use double dispatch in {@code or}
     */
    WType orWithBool(WrappedBool wBool);

    /**
     * To use double dispatch in {@code or}
     */
    WType orWithBinary(WrappedBinary wBinary);

    /**
     * To use double dispatch in {@code or}
     */
    WType orWithFloat(WrappedFloat wrappedFloat);

    /**
     * To use double dispatch in {@code or}
     */
    WType orWithInt(WrappedInt wrappedInt);
}
