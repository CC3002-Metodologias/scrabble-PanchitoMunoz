package cl.uchile.dcc.scrabble.model.ast.operations.abstract_operations;

import cl.uchile.dcc.scrabble.model.ast.operations.Operation;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.HiddenOperator;

/**
 * An abstract class for a general transformation in {@code Operations}.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/27 11:55
 * @see Operation
 */
public abstract class AbstractTransformation extends AbstractOperation {

    /**
     * Constructor by default.
     *
     * @param adaptee a HiddenOperator to adapt
     */
    protected AbstractTransformation(
        HiddenOperator adaptee) {
        super(adaptee);
    }
}
