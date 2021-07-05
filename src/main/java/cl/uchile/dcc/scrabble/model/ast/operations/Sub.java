package cl.uchile.dcc.scrabble.model.ast.operations;

import cl.uchile.dcc.scrabble.model.builders.ASTBuilder;
import cl.uchile.dcc.scrabble.model.hidden_ast.hidden_operations.operations.HiddenSub;
import cl.uchile.dcc.scrabble.model.ast.AST;
import cl.uchile.dcc.scrabble.model.ast.operations.abstract_operations.AbstractOperation;

/**
 * An {@code Operation} class that adds a node in the {@code AST}.
 * It is equivalent to applying {@code sub} method. If an {@code AST} is constructed with an
 * invalid type, it will return {@code null}. In order to ensure that an {@code AST} is well
 * constructed, use {@code ASTBuilder}.
 *
 * @see ASTBuilder
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/15 11:43
 */
public class Sub extends AbstractOperation {

    /**
     * Constructor.
     *
     * @param leftValue  an AST. It can be an {@code Operation} or a {@code SType}.
     * @param rightValue an AST. It can be an {@code Operation} or a {@code SType}.
     */
    public Sub(AST leftValue, AST rightValue) {
        super(new HiddenSub(leftValue.toHiddenAST(), rightValue.toHiddenAST()));
    }

}
