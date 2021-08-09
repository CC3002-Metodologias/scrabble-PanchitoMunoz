package cl.uchile.dcc.scrabble.model.ast.relational_operators;

import cl.uchile.dcc.scrabble.model.ast.ASTComponent;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_relational_operator.HiddenLowerThan;

/**
 * A class that represents the relational operator lower than
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/08/05 12:15
 */
public class LowerThan extends AbstractRelationalOperator {

    /**
     * Constructor.
     *
     * @param leftValue  the left value
     * @param rightValue the right value
     */
    public LowerThan(
        ASTComponent leftValue,
        ASTComponent rightValue) {
        super(new HiddenLowerThan(leftValue.asHiddenAST(), rightValue.asHiddenAST()));
    }
}
