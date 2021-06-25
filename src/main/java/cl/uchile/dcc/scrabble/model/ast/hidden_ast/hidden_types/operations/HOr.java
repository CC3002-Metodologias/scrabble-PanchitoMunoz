package cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.operations;

import cl.uchile.dcc.scrabble.model.ast.hidden_ast.interfaces.HType;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HiddenBinary;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HiddenBool;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HiddenInt;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HiddenString;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HiddenFloat;

/**
 * Interface to implements the conjunction in wrapped classes.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/13 0:23
 */
public interface HOr {

    /**
     * Returns the conjunction between logicals
     *
     * @param hType another logical
     * @return the conjunction
     */
    default HType or(HType hType) {
        return null;
    }

    /**
     * To use double dispatch in {@code or}
     */
    default HType orWithString(HiddenString wrappedString) {
        return null;
    }

    /**
     * To use double dispatch in {@code or}
     */
    default HType orWithBool(HiddenBool wBool) {
        return null;
    }

    /**
     * To use double dispatch in {@code or}
     */
    default HType orWithBinary(HiddenBinary wBinary) {
        return null;
    }

    /**
     * To use double dispatch in {@code or}
     */
    default HType orWithFloat(HiddenFloat wrappedFloat) {
        return null;
    }

    /**
     * To use double dispatch in {@code or}
     */
    default HType orWithInt(HiddenInt wrappedInt) {
        return null;
    }
}
