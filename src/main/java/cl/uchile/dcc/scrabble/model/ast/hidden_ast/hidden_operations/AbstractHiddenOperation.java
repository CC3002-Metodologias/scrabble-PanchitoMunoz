package cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_operations;

import cl.uchile.dcc.scrabble.model.ast.hidden_ast.interfaces.HiddenAST;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.interfaces.HiddenOperation;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.wrapped_types.WType;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.wrapped_types.WrappedBinary;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.wrapped_types.WrappedBool;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.wrapped_types.WrappedFloat;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.wrapped_types.WrappedInt;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.wrapped_types.WrappedString;

/**
 * todo: documentar
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/21 17:16
 */
public abstract class AbstractHiddenOperation implements HiddenOperation {

    private final HiddenAST leftChildren;
    private final HiddenAST rightChildren;

    /**
     * Default constructor. It can receive an {@code HiddenOperation} or a {@code WType}.
     *
     * @param leftValue  left value, it can be an {@code HiddenOperation} or a {@code WType}.
     * @param rightValue right value, it can be an {@code HiddenOperation} or a {@code WType}.
     */
    public AbstractHiddenOperation(HiddenAST leftValue, HiddenAST rightValue) {
        leftChildren = leftValue;
        rightChildren = rightValue;
    }

    /**
     * Calculate the {@code SType} result of performing all operations
     *
     * @return SType result of operations.
     */
    @Override
    public WType calculate() {
        WType leftCalculated = leftChildren.calculate();
        WType rightCalculated = rightChildren.calculate();
        return mainOperation(leftCalculated, rightCalculated);
    }

    /**
     * Compute the operation between 2 {@code WType} and returns its operation. To use template
     * pattern.
     *
     * @param value1 the value at the left
     * @param value2 the value at the right
     * @return the value computed
     */
    protected abstract WType mainOperation(WType value1, WType value2);

    /**
     * Get the left children.
     *
     * @return an HiddenAST
     */
    @Override
    public HiddenAST getLeftChildren() {
        return leftChildren;
    }

    /**
     * Get the right children.
     *
     * @return an HiddenAST
     */
    @Override
    public HiddenAST getRightChildren() {
        return rightChildren;
    }

    /**
     * Generalize the {@code asString} method, in order to only modify the operator symbol and the
     * class name.
     *
     * @param space          number of spaces to ident
     * @param operatorSymbol an operator symbol. E.g.: "+", "-"...
     * @param name           the name of the class. E.g.: "Add", "Sub"
     * @return the string representation.
     */
    protected String asString(int space, String operatorSymbol, String name) {
        String tab = " ".repeat(space);
        return tab + name + "(\n"
            + leftChildren.asString(space + 2) + ' ' + operatorSymbol + '\n'
            + rightChildren.asString(space + 2) + '\n'
            + tab + ')';
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
     * Transform the current instance into a {@code WrappedBinary}.
     *
     * @return a {@code WrappedBinary}
     */
    @Override
    public WrappedBinary toWrappedBinary() {
        return this.calculate().toWrappedBinary();
    }

    /**
     * Transform the current instance into a {@code WrappedBool}.
     *
     * @return a {@code WrappedBool}
     */
    @Override
    public WrappedBool toWrappedBool() {
        return this.calculate().toWrappedBool();
    }

    /**
     * Transform the current instance into a {@code WrappedFloat}.
     *
     * @return a {@code WrappedFloat}
     */
    @Override
    public WrappedFloat toWrappedFloat() {
        return this.calculate().toWrappedFloat();
    }

    /**
     * Transform the current instance into a {@code WrappedInt}.
     *
     * @return a {@code WrappedInt}
     */
    @Override
    public WrappedInt toWrappedInt() {
        return this.calculate().toWrappedInt();
    }

    /**
     * Transform the current instance into a {@code WrappedString}.
     *
     * @return a {@code WrappedString}
     */
    @Override
    public WrappedString toWrappedString() {
        return this.calculate().toWrappedString();
    }
}
