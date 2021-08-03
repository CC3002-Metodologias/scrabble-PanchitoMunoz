package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_relational_operator;

import cl.uchile.dcc.scrabble.model.hidden_layer.HiddenASTComponent;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.binary_operators.HiddenBinaryOperator;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HType;

/**
 * A class to be adapted. It is for the greater than AST.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/07/27 18:56
 */
public class HiddenGreaterThan extends AbstractHiddenRelationalOperator {

    /**
     * Default constructor. It can receive an {@code HiddenOperator} or a {@code HType}.
     *
     * @param leftValue  left value, it can be an {@code HiddenOperator} or a {@code HType}.
     * @param rightValue right value, it can be an {@code HiddenOperator} or a {@code HType}.
     */
    public HiddenGreaterThan(
        HiddenASTComponent leftValue,
        HiddenASTComponent rightValue) {
        super(leftValue, rightValue, "GreaterThan", ">");
    }

    /**
     * Compute the operation between 2 {@code HType} and returns its operation. To use template
     * pattern in {@code calculate}.
     *
     * @param value1 the value at the left
     * @param value2 the value at the right
     * @return the value computed
     */
    @Override
    protected HType mainOperation(HType value1, HType value2) {
        return value1.greaterThan(value2);
    }

    /**
     * Creates and returns a copy of this object.
     *
     * @return a clone of this instance.
     */
    @Override
    public HiddenBinaryOperator copy() {
        return new HiddenGreaterThan(getFirstChildren().copy(), getSecondChildren().copy());
    }
}
