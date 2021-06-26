package cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.operations;

import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HType;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HiddenBinary;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HiddenBool;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HiddenFloat;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HiddenInt;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HiddenString;

/**
 * Interface to implements the division in wrapped classes.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/13 0:23
 */
public interface HDiv {

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
}
