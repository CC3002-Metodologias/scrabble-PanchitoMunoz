package cl.uchile.dcc.scrabble.model.ast.relational_operators;

import cl.uchile.dcc.scrabble.model.ast.ASTComponent;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_relational_operator.HiddenEquals;

/**
 * A class for the relational operator equals
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/08/05 12:04
 */
public class Equals extends AbstractRelationalOperator {

    /**
     * Constructor.
     *
     * @param leftValue  the left value
     * @param rightValue the right value
     */
    public Equals(
        ASTComponent leftValue,
        ASTComponent rightValue) {
        super(new HiddenEquals(leftValue.asHiddenAST(), rightValue.asHiddenAST()));
    }
}
