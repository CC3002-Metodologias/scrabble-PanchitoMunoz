package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_visitors;

import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_control_flow.HiddenFor;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_control_flow.HiddenIf;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_control_flow.HiddenIfElse;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_control_flow.HiddenWhile;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_executables.HiddenListOfInstructions;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.HiddenOperator;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.binary_operators.HiddenAdd;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.binary_operators.HiddenAnd;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.binary_operators.HiddenBinaryOperator;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.binary_operators.HiddenDiv;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.binary_operators.HiddenMult;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.binary_operators.HiddenOr;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.binary_operators.HiddenSub;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.unary_operators.HiddenNeg;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.unary_operators.HiddenUnaryOperator;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.unary_operators.ToHiddenBinary;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.unary_operators.ToHiddenBool;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.unary_operators.ToHiddenFloat;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.unary_operators.ToHiddenInt;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.unary_operators.ToHiddenString;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_relational_operator.HiddenEquals;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_relational_operator.HiddenGreaterEquals;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_relational_operator.HiddenGreaterThan;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_relational_operator.HiddenLowerEquals;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_relational_operator.HiddenLowerThan;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_relational_operator.HiddenNotEquals;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HType;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HiddenBinary;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HiddenBool;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HiddenFloat;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HiddenInt;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HiddenNull;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HiddenString;
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
     * Visit a {@code HiddenInt}.
     *
     * @param hiddenInt an generic {@code HiddenInt}
     */
    default void visitHiddenInt(HiddenInt hiddenInt) {
        this.visitHType(hiddenInt);
    }

    /**
     * Visit a {@code HiddenBinary}.
     *
     * @param hiddenBinary an generic {@code HiddenBinary}
     */
    default void visitHiddenBinary(HiddenBinary hiddenBinary) {
        this.visitHType(hiddenBinary);
    }

    /**
     * Visit a {@code HiddenNull}.
     *
     * @param hiddenNull an generic {@code HiddenNull}
     */
    default void visitHiddenNull(HiddenNull hiddenNull) {
        this.visitHType(hiddenNull);
    }

    /**
     * Visit a {@code HiddenFloat}.
     *
     * @param hiddenFloat an generic {@code HiddenFloat}
     */
    default void visitHiddenFloat(HiddenFloat hiddenFloat) {
        this.visitHType(hiddenFloat);
    }

    /**
     * Visit a {@code HiddenBool}.
     *
     * @param hiddenBool an generic {@code HiddenBool}
     */
    default void visitHiddenBool(HiddenBool hiddenBool) {
        this.visitHType(hiddenBool);
    }

    /**
     * Visit a {@code HiddenString}.
     *
     * @param hiddenString an generic {@code HiddenString}
     */
    default void visitHiddenString(HiddenString hiddenString) {
        this.visitHType(hiddenString);
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
     * Visit a {@code ToHiddenFloat}.
     *
     * @param toHiddenFloat an generic {@code ToHiddenFloat}
     */
    default void visitToHiddenFloat(ToHiddenFloat toHiddenFloat) {
        this.visitHiddenUnaryOperator(toHiddenFloat);
    }

    /**
     * Visit a {@code ToHiddenBinary}.
     *
     * @param toHiddenBinary an generic {@code ToHiddenBinary}
     */
    default void visitToHiddenBinary(ToHiddenBinary toHiddenBinary) {
        this.visitHiddenUnaryOperator(toHiddenBinary);
    }

    /**
     * Visit a {@code ToHiddenString}.
     *
     * @param toHiddenString an generic {@code ToHiddenString}
     */
    default void visitToHiddenString(ToHiddenString toHiddenString) {
        this.visitHiddenUnaryOperator(toHiddenString);
    }

    /**
     * Visit a {@code ToHiddenBool}.
     *
     * @param toHiddenBool an generic {@code ToHiddenBool}
     */
    default void visitToHiddenBool(ToHiddenBool toHiddenBool) {
        this.visitHiddenUnaryOperator(toHiddenBool);
    }

    /**
     * Visit a {@code ToHiddenInt}.
     *
     * @param toHiddenInt an generic {@code ToHiddenInt}
     */
    default void visitToHiddenInt(ToHiddenInt toHiddenInt) {
        this.visitHiddenUnaryOperator(toHiddenInt);
    }

    /**
     * Visit a {@code HiddenNeg}.
     *
     * @param hiddenNeg an generic {@code HiddenNeg}
     */
    default void visitHiddenNeg(HiddenNeg hiddenNeg) {
        this.visitHiddenUnaryOperator(hiddenNeg);
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
     * Visit a {@code HiddenMult}.
     *
     * @param hiddenMult an generic {@code HiddenMult}
     */
    default void visitHiddenMult(HiddenMult hiddenMult) {
        this.visitHiddenBinaryOperator(hiddenMult);
    }

    /**
     * Visit a {@code HiddenSub}.
     *
     * @param hiddenSub an generic {@code HiddenSub}
     */
    default void visitHiddenSub(HiddenSub hiddenSub) {
        this.visitHiddenBinaryOperator(hiddenSub);
    }

    /**
     * Visit a {@code HiddenAdd}.
     *
     * @param hiddenAdd an generic {@code HiddenAdd}
     */
    default void visitHiddenAdd(HiddenAdd hiddenAdd) {
        this.visitHiddenBinaryOperator(hiddenAdd);
    }

    /**
     * Visit a {@code HiddenOr}.
     *
     * @param hiddenOr an generic {@code HiddenOr}
     */
    default void visitHiddenOr(HiddenOr hiddenOr) {
        this.visitHiddenBinaryOperator(hiddenOr);
    }

    /**
     * Visit a {@code HiddenDiv}.
     *
     * @param hiddenDiv an generic {@code HiddenDiv}
     */
    default void visitHiddenDiv(HiddenDiv hiddenDiv) {
        this.visitHiddenBinaryOperator(hiddenDiv);
    }

    /**
     * Visit a {@code HiddenAnd}.
     *
     * @param hiddenAnd an generic {@code HiddenAnd}
     */
    default void visitHiddenAnd(HiddenAnd hiddenAnd) {
        this.visitHiddenBinaryOperator(hiddenAnd);
    }

    /**
     * Visit a {@code HiddenNotEquals}.
     *
     * @param hiddenNotEquals an generic {@code HiddenNotEquals}
     */
    default void visitHiddenNotEquals(HiddenNotEquals hiddenNotEquals) {
        this.visitHiddenBinaryOperator(hiddenNotEquals);
    }

    /**
     * Visit a {@code HiddenEquals}.
     *
     * @param hiddenEquals an generic {@code HiddenEquals}
     */
    default void visitHiddenEquals(HiddenEquals hiddenEquals) {
        this.visitHiddenBinaryOperator(hiddenEquals);
    }

    /**
     * Visit a {@code HiddenGreaterEquals}.
     *
     * @param hiddenGreaterEquals an generic {@code HiddenGreaterEquals}
     */
    default void visitHiddenGreaterEquals(HiddenGreaterEquals hiddenGreaterEquals) {
        this.visitHiddenBinaryOperator(hiddenGreaterEquals);
    }

    /**
     * Visit a {@code HiddenGreaterThan}.
     *
     * @param hiddenGreaterThan an generic {@code HiddenGreaterThan}
     */
    default void visitHiddenGreaterThan(HiddenGreaterThan hiddenGreaterThan) {
        this.visitHiddenBinaryOperator(hiddenGreaterThan);
    }

    /**
     * Visit a {@code HiddenLowerEquals}.
     *
     * @param hiddenLowerEquals an generic {@code HiddenLowerEquals}
     */
    default void visitHiddenLowerEquals(HiddenLowerEquals hiddenLowerEquals) {
        this.visitHiddenBinaryOperator(hiddenLowerEquals);
    }

    /**
     * Visit a {@code HiddenLowerThan}.
     *
     * @param hiddenLowerThan an generic {@code HiddenLowerThan}
     */
    default void visitHiddenLowerThan(HiddenLowerThan hiddenLowerThan) {
        this.visitHiddenBinaryOperator(hiddenLowerThan);
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
     * Visit a {@code HiddenFor}.
     *
     * @param hiddenFor an generic {@code HiddenFor}
     */
    default void visitHiddenFor(HiddenFor hiddenFor) {
    }

    /**
     * Visit a {@code HiddenListOfInstructions}.
     *
     * @param hiddenListOfInstructions an generic {@code HiddenListOfInstructions}
     */
    default void visitHiddenListOfInstructions(HiddenListOfInstructions hiddenListOfInstructions) {
    }
}
