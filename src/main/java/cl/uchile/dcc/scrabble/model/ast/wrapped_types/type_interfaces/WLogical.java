package cl.uchile.dcc.scrabble.model.ast.wrapped_types.type_interfaces;

import cl.uchile.dcc.scrabble.model.ast.wrapped_types.operations.WAnd;
import cl.uchile.dcc.scrabble.model.ast.wrapped_types.operations.WOr;

/**
 * An interface that defines a generic Logical in the wrapped class. To use adapter pattern.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/13 0:13
 */
public interface WLogical extends WAnd, WOr {

}
