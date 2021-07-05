package cl.uchile.dcc.scrabble.model.hidden_ast.hidden_operations.transformations;

import cl.uchile.dcc.scrabble.model.hidden_ast.hidden_operations.abstract_classes.AbstractHiddenTransformation;
import cl.uchile.dcc.scrabble.model.hidden_ast.hidden_types.HType;
import cl.uchile.dcc.scrabble.model.hidden_ast.HiddenAST;
import cl.uchile.dcc.scrabble.model.ast.operations.transformations.ToTypeString;

/**
 * A class to add a node in the {@code HiddenAST}. It is equivalent to compute the {@code toHiddenString} method. This class will be adapted by the {@code ToTypeString} class.
 *
 * @see ToTypeString
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/22 23:32
 */
public class ToHiddenString extends AbstractHiddenTransformation {

    /**
     * Constructor with one parameter. It can receive an {@code HiddenOperation} or a {@code HType}.
     *
     * @param value a value. It can receive an {@code HiddenOperation} or a {@code HType}.
     */
    public ToHiddenString(HiddenAST value) {
        super(value, "toTypeString");
    }

    /**
     * Compute the unary operation. To use template pattern in {@code mainOperation}.
     *
     * @param value a value
     * @return the value computed
     */
    @Override
    protected HType mainUnaryOperation(HType value) {
        return value.toHiddenString();
    }
}
