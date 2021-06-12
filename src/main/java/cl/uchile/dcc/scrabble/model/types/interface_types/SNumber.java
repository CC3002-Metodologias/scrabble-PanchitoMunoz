package cl.uchile.dcc.scrabble.model.types.interface_types;

import cl.uchile.dcc.scrabble.model.operations.add.IAddWithFloat;
import cl.uchile.dcc.scrabble.model.operations.add.IAddWithInt;
import cl.uchile.dcc.scrabble.model.operations.division.IDivWithFloat;
import cl.uchile.dcc.scrabble.model.operations.division.IDivWithInt;
import cl.uchile.dcc.scrabble.model.operations.multiplication.IMultWithFloat;
import cl.uchile.dcc.scrabble.model.operations.multiplication.IMultWithInt;
import cl.uchile.dcc.scrabble.model.operations.subtraction.ISubWithFloat;
import cl.uchile.dcc.scrabble.model.operations.subtraction.ISubWithInt;
import cl.uchile.dcc.scrabble.model.types.TypeFloat;

/**
 * An interface for the sole purpose of representing a number.
 *
 * @author Francisco Muñoz Guajardo
 */
public interface SNumber
    extends IAddWithFloat, IAddWithInt, ISubWithFloat, ISubWithInt,
    IMultWithFloat, IMultWithInt, IDivWithFloat, IDivWithInt {

    /**
     * Transforms the current type to a TypeFloat.
     *
     * @return TypeFloat with a value equivalent to the current type.
     */
    TypeFloat toTypeFloat();
}
