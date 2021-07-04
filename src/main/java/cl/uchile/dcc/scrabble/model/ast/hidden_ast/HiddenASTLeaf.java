package cl.uchile.dcc.scrabble.model.ast.hidden_ast;

import cl.uchile.dcc.scrabble.model.types.interface_types.SType;

/**
 * An interface to define a generic leaf in {@code HiddenAST}
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/07/04 0:47
 */
public interface HiddenASTLeaf extends HiddenAST {

    /**
     * Gets the current instance in the wrapper
     *
     * @return the instance in the wrapper
     */
    SType toSType();

}
