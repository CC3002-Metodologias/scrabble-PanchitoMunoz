package cl.uchile.dcc.scrabble.model.operations;

import cl.uchile.dcc.scrabble.model.types.TypeBinary;
import cl.uchile.dcc.scrabble.model.types.TypeFloat;
import cl.uchile.dcc.scrabble.model.types.TypeInt;

/**
 * Interface for the multiplication operation.
 * @author Francisco Muñoz Guajardo
 */
public interface IMult {
    /**
     * Method that returns the multiplication between the current type and the other type.
     * Returns the dominant type if possible, or throws an error if the operation is undefined.
     *
     * @param otherType Another type that will be multiplied to the current type.
     * @return The multiplication between the two types, returning the dominant type.
     */
    IMult mult(IMult otherType);

    /**
     * Returns the multiplication between the current type and a Float Type.
     *
     * @param typeFloat A Float type who will be multiplied to the current type.
     * @return The multiplication between the Float type and the other type.
     */
    IMult multWithFloat(TypeFloat typeFloat);

    /**
     * Returns the multiplication between the current type and an Int Type.
     *
     * @param intType An Int type who will be multiplied to the current type.
     * @return The multiplication between the Int type and the other type.
     */
    IMult multWithInt(TypeInt intType);

    /**
     * Returns the multiplication between the current type and a Binary Type.
     * @param typeBinary A Binary type who will be multiplied to the current type.
     * @return The multiplication between the Binary type and the other type.
     */
    IMult multWithBinary(TypeBinary typeBinary);
}
