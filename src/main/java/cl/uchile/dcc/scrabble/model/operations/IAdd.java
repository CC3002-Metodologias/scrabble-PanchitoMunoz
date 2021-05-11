package cl.uchile.dcc.scrabble.model.operations;

import cl.uchile.dcc.scrabble.model.types.*;

/**
 * Interface for the addition operation.
 * @author Francisco Muñoz Guajardo
 */
public interface IAdd {

    /**
     * Method that returns the sum between the current type and the other type.
     * Returns the dominant type if possible, or throws an error if the operation is undefined.
     * @param otherType Another type that will be added to the current type.
     * @return The sum between the two types, returning the dominant type.
     */
    IAdd add(IAdd otherType);

    /**
     * Returns the add between the current type and a String Type.
     * @param typeString A string type who will be added to the current type.
     * @return The sum between the String type and the other type.
     */
    IAdd addWithString(TypeString typeString);

    /**
     * Returns the add between the current type and a Bool Type.
     * @param typeBool A Bool type who will be added to the current type.
     * @return The sum between the Bool type and the other type.
     */
    IAdd addWithBool(TypeBool typeBool);

    /**
     * Returns the add between the current type and a Float Type.
     * @param typeFloat A Float type who will be added to the current type.
     * @return The sum between the Float type and the other type.
     */
    IAdd addWithFloat(TypeFloat typeFloat);

    /**
     * Returns the add between the current type and an Int Type.
     * @param intType An Int type who will be added to the current type.
     * @return The sum between the Int type and the other type.
     */
    IAdd addWithInt(TypeInt intType);

    /**
     * Returns the add between the current type and a Binary Type.
     * @param typeBinary A Binary type who will be added to the current type.
     * @return The sum between the Binary type and the other type.
     */
    IAdd addWithBinary(TypeBinary typeBinary);
}
