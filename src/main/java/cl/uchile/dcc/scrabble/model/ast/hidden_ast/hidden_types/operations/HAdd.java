package cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.operations;

import cl.uchile.dcc.scrabble.model.ast.hidden_ast.interfaces.HType;
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
    HType add(HType hType);

    /**
     * To use double dispatch in {@code add}
     */
    HType addWithString(HiddenString wString);

    /**
     * To use double dispatch in {@code add}
     */
    HType addWithBool(HiddenBool wBool);

    /**
     * To use double dispatch in {@code add}
     */
    HType addWithBinary(HiddenBinary wBinary);

    /**
     * To use double dispatch in {@code add}
     */
    HType addWithFloat(HiddenFloat wFloat);

    /**
     * To use double dispatch in {@code add}
     */
    HType addWithInt(HiddenInt wInt);
}
