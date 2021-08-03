package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.binary_operators;

import cl.uchile.dcc.scrabble.model.ast.operations.And;
import cl.uchile.dcc.scrabble.model.hidden_layer.HiddenASTComponent;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HType;

/**
 * A class to add a node in the {@code HiddenASTComponent}. It is equivalent to compute the {@code
 * and} method. This class will be adapted by the {@code And} class.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/21 17:33
 * @see And
 */
public class HiddenAnd extends AbstractHiddenBinaryOperator {

    /**
     * Default constructor. It can receive an {@code HiddenOperator} or a {@code HType}.
     *
     * @param leftValue  left value, it can be an {@code HiddenOperator} or a {@code HType}.
     * @param rightValue right value, it can be an {@code HiddenOperator} or a {@code HType}.
     */
    public HiddenAnd(HiddenASTComponent leftValue, HiddenASTComponent rightValue) {
        super(leftValue, rightValue, "And", "and");
    }

    /**
     * Compute the operation between 2 {@code HType} and returns its operation. To use template
     * pattern.
     *
     * @param value1 the value at the left
     * @param value2 the value at the right
     * @return the value computed
     */
    @Override
    protected HType mainOperation(HType value1, HType value2) {
        return value1.and(value2);
    }

    /**
     * Creates and returns a copy of this object.
     *
     * @return a clone of this instance.
     */
    @Override
    public HiddenAnd copy() {
        return new HiddenAnd(getFirstChildren().copy(), getSecondChildren().copy());
    }
}
