package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_relational_operator;

import cl.uchile.dcc.scrabble.model.hidden_layer.HiddenASTComponent;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.binary_operators.HiddenBinaryOperator;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HType;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_visitors.HiddenVisitor;

/**
 * A class to be adapted. It is for the lower than AST.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/07/27 18:58
 */
public class HiddenLowerThan extends AbstractHiddenRelationalOperator {

    /**
     * Default constructor. It can receive an {@code HiddenOperator} or a {@code HType}.
     *
     * @param leftValue  left value, it can be an {@code HiddenOperator} or a {@code HType}.
     * @param rightValue right value, it can be an {@code HiddenOperator} or a {@code HType}.
     */
    public HiddenLowerThan(
        HiddenASTComponent leftValue,
        HiddenASTComponent rightValue) {
        super(leftValue, rightValue, "LowerThan", "<");
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
        return value1.lowerThan(value2);
    }

    /**
     * Method that accepts a {@code HiddenVisitor}.
     *
     * @param visitor a {@code HiddenVisitor}.
     */
    @Override
    public void accept(HiddenVisitor visitor) {
        visitor.visitHiddenLowerThan(this);
    }

    /**
     * Creates and returns a copy of this object.
     *
     * @return a clone of this instance.
     */
    @Override
    public HiddenBinaryOperator copy() {
        return new HiddenLowerThan(getFirstChildren().copy(), getSecondChildren().copy());
    }
}
