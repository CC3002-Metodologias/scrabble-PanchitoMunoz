package cl.uchile.dcc.scrabble.model.ast.operations.abstract_operations;

import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.HiddenOperator;

/**
 * An abstract class for generics binary operators
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/08/05 11:55
 */
public abstract class AbstractBinaryOperator extends AbstractOperation {

    /**
     * Constructor by default.
     *
     * @param adaptee a HiddenOperator to adapt
     */
    protected AbstractBinaryOperator(
        HiddenOperator adaptee) {
        super(adaptee);
    }
}
