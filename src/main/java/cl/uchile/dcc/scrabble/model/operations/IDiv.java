package cl.uchile.dcc.scrabble.model.operations;

import cl.uchile.dcc.scrabble.model.types.TypeBinary;
import cl.uchile.dcc.scrabble.model.types.TypeFloat;
import cl.uchile.dcc.scrabble.model.types.TypeInt;

/**
 * Interface for the division operation.
 * @author Francisco Muñoz Guajardo
 */
public interface IDiv {
    /**
     * Method that returns the division between the current type and the other type.
     * Returns the dominant type if possible, or throws an error if the operation is undefined.
     *
     * @param otherType Another type that will be divided to the current type.
     * @return The division between the two types, returning the dominant type.
     */
    IDiv div(IDiv otherType);

    /**
     * Returns the division between the current type and a Float Type.
     *
     * @param typeFloat A Float type who will be divided to the current type.
     * @return The division between the Float type and the other type.
     */
    IDiv divWithFloat(TypeFloat typeFloat);

    /**
     * Returns the division between the current type and an Int Type.
     *
     * @param typeInt An Int type who will be divided to the current type.
     * @return The division between the Int type and the other type.
     */
    IDiv divWithInt(TypeInt typeInt);

    /**
     * Returns the division between the current type and a Binary Type.
     *
     * @param typeBinary A Binary type who will be divided to the current type.
     * @return The division between the Binary type and the other type.
     */
    IDiv divWithBinary(TypeBinary typeBinary);
}
