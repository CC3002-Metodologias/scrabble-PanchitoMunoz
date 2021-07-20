package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.interfaces;

import cl.uchile.dcc.scrabble.model.factories.hidden_factories.HTypeFactory;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HType;

/**
 * A general interface for every allowed transformation.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/07/20 1:42
 */
public interface HTypesTransformations {

    /**
     * Transform the current instance to a {@code HiddenBinary}.
     *
     * @return a {@code HiddenBinary} equivalent
     */
    default HType toHiddenBinary() {
        return HTypeFactory.createHiddenNull();
    }

    /**
     * Transform the current instance to a {@code HiddenBool}.
     *
     * @return a {@code HiddenBool} equivalent
     */
    default HType toHiddenBool() {
        return HTypeFactory.createHiddenNull();
    }

    /**
     * Transform the current instance to a {@code HiddenFloat}.
     *
     * @return a {@code HiddenFloat} equivalent
     */
    default HType toHiddenFloat() {
        return HTypeFactory.createHiddenNull();
    }

    /**
     * Transform the current instance to a {@code HiddenInt}.
     *
     * @return a {@code HiddenInt} equivalent
     */
    default HType toHiddenInt() {
        return HTypeFactory.createHiddenNull();
    }

    /**
     * Transform the current instance to a {@code HiddenString}.
     *
     * @return a {@code HiddenString} equivalent
     */
    default HType toHiddenString() {
        return HTypeFactory.createHiddenNull();
    }

}
