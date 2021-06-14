package cl.uchile.dcc.scrabble.model.ast.wrapped_types.operations;

import cl.uchile.dcc.scrabble.model.ast.wrapped_types.WrappedBinary;
import cl.uchile.dcc.scrabble.model.ast.wrapped_types.WrappedFloat;
import cl.uchile.dcc.scrabble.model.ast.wrapped_types.WrappedInt;
import cl.uchile.dcc.scrabble.model.ast.wrapped_types.interfaces_types.WNumber;

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
    WNumber multWithBinary(WrappedBinary wBinary);

    /**
     * To use double dispatch in {@code mult}
     */
    WNumber multWithFloat(WrappedFloat wFloat);

    /**
     * To use double dispatch in {@code mult}
     */
    WNumber multWithInt(WrappedInt wInt);
}
