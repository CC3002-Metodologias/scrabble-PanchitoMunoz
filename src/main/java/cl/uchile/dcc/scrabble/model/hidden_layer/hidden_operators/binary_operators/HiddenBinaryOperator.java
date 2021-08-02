package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.binary_operators;

import cl.uchile.dcc.scrabble.model.hidden_layer.HiddenASTComponent;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.HiddenOperator;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_visitors.HiddenVisitor;

/**
 * An interface for generics binaries operators.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/07/31 13:46
 */
public interface HiddenBinaryOperator extends HiddenOperator {

    /**
     * Method that accepts a {@code HiddenVisitor}.
     *
     * @param visitor a {@code HiddenVisitor}.
     */
    @Override
    default void accept(HiddenVisitor visitor) {
        visitor.visitHiddenBinaryOperator(this);
    }

    HiddenASTComponent getSecondChildren();
}
