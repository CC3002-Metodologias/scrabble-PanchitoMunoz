package cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_operations.abstract_classes;

import static cl.uchile.dcc.scrabble.model.factories.hidden_factories.HTypeFactory.createHiddenBool;

import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_operations.HiddenOperation;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HType;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.HiddenAST;
import java.util.HashMap;
import java.util.Objects;

/**
 * Abstract class for a general operation in the hidden types.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/21 17:16
 */
public abstract class AbstractHiddenOperation implements HiddenOperation {

    private final HiddenAST leftChildren;
    private final HiddenAST rightChildren;
    private final String operatorName;
    private final String operatorSymbol;

    /**
     * Default constructor. It can receive an {@code HiddenOperation} or a {@code HType}.
     *
     * @param leftValue  left value, it can be an {@code HiddenOperation} or a {@code HType}.
     * @param rightValue right value, it can be an {@code HiddenOperation} or a {@code HType}.
     */
    public AbstractHiddenOperation(
        HiddenAST leftValue, HiddenAST rightValue,
        String operatorName, String operatorSymbol) {
        this.leftChildren = leftValue;
        this.rightChildren = rightValue;
        this.operatorName = operatorName;
        this.operatorSymbol = operatorSymbol;
    }

    /**
     * A String representation of the current instance.
     *
     * @return a string representation
     */
    @Override
    public String toString() {
        return asString(0);
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
        if (!(o instanceof AbstractHiddenOperation)) {
            return false;
        }
        AbstractHiddenOperation that = (AbstractHiddenOperation) o;
        return Objects.equals(leftChildren, that.leftChildren)
            && Objects.equals(rightChildren, that.rightChildren)
            && Objects.equals(this.calculate(), that.calculate());
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
        return Objects.hash(leftChildren, rightChildren, this.calculate());
    }

    /**
     * Returns the {@code String} representation of the current {@code HiddenAST}.
     *
     * @param space number of spaces to ident
     * @return the current {@code HiddenAST} as {@code String}
     */
    @Override
    public final String asString(int space) {
        String tab = " ".repeat(space);
        if (!isTransformation()) {
            return tab + operatorName + "(\n"
                + leftChildren.asString(space + 2) + rightValueAsString(space) + '\n'
                + tab + ')';
        } else {
            return leftChildren.asString(space) + '.' + operatorName + "()";
        }
    }

    /**
     * Right value as {@code String}.
     * To use template pattern in {@code asString}.
     *
     * @param space number of space
     * @return right value as {@code String}
     */
    protected String rightValueAsString(int space) {
        return ' ' + operatorSymbol + '\n'
            + rightChildren.asString(space + 2) ;
    }

    /**
     * Returns true if the operation is a transformation, false otherwise.
     * To use template pattern in {@code asString}.
     *
     * @return true if the operation is a transformation, false otherwise.
     */
    protected boolean isTransformation() {
        return false;  // Usually is false
    }

    /**
     * Calculate the {@code HType} result of performing all operations
     *
     * @return {@code HType} result of operations.
     */
    @Override
    public final HType calculate() {
        HType leftCalculated = leftChildren.calculate();
        HType rightCalculated = rightChildren.calculate();
        return mainOperation(leftCalculated, rightCalculated);
    }

    /**
     * Compute the operation between 2 {@code HType} and returns its operation. To use template
     * pattern in {@code calculate}.
     *
     * @param value1 the value at the left
     * @param value2 the value at the right
     * @return the value computed
     */
    protected abstract HType mainOperation(HType value1, HType value2);
}
