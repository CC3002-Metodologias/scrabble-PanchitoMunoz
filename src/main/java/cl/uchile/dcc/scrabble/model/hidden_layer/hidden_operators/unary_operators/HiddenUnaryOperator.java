package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.unary_operators;

import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.HiddenOperator;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_visitors.HiddenVisitor;

/**
 * An interface to represent an unary operation
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/07/31 13:44
 */
public interface HiddenUnaryOperator extends HiddenOperator {

    /**
     * Method that accepts a {@code HiddenVisitor}.
     *
     * @param visitor a {@code HiddenVisitor}.
     */
    @Override
    default void accept(HiddenVisitor visitor) {
        visitor.visitHiddenUnaryOperator(this);
    }

    /**
     * Creates and returns a copy of this object.
     *
     * @return a clone of this instance.
     */
    @Override
    HiddenUnaryOperator copy();
}
