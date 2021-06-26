package cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.operations;

import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HType;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HiddenBinary;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HiddenBool;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HiddenFloat;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HiddenInt;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HiddenString;

/**
 * Interface to implements the subtraction in wrapped classes.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/13 0:16
 */
public interface HSub {

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
