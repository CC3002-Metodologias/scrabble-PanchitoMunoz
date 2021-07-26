package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.transformations;

import cl.uchile.dcc.scrabble.model.ast.operations.transformations.ToTypeBool;
import cl.uchile.dcc.scrabble.model.hidden_layer.HiddenASTComponent;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.abstract_classes.AbstractHiddenTransformation;
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
     * Constructor with one parameter. It can receive an {@code HiddenOperator} or a {@code
     * HType}.
     *
     * @param value a value. It can receive an {@code HiddenOperator} or a {@code HType}.
     */
    public ToHiddenBool(HiddenASTComponent value) {
        super(value, "toTypeBool");
    }

    /**
     * Compute the unary operation. To use template pattern in {@code mainOperation}.
     *
     * @param value a value
     * @return the value computed
     */
    @Override
    protected HType mainUnaryOperation(HType value) {
        return value.toHiddenBool();
    }
}
