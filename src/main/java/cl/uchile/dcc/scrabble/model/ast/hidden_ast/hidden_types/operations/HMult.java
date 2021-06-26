package cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.operations;

import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HType;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HiddenBinary;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HiddenBool;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HiddenFloat;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HiddenInt;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HiddenString;

/**
 * Interface to implements the multiplication in wrapped classes.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/13 0:22
 */
public interface HMult {

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
}
