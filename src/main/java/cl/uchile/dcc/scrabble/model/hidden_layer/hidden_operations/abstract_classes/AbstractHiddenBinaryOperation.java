package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operations.abstract_classes;

import cl.uchile.dcc.scrabble.model.hidden_layer.HiddenASTComponent;
import java.util.Stack;

/**
 * Abstract class for binary operations in the hidden types.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/26 13:31
 */
public abstract class AbstractHiddenBinaryOperation extends AbstractHiddenOperation {

    /**
     * Default constructor. It can receive an {@code HiddenOperation} or a {@code HType}.
     *
     * @param leftValue  left value, it can be an {@code HiddenOperation} or a {@code HType}.
     * @param rightValue right value, it can be an {@code HiddenOperation} or a {@code HType}.
     */
    public AbstractHiddenBinaryOperation(
        HiddenASTComponent leftValue, HiddenASTComponent rightValue,
        String operatorName, String operatorSymbol) {
        super(leftValue, rightValue, operatorName, operatorSymbol);
    }

    /**
     * Updates the stack.
     *
     * @param stack the current stack.
     */
    @Override
    public final void updateStack(Stack<HiddenASTComponent> stack) {
        stack.push(this.getRightChildren());
        stack.push(this.getLeftChildren());
    }

    /**
     * Returns the number of vertices in the current {@code HiddenASTComponent}
     *
     * @return the number of vertices
     */
    @Override
    public int size() {
        return this.getLeftChildren().size() + this.getRightChildren().size() + 1;
    }
}
