package cl.uchile.dcc.scrabble.model.ast.wrapped_types.operations;

import cl.uchile.dcc.scrabble.model.ast.wrapped_types.WrappedBinary;
import cl.uchile.dcc.scrabble.model.ast.wrapped_types.WrappedFloat;
import cl.uchile.dcc.scrabble.model.ast.wrapped_types.WrappedInt;
import cl.uchile.dcc.scrabble.model.ast.wrapped_types.interfaces_types.WNumber;

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
     * @param wNumber another number
     * @return the division
     */
    WNumber div(WNumber wNumber);

    /**
     * To use double dispatch in {@code div}
     */
    WNumber divWithBinary(WrappedBinary wBinary);

    /**
     * To use double dispatch in {@code div}
     */
    WNumber divWithFloat(WrappedFloat wFloat);

    /**
     * To use double dispatch in {@code div}
     */
    WNumber divWithInt(WrappedInt wInt);
}
