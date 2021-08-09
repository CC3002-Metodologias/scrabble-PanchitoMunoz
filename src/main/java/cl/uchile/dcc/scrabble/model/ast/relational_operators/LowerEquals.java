package cl.uchile.dcc.scrabble.model.ast.relational_operators;

import cl.uchile.dcc.scrabble.model.ast.ASTComponent;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_relational_operator.HiddenLowerEquals;

/**
 * A class for the relational operator lower equals
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/08/05 12:13
 */
public class LowerEquals extends AbstractRelationalOperator {

    /**
     * Constructor.
     *
     * @param leftValue  the left value
     * @param rightValue the right value
     */
    public LowerEquals(
        ASTComponent leftValue,
        ASTComponent rightValue) {
        super(new HiddenLowerEquals(leftValue.asHiddenAST(), rightValue.asHiddenAST()));
    }
}
