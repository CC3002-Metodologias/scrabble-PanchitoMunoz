package cl.uchile.dcc.scrabble.model.ast.hidden_ast.wrapped_types.operations;

import cl.uchile.dcc.scrabble.model.ast.hidden_ast.wrapped_types.WType;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.wrapped_types.WrappedBinary;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.wrapped_types.WrappedBool;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.wrapped_types.WrappedFloat;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.wrapped_types.WrappedInt;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.wrapped_types.WrappedString;

/**
 * Interface to implements the division in wrapped classes.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/13 0:23
 */
public interface WDiv {

    /**
     * Returns the division between numbers
     *
     * @param wType another number
     * @return the division
     */
    WType div(WType wType);

    /**
     * To use double dispatch in {@code div}
     */
    WType divWithString(WrappedString wrappedString);

    /**
     * To use double dispatch in {@code div}
     */
    WType divWithBool(WrappedBool wrappedBool);

    /**
     * To use double dispatch in {@code div}
     */
    WType divWithBinary(WrappedBinary wBinary);

    /**
     * To use double dispatch in {@code div}
     */
    WType divWithFloat(WrappedFloat wFloat);

    /**
     * To use double dispatch in {@code div}
     */
    WType divWithInt(WrappedInt wInt);
}
