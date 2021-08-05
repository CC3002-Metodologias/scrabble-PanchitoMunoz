package cl.uchile.dcc.scrabble.model.ast.relational_operators;

import cl.uchile.dcc.scrabble.model.ast.ASTComponent;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_relational_operator.HiddenGreaterThan;

/**
 * A class for the relational operator greater than.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/08/05 12:11
 */
public class GreaterThan extends AbstractRelationalOperator {

    /**
     * Constructor.
     *
     * @param leftValue  the left value
     * @param rightValue the right value
     */
    public GreaterThan(
        ASTComponent leftValue,
        ASTComponent rightValue) {
        super(new HiddenGreaterThan(leftValue.asHiddenAST(), rightValue.asHiddenAST()));
    }
}
