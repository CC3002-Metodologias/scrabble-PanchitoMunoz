package cl.uchile.dcc.scrabble.model.ast.operations;

import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_operations.operations.HiddenAnd;
import cl.uchile.dcc.scrabble.model.ast.AST;
import cl.uchile.dcc.scrabble.model.ast.operations.abstract_operations.AbstractOperation;

/**
 * An {@code Operation} class that adds a node in the {@code AST}. It is equivalent to applying {@code and} method.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/15 11:49
 */
public class And extends AbstractOperation {

    /**
     * Constructor.
     *
     * @param leftValue  an AST. It can be an {@code Operation} or a {@code SType}.
     * @param rightValue an AST. It can be an {@code Operation} or a {@code SType}.
     */
    public And(AST leftValue, AST rightValue) {
        super(new HiddenAnd(leftValue.toHiddenAST(), rightValue.toHiddenAST()));
    }
}
