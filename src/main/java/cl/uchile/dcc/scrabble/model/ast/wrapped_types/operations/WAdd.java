package cl.uchile.dcc.scrabble.model.ast.wrapped_types.operations;

import cl.uchile.dcc.scrabble.model.ast.wrapped_types.WType;
import cl.uchile.dcc.scrabble.model.ast.wrapped_types.WrappedBinary;
import cl.uchile.dcc.scrabble.model.ast.wrapped_types.WrappedBool;
import cl.uchile.dcc.scrabble.model.ast.wrapped_types.WrappedFloat;
import cl.uchile.dcc.scrabble.model.ast.wrapped_types.WrappedInt;
import cl.uchile.dcc.scrabble.model.ast.wrapped_types.WrappedString;

/**
 * Interface to implements the addition in wrapped classes.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/13 0:15
 */
public interface WAdd {

    /**
     * Returns the sum
     *
     * @param wType other type to sum
     * @return the sum
     */
    WType add(WType wType);

    /**
     * To use double dispatch in {@code add}
     */
    WType addWithString(WrappedString wString);

    /**
     * To use double dispatch in {@code add}
     */
    WType addWithBool(WrappedBool wBool);

    /**
     * To use double dispatch in {@code add}
     */
    WType addWithBinary(WrappedBinary wBinary);

    /**
     * To use double dispatch in {@code add}
     */
    WType addWithFloat(WrappedFloat wFloat);

    /**
     * To use double dispatch in {@code add}
     */
    WType addWithInt(WrappedInt wInt);
}
