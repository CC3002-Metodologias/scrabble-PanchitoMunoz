package cl.uchile.dcc.scrabble.model.types.abstract_types;

import cl.uchile.dcc.scrabble.model.operations.add.IAddWithBinary;
import cl.uchile.dcc.scrabble.model.operations.division.IDivWithBinary;
import cl.uchile.dcc.scrabble.model.operations.multiplication.IMultWithBinary;
import cl.uchile.dcc.scrabble.model.operations.subtraction.ISubWithBinary;
import cl.uchile.dcc.scrabble.model.types.interface_types.SInteger;
import cl.uchile.dcc.scrabble.model.types.TypeBinary;
import cl.uchile.dcc.scrabble.model.types.TypeInt;

/**
 * An abstract class for numbers that are like integers (e.g.: TypeInt and TypeBinary).
 * @author Francisco Muñoz Guajardo
 */
public abstract class AbstractInteger extends AbstractNumber
        implements SInteger, IAddWithBinary, ISubWithBinary, IMultWithBinary, IDivWithBinary {
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
