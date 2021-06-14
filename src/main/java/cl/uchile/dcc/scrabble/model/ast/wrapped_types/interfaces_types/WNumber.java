package cl.uchile.dcc.scrabble.model.ast.wrapped_types.interfaces_types;

import cl.uchile.dcc.scrabble.model.ast.wrapped_types.operations.WDiv;
import cl.uchile.dcc.scrabble.model.ast.wrapped_types.operations.WMult;
import cl.uchile.dcc.scrabble.model.ast.wrapped_types.operations.WSub;

/**
 * An interface that defines a generic Number in the wrapped class. To use adapter pattern.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/13 0:09
 */
public interface WNumber extends WSub, WMult, WDiv {

}
