package cl.uchile.dcc.scrabble.model.ast.operations.transformations;

import cl.uchile.dcc.scrabble.model.ast.AST;
import cl.uchile.dcc.scrabble.model.ast.operations.abstract_operations.AbstractTransformation;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.transformations.ToHiddenString;

/**
 * A class that works as a decorator for an {@code Operation}. Allows string transformation.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/22 23:58
 */
public class ToTypeString extends AbstractTransformation {

    /**
     * Constructor.
     *
     * @param value an AST. It can be an {@code Operation} or a {@code SType}.
     */
    public ToTypeString(AST value) {
        super(new ToHiddenString(value.asHiddenAST()));
    }
}
