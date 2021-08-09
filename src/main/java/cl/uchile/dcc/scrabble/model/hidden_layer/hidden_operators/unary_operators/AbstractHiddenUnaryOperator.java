package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.unary_operators;

import cl.uchile.dcc.scrabble.model.hidden_layer.HiddenASTComponent;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.AbstractHiddenOperator;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HType;

/**
 * Abstract class for unary operations in the hidden types.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/26 13:31
 */
public abstract class AbstractHiddenUnaryOperator
    extends AbstractHiddenOperator
    implements HiddenUnaryOperator {

    /**
     * Default constructor. It can receive any {@code HiddenASTComponent}.
     *
     * @param firstChildren the first value. It can be any {@code HiddenASTComponent}.
     * @param operatorName  the operator's name.
     */
    public AbstractHiddenUnaryOperator(
        HiddenASTComponent firstChildren, String operatorName) {
        super(firstChildren, operatorName);
    }

    /**
     * Returns the {@code String} representation of the current {@code HiddenASTComponent}.
     *
     * @param space number of spaces to ident
     * @return the current {@code HiddenASTComponent} as {@code String}
     */
    @Override
    public String asString(int space) {
        String tab = " ".repeat(space);
        return tab + getOperatorName() + "(\n"
            + getFirstChildren().asString(space + 2) + "\n"
            + tab + ')';
    }

    /**
     * Calculate the {@code HType} result of performing all operations
     *
     * @return {@code HType} result of operations.
     */
    @Override
    public final HType calculate() {
        return mainOperation(firstChildrenCalculated());
    }

    /**
     * Compute the main operation of the {@code HiddenOperation}. To use template pattern in {@code
     * calculate}.
     *
     * @param value1 the value at the left
     * @return the value computed
     */
    protected abstract HType mainOperation(HType value1);

}
