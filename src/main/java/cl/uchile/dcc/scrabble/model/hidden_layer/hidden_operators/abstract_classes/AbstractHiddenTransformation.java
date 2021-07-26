package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.abstract_classes;

import cl.uchile.dcc.scrabble.model.hidden_layer.HiddenASTComponent;

/**
 * Abstract class for the hidden transformations.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/26 13:31
 */
public abstract class AbstractHiddenTransformation extends AbstractHiddenUnaryOperator {

    /**
     * Constructor with one parameter. It can receive an {@code HiddenOperator} or a {@code
     * HType}.
     *
     * @param value a value. It can receive an {@code HiddenOperator} or a {@code HType}.
     */
    public AbstractHiddenTransformation(HiddenASTComponent value, String operatorName) {
        super(value, operatorName);
    }

    /**
     * Returns true if the operation is a transformation, false otherwise. To use template pattern
     * in {@code asString}.
     *
     * @return true if the operation is a transformation, false otherwise.
     */
    @Override
    protected boolean isTransformation() {
        return true;
    }
}
