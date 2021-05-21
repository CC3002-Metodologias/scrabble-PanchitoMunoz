package cl.uchile.dcc.scrabble.model.types.interface_types;

import cl.uchile.dcc.scrabble.model.operations.add.IAddWithBinary;
import cl.uchile.dcc.scrabble.model.operations.division.IDivWithBinary;
import cl.uchile.dcc.scrabble.model.operations.multiplication.IMultWithBinary;
import cl.uchile.dcc.scrabble.model.operations.subtraction.ISubWithBinary;

/**
 * An interface for the sole purpose of representing an integer.
 * @author Francisco Muñoz Guajardo
 */
public interface SInteger
        extends IAddWithBinary, ISubWithBinary, IMultWithBinary, IDivWithBinary {
}
