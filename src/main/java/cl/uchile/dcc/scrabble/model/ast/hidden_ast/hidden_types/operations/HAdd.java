package cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.operations;

import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HType;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HiddenBinary;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HiddenBool;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HiddenFloat;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HiddenInt;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HiddenString;

/**
 * Interface to implements the addition in wrapped classes.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/13 0:15
 */
public interface HAdd {

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
    default HType addWithString(HiddenString wString) {
        return null;
    }

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
}
