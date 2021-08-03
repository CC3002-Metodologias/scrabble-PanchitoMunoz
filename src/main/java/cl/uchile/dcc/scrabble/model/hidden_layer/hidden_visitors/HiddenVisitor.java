package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_visitors;

import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_control_flow.HiddenIf;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_control_flow.HiddenIfElse;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_control_flow.HiddenWhile;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_executables.HiddenListOfInstructions;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.HiddenOperator;
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
     * Visit a {@code HiddenOperator}.
     *
     * @param hiddenOperator an generic {@code HiddenOperator}
     */
    default void visitHiddenOperator(HiddenOperator hiddenOperator) {
    }

    /**
     * Visit a {@code HiddenUnaryOperator}.
     *
     * @param hiddenUnaryOperator an generic {@code HiddenUnaryOperator}
     */
    default void visitHiddenUnaryOperator(HiddenUnaryOperator hiddenUnaryOperator) {
        this.visitHiddenOperator(hiddenUnaryOperator);
    }

    /**
     * Visit a {@code HiddenBinaryOperator}.
     *
     * @param hiddenBinaryOperator an generic {@code HiddenBinaryOperator}
     */
    default void visitHiddenBinaryOperator(HiddenBinaryOperator hiddenBinaryOperator) {
        this.visitHiddenOperator(hiddenBinaryOperator);
    }

    /**
     * Visit a {@code HiddenIf}.
     *
     * @param hiddenIf an generic {@code HiddenIf}
     */
    default void visitHiddenIf(HiddenIf hiddenIf) {
    }

    /**
     * Visit a {@code HiddenIfElse}.
     *
     * @param hiddenIfElse an generic {@code HiddenIfElse}
     */
    default void visitHiddenIfElse(HiddenIfElse hiddenIfElse) {
    }

    /**
     * Visit a {@code HiddenWhile}.
     *
     * @param hiddenWhile an generic {@code HiddenWhile}
     */
    default void visitHiddenWhile(HiddenWhile hiddenWhile) {
    }

    /**
     * Visit a {@code HiddenListOfInstructions}.
     *
     * @param hiddenListOfInstructions an generic {@code HiddenListOfInstructions}
     */
    default void visitHiddenListOfInstructions(HiddenListOfInstructions hiddenListOfInstructions) {
    }
}
