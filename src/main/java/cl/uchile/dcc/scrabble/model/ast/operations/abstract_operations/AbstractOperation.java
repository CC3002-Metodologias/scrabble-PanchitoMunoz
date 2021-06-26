package cl.uchile.dcc.scrabble.model.ast.operations.abstract_operations;

import cl.uchile.dcc.scrabble.model.ast.hidden_ast.HiddenAST;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_operations.HiddenOperation;
import cl.uchile.dcc.scrabble.model.ast.operations.Operation;
import cl.uchile.dcc.scrabble.model.types.interface_types.SType;

// TODO: Crear métodos equals y hashCode
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

    // TODO: Actualizar doc
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
        return adaptee.toString();
    }

}
