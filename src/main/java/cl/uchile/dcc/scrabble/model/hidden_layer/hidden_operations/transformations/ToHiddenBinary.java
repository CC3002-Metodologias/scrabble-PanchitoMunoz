package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operations.transformations;

import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operations.abstract_classes.AbstractHiddenTransformation;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HType;
import cl.uchile.dcc.scrabble.model.hidden_layer.HiddenAST;
import cl.uchile.dcc.scrabble.model.ast.operations.transformations.ToTypeBinary;

/**
 * A class to add a node in the {@code HiddenAST}. It is equivalent to compute the {@code toHiddenBinary} method. This class will be adapted by the {@code ToTypeBinar} class.
 *
 * @see ToTypeBinary
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/22 23:18
 */
public class ToHiddenBinary extends AbstractHiddenTransformation {

    /**
     * Constructor with one parameter. It can receive an {@code HiddenOperation} or a {@code HType}.
     *
     * @param value a value. It can receive an {@code HiddenOperation} or a {@code HType}.
     */
    public ToHiddenBinary(HiddenAST value) {
        super(value, "toTypeBinary");
    }

    /**
     * Compute the unary operation. To use template pattern in {@code mainOperation}.
     *
     * @param value a value
     * @return the value computed
     */
    @Override
    protected HType mainUnaryOperation(HType value) {
        return value.toHiddenBinary();
    }
}
