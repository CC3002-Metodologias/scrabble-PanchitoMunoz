package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.operations;

import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HType;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HiddenBinary;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HiddenBool;
import cl.uchile.dcc.scrabble.model.factories.hidden_factories.HTypeFactory;

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
     * To use double dispatch in {@code and}
     * @param hiddenBool a {@code HiddenBool}
     */
    default HType andWithBool(HiddenBool hiddenBool) {
        return HTypeFactory.createHiddenNull();
    }

    /**
     * To use double dispatch in {@code and}
     * @param hiddenBinary a {@code HiddenBinary}
     */
    default HType andWithBinary(HiddenBinary hiddenBinary) {
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
     * To use double dispatch in {@code or}
     * @param hiddenBool a {@code HiddenBool}
     */
    default HType orWithBool(HiddenBool hiddenBool) {
        return HTypeFactory.createHiddenNull();
    }

    /**
     * To use double dispatch in {@code or}
     * @param hiddenBinary a {@code HiddenBinary}
     */
    default HType orWithBinary(HiddenBinary hiddenBinary) {
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
