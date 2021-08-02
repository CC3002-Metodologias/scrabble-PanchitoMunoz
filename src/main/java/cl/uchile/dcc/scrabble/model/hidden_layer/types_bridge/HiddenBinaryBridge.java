package cl.uchile.dcc.scrabble.model.hidden_layer.types_bridge;

import cl.uchile.dcc.scrabble.model.factories.hidden_factories.HTypeFactory;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HiddenBinary;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HiddenBool;
import cl.uchile.dcc.scrabble.model.utils.BinaryUtilities;

/**
 * A class to define the auxiliary methods for a Hidden Binary to use double dispatch. The purpose of this class is to use Bridge Pattern.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/07/13 17:46
 */
public class HiddenBinaryBridge extends AbstractHiddenIntegerBridge {

    /**
     * Constructor.
     *
     * @param value an {@code HType}
     */
    public HiddenBinaryBridge(HiddenBinary value) {
        super(value);
    }

    @Override
    public HiddenBinary getValue() {
        return (HiddenBinary) super.getValue();
    }

    /**
     * To use double dispatch in {@code and}
     * @param hiddenBool a {@code HiddenBool}
     */
    @Override
    public HiddenBinary andWithBool(HiddenBool hiddenBool) {
        String computed = BinaryUtilities.boolAndBinary(
            hiddenBool.getValueAsBool(), this.getValueAsBinary());
        return HTypeFactory.createHiddenBinary(computed);
    }

    /**
     * To use double dispatch in {@code and}
     * @param hiddenBinary a {@code HiddenBinary}
     */
    @Override
    public HiddenBinary andWithBinary(HiddenBinary hiddenBinary) {
        String computed = BinaryUtilities.binaryAndBinary(
            hiddenBinary.getValueAsBinary(), this.getValueAsBinary());
        return HTypeFactory.createHiddenBinary(computed);
    }

    /**
     * To use double dispatch in {@code or}
     * @param hiddenBool a {@code HiddenBool}
     */
    @Override
    public HiddenBinary orWithBool(HiddenBool hiddenBool) {
        String computed = BinaryUtilities.boolOrBinary(
            hiddenBool.getValueAsBool(), this.getValueAsBinary());
        return HTypeFactory.createHiddenBinary(computed);
    }

    /**
     * To use double dispatch in {@code or}
     * @param hiddenBinary a {@code HiddenBinary}
     */
    @Override
    public HiddenBinary orWithBinary(HiddenBinary hiddenBinary) {
        String computed = BinaryUtilities.binaryOrBinary(
            hiddenBinary.getValueAsBinary(), this.getValueAsBinary());
        return HTypeFactory.createHiddenBinary(computed);
    }
}
