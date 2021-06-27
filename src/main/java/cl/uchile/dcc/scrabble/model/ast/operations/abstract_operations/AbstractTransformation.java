package cl.uchile.dcc.scrabble.model.ast.operations.abstract_operations;

import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_operations.HiddenOperation;
import cl.uchile.dcc.scrabble.model.ast.operations.Operation;

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
     * @param adaptee a HiddenOperation to adapt
     */
    protected AbstractTransformation(
        HiddenOperation adaptee) {
        super(adaptee);
    }
}
