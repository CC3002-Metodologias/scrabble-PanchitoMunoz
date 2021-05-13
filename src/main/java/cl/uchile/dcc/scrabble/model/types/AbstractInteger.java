package cl.uchile.dcc.scrabble.model.types;

import cl.uchile.dcc.scrabble.model.operations.add.IAddWithBinary;
import cl.uchile.dcc.scrabble.model.operations.subtraction.ISubWithBinary;

/**
 * An abstract class for numbers that are like integers (e.g.: TypeInt and TypeBinary).
 * @author Francisco Muñoz Guajardo
 */
public abstract class AbstractInteger extends AbstractNumber
        implements SInteger, IAddWithBinary, ISubWithBinary {
    /**
     * Transforms the current type to a TypeBinary.
     *
     * @return TypeBinary with a value equivalent to the current type.
     */
    abstract public TypeBinary toTypeBinary();

    /**
     * Transforms the current type to a TypeInt.
     *
     * @return TypeInt with a value equivalent to the current type.
     */
    abstract public TypeInt toTypeInt();
}
