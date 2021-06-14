package cl.uchile.dcc.scrabble.model.ast.wrapped_types.operations;

import cl.uchile.dcc.scrabble.model.ast.wrapped_types.WrappedBinary;
import cl.uchile.dcc.scrabble.model.ast.wrapped_types.WrappedBool;
import cl.uchile.dcc.scrabble.model.ast.wrapped_types.interfaces_types.WLogical;

/**
 * Interface to implements the conjunction in wrapped classes.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/13 0:23
 */
public interface WOr {

    /**
     * Returns the conjunction between logicals
     *
     * @param wLogical another logical
     * @return the conjunction
     */
    WLogical or(WLogical wLogical);

    /**
     * To use double dispatch in {@code or}
     */
    WLogical orWithBool(WrappedBool wBool);

    /**
     * To use double dispatch in {@code or}
     */
    WLogical orWithBinary(WrappedBinary wBinary);
}
