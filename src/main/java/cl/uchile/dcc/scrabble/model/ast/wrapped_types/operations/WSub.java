package cl.uchile.dcc.scrabble.model.ast.wrapped_types.operations;

import cl.uchile.dcc.scrabble.model.ast.wrapped_types.WBinary;
import cl.uchile.dcc.scrabble.model.ast.wrapped_types.WFloat;
import cl.uchile.dcc.scrabble.model.ast.wrapped_types.WInt;
import cl.uchile.dcc.scrabble.model.ast.wrapped_types.type_interfaces.WNumber;

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
    WNumber subWithBinary(WBinary wBinary);

    /**
     * To use double dispatch in {@code sub}
     */
    WNumber subWithFloat(WFloat wFloat);

    /**
     * To use double dispatch in {@code sub}
     */
    WNumber subWithInt(WInt wInt);
}
