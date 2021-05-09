package cl.uchile.dcc.scrabble.model.operations;

import cl.uchile.dcc.scrabble.model.types.TypeBinary;
import cl.uchile.dcc.scrabble.model.types.TypeBool;

/**
 * Interface for the 'and' operation (the disjunction).
 * @author Francisco Muñoz Guajardo
 */
public interface IAnd {
    /**
     * Method that returns the disjunction between the current type and the other type.
     * Returns the dominant type if possible, or throws an error if the operation is undefined.
     * @param otherType Another type that will be disjunct to the current type.
     * @return The disjunction between the two types, returning the dominant type.
     */
    IAnd and(IAnd otherType);

    /**
     * Returns the disjunction between the current type and a Bool Type.
     * @param typeBool A Bool type who will be disjunct to the current type.
     * @return The disjunction between the Bool type and the other type.
     */
    IAnd andWithBool(TypeBool typeBool);

    /**
     * Returns the disjunction between the current type and a Binary Type.
     * @param typeBinary A Binary type who will be disjunct to the current type.
     * @return The disjunction between the Binary type and the other type.
     */
    IAnd andWithBinary(TypeBinary typeBinary);
}
