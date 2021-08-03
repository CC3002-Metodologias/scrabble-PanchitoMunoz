package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.binary_operators;

import cl.uchile.dcc.scrabble.model.ast.operations.Or;
import cl.uchile.dcc.scrabble.model.hidden_layer.HiddenASTComponent;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HType;

/**
 * A class to add a node in the {@code HiddenASTComponent}. It is equivalent to compute the {@code
 * or} method. This class will be adapted by the {@code Or} class.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/21 17:34
 * @see Or
 */
public class HiddenOr extends AbstractHiddenBinaryOperator {

    /**
     * Default constructor. It can receive an {@code HiddenOperator} or a {@code HType}.
     *
     * @param leftValue  left value, it can be an {@code HiddenOperator} or a {@code HType}.
     * @param rightValue right value, it can be an {@code HiddenOperator} or a {@code HType}.
     */
    public HiddenOr(HiddenASTComponent leftValue, HiddenASTComponent rightValue) {
        super(leftValue, rightValue, "Or", "or");
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
        return value1.or(value2);
    }

    /**
     * Creates and returns a copy of this object.
     *
     * @return a clone of this instance.
     */
    @Override
    public HiddenOr copy() {
        return new HiddenOr(getFirstChildren().copy(), getSecondChildren().copy());
    }
}
