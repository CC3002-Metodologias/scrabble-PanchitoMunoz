package cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.operations;

import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HType;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HiddenBinary;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HiddenBool;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HiddenString;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HiddenFloat;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HiddenInt;

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
    HType mult(HType hType);

    /**
     * To use double dispatch in {@code mult}
     */
    HType multWithString(HiddenString wrappedString);

    /**
     * To use double dispatch in {@code mult}
     */
    HType multWithBool(HiddenBool wrappedBool);

    /**
     * To use double dispatch in {@code mult}
     */
    HType multWithBinary(HiddenBinary wBinary);

    /**
     * To use double dispatch in {@code mult}
     */
    HType multWithFloat(HiddenFloat wFloat);

    /**
     * To use double dispatch in {@code mult}
     */
    HType multWithInt(HiddenInt wInt);
}
