package cl.uchile.dcc.scrabble.model.ast.operations.abstract_operations;

import cl.uchile.dcc.scrabble.model.ast.hidden_ast.interfaces.HiddenAST;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.interfaces.HiddenOperation;
import cl.uchile.dcc.scrabble.model.ast.interfaces.Operation;
import cl.uchile.dcc.scrabble.model.ast.operations.transformations.ToTypeBinary;
import cl.uchile.dcc.scrabble.model.ast.operations.transformations.ToTypeBool;
import cl.uchile.dcc.scrabble.model.ast.operations.transformations.ToTypeFloat;
import cl.uchile.dcc.scrabble.model.ast.operations.transformations.ToTypeInt;
import cl.uchile.dcc.scrabble.model.ast.operations.transformations.ToTypeString;
import cl.uchile.dcc.scrabble.model.types.interface_types.SType;

/**
 * Abstract class for a general {@code Operation}.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/14 9:52 TODO: agregar el resto de hijos que podrían verse afectadas por esta
 * clase
 */
public abstract class AbstractOperation implements Operation {

    private final HiddenOperation adaptee;

    /**
     * Constructor by default.
     *
     * @param adaptee a HiddenOperation to adapt
     */
    protected AbstractOperation(HiddenOperation adaptee) {
        this.adaptee = adaptee;
    }

    /**
     * Transform a {@code SType} into its equivalent {@code HType}. If the
     * argument is a {@code HType} or an {@code HiddenAST}, it does nothing.
     *
     * @return a transformation
     */
    @Override
    public HiddenAST toHiddenAST() {
        return adaptee;
    }

    /**
     * Calculate the {@code SType} result of performing all operations
     *
     * @return SType result of operations.
     */
    @Override
    public SType calculate() {
        return adaptee.calculate().toSType();
    }

    /**
     * A String representation of the current instance.
     *
     * @return a string representation
     */
    @Override
    public String toString() {
        return adaptee.asString(0);
    }

    /**
     * Transform the current instance into a {@code TypeBinary}.
     *
     * @return a {@code TypeBinary}
     */
    @Override
    public Operation toTypeBinary() {
        return new ToTypeBinary(this);
    }

    /**
     * Transform the current instance into a {@code TypeBool}.
     *
     * @return a {@code TypeBool}
     */
    @Override
    public Operation toTypeBool() {
        return new ToTypeBool(this);
    }

    /**
     * Transform the current instance into a {@code TypeFloat}.
     *
     * @return a {@code TypeFloat}
     */
    @Override
    public Operation toTypeFloat() {
        return new ToTypeFloat(this);
    }

    /**
     * Transform the current instance into a {@code TypeInt}.
     *
     * @return a {@code TypeInt}
     */
    @Override
    public Operation toTypeInt() {
        return new ToTypeInt(this);
    }

    /**
     * Transform the current instance into a {@code TypeString}.
     *
     * @return a {@code TypeString}
     */
    @Override
    public Operation toTypeString() {
        return new ToTypeString(this);
    }
}
