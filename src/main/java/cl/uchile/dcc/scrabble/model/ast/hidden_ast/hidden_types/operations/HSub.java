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
    HType sub(HType hType);

    /**
     * To use double dispatch in {@code sub}
     */
    HType subWithString(HiddenString wrappedString);

    /**
     * To use double dispatch in {@code sub}
     */
    HType subWithBool(HiddenBool wrappedBool);

    /**
     * To use double dispatch in {@code sub}
     */
    HType subWithBinary(HiddenBinary wBinary);

    /**
     * To use double dispatch in {@code sub}
     */
    HType subWithFloat(HiddenFloat wFloat);

    /**
     * To use double dispatch in {@code sub}
     */
    HType subWithInt(HiddenInt wInt);
}
