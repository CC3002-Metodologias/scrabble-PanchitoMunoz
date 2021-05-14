package cl.uchile.dcc.scrabble.model.types.abstract_types;

import cl.uchile.dcc.scrabble.model.operations.add.IAddWithStr;
import cl.uchile.dcc.scrabble.model.types.interface_types.SType;
import cl.uchile.dcc.scrabble.model.types.TypeString;

/**
 * An abstract class for the general types used.
 * @author Francisco Muñoz Guajardo
 */
public abstract class AbstractType implements SType, IAddWithStr {
    /**
     * Transforms the current type to a TypeString.
     * @return TypeString with a value equivalent to the current type.
     */
    abstract public TypeString toTypeString();
}
