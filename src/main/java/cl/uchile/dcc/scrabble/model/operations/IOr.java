package cl.uchile.dcc.scrabble.model.operations;

import cl.uchile.dcc.scrabble.model.types.TypeBinary;
import cl.uchile.dcc.scrabble.model.types.TypeBool;

/**
 * Interface for the 'or' operation (the conjunction).
 * @author Francisco Muñoz Guajardo
 */
public interface IOr {
    /**
     * Method that returns the conjunction between the current type and the other type.
     * Returns the dominant type if possible, or throws an error if the operation is undefined.
     * @param otherType Another type that will be conjunct to the current type.
     * @return The conjunction between the two types, returning the dominant type.
     */
    IOr or(IOr otherType);

    /**
     * Returns the conjunction between the current type and a Bool Type.
     * @param typeBool A Bool type who will be conjunct to the current type.
     * @return The conjunction between the Bool type and the other type.
     */
    IOr orWithBool(TypeBool typeBool);

    /**
     * Returns the conjunction between the current type and a Binary Type.
     * @param typeBinary A Binary type who will be conjunct to the current type.
     * @return The conjunction between the Binary type and the other type.
     */
    IOr orWithBinary(TypeBinary typeBinary);
}
