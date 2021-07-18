package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.types_bridge;

import cl.uchile.dcc.scrabble.model.factories.hidden_factories.HTypeFactory;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HType;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HiddenFloat;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HiddenInt;
import cl.uchile.dcc.scrabble.model.types.TypeFloat;

/**
 * todo: doc
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/07/13 18:18
 */
public class HiddenFloatBridge extends AbstractHiddenTypeBridge {

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
     * Returns the value in the visitor
     *
     * @return the value in the visitor
     */
    @Override
    public HiddenFloat getValue() {
        return (HiddenFloat) super.getValue();
    }

    /**
     * To use double dispatch in {@code add}
     * @param hiddenFloat a {@code HiddenFloat}
     */
    @Override
    public HType addWithFloat(HiddenFloat hiddenFloat) {
        TypeFloat computed = this.getValue().asSType().addWithFloat(hiddenFloat.asSType());
        return HTypeFactory.createHiddenFloat(computed);
    }

    /**
     * To use double dispatch in {@code add}
     * @param hiddenInt a {@code HiddenInt}
     */
    @Override
    public HType addWithInt(HiddenInt hiddenInt) {
        TypeFloat computed = this.getValue().asSType().addWithInt(hiddenInt.asSType());
        return HTypeFactory.createHiddenFloat(computed);
    }

    /**
     * To use double dispatch in {@code sub}
     * @param hiddenFloat a {@code HiddenFloat}
     */
    @Override
    public HType subWithFloat(HiddenFloat hiddenFloat) {
        TypeFloat computed = this.getValue().asSType().subWithFloat(hiddenFloat.asSType());
        return HTypeFactory.createHiddenFloat(computed);
    }

    /**
     * To use double dispatch in {@code sub}
     *
     *
     * @param hiddenInt a {@code HiddenInt}
     */
    @Override
    public HType subWithInt(HiddenInt hiddenInt) {
        TypeFloat computed = this.getValue().asSType().subWithInt(hiddenInt.asSType());
        return HTypeFactory.createHiddenFloat(computed);
    }

    /**
     * To use double dispatch in {@code mult}
     *
     *
     * @param hiddenFloat a {@code HiddenFloat}
     */
    @Override
    public HType multWithFloat(HiddenFloat hiddenFloat) {
        TypeFloat computed = this.getValue().asSType().multWithFloat(hiddenFloat.asSType());
        return HTypeFactory.createHiddenFloat(computed);
    }

    /**
     * To use double dispatch in {@code mult}
     *
     *
     * @param hiddenInt a {@code HiddenInt}
     */
    @Override
    public HType multWithInt(HiddenInt hiddenInt) {
        TypeFloat computed = this.getValue().asSType().multWithInt(hiddenInt.asSType());
        return HTypeFactory.createHiddenFloat(computed);
    }

    /**
     * To use double dispatch in {@code div}
     *
     *
     * @param hiddenFloat a {@code HiddenFloat}
     */
    @Override
    public HType divWithFloat(HiddenFloat hiddenFloat) {
        TypeFloat computed = this.getValue().asSType().divWithFloat(hiddenFloat.asSType());
        return HTypeFactory.createHiddenFloat(computed);
    }

    /**
     * To use double dispatch in {@code div}
     *
     *
     * @param hiddenInt a {@code HiddenInt}
     */
    @Override
    public HType divWithInt(HiddenInt hiddenInt) {
        TypeFloat computed = this.getValue().asSType().divWithInt(hiddenInt.asSType());
        return HTypeFactory.createHiddenFloat(computed);
    }
}
