package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.operation_visitor;

import cl.uchile.dcc.scrabble.model.factories.hidden_factories.HTypeFactory;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HType;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HiddenBinary;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HiddenBool;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HiddenFloat;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HiddenInt;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HiddenNull;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HiddenString;

/**
 * An interface for a general Operation Visitor
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/07/13 15:08
 */
public interface HiddenOperationVisitor {

    /**
     * To use double dispatch. Operates with a {@code HiddenBinary}
     * @param hiddenBinary a {@code HiddenBinary}
     * @return a {@code HType} operated
     */
    default HType operateWithBinary(HiddenBinary hiddenBinary) {
        return HTypeFactory.createHiddenNull();
    }

    /**
     * To use double dispatch. Operates with a {@code HiddenBool}
     * @param hiddenBool a {@code HiddenBool}
     * @return a {@code HType} operated
     */
    default HType operateWithBool(HiddenBool hiddenBool) {
        return HTypeFactory.createHiddenNull();
    }

    /**
     * To use double dispatch. Operates with a {@code HiddenFloat}
     * @param hiddenFloat a {@code HiddenFloat}
     * @return a {@code HType} operated
     */
    default HType operateWithFloat(HiddenFloat hiddenFloat) {
        return HTypeFactory.createHiddenNull();
    }

    /**
     * To use double dispatch. Operates with a {@code HiddenInt}
     * @param hiddenInt a {@code HiddenInt}
     * @return a {@code HType} operated
     */
    default HType operateWithInt(HiddenInt hiddenInt) {
        return HTypeFactory.createHiddenNull();
    }

    /**
     * To use double dispatch. Operates with a {@code HiddenString}
     * @param hiddenString a {@code HiddenString}
     * @return a {@code HType} operated
     */
    default HType operateWithString(HiddenString hiddenString) {
        return HTypeFactory.createHiddenNull();
    }

    /**
     * To use double dispatch. Operates with a {@code HiddenNull}
     * @param hiddenNull a {@code HiddenNull}
     * @return a {@code HType} operated
     */
    default HType operateWithNull(HiddenNull hiddenNull) {
        return HTypeFactory.createHiddenNull();
    }

}
