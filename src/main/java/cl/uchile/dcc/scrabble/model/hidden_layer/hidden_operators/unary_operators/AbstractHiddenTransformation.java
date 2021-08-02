package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.unary_operators;

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
     * Returns the {@code String} representation of the current {@code HiddenASTComponent}.
     *
     * @param space number of spaces to ident
     * @return the current {@code HiddenASTComponent} as {@code String}
     */
    @Override
    public final String asString(int space) {
        return getFirstChildren().asString(space) + '.' + getOperatorName() + "()";
    }
}
