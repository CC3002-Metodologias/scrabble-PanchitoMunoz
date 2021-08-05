package cl.uchile.dcc.scrabble.model.ast.relational_operators;

import cl.uchile.dcc.scrabble.model.ast.ASTComponent;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_relational_operator.HiddenGreaterEquals;

/**
 * A class that represents the relational operator greater equals
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/08/05 12:09
 */
public class GreaterEquals extends AbstractRelationalOperator {

    /**
     * Constructor.
     *
     * @param leftValue  the left value
     * @param rightValue the right value
     */
    public GreaterEquals(
        ASTComponent leftValue,
        ASTComponent rightValue) {
        super(new HiddenGreaterEquals(leftValue.asHiddenAST(), rightValue.asHiddenAST()));
    }
}
