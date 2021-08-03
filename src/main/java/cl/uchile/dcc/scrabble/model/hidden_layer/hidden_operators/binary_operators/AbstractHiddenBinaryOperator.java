package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.binary_operators;

import cl.uchile.dcc.scrabble.model.hidden_layer.HiddenASTComponent;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.AbstractHiddenOperator;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HType;
import java.util.HashMap;

/**
 * Abstract class for binary operations in the hidden types.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/26 13:31
 */
public abstract class AbstractHiddenBinaryOperator
    extends AbstractHiddenOperator
    implements HiddenBinaryOperator {

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
     * Indicates whether some other object is "equal to" this one.
     *
     * @param o the reference object with which to compare.
     * @return {@code true} if this object is the same as the obj argument; {@code false} otherwise.
     * @see #hashCode()
     * @see HashMap
     */
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

    /**
     * Returns a hash code value for the object.
     *
     * @return a hash code value for this object.
     * @see Object#equals(Object)
     * @see System#identityHashCode
     */
    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getSecondChildren().hashCode();
        result = 31 * result + getOperatorSymbol().hashCode();
        return result;
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

    /**
     * Returns the code representation.
     *
     * @param space the number of space of indentation.
     * @return a code representation
     */
    @Override
    public String asCode(int space) {
        String tab = " ".repeat(space);
        return tab + '(' + getFirstChildren().asCode()
            + ' ' + getOperatorSymbol()
            + ' ' + getSecondChildren().asCode() + ')';
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

    /**
     * Returns the second children.
     *
     * @return the second children
     */
    @Override
    public final HiddenASTComponent getSecondChildren() {
        return secondChildren;
    }

    /**
     * Returns the operator's symbol.
     *
     * @return the operator's symbol
     */
    public final String getOperatorSymbol() {
        return operatorSymbol;
    }

    /**
     * Returns the second children calculated.
     *
     * @return the second children calculated.
     */
    protected final HType secondChildrenCalculated() {
        return getSecondChildren().calculate();
    }

    /**
     * The main operation to use template pattern in {@code calculate}.
     *
     * @param value1 the first value
     * @param value2 the second value
     * @return the first value computed with the second value.
     */
    protected abstract HType mainOperation(HType value1, HType value2);

    /**
     * Calculate the {@code HType} result of performing all operations
     *
     * @return {@code HType} result of operations.
     */
    @Override
    public final HType calculate() {
        return mainOperation(firstChildrenCalculated(), secondChildrenCalculated());
    }
}
