package cl.uchile.dcc.scrabble.model.types.operations.operations_type;

import cl.uchile.dcc.scrabble.model.types.TypeFloat;

/**
 * Interface that provides the arithmetics operations of {@code TypeFloat}.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/24 21:46
 */
public interface ArithmeticOperationsWithFloat {
    /**
     * Returns the add between the current type and a Float Type.
     * @param typeFloat A Float type who will be added to the current type.
     * @return The sum between the Float type and the other type.
     */
    TypeFloat addWithFloat(TypeFloat typeFloat);

    /**
     * Returns the division between the current type and a Float Type.
     *
     * @param typeFloat A Float type who will be divided to the current type.
     * @return The division between the Float type and the other type.
     */
    TypeFloat divWithFloat(TypeFloat typeFloat);

    /**
     * Returns the multiplication between the current type and a Float Type.
     *
     * @param typeFloat A Float type who will be multiplied to the current type.
     * @return The multiplication between the Float type and the other type.
     */
    TypeFloat multWithFloat(TypeFloat typeFloat);

    /**
     * Returns the subtraction between the current type and a Float Type.
     * @param typeFloat A Float type who will be subtracted to the current type.
     * @return The subtraction between the Float type and the other type.
     */
    TypeFloat subWithFloat(TypeFloat typeFloat);

}
