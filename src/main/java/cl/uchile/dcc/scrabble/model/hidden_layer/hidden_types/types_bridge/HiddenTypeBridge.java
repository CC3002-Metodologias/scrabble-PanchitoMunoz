package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.types_bridge;

import cl.uchile.dcc.scrabble.model.factories.hidden_factories.HTypeFactory;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HType;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HiddenBinary;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HiddenBool;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HiddenFloat;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HiddenInt;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HiddenString;

/**
 * An interface for a general Type Bridge. The classes that implements this interface is to store
 * the logic of the Double Dispatch.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/07/13 15:08
 */
public interface HiddenTypeBridge {

    /**
     * Returns the value in the bridge
     * @return the value in the bridge
     */
    HType getValue();

    /**
     * To use double dispatch in {@code add}
     *
     * @param hiddenString a {@code HiddenString}
     */
    HType addWithString(HiddenString hiddenString);

    /**
     * To use double dispatch in {@code add}
     * @param hiddenBinary a {@code HiddenBinary}
     */
    default HType addWithBinary(HiddenBinary hiddenBinary) {
        return HTypeFactory.createHiddenNull();
    }

    /**
     * To use double dispatch in {@code add}
     * @param hiddenFloat a {@code HiddenFloat}
     */
    default HType addWithFloat(HiddenFloat hiddenFloat) {
        return HTypeFactory.createHiddenNull();
    }

    /**
     * To use double dispatch in {@code add}
     * @param hiddenInt a {@code HiddenInt}
     */
    default HType addWithInt(HiddenInt hiddenInt) {
        return HTypeFactory.createHiddenNull();
    }

    /**
     * To use double dispatch in {@code div}
     * @param hiddenBinary a {@code HiddenBinary}
     */
    default HType divWithBinary(HiddenBinary hiddenBinary) {
        return HTypeFactory.createHiddenNull();
    }

    /**
     * To use double dispatch in {@code div}
     * @param hiddenFloat a {@code HiddenFloat}
     */
    default HType divWithFloat(HiddenFloat hiddenFloat) {
        return HTypeFactory.createHiddenNull();
    }

    /**
     * To use double dispatch in {@code div}
     * @param hiddenInt a {@code HiddenInt}
     */
    default HType divWithInt(HiddenInt hiddenInt) {
        return HTypeFactory.createHiddenNull();
    }

    /**
     * To use double dispatch in {@code mult}
     * @param hiddenBinary a {@code HiddenBinary}
     */
    default HType multWithBinary(HiddenBinary hiddenBinary) {
        return HTypeFactory.createHiddenNull();
    }

    /**
     * To use double dispatch in {@code mult}
     * @param hiddenFloat a {@code HiddenFloat}
     */
    default HType multWithFloat(HiddenFloat hiddenFloat) {
        return HTypeFactory.createHiddenNull();
    }

    /**
     * To use double dispatch in {@code mult}
     * @param hiddenInt a {@code HiddenInt}
     */
    default HType multWithInt(HiddenInt hiddenInt) {
        return HTypeFactory.createHiddenNull();
    }

    /**
     * To use double dispatch in {@code sub}
     * @param hiddenBinary a {@code HiddenBinary}
     */
    default HType subWithBinary(HiddenBinary hiddenBinary) {
        return HTypeFactory.createHiddenNull();
    }

    /**
     * To use double dispatch in {@code sub}
     * @param hiddenFloat a {@code HiddenFloat}
     */
    default HType subWithFloat(HiddenFloat hiddenFloat) {
        return HTypeFactory.createHiddenNull();
    }

    /**
     * To use double dispatch in {@code sub}
     * @param hiddenInt a {@code HiddenInt}
     */
    default HType subWithInt(HiddenInt hiddenInt) {
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

}
