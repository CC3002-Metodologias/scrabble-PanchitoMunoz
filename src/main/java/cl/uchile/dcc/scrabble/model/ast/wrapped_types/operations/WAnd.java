package cl.uchile.dcc.scrabble.model.ast.wrapped_types.operations;

import cl.uchile.dcc.scrabble.model.ast.wrapped_types.WBinary;
import cl.uchile.dcc.scrabble.model.ast.wrapped_types.WBool;
import cl.uchile.dcc.scrabble.model.ast.wrapped_types.type_interfaces.WLogical;

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
     * @param wLogical another logical
     * @return the disjunction
     */
    WLogical and(WLogical wLogical);

    /**
     * To use double dispatch in {@code and}
     */
    WLogical andWithBool(WBool wBool);

    /**
     * To use double dispatch in {@code and}
     */
    WLogical andWithBinary(WBinary wBinary);
}
