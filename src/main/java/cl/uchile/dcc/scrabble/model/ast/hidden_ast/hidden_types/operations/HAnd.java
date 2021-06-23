package cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.operations;

import cl.uchile.dcc.scrabble.model.ast.hidden_ast.interfaces.HType;
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
    HType and(HType hType);

    /**
     * To use double dispatch in {@code and}
     */
    HType andWithString(HiddenString wrappedString);

    /**
     * To use double dispatch in {@code and}
     */
    HType andWithBool(HiddenBool wBool);

    /**
     * To use double dispatch in {@code and}
     */
    HType andWithBinary(HiddenBinary wBinary);

    /**
     * To use double dispatch in {@code and}
     */
    HType andWithFloat(HiddenFloat wrappedFloat);

    /**
     * To use double dispatch in {@code and}
     */
    HType andWithInt(HiddenInt wrappedInt);
}
