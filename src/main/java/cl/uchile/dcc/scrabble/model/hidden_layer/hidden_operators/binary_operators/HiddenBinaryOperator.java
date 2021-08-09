package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.binary_operators;

import cl.uchile.dcc.scrabble.model.hidden_layer.HiddenASTComponent;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.HiddenOperator;

/**
 * An interface for generics binaries operators.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/07/31 13:46
 */
public interface HiddenBinaryOperator extends HiddenOperator {

    /**
     * Creates and returns a copy of this object.
     *
     * @return a clone of this instance.
     */
    @Override
    HiddenBinaryOperator copy();

    /**
     * Returns the second child.
     *
     * @return the second child
     */
    HiddenASTComponent getSecondChildren();
}
