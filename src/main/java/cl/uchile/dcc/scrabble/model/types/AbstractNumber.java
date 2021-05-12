package cl.uchile.dcc.scrabble.model.types;

import cl.uchile.dcc.scrabble.model.operations.add.IAddWithFloat;
import cl.uchile.dcc.scrabble.model.operations.add.IAddWithInt;

/**
 * An abstract class for the general numbers used.
 * @author Francisco Muñoz Guajardo
 */
public abstract class AbstractNumber extends AbstractType implements IAddWithInt, IAddWithFloat {
    /**
     * Transforms the current type to a TypeFloat.
     *
     * @return TypeFloat with a value equivalent to the current type.
     */
    abstract public TypeFloat toTypeFloat();
}
