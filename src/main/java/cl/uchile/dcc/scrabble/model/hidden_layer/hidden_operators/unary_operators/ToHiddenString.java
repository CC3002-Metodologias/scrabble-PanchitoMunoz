package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.unary_operators;

import cl.uchile.dcc.scrabble.model.ast.operations.transformations.ToTypeString;
import cl.uchile.dcc.scrabble.model.hidden_layer.HiddenASTComponent;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HType;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_visitors.HiddenVisitor;

/**
 * A class to add a node in the {@code HiddenASTComponent}. It is equivalent to compute the {@code
 * toHiddenString} method. This class will be adapted by the {@code ToTypeString} class.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/22 23:32
 * @see ToTypeString
 */
public class ToHiddenString extends AbstractHiddenTransformation {

    /**
     * Constructor with one parameter. It can receive an {@code HiddenOperator} or a {@code
     * HType}.
     *
     * @param value a value. It can receive an {@code HiddenOperator} or a {@code HType}.
     */
    public ToHiddenString(HiddenASTComponent value) {
        super(value, "toTypeString");
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
        return value1.toHiddenString();
    }

    /**
     * Method that accepts a {@code HiddenVisitor}.
     *
     * @param visitor a {@code HiddenVisitor}.
     */
    @Override
    public void accept(HiddenVisitor visitor) {
        visitor.visitToHiddenString(this);
    }

    /**
     * Creates and returns a copy of this object.
     *
     * @return a clone of this instance.
     */
    @Override
    public ToHiddenString copy() {
        return new ToHiddenString(getFirstChildren().copy());
    }
}
