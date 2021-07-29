package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.abstract_classes;

import cl.uchile.dcc.scrabble.model.hidden_layer.HiddenASTComponent;
import java.util.Stack;

/**
 * Abstract class for unary operations in the hidden types.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/26 13:31
 */
public abstract class AbstractHiddenUnaryOperator extends AbstractHiddenOperator {

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
     * Updates the stack.
     *
     * @param stack the current stack.
     */
    @Override
    public final void updateStack(Stack<HiddenASTComponent> stack) {
        stack.push(this.getFirstChildren());
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


}
