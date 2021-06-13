package cl.uchile.dcc.scrabble.model.ast.wrapped_types.operations;

import cl.uchile.dcc.scrabble.model.ast.wrapped_types.WBinary;
import cl.uchile.dcc.scrabble.model.ast.wrapped_types.WBool;
import cl.uchile.dcc.scrabble.model.ast.wrapped_types.type_interfaces.WLogical;

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
    WLogical orWithBool(WBool wBool);

    /**
     * To use double dispatch in {@code or}
     */
    WLogical orWithBinary(WBinary wBinary);
}
