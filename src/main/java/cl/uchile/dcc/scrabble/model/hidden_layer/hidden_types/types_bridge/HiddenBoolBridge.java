package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.types_bridge;

import cl.uchile.dcc.scrabble.model.factories.hidden_factories.HTypeFactory;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HiddenBinary;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HiddenBool;
import cl.uchile.dcc.scrabble.model.utils.BinaryUtilities;

/**
 * A class to define the auxiliary methods for a Hidden Bool to use double dispatch. The purpose of this class is to use Bridge Pattern.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/07/13 18:11
 */
public class HiddenBoolBridge extends AbstractHiddenTypeBridge {

    /**
     * Constructor.
     *
     * @param value an {@code HType}
     */
    public HiddenBoolBridge(
        HiddenBool value) {
        super(value);
    }

    /**
     * Returns the value in the bridge
     *
     * @return the value in the bridge
     */
    @Override
    public HiddenBool getValue() {
        return (HiddenBool) super.getValue();
    }

    /**
     * Gets the value as bool
     * @return the value as bool
     */
    public boolean getValueAsBool() {
        return this.getValue().getValueAsBool();
    }

    /**
     * To use double dispatch in {@code and}
     * @param hiddenBool a {@code HiddenBool}
     */
    @Override
    public HiddenBool andWithBool(HiddenBool hiddenBool) {
        boolean computed = hiddenBool.getValueAsBool() && this.getValueAsBool();
        return HTypeFactory.createHiddenBool(computed);
    }

    /**
     * To use double dispatch in {@code and}
     *
     *
     * @param hiddenBinary a {@code HiddenBinary}
     */
    @Override
    public HiddenBinary andWithBinary(HiddenBinary hiddenBinary) {
        String computed = BinaryUtilities.boolAndBinary(
            this.getValueAsBool(), hiddenBinary.getValueAsBinary());
        return HTypeFactory.createHiddenBinary(computed);
    }

    /**
     * To use double dispatch in {@code or}
     *
     *
     * @param hiddenBool a {@code HiddenBool}
     */
    @Override
    public HiddenBool orWithBool(HiddenBool hiddenBool) {
        boolean computed = hiddenBool.getValueAsBool() || this.getValueAsBool();
        return HTypeFactory.createHiddenBool(computed);
    }

    /**
     * To use double dispatch in {@code or}
     *
     *
     * @param hiddenBinary a {@code HiddenBinary}
     */
    @Override
    public HiddenBinary orWithBinary(HiddenBinary hiddenBinary) {
        String computed = BinaryUtilities.boolOrBinary(
            this.getValueAsBool(), hiddenBinary.getValueAsBinary());
        return HTypeFactory.createHiddenBinary(computed);
    }
}
