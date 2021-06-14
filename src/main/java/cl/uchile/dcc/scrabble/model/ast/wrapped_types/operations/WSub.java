package cl.uchile.dcc.scrabble.model.ast.wrapped_types.operations;

import cl.uchile.dcc.scrabble.model.ast.wrapped_types.WrappedBinary;
import cl.uchile.dcc.scrabble.model.ast.wrapped_types.WrappedFloat;
import cl.uchile.dcc.scrabble.model.ast.wrapped_types.WrappedInt;
import cl.uchile.dcc.scrabble.model.ast.wrapped_types.interfaces_types.WNumber;

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
     * @param wNumber another number
     * @return the subtraction
     */
    WNumber sub(WNumber wNumber);

    /**
     * To use double dispatch in {@code sub}
     */
    WNumber subWithBinary(WrappedBinary wBinary);

    /**
     * To use double dispatch in {@code sub}
     */
    WNumber subWithFloat(WrappedFloat wFloat);

    /**
     * To use double dispatch in {@code sub}
     */
    WNumber subWithInt(WrappedInt wInt);
}
