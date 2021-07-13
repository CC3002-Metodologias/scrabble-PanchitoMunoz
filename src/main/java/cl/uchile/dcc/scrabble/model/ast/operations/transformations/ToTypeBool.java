package cl.uchile.dcc.scrabble.model.ast.operations.transformations;

import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operations.transformations.ToHiddenBool;
import cl.uchile.dcc.scrabble.model.ast.AST;
import cl.uchile.dcc.scrabble.model.ast.operations.abstract_operations.AbstractTransformation;

/**
 * A class that works as a decorator for an {@code Operation}. Allows bool transformation.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/22 23:57
 */
public class ToTypeBool extends AbstractTransformation {

    /**
     * Constructor.
     *
     * @param value an AST. It can be an {@code Operation} or a {@code SType}.
     */
    public ToTypeBool(AST value) {
        super(new ToHiddenBool(value.asHiddenAST()));
    }

}
