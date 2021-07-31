package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.abstract_classes;

import cl.uchile.dcc.scrabble.model.hidden_layer.HiddenASTComponent;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.hidden_relational_operator.HiddenRelationalOperator;

/**
 * todo: doc
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/07/26 0:34
 */
public abstract class AbstractHiddenRelationalOperator
    extends AbstractHiddenBinaryOperator
    implements HiddenRelationalOperator {

    /**
     * Default constructor. It can receive an {@code HiddenOperator} or a {@code HType}.
     *
     * @param leftValue      left value, it can be an {@code HiddenOperator} or a {@code HType}.
     * @param rightValue     right value, it can be an {@code HiddenOperator} or a {@code HType}.
     * @param operatorName   the operator's name
     * @param operatorSymbol the operator's symbol
     */
    public AbstractHiddenRelationalOperator(
        HiddenASTComponent leftValue,
        HiddenASTComponent rightValue,
        String operatorName, String operatorSymbol) {
        super(leftValue, rightValue, operatorName, operatorSymbol);
    }
}
