package cl.uchile.dcc.scrabble.model.types.operations.operations_type;

import cl.uchile.dcc.scrabble.model.types.TypeInt;
import cl.uchile.dcc.scrabble.model.types.interface_types.SNumber;

/**
 * Interface that provides the arithmetics operations of {@code TypeInt}.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/24 21:41
 */
public interface ArithmeticOperationsWithInt {
    /**
     * Returns the sum between the current type and an Int Type.
     * @param typeInt An Int type who will be added to the current type.
     * @return The sum between the Int type and the other type.
     */
    SNumber addWithInt(TypeInt typeInt);

    /**
     * Returns the division between the current type and an Int Type.
     *
     * @param typeInt An Int type who will be divided to the current type.
     * @return The division between the Int type and the other type.
     */
    SNumber divWithInt(TypeInt typeInt);

    /**
     * Returns the multiplication between the current type and an Int Type.
     *
     * @param typeInt An Int type who will be multiplied to the current type.
     * @return The multiplication between the Int type and the other type.
     */
    SNumber multWithInt(TypeInt typeInt);

    /**
     * Returns the subtraction between the current type and an Int Type.
     * @param typeInt An Int type who will be subtracted to the current type.
     * @return The subtraction between the Int type and the other type.
     */
    SNumber subWithInt(TypeInt typeInt);
}
