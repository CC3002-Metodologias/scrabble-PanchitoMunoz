package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operations.transformations;

import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operations.abstract_classes.AbstractHiddenTransformation;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HType;
import cl.uchile.dcc.scrabble.model.hidden_layer.HiddenAST;
import cl.uchile.dcc.scrabble.model.ast.operations.transformations.ToTypeFloat;

/**
 * A class to add a node in the {@code HiddenAST}. It is equivalent to compute the {@code toHiddenFloat} method. This class will be adapted by the {@code ToTypeFloat} class.
 *
 * @see ToTypeFloat
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/22 23:32
 */
public class ToHiddenFloat extends AbstractHiddenTransformation {

    /**
     * Constructor with one parameter. It can receive an {@code HiddenOperation} or a {@code HType}.
     *
     * @param value a value. It can receive an {@code HiddenOperation} or a {@code HType}.
     */
    public ToHiddenFloat(HiddenAST value) {
        super(value, "toTypeFloat");
    }

    /**
     * Compute the unary operation. To use template pattern in {@code mainOperation}.
     *
     * @param value a value
     * @return the value computed
     */
    @Override
    protected HType mainUnaryOperation(HType value) {
        return value.toHiddenFloat();
    }
}
