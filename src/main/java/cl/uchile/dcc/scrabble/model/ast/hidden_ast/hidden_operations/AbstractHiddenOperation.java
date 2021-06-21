package cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_operations;

import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HiddenBinary;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.interfaces.HiddenAST;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.interfaces.HiddenOperation;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HType;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HiddenBool;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HiddenFloat;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HiddenInt;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HiddenString;

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
     * Default constructor. It can receive an {@code HiddenOperation} or a {@code HType}.
     *
     * @param leftValue  left value, it can be an {@code HiddenOperation} or a {@code HType}.
     * @param rightValue right value, it can be an {@code HiddenOperation} or a {@code HType}.
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
    public HType calculate() {
        HType leftCalculated = leftChildren.calculate();
        HType rightCalculated = rightChildren.calculate();
        return mainOperation(leftCalculated, rightCalculated);
    }

    /**
     * Compute the operation between 2 {@code HType} and returns its operation. To use template
     * pattern.
     *
     * @param value1 the value at the left
     * @param value2 the value at the right
     * @return the value computed
     */
    protected abstract HType mainOperation(HType value1, HType value2);

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
     * Transform the current instance into a {@code HiddenBinary}.
     *
     * @return a {@code HiddenBinary}
     */
    @Override
    public HiddenBinary toWrappedBinary() {
        return this.calculate().toWrappedBinary();
    }

    /**
     * Transform the current instance into a {@code HiddenBool}.
     *
     * @return a {@code HiddenBool}
     */
    @Override
    public HiddenBool toWrappedBool() {
        return this.calculate().toWrappedBool();
    }

    /**
     * Transform the current instance into a {@code HiddenFloat}.
     *
     * @return a {@code HiddenFloat}
     */
    @Override
    public HiddenFloat toWrappedFloat() {
        return this.calculate().toWrappedFloat();
    }

    /**
     * Transform the current instance into a {@code HiddenInt}.
     *
     * @return a {@code HiddenInt}
     */
    @Override
    public HiddenInt toWrappedInt() {
        return this.calculate().toWrappedInt();
    }

    /**
     * Transform the current instance into a {@code HiddenString}.
     *
     * @return a {@code HiddenString}
     */
    @Override
    public HiddenString toWrappedString() {
        return this.calculate().toWrappedString();
    }
}
