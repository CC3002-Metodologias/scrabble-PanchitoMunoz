package cl.uchile.dcc.scrabble.model.types.operations.operations_type;

import cl.uchile.dcc.scrabble.model.types.TypeString;

/**
 * TODO: DOCUMENTAR
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/24 21:38
 */
public interface ArithmeticOperationsWithString {
    /**
     * Returns the add between the current type and a String Type.
     * @param typeString A string type who will be added to the current type.
     * @return The sum between the String type and the other type.
     */
    TypeString addWithString(TypeString typeString);
}
