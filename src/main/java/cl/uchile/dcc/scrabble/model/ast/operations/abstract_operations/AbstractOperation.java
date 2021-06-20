package cl.uchile.dcc.scrabble.model.ast.operations.abstract_operations;

import cl.uchile.dcc.scrabble.model.ast.interfaces.AST;
import cl.uchile.dcc.scrabble.model.ast.interfaces.HiddenAST;
import cl.uchile.dcc.scrabble.model.ast.operations.Operation;
import cl.uchile.dcc.scrabble.model.ast.wrapped_types.WType;
import cl.uchile.dcc.scrabble.model.types.TypeBinary;
import cl.uchile.dcc.scrabble.model.types.TypeBool;
import cl.uchile.dcc.scrabble.model.types.TypeFloat;
import cl.uchile.dcc.scrabble.model.types.TypeInt;
import cl.uchile.dcc.scrabble.model.types.TypeString;
import cl.uchile.dcc.scrabble.model.types.interface_types.SType;

/**
 * Abstract class for a general {@code Operation}.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/14 9:52 TODO: agregar el resto de hijos que podrían verse afectadas por esta
 * clase
 */
public abstract class AbstractOperation implements Operation {

    private final HiddenAST leftChildren;
    private final HiddenAST rightChildren;

    /**
     * Default constructor. It can receive an {@code Operation} or a {@code WType}.
     *
     * @param leftValue  left value, it can be an {@code Operation} or a {@code WType}.
     * @param rightValue right value, it can be an {@code Operation} or a {@code WType}.
     */
    protected AbstractOperation(HiddenAST leftValue, HiddenAST rightValue) {
        leftChildren = leftValue;
        rightChildren = rightValue;
    }

    /**
     * Constructor. It can receive an {@code Operation} or a {@code SType}.
     *
     * @param leftValue  left value, it can be an {@code Operation} or a {@code SType}.
     * @param rightValue right value, it can be an {@code Operation} or a {@code SType}.
     */
    public AbstractOperation(AST leftValue, AST rightValue) {
        this(leftValue.toHiddenAST(), rightValue.toHiddenAST());
    }

    /**
     * Transform a {@code SType} into its equivalent {@code WType}. If the argument is a {@code
     * WType} or an {@code HiddenAST}, it does nothing.
     *
     * @return a transformation
     */
    @Override
    public HiddenAST toHiddenAST() {
        return this;
    }

    /**
     * Calculate the {@code SType} result of performing all operations
     *
     * @return SType result of operations.
     */
    @Override
    public SType calculate() {
        WType leftCalculated = (WType) leftChildren.calculate().toHiddenAST();
        WType rightCalculated = (WType) rightChildren.calculate().toHiddenAST();

        return mainOperation(leftCalculated, rightCalculated);
    }

    protected HiddenAST getLeftChildren() {
        return leftChildren;
    }

    protected HiddenAST getRightChildren() {
        return rightChildren;
    }

    /**
     * Compute the operation between 2 {@code WType} and returns its operation.
     *
     * @param value1 the value at the left
     * @param value2 the value at the right
     * @return the value computed
     */
    protected abstract SType mainOperation(WType value1, WType value2);

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
     * Computes the final value as {@code WType}.
     *
     * @return the calculated value as {@code WType}
     */
    private WType calculateAsWrapped() {
        SType computedValue = this.calculate();
        return (WType) computedValue.toHiddenAST();
    }

    /**
     * Transform the current instance into a {@code TypeBinary}.
     *
     * @return a {@code TypeBinary}
     */
    @Override
    public TypeBinary toTypeBinary() {
        return (TypeBinary) this.calculateAsWrapped().toWrappedBinary().getAdaptee();
    }

    /**
     * Transform the current instance into a {@code TypeBool}.
     *
     * @return a {@code TypeBool}
     */
    @Override
    public TypeBool toTypeBool() {
        return (TypeBool) calculateAsWrapped().toWrappedBool().getAdaptee();
    }

    /**
     * Transform the current instance into a {@code TypeFloat}.
     *
     * @return a {@code TypeFloat}
     */
    @Override
    public TypeFloat toTypeFloat() {
        return (TypeFloat) calculateAsWrapped().toWrappedFloat().getAdaptee();
    }

    /**
     * Transform the current instance into a {@code TypeInt}.
     *
     * @return a {@code TypeInt}
     */
    @Override
    public TypeInt toTypeInt() {
        return (TypeInt) calculateAsWrapped().toWrappedInt().getAdaptee();
    }

    /**
     * Transform the current instance into a {@code TypeString}.
     *
     * @return a {@code TypeString}
     */
    @Override
    public TypeString toTypeString() {
        return (TypeString) calculateAsWrapped().toWrappedString().getAdaptee();
    }
}
