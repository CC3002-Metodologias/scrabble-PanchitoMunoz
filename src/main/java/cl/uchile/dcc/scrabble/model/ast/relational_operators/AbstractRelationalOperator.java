package cl.uchile.dcc.scrabble.model.ast.relational_operators;

import cl.uchile.dcc.scrabble.model.ast.operations.abstract_operations.AbstractBinaryOperator;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.HiddenOperator;

/**
 * An abstract class for generics relational operators.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/08/05 11:54
 */
public abstract class AbstractRelationalOperator
    extends AbstractBinaryOperator
    implements RelationalOperator {

    /**
     * Constructor by default.
     *
     * @param adaptee a HiddenOperator to adapt
     */
    protected AbstractRelationalOperator(
        HiddenOperator adaptee) {
        super(adaptee);
    }
}
