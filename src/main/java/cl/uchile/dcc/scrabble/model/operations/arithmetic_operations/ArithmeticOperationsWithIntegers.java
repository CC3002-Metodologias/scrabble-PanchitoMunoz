package cl.uchile.dcc.scrabble.model.operations.arithmetic_operations;

import cl.uchile.dcc.scrabble.model.types.interface_types.SInteger;

/**
 * An interface that provides the usual behavior of being operated with another integer.
 * @author Francisco Muñoz Guajardo
 */
public interface ArithmeticOperationsWithIntegers {
    /**
     * Method that returns the sum between the current and another type.
     * Returns the dominant type if possible.
     * @param otherType Another type that will be added to the current type.
     * @return The sum between the two types, returning the dominant type.
     */
    SInteger add(SInteger otherType);

    /**
     * Method that returns the subtraction between the current and another type.
     * Returns the dominant type if possible.
     * @param otherType Another type that will be added to the current type.
     * @return The subtraction between the two types, returning the dominant type.
     */
    SInteger sub(SInteger otherType);

    /**
     * Method that returns the multiplication between the current type and the other type.
     * Returns the dominant type if possible.
     *
     * @param otherType Another type that will be multiplied to the current type.
     * @return The multiplication between the two types, returning the dominant type.
     */
    SInteger mult(SInteger otherType);

    /**
     * Method that returns the division between the current type and the other type.
     * Returns the dominant type if possible.
     *
     * @param otherType Another type that will be divided to the current type.
     * @return The division between the two types, returning the dominant type.
     */
    SInteger div(SInteger otherType);
}
