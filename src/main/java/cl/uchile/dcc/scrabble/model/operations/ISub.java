package cl.uchile.dcc.scrabble.model.operations;

import cl.uchile.dcc.scrabble.model.types.TypeBinary;
import cl.uchile.dcc.scrabble.model.types.TypeFloat;
import cl.uchile.dcc.scrabble.model.types.TypeInt;

/**
 * Interface for the subtraction operation.
 * @author Francisco Muñoz Guajardo
 */
public interface ISub {

    /**
     * Method that returns the subtraction between the current type and the other type.
     * Returns the dominant type if possible, or throws an error if the operation is undefined.
     * @param otherType Another type that will be subtracted to the current type.
     * @return The subtraction between the two types, returning the dominant type.
     */
    ISub sub(ISub otherType);

    /**
     * Returns the subtraction between the current type and a Float Type.
     * @param typeFloat A Float type who will be subtracted to the current type.
     * @return The subtraction between the Float type and the other type.
     */
    ISub subWithFloat(TypeFloat typeFloat);

    /**
     * Returns the subtraction between the current type and an Int Type.
     * @param typeInt An Int type who will be subtracted to the current type.
     * @return The subtraction between the Int type and the other type.
     */
    ISub subWithInt(TypeInt typeInt);

    /**
     * Returns the subtraction between the current type and a Binary Type.
     * @param typeBinary A Binary type who will be subtracted to the current type.
     * @return The subtraction between the Binary type and the other type.
     */
    ISub subWithBinary(TypeBinary typeBinary);
}
