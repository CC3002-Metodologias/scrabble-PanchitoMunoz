package cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.operations;

import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HType;
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
    HType or(HType hType);

    /**
     * To use double dispatch in {@code or}
     */
    HType orWithString(HiddenString wrappedString);

    /**
     * To use double dispatch in {@code or}
     */
    HType orWithBool(HiddenBool wBool);

    /**
     * To use double dispatch in {@code or}
     */
    HType orWithBinary(HiddenBinary wBinary);

    /**
     * To use double dispatch in {@code or}
     */
    HType orWithFloat(HiddenFloat wrappedFloat);

    /**
     * To use double dispatch in {@code or}
     */
    HType orWithInt(HiddenInt wrappedInt);
}
