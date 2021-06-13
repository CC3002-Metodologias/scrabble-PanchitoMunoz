package cl.uchile.dcc.scrabble.model.ast.wrapped_types.operations;

import cl.uchile.dcc.scrabble.model.ast.wrapped_types.WBinary;
import cl.uchile.dcc.scrabble.model.ast.wrapped_types.WFloat;
import cl.uchile.dcc.scrabble.model.ast.wrapped_types.WInt;
import cl.uchile.dcc.scrabble.model.ast.wrapped_types.type_interfaces.WNumber;

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
     * @param wNumber another number
     * @return the multiplication
     */
    WNumber mult(WNumber wNumber);

    /**
     * To use double dispatch in {@code mult}
     */
    WNumber multWithBinary(WBinary wBinary);

    /**
     * To use double dispatch in {@code mult}
     */
    WNumber multWithFloat(WFloat wFloat);

    /**
     * To use double dispatch in {@code mult}
     */
    WNumber multWithInt(WInt wInt);
}
