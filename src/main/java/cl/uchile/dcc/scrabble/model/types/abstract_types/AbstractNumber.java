package cl.uchile.dcc.scrabble.model.types.abstract_types;

import cl.uchile.dcc.scrabble.model.operations.add.*;
import cl.uchile.dcc.scrabble.model.operations.division.*;
import cl.uchile.dcc.scrabble.model.operations.multiplication.*;
import cl.uchile.dcc.scrabble.model.operations.subtraction.*;
import cl.uchile.dcc.scrabble.model.types.interface_types.SNumber;
import cl.uchile.dcc.scrabble.model.types.TypeFloat;

/**
 * An abstract class for the general numbers used.
 * @author Francisco Muñoz Guajardo
 */
public abstract class AbstractNumber extends AbstractType
        implements SNumber, IAddWithFloat, IAddWithInt, ISubWithFloat,  ISubWithInt,
        IMultWithFloat, IMultWithInt, IDivWithFloat, IDivWithInt {
    /**
     * Transforms the current type to a TypeFloat.
     *
     * @return TypeFloat with a value equivalent to the current type.
     */
    abstract public TypeFloat toTypeFloat();
}
