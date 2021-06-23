package cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.operations;

import cl.uchile.dcc.scrabble.model.ast.hidden_ast.interfaces.HType;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HiddenBinary;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HiddenBool;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HiddenInt;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HiddenFloat;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HiddenString;

/**
 * Interface to implements the division in wrapped classes.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/13 0:23
 */
public interface HDiv {

    /**
     * Returns the division between numbers
     *
     * @param hType another number
     * @return the division
     */
    HType div(HType hType);

    /**
     * To use double dispatch in {@code div}
     */
    HType divWithString(HiddenString wrappedString);

    /**
     * To use double dispatch in {@code div}
     */
    HType divWithBool(HiddenBool wrappedBool);

    /**
     * To use double dispatch in {@code div}
     */
    HType divWithBinary(HiddenBinary wBinary);

    /**
     * To use double dispatch in {@code div}
     */
    HType divWithFloat(HiddenFloat wFloat);

    /**
     * To use double dispatch in {@code div}
     */
    HType divWithInt(HiddenInt wInt);
}
