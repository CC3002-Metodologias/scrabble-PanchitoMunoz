package cl.uchile.dcc.scrabble.model.types.operations.operations_type;

import cl.uchile.dcc.scrabble.model.types.TypeBinary;

/**
 * TODO: DOCUMENTAR
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/24 21:49
 */
public interface ArithmeticOperationsWithBinary {
    /**
     * Returns the sum between the current type and a Binary Type.
     * @param typeBinary A Binary type who will be added to the current type.
     * @return The sum between the Binary type and the other type.
     */
    TypeBinary addWithBinary(TypeBinary typeBinary);

    /**
     * Returns the division between the current type and a Binary Type.
     *
     * @param typeBinary A Binary type who will be divided to the current type.
     * @return The division between the Binary type and the other type.
     */
    TypeBinary divWithBinary(TypeBinary typeBinary);

    /**
     * Returns the multiplication between the current type and a Binary Type.
     * @param typeBinary A Binary type who will be multiplied to the current type.
     * @return The multiplication between the Binary type and the other type.
     */
    TypeBinary multWithBinary(TypeBinary typeBinary);

    /**
     * Returns the subtraction between the current type and a Binary Type.
     * @param typeBinary A Binary type who will be subtracted to the current type.
     * @return The subtraction between the Binary type and the other type.
     */
    TypeBinary subWithBinary(TypeBinary typeBinary);
}
