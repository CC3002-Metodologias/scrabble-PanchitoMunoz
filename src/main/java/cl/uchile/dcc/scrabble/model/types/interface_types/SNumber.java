package cl.uchile.dcc.scrabble.model.types.interface_types;

import cl.uchile.dcc.scrabble.model.ast.interfaces.NumberAST;
import cl.uchile.dcc.scrabble.model.types.TypeFloat;
import cl.uchile.dcc.scrabble.model.types.operations.add.IAddWithFloat;
import cl.uchile.dcc.scrabble.model.types.operations.add.IAddWithInt;
import cl.uchile.dcc.scrabble.model.types.operations.division.IDivWithFloat;
import cl.uchile.dcc.scrabble.model.types.operations.division.IDivWithInt;
import cl.uchile.dcc.scrabble.model.types.operations.multiplication.IMultWithFloat;
import cl.uchile.dcc.scrabble.model.types.operations.multiplication.IMultWithInt;
import cl.uchile.dcc.scrabble.model.types.operations.subtraction.ISubWithFloat;
import cl.uchile.dcc.scrabble.model.types.operations.subtraction.ISubWithInt;

/**
 * An interface for the sole purpose of representing a number.
 *
 * @author Francisco Muñoz Guajardo
 */
public interface SNumber
    extends NumberAST, IAddWithFloat, IAddWithInt, ISubWithFloat, ISubWithInt,
    IMultWithFloat, IMultWithInt, IDivWithFloat, IDivWithInt {

    /**
     * Transforms the current type to a TypeFloat.
     *
     * @return TypeFloat with a value equivalent to the current type.
     */
    TypeFloat toTypeFloat();
}
