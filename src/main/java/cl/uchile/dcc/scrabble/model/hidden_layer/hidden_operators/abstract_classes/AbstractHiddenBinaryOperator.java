package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.abstract_classes;

import cl.uchile.dcc.scrabble.model.factories.hidden_factories.HTypeFactory;
import cl.uchile.dcc.scrabble.model.hidden_layer.HiddenASTComponent;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HType;
import java.util.Stack;

/**
 * Abstract class for binary operations in the hidden types.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/26 13:31
 */
public abstract class AbstractHiddenBinaryOperator extends AbstractHiddenOperator {

    private final HiddenASTComponent secondChildren;
    private final String operatorSymbol;

    /**
     * Default constructor. It can receive any {@code HiddenASTComponent}.
     *
     * @param firstChildren  the first value. It can be any {@code HiddenASTComponent}.
     * @param secondChildren the second value. It can be any {@code HiddenASTComponent}.
     * @param operatorName   the operator's name.
     * @param operatorSymbol the operator's symbol.
     */
    public AbstractHiddenBinaryOperator(
        HiddenASTComponent firstChildren, HiddenASTComponent secondChildren,
        String operatorName, String operatorSymbol) {
        super(firstChildren, operatorName);
        this.secondChildren = secondChildren;
        this.operatorSymbol = operatorSymbol;
    }

    /**
     * Updates the stack.
     *
     * @param stack the current stack.
     */
    @Override
    public final void updateStack(Stack<HiddenASTComponent> stack) {
        stack.push(this.getSecondChildren());
        stack.push(this.getFirstChildren());
    }

    /**
     * Returns the number of vertices in the current {@code HiddenASTComponent}
     *
     * @return the number of vertices
     */
    @Override
    public final int size() {
        return super.size() + getSecondChildren().size();
    }

    public final HiddenASTComponent getSecondChildren() {
        return secondChildren;
    }

    public final String getOperatorSymbol() {
        return operatorSymbol;
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
            + getFirstChildren().asString(space + 2) + ' ' + getOperatorSymbol() + '\n'
            + getSecondChildren().asString(space + 2) + '\n'
            + tab + ')';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AbstractHiddenBinaryOperator)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }

        AbstractHiddenBinaryOperator that = (AbstractHiddenBinaryOperator) o;

        if (!getSecondChildren().equals(that.getSecondChildren())) {
            return false;
        }
        return getOperatorSymbol().equals(that.getOperatorSymbol());
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getSecondChildren().hashCode();
        result = 31 * result + getOperatorSymbol().hashCode();
        return result;
    }

    /**
     * Calculate the {@code HType} result of performing all operations
     *
     * @return {@code HType} result of operations.
     */
    @Override
    public HType calculate() {
        return mainOperation(firstChildrenCalculated(), secondChildrenCalculated());
    }

    protected final HType secondChildrenCalculated() {
        return getSecondChildren().calculate();
    }

    /**
     * Compute the main operation of the {@code HiddenOperation}. To use template pattern in {@code
     * calculate}.
     *
     * @param value1 the value at the left
     * @return the value computed
     */
    @Override
    protected final HType mainOperation(HType value1) {
        return mainOperation(value1, HTypeFactory.createHiddenNull());
    }

    protected abstract HType mainOperation(HType value1, HType value2);
}
