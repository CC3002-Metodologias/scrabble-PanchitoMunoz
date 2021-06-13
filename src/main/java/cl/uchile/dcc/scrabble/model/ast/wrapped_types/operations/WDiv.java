package cl.uchile.dcc.scrabble.model.ast.wrapped_types.operations;

import cl.uchile.dcc.scrabble.model.ast.wrapped_types.WBinary;
import cl.uchile.dcc.scrabble.model.ast.wrapped_types.WFloat;
import cl.uchile.dcc.scrabble.model.ast.wrapped_types.WInt;
import cl.uchile.dcc.scrabble.model.ast.wrapped_types.type_interfaces.WNumber;

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
    WNumber divWithBinary(WBinary wBinary);

    /**
     * To use double dispatch in {@code div}
     */
    WNumber divWithFloat(WFloat wFloat);

    /**
     * To use double dispatch in {@code div}
     */
    WNumber divWithInt(WInt wInt);
}
