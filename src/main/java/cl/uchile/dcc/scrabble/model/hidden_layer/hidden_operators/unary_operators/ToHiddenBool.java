package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.unary_operators;

import cl.uchile.dcc.scrabble.model.ast.operations.transformations.ToTypeBool;
import cl.uchile.dcc.scrabble.model.hidden_layer.HiddenASTComponent;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HType;

/**
 * A class to add a node in the {@code HiddenASTComponent}. It is equivalent to compute the {@code
 * toHiddenBool} method. This class will be adapted by the {@code ToTypeBool} class.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/22 23:31
 * @see ToTypeBool
 */
public class ToHiddenBool extends AbstractHiddenTransformation {

    /**
     * Constructor with one parameter. It can receive an {@code HiddenOperator} or a {@code HType}.
     *
     * @param value a value. It can receive an {@code HiddenOperator} or a {@code HType}.
     */
    public ToHiddenBool(HiddenASTComponent value) {
        super(value, "toTypeBool");
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
        return value1.toHiddenBool();
    }

    /**
     * Creates and returns a copy of this object.
     *
     * @return a clone of this instance.
     */
    @Override
    public ToHiddenBool copy() {
        return new ToHiddenBool(getFirstChildren().copy());
    }
}
