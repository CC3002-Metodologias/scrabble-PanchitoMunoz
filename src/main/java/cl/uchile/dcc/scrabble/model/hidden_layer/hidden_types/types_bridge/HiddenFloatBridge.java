package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.types_bridge;

import cl.uchile.dcc.scrabble.model.factories.hidden_factories.HTypeFactory;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HiddenFloat;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HiddenInt;

/**
 * A class to define the auxiliary methods for a Hidden Float to use double dispatch. The purpose of this class is to use Bridge Pattern.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/07/13 18:18
 */
public class HiddenFloatBridge extends AbstractHiddenNumberBridge {

    /**
     * Constructor.
     *
     * @param value an {@code HType}
     */
    public HiddenFloatBridge(
        HiddenFloat value) {
        super(value);
    }

    /**
     * Returns the value in the bridge
     *
     * @return the value in the bridge
     */
    @Override
    public HiddenFloat getValue() {
        return (HiddenFloat) super.getValue();
    }

    /**
     * To use double dispatch in {@code add}
     * @param hiddenInt a {@code HiddenInt}
     */
    @Override
    public HiddenFloat addWithInt(HiddenInt hiddenInt) {
        double computed = hiddenInt.getValueAsDouble() + this.getValueAsDouble();
        return HTypeFactory.createHiddenFloat(computed);
    }

    /**
     * To use double dispatch in {@code sub}
     *
     *
     * @param hiddenInt a {@code HiddenInt}
     */
    @Override
    public HiddenFloat subWithInt(HiddenInt hiddenInt) {
        double computed = hiddenInt.getValueAsDouble() - this.getValueAsDouble();
        return HTypeFactory.createHiddenFloat(computed);
    }

    /**
     * To use double dispatch in {@code mult}
     *
     *
     * @param hiddenInt a {@code HiddenInt}
     */
    @Override
    public HiddenFloat multWithInt(HiddenInt hiddenInt) {
        double computed = hiddenInt.getValueAsDouble() * this.getValueAsDouble();
        return HTypeFactory.createHiddenFloat(computed);
    }

    /**
     * To use double dispatch in {@code div}
     *
     *
     * @param hiddenInt a {@code HiddenInt}
     */
    @Override
    public HiddenFloat divWithInt(HiddenInt hiddenInt) {
        if (this.getValueAsDouble() == 0) {
            return HTypeFactory.createHiddenFloat(0.0);
        }
        double computed = hiddenInt.getValueAsDouble() / this.getValueAsDouble();
        return HTypeFactory.createHiddenFloat(computed);
    }
}
