package cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.operations;

import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HType;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HiddenBinary;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HiddenBool;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HiddenFloat;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HiddenInt;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HiddenString;

/**
 * Interface for arithmetical operations in {@code HType}.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/26 22:26
 */
public interface HArithmeticOperations {

    /**
     * Returns the sum
     *
     * @param hType other type to sum
     * @return the sum
     */
    default HType add(HType hType) {
        return null;
    }

    /**
     * To use double dispatch in {@code add}
     */
    HType addWithString(HiddenString wString);

    /**
     * To use double dispatch in {@code add}
     */
    default HType addWithBool(HiddenBool wBool) {
        return null;
    }

    /**
     * To use double dispatch in {@code add}
     */
    default HType addWithBinary(HiddenBinary wBinary) {
        return null;
    }

    /**
     * To use double dispatch in {@code add}
     */
    default HType addWithFloat(HiddenFloat wFloat) {
        return null;
    }

    /**
     * To use double dispatch in {@code add}
     */
    default HType addWithInt(HiddenInt wInt) {
        return null;
    }

    /**
     * Returns the division between numbers
     *
     * @param hType another number
     * @return the division
     */
    default HType div(HType hType) {
        return null;
    }

    /**
     * To use double dispatch in {@code div}
     */
    default HType divWithString(HiddenString wrappedString) {
        return null;
    }

    /**
     * To use double dispatch in {@code div}
     */
    default HType divWithBool(HiddenBool wrappedBool) {
        return null;
    }

    /**
     * To use double dispatch in {@code div}
     */
    default HType divWithBinary(HiddenBinary wBinary) {
        return null;
    }

    /**
     * To use double dispatch in {@code div}
     */
    default HType divWithFloat(HiddenFloat wFloat) {
        return null;
    }

    /**
     * To use double dispatch in {@code div}
     */
    default HType divWithInt(HiddenInt wInt) {
        return null;
    }

    /**
     * Returns the multiplication between numbers
     *
     * @param hType another number
     * @return the multiplication
     */
    default HType mult(HType hType) {
        return null;
    }

    /**
     * To use double dispatch in {@code mult}
     */
    default HType multWithString(HiddenString wrappedString) {
        return null;
    }

    /**
     * To use double dispatch in {@code mult}
     */
    default HType multWithBool(HiddenBool wrappedBool) {
        return null;
    }

    /**
     * To use double dispatch in {@code mult}
     */
    default HType multWithBinary(HiddenBinary wBinary) {
        return null;
    }

    /**
     * To use double dispatch in {@code mult}
     */
    default HType multWithFloat(HiddenFloat wFloat) {
        return null;
    }

    /**
     * To use double dispatch in {@code mult}
     */
    default HType multWithInt(HiddenInt wInt) {
        return null;
    }

    /**
     * Returns the subtraction between numbers
     *
     * @param hType another number
     * @return the subtraction
     */
    default HType sub(HType hType) {
        return null;
    }

    /**
     * To use double dispatch in {@code sub}
     */
    default HType subWithString(HiddenString wrappedString) {
        return null;
    }

    /**
     * To use double dispatch in {@code sub}
     */
    default HType subWithBool(HiddenBool wrappedBool) {
        return null;
    }

    /**
     * To use double dispatch in {@code sub}
     */
    default HType subWithBinary(HiddenBinary wBinary) {
        return null;
    }

    /**
     * To use double dispatch in {@code sub}
     */
    default HType subWithFloat(HiddenFloat wFloat) {
        return null;
    }

    /**
     * To use double dispatch in {@code sub}
     */
    default HType subWithInt(HiddenInt wInt) {
        return null;
    }

}
