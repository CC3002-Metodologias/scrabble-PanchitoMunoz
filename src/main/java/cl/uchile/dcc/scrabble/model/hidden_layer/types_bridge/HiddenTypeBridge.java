package cl.uchile.dcc.scrabble.model.hidden_layer.types_bridge;

import cl.uchile.dcc.scrabble.model.exceptions.ZeroDivisionException;
import cl.uchile.dcc.scrabble.model.factories.hidden_factories.HTypeFactory;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HType;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HiddenBinary;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HiddenBool;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HiddenFloat;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HiddenInt;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HiddenString;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.interfaces.HBinary;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.interfaces.HBool;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.interfaces.HFloat;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.interfaces.HLogical;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.interfaces.HNumber;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.interfaces.HString;

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
    HString addWithString(HiddenString hiddenString);

    /**
     * To use double dispatch in {@code add}
     *
     * @param hiddenBinary a {@code HiddenBinary}
     */
    default HBinary addWithBinary(HiddenBinary hiddenBinary) {
        return HTypeFactory.createHiddenNull();
    }

    /**
     * To use double dispatch in {@code add}
     *
     * @param hiddenFloat a {@code HiddenFloat}
     */
    default HFloat addWithFloat(HiddenFloat hiddenFloat) {
        return HTypeFactory.createHiddenNull();
    }

    /**
     * To use double dispatch in {@code add}
     *
     * @param hiddenInt a {@code HiddenInt}
     */
    default HNumber addWithInt(HiddenInt hiddenInt) {
        return HTypeFactory.createHiddenNull();
    }

    /**
     * To use double dispatch in {@code div}
     *
     * @param hiddenBinary a {@code HiddenBinary}
     */
    default HBinary divWithBinary(HiddenBinary hiddenBinary) throws ZeroDivisionException {
        return HTypeFactory.createHiddenNull();
    }

    /**
     * To use double dispatch in {@code div}
     *
     * @param hiddenFloat a {@code HiddenFloat}
     */
    default HFloat divWithFloat(HiddenFloat hiddenFloat) throws ZeroDivisionException {
        return HTypeFactory.createHiddenNull();
    }

    /**
     * To use double dispatch in {@code div}
     *
     * @param hiddenInt a {@code HiddenInt}
     */
    default HNumber divWithInt(HiddenInt hiddenInt) throws ZeroDivisionException {
        return HTypeFactory.createHiddenNull();
    }

    /**
     * To use double dispatch in {@code mult}
     *
     * @param hiddenBinary a {@code HiddenBinary}
     */
    default HBinary multWithBinary(HiddenBinary hiddenBinary) {
        return HTypeFactory.createHiddenNull();
    }

    /**
     * To use double dispatch in {@code mult}
     *
     * @param hiddenFloat a {@code HiddenFloat}
     */
    default HFloat multWithFloat(HiddenFloat hiddenFloat) {
        return HTypeFactory.createHiddenNull();
    }

    /**
     * To use double dispatch in {@code mult}
     *
     * @param hiddenInt a {@code HiddenInt}
     */
    default HNumber multWithInt(HiddenInt hiddenInt) {
        return HTypeFactory.createHiddenNull();
    }

    /**
     * To use double dispatch in {@code sub}
     *
     * @param hiddenBinary a {@code HiddenBinary}
     */
    default HBinary subWithBinary(HiddenBinary hiddenBinary) {
        return HTypeFactory.createHiddenNull();
    }

    /**
     * To use double dispatch in {@code sub}
     *
     * @param hiddenFloat a {@code HiddenFloat}
     */
    default HFloat subWithFloat(HiddenFloat hiddenFloat) {
        return HTypeFactory.createHiddenNull();
    }

    /**
     * To use double dispatch in {@code sub}
     *
     * @param hiddenInt a {@code HiddenInt}
     */
    default HNumber subWithInt(HiddenInt hiddenInt) {
        return HTypeFactory.createHiddenNull();
    }

    /**
     * To use double dispatch in {@code and}
     *
     * @param hiddenBool a {@code HiddenBool}
     */
    default HLogical andWithBool(HiddenBool hiddenBool) {
        return HTypeFactory.createHiddenNull();
    }

    /**
     * To use double dispatch in {@code and}
     *
     * @param hiddenBinary a {@code HiddenBinary}
     */
    default HBinary andWithBinary(HiddenBinary hiddenBinary) {
        return HTypeFactory.createHiddenNull();
    }

    /**
     * To use double dispatch in {@code or}
     *
     * @param hiddenBool a {@code HiddenBool}
     */
    default HLogical orWithBool(HiddenBool hiddenBool) {
        return HTypeFactory.createHiddenNull();
    }

    /**
     * To use double dispatch in {@code or}
     *
     * @param hiddenBinary a {@code HiddenBinary}
     */
    default HBinary orWithBinary(HiddenBinary hiddenBinary) {
        return HTypeFactory.createHiddenNull();
    }

    /**
     * To use double dispatch in {@code equals}
     *
     * @param hNumber a {@code HNumber}
     */
    default HBool equalsWithNumber(HNumber hNumber) {
        return HTypeFactory.createHiddenNull();
    }

    /**
     * To use double dispatch in {@code equals}
     *
     * @param hNumber a {@code HNumber}
     */
    default HBool greaterEqualsWithNumber(HNumber hNumber) {
        return HTypeFactory.createHiddenNull();
    }

    /**
     * To use double dispatch in {@code equals}
     *
     * @param hNumber a {@code HNumber}
     */
    default HBool greaterThanWithNumber(HNumber hNumber) {
        return HTypeFactory.createHiddenNull();
    }

    /**
     * To use double dispatch in {@code equals}
     *
     * @param hNumber a {@code HNumber}
     */
    default HBool lowerEqualsWithNumber(HNumber hNumber) {
        return HTypeFactory.createHiddenNull();
    }

    /**
     * To use double dispatch in {@code equals}
     *
     * @param hNumber a {@code HNumber}
     */
    default HBool lowerThanWithNumber(HNumber hNumber) {
        return HTypeFactory.createHiddenNull();
    }

}
