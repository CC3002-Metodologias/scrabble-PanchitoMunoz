package cl.uchile.dcc.scrabble.model.types.interface_types;

import cl.uchile.dcc.scrabble.model.operations.INeg;
import cl.uchile.dcc.scrabble.model.operations.and.IAndWithBinary;
import cl.uchile.dcc.scrabble.model.operations.and.IAndWithBool;
import cl.uchile.dcc.scrabble.model.operations.or.IOrWithBinary;
import cl.uchile.dcc.scrabble.model.operations.or.IOrWithBool;

/**
 * An interface for the sole purpose of representing a logical (e.g.: TypeBinary and TypeBool).
 * @author Francisco Muñoz Guajardo
 */
public interface SLogical
        extends INeg, IAndWithBool, IOrWithBool, IAndWithBinary, IOrWithBinary {
    /**
     * Method that returns the disjunction between the current type and the other type.
     * Returns the dominant type if possible.
     * @param otherType Another type that will be disjunct to the current type.
     * @return The disjunction between the two types, returning the dominant type.
     */
    SLogical and(SLogical otherType);

    /**
     * Method that returns the conjunction between the current type and the other type.
     * Returns the dominant type if possible.
     * @param otherType Another type that will be conjunct to the current type.
     * @return The conjunction between the two types, returning the dominant type.
     */
    SLogical or(SLogical otherType);
}
