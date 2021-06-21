package cl.uchile.dcc.scrabble.model.ast.hidden_ast.wrapped_types.operations;

import cl.uchile.dcc.scrabble.model.ast.hidden_ast.wrapped_types.WType;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.wrapped_types.WrappedBinary;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.wrapped_types.WrappedBool;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.wrapped_types.WrappedFloat;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.wrapped_types.WrappedInt;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.wrapped_types.WrappedString;

/**
 * Interface to implements the disjunction in wrapped classes.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/13 0:23
 */
public interface WAnd {

    /**
     * Returns the disjunction between logicals
     *
     * @param wType another logical
     * @return the disjunction
     */
    WType and(WType wType);

    /**
     * To use double dispatch in {@code and}
     */
    WType andWithString(WrappedString wrappedString);

    /**
     * To use double dispatch in {@code and}
     */
    WType andWithBool(WrappedBool wBool);

    /**
     * To use double dispatch in {@code and}
     */
    WType andWithBinary(WrappedBinary wBinary);

    /**
     * To use double dispatch in {@code and}
     */
    WType andWithFloat(WrappedFloat wrappedFloat);

    /**
     * To use double dispatch in {@code and}
     */
    WType andWithInt(WrappedInt wrappedInt);
}
