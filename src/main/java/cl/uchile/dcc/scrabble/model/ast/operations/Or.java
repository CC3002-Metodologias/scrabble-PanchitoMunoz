package cl.uchile.dcc.scrabble.model.ast.operations;

import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_operations.operations.HiddenOr;
import cl.uchile.dcc.scrabble.model.ast.AST;
import cl.uchile.dcc.scrabble.model.ast.operations.abstract_operations.AbstractOperation;

/**
 * An {@code Operation} class that adds a node in the {@code AST}. It is equivalent to applying {@code or} method.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/15 11:52
 */
public class Or extends AbstractOperation {

    /**
     * Constructor.
     *
     * @param leftValue  an AST. It can be an {@code Operation} or a {@code SType}.
     * @param rightValue an AST. It can be an {@code Operation} or a {@code SType}.
     */
    public Or(AST leftValue, AST rightValue) {
        super(new HiddenOr(leftValue.toHiddenAST(), rightValue.toHiddenAST()));
    }

}
