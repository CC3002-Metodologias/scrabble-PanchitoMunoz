package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.unary_operators;

import cl.uchile.dcc.scrabble.model.ast.operations.Neg;
import cl.uchile.dcc.scrabble.model.hidden_layer.HiddenASTComponent;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HType;

/**
 * A class to add a node in the {@code HiddenASTComponent}. It is equivalent to compute the {@code
 * neg} method. This class will be adapted by the {@code Neg} class.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/21 17:33
 * @see Neg
 */
public class HiddenNeg extends AbstractHiddenUnaryOperator {

    /**
     * Default constructor. It can receive an {@code HiddenOperator} or a {@code HType}.
     *
     * @param value left value, it can be an {@code HiddenOperator} or a {@code HType}.
     */
    public HiddenNeg(HiddenASTComponent value) {
        super(value, "Neg");
    }

    /**
     * Compute the main operation of the {@code HiddenOperation}. To use template pattern in {@code
     * calculate}.
     *
     * @param value1 the value at the left
     * @return the value computed
     */
    @Override
    protected HType mainOperation(HType value1) {
        return value1.neg();
    }

    /**
     * Creates and returns a copy of this object.
     *
     * @return a clone of this instance.
     */
    @Override
    public HiddenNeg copy() {
        return new HiddenNeg(getFirstChildren().copy());
    }

    /**
     * Returns the code representation.
     *
     * @param space the number of space of indentation.
     * @return a code representation
     */
    @Override
    public String asCode(int space) {
        String tab = " ".repeat(space);
        return tab + "~ " + getFirstChildren().asCode();
    }
}
