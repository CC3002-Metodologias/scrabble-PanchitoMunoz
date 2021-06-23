package cl.uchile.dcc.scrabble.model.ast.operations.abstract_operations;

import cl.uchile.dcc.scrabble.model.ast.hidden_ast.interfaces.HiddenAST;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.interfaces.HiddenOperation;
import cl.uchile.dcc.scrabble.model.ast.interfaces.Operation;
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
     * Get the left children of the adaptee.
     *
     * @return a hidden AST
     */
    protected HiddenAST getLeftChildren() {
        return adaptee.getLeftChildren();
    }

    /**
     * Get the right children of the adaptee.
     *
     * @return a hidden AST
     */
    protected HiddenAST getRightChildren() {
        return adaptee.getRightChildren();
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
        return null;
//        return adaptee.toHiddenBinary();
    }

    /**
     * Transform the current instance into a {@code TypeBool}.
     *
     * @return a {@code TypeBool}
     */
    @Override
    public Operation toTypeBool() {
        return null;
//        return adaptee.toHiddenBool().toSType();
    }

    /**
     * Transform the current instance into a {@code TypeFloat}.
     *
     * @return a {@code TypeFloat}
     */
    @Override
    public Operation toTypeFloat() {
        return null;
//        return adaptee.toHiddenFloat().toSType();
    }

    /**
     * Transform the current instance into a {@code TypeInt}.
     *
     * @return a {@code TypeInt}
     */
    @Override
    public Operation toTypeInt() {
        return null;
//        return adaptee.toHiddenInt().toSType();
    }

    /**
     * Transform the current instance into a {@code TypeString}.
     *
     * @return a {@code TypeString}
     */
    @Override
    public Operation toTypeString() {
        return null;
//        return adaptee.toHiddenString().toSType();
    }
}
