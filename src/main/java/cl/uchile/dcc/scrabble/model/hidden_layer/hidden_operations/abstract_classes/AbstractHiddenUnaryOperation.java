package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operations.abstract_classes;

import cl.uchile.dcc.scrabble.model.factories.hidden_factories.HTypeFactory;
import cl.uchile.dcc.scrabble.model.hidden_layer.HiddenASTComponent;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HType;
import java.util.Stack;

/**
 * Abstract class for unary operations in the hidden types.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/26 13:31
 */
public abstract class AbstractHiddenUnaryOperation extends AbstractHiddenOperation {

    /**
     * Constructor with one parameter. It can receive an {@code HiddenOperation} or a {@code
     * HType}.
     *
     * @param value a value. It can receive an {@code HiddenOperation} or a {@code HType}.
     */
    public AbstractHiddenUnaryOperation(HiddenASTComponent value, String operatorName) {
        super(value, HTypeFactory.createHiddenNull(), operatorName, null);
    }

    /**
     * Right value as {@code String}. To use template pattern in {@code asString}.
     *
     * @param space number of space
     * @return right value as {@code String}
     */
    @Override
    protected final String rightValueAsString(int space) {
        return "";  // Don't used
    }

    /**
     * Compute the operation between 2 {@code HType} and returns its operation. To use template
     * pattern in {@code calculate}.
     *
     * @param value1 the value at the left
     * @param value2 the value at the right
     * @return the value computed
     */
    @Override
    protected final HType mainOperation(HType value1, HType value2) {
        return mainUnaryOperation(value1);
    }

    /**
     * Compute the unary operation. To use template pattern in {@code mainOperation}.
     *
     * @param value a value
     * @return the value computed
     */
    protected abstract HType mainUnaryOperation(HType value);

    /**
     * Updates the stack.
     *
     * @param stack the current stack.
     */
    @Override
    public final void updateStack(Stack<HiddenASTComponent> stack) {
        stack.push(this.getLeftChildren());
    }

    /**
     * Returns the number of vertices in the current {@code HiddenASTComponent}
     *
     * @return the number of vertices
     */
    @Override
    public int size() {
        return this.getLeftChildren().size() + 1;
    }
}
