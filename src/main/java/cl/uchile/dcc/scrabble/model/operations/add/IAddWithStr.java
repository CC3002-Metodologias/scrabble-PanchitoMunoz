package cl.uchile.dcc.scrabble.model.operations.add;

import cl.uchile.dcc.scrabble.model.types.TypeString;

/**
 * Interface for the addition operation. It is in case a String is sum with any type.
 * Currently this interface is for the other types.
 * @author Francisco Muñoz Guajardo
 */
public interface IAddWithStr {
    /**
     * Returns the add between the current type and a String Type.
     * @param typeString A string type who will be added to the current type.
     * @return The sum between the String type and the other type.
     */
    TypeString addWithString(TypeString typeString);
}
