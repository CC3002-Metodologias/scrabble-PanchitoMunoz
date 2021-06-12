package cl.uchile.dcc.scrabble.model.operations;

import cl.uchile.dcc.scrabble.model.types.interface_types.SLogical;

/**
 * An interface that provides the behavior of being operated with another logical.
 *
 * @author Francisco Muñoz Guajardo</a> Date : 2021/06/11 Time : 22:51
 */
public interface LogicalOperations {

    /**
     * Method that returns the disjunction between the current type and the other type. Returns the
     * dominant type if possible.
     *
     * @param otherType Another type that will be disjunct to the current type.
     * @return The disjunction between the two types, returning the dominant type.
     */
    SLogical and(SLogical otherType);

    /**
     * Method that returns the conjunction between the current type and the other type. Returns the
     * dominant type if possible.
     *
     * @param otherType Another type that will be conjunct to the current type.
     * @return The conjunction between the two types, returning the dominant type.
     */
    SLogical or(SLogical otherType);
}
