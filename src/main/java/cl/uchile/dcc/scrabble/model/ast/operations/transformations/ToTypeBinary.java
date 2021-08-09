package cl.uchile.dcc.scrabble.model.ast.operations.transformations;

import cl.uchile.dcc.scrabble.model.ast.ASTComponent;
import cl.uchile.dcc.scrabble.model.ast.operations.abstract_operations.AbstractTransformation;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.unary_operators.ToHiddenBinary;

/**
 * A class that works as a decorator for an {@code Operation}. Allows binary transformation.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/22 23:56
 */
public class ToTypeBinary extends AbstractTransformation {

    /**
     * Constructor.
     *
     * @param value an AST. It can be an {@code Operation} or a {@code SType}.
     */
    public ToTypeBinary(ASTComponent value) {
        super(new ToHiddenBinary(value.asHiddenAST()));
    }
}
