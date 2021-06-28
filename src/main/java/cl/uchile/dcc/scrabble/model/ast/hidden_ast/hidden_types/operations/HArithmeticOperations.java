package cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.operations;

import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HType;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HiddenBinary;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HiddenBool;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HiddenFloat;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HiddenInt;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HiddenString;
import cl.uchile.dcc.scrabble.model.factories.hidden_factories.HTypeFactory;

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
        return HTypeFactory.createHiddenNull();
    }

    /**
     * To use double dispatch in {@code add}
     * 
     * @param hiddenString a {@code HiddenString}
     */
    HType addWithString(HiddenString hiddenString);

    /**
     * To use double dispatch in {@code add}
     * @param hiddenBinary a {@code HiddenBinary}
     */
    default HType addWithBinary(HiddenBinary hiddenBinary) {
        return HTypeFactory.createHiddenNull();
    }

    /**
     * To use double dispatch in {@code add}
     * @param hiddenFloat a {@code HiddenFloat}
     */
    default HType addWithFloat(HiddenFloat hiddenFloat) {
        return HTypeFactory.createHiddenNull();
    }

    /**
     * To use double dispatch in {@code add}
     * @param hiddenInt a {@code HiddenInt}
     */
    default HType addWithInt(HiddenInt hiddenInt) {
        return HTypeFactory.createHiddenNull();
    }

    /**
     * Returns the division between numbers
     *
     * @param hType another number
     * @return the division
     */
    default HType div(HType hType) {
        return HTypeFactory.createHiddenNull();
    }

    /**
     * To use double dispatch in {@code div}
     * @param hiddenBinary a {@code HiddenBinary}
     */
    default HType divWithBinary(HiddenBinary hiddenBinary) {
        return HTypeFactory.createHiddenNull();
    }

    /**
     * To use double dispatch in {@code div}
     * @param hiddenFloat a {@code HiddenFloat}
     */
    default HType divWithFloat(HiddenFloat hiddenFloat) {
        return HTypeFactory.createHiddenNull();
    }

    /**
     * To use double dispatch in {@code div}
     * @param hiddenInt a {@code HiddenInt}
     */
    default HType divWithInt(HiddenInt hiddenInt) {
        return HTypeFactory.createHiddenNull();
    }

    /**
     * Returns the multiplication between numbers
     *
     * @param hType another number
     * @return the multiplication
     */
    default HType mult(HType hType) {
        return HTypeFactory.createHiddenNull();
    }

    /**
     * To use double dispatch in {@code mult}
     * @param hiddenBinary a {@code HiddenBinary}
     */
    default HType multWithBinary(HiddenBinary hiddenBinary) {
        return HTypeFactory.createHiddenNull();
    }

    /**
     * To use double dispatch in {@code mult}
     * @param hiddenFloat a {@code HiddenFloat}
     */
    default HType multWithFloat(HiddenFloat hiddenFloat) {
        return HTypeFactory.createHiddenNull();
    }

    /**
     * To use double dispatch in {@code mult}
     * @param hiddenInt a {@code HiddenInt}
     */
    default HType multWithInt(HiddenInt hiddenInt) {
        return HTypeFactory.createHiddenNull();
    }

    /**
     * Returns the subtraction between numbers
     *
     * @param hType another number
     * @return the subtraction
     */
    default HType sub(HType hType) {
        return HTypeFactory.createHiddenNull();
    }

    /**
     * To use double dispatch in {@code sub}
     * @param hiddenBinary a {@code HiddenBinary}
     */
    default HType subWithBinary(HiddenBinary hiddenBinary) {
        return HTypeFactory.createHiddenNull();
    }

    /**
     * To use double dispatch in {@code sub}
     * @param hiddenFloat a {@code HiddenFloat}
     */
    default HType subWithFloat(HiddenFloat hiddenFloat) {
        return HTypeFactory.createHiddenNull();
    }

    /**
     * To use double dispatch in {@code sub}
     * @param hiddenInt a {@code HiddenInt}
     */
    default HType subWithInt(HiddenInt hiddenInt) {
        return HTypeFactory.createHiddenNull();
    }

}
