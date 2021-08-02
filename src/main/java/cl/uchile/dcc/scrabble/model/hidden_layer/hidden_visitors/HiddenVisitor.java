package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_visitors;

import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.binary_operators.HiddenBinaryOperator;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.unary_operators.HiddenUnaryOperator;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HType;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_variable.HiddenVariable;

/**
 * An interface for generics visitors in the hidden layer.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/07/31 13:40
 */
public interface HiddenVisitor {

    /**
     * Visit a {@code HType}.
     *
     * @param hType an generic {@code HType}
     */
    default void visitHType(HType hType) {
    }

    /**
     * Visit a {@code HiddenVariable}.
     *
     * @param hiddenVariable an generic {@code HiddenVariable}
     */
    default void visitHiddenVariable(HiddenVariable hiddenVariable) {
    }

    /**
     * Visit a {@code HiddenUnaryOperator}.
     *
     * @param hiddenUnaryOperator an generic {@code HiddenUnaryOperator}
     */
    default void visitHiddenUnaryOperator(HiddenUnaryOperator hiddenUnaryOperator) {
    }

    /**
     * Visit a {@code hiddenBinaryOperator}.
     *
     * @param hiddenBinaryOperator an generic {@code hiddenBinaryOperator}
     */
    default void visitHiddenBinaryOperator(HiddenBinaryOperator hiddenBinaryOperator) {
    }

}
