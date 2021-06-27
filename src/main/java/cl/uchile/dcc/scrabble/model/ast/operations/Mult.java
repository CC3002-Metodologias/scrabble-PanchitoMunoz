package cl.uchile.dcc.scrabble.model.ast.operations;

import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_operations.operations.HiddenMult;
import cl.uchile.dcc.scrabble.model.ast.AST;
import cl.uchile.dcc.scrabble.model.ast.operations.abstract_operations.AbstractOperation;

/**
 * An {@code Operation} class that adds a node in the {@code AST}. It is equivalent to applying {@code mult} method.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/15 11:45
 */
public class Mult extends AbstractOperation {

    /**
     * Constructor.
     *
     * @param leftValue  an AST. It can be an {@code Operation} or a {@code SType}.
     * @param rightValue an AST. It can be an {@code Operation} or a {@code SType}.
     */
    public Mult(AST leftValue, AST rightValue) {
        super(new HiddenMult(leftValue.toHiddenAST(), rightValue.toHiddenAST()));
    }

}
