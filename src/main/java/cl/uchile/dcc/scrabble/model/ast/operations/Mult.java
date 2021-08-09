package cl.uchile.dcc.scrabble.model.ast.operations;

import cl.uchile.dcc.scrabble.model.ast.ASTComponent;
import cl.uchile.dcc.scrabble.model.ast.operations.abstract_operations.AbstractBinaryOperator;
import cl.uchile.dcc.scrabble.model.builders.ASTBuilder;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.binary_operators.HiddenMult;

/**
 * An {@code Operation} class that adds a node in the {@code AST}.
 * It is equivalent to applying {@code mult} method. If an {@code AST} is constructed with an
 * invalid type, it will return {@code null}. In order to ensure that an {@code AST} is well
 * constructed, use {@code ASTBuilder}.
 *
 * @see ASTBuilder
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/15 11:45
 */
public class Mult extends AbstractBinaryOperator {

    /**
     * Constructor.
     *
     * @param leftValue  an AST. It can be an {@code Operation} or a {@code SType}.
     * @param rightValue an AST. It can be an {@code Operation} or a {@code SType}.
     */
    public Mult(ASTComponent leftValue, ASTComponent rightValue) {
        super(new HiddenMult(leftValue.asHiddenAST(), rightValue.asHiddenAST()));
    }

}
