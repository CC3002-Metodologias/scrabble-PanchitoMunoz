package cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.operations;

import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HType;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HiddenBinary;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HiddenBool;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HiddenFloat;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HiddenInt;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HiddenString;

/**
 * Interface to implements the disjunction in wrapped classes.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/13 0:23
 */
public interface HAnd {

    /**
     * Returns the disjunction between logicals
     *
     * @param hType another logical
     * @return the disjunction
     */
    default HType and(HType hType) {
        return null;
    }

    /**
     * To use double dispatch in {@code and}
     */
    default HType andWithString(HiddenString wrappedString) {
        return null;
    }

    /**
     * To use double dispatch in {@code and}
     */
    default HType andWithBool(HiddenBool wBool) {
        return null;
    }

    /**
     * To use double dispatch in {@code and}
     */
    default HType andWithBinary(HiddenBinary wBinary) {
        return null;
    }

    /**
     * To use double dispatch in {@code and}
     */
    default HType andWithFloat(HiddenFloat wrappedFloat) {
        return null;
    }

    /**
     * To use double dispatch in {@code and}
     */
    default HType andWithInt(HiddenInt wrappedInt) {
        return null;
    }
}
