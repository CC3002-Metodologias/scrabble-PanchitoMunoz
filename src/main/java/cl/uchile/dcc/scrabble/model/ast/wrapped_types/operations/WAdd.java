package cl.uchile.dcc.scrabble.model.ast.wrapped_types.operations;

import cl.uchile.dcc.scrabble.model.ast.wrapped_types.WBinary;
import cl.uchile.dcc.scrabble.model.ast.wrapped_types.WBool;
import cl.uchile.dcc.scrabble.model.ast.wrapped_types.WFloat;
import cl.uchile.dcc.scrabble.model.ast.wrapped_types.WInt;
import cl.uchile.dcc.scrabble.model.ast.wrapped_types.WString;
import cl.uchile.dcc.scrabble.model.ast.wrapped_types.WType;

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
    WType addWithString(WString wString);

    /**
     * To use double dispatch in {@code add}
     */
    WType addWithBool(WBool wBool);

    /**
     * To use double dispatch in {@code add}
     */
    WType addWithBinary(WBinary wBinary);

    /**
     * To use double dispatch in {@code add}
     */
    WType addWithFloat(WFloat wFloat);

    /**
     * To use double dispatch in {@code add}
     */
    WType addWithInt(WInt wInt);
}
