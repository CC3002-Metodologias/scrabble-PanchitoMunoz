package cl.uchile.dcc.scrabble.model.ast.operations.abstract_operations;

import cl.uchile.dcc.scrabble.model.ast.AST;
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

    private final AST leftChildren;
    private final AST rightChildren;

    /**
     * Default constructor. It can receive an {@code Operation} or a {@code WType}.
     *
     * @param leftValue  left value, it can be an {@code Operation} or a {@code WType}.
     * @param rightValue right value, it can be an {@code Operation} or a {@code WType}.
     */
    protected AbstractOperation(AST leftValue, AST rightValue) {
        leftChildren = leftValue;
        rightChildren = rightValue;
    }

    /**
     * Transform a {@code SType} into its equivalent {@code WType}. If the argument is a {@code
     * WType} or an {@code AST}, it does nothing.
     *
     * @return a transformation
     */
    @Override
    public AST toAST() {
        return this;
    }

    /**
     * Calculate the {@code SType} result of performing all operations
     *
     * @return SType result of operations.
     */
    @Override
    public SType calculate() {
        WType leftCalculated = (WType) leftChildren.calculate().toAST();
        WType rightCalculated = (WType) rightChildren.calculate().toAST();

        return mainOperation(leftCalculated, rightCalculated);
    }

    protected AST getLeftChildren() {
        return leftChildren;
    }

    protected AST getRightChildren() {
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
        int nTab = 2;
        return tab + name + "(\n"
            + leftChildren.asString(space + nTab) + '\n'
//            + operatorSymbol + '\n'
            + tab + " ".repeat(nTab) + operatorSymbol + rightChildren.asString(1) + '\n'
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
        return (WType) computedValue.toAST();
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
