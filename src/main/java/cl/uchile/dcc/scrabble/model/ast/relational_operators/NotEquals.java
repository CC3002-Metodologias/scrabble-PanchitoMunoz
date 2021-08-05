package cl.uchile.dcc.scrabble.model.ast.relational_operators;

import cl.uchile.dcc.scrabble.model.ast.ASTComponent;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_relational_operator.HiddenNotEquals;

/**
 * A class for the relational operator not equals
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/08/05 12:17
 */
public class NotEquals extends AbstractRelationalOperator {

    /**
     * Constructor.
     *
     * @param leftValue  the left value
     * @param rightValue the right value
     */
    public NotEquals(
        ASTComponent leftValue,
        ASTComponent rightValue) {
        super(new HiddenNotEquals(leftValue.asHiddenAST(), rightValue.asHiddenAST()));
    }
}
