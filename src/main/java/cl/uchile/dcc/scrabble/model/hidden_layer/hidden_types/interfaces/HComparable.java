package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.interfaces;

import cl.uchile.dcc.scrabble.model.factories.hidden_factories.HTypeFactory;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HType;

/**
 * An interface for relational operators.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/07/31 14:27
 */
public interface HComparable {

    /**
     * Returns a {@code HiddenBool} if the parameter {@code other} is equals.
     *
     * @param other other {@code HType}
     * @return a {@code HBool}
     */
    default HBool equalsTo(HType other) {
        return HTypeFactory.createHiddenNull();
    }

    /**
     * Returns a {@code HiddenBool} if the parameter {@code other} is greater equals than the
     * current.
     *
     * @param other other {@code HType}
     * @return a {@code HBool}
     */
    default HBool greaterEquals(HType other) {
        return HTypeFactory.createHiddenNull();
    }

    /**
     * Returns a {@code HiddenBool} if the parameter {@code other} is greater than the current.
     *
     * @param other other {@code HType}
     * @return a {@code HBool}
     */
    default HBool greaterThan(HType other) {
        return HTypeFactory.createHiddenNull();
    }

    /**
     * Returns a {@code HiddenBool} if the parameter {@code other} is lower equals than the
     * current.
     *
     * @param other other {@code HType}
     * @return a {@code HBool}
     */
    default HBool lowerEquals(HType other) {
        return HTypeFactory.createHiddenNull();
    }

    /**
     * Returns a {@code HiddenBool} if the parameter {@code other} is lower than the current.
     *
     * @param other other {@code HType}
     * @return a {@code HBool}
     */
    default HBool lowerThan(HType other) {
        return HTypeFactory.createHiddenNull();
    }

}
