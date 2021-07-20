package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.interfaces;

import cl.uchile.dcc.scrabble.model.factories.hidden_factories.HTypeFactory;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HType;

/**
 * Interface for logical operations in {@code HType}.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/26 22:26
 */
public interface HLogicalOperations {

    /**
     * Returns the disjunction between logicals
     *
     * @param hType another logical
     * @return the disjunction
     */
    default HType and(HType hType) {
        return HTypeFactory.createHiddenNull();
    }

    /**
     * Returns the conjunction between logicals
     *
     * @param hType another logical
     * @return the conjunction
     */
    default HType or(HType hType) {
        return HTypeFactory.createHiddenNull();
    }

    /**
     * Returns the negation of the current instance
     *
     * @return the negation.
     */
    default HType neg() {
        return HTypeFactory.createHiddenNull();
    }

}
