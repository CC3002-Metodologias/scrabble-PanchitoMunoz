package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.types_bridge;

import cl.uchile.dcc.scrabble.model.factories.hidden_factories.HTypeFactory;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HiddenFloat;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.interfaces.HBool;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.interfaces.HNumber;

/**
 * Abstract class for a general Number Bridge.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/07/20 0:23
 */
public abstract class AbstractHiddenNumberBridge extends AbstractHiddenTypeBridge {

    /**
     * Constructor.
     *
     * @param value an {@code HType}
     */
    protected AbstractHiddenNumberBridge(
        HNumber value) {
        super(value);
    }

    /**
     * Returns the value in the bridge
     *
     * @return the value in the bridge
     */
    @Override
    public HNumber getValue() {
        return (HNumber) super.getValue();
    }

    /**
     * Gets the value as Double
     *
     * @return the value as Double
     */
    public double getValueAsDouble() {
        return this.getValue().getValueAsDouble();
    }

    /**
     * To use double dispatch in {@code add}
     * @param hiddenFloat a {@code HiddenFloat}
     */
    @Override
    public final HiddenFloat addWithFloat(HiddenFloat hiddenFloat) {
        double computed = hiddenFloat.getValueAsDouble() + this.getValueAsDouble();
        return HTypeFactory.createHiddenFloat(computed);
    }

    /**
     * To use double dispatch in {@code sub}
     * @param hiddenFloat a {@code HiddenFloat}
     */
    @Override
    public final HiddenFloat subWithFloat(HiddenFloat hiddenFloat) {
        double computed = hiddenFloat.getValueAsDouble() - this.getValueAsDouble();
        return HTypeFactory.createHiddenFloat(computed);
    }

    /**
     * To use double dispatch in {@code mult}
     * @param hiddenFloat a {@code HiddenFloat}
     */
    @Override
    public final HiddenFloat multWithFloat(HiddenFloat hiddenFloat) {
        double computed = hiddenFloat.getValueAsDouble() * this.getValueAsDouble();
        return HTypeFactory.createHiddenFloat(computed);
    }

    /**
     * To use double dispatch in {@code div}
     * @param hiddenFloat a {@code HiddenFloat}
     */
    @Override
    public final HiddenFloat divWithFloat(HiddenFloat hiddenFloat) {
        if (this.getValueAsDouble() == 0) {
            return HTypeFactory.createHiddenFloat(0.0);
        }
        double computed = hiddenFloat.getValueAsDouble() / this.getValueAsDouble();
        return HTypeFactory.createHiddenFloat(computed);
    }

    /**
     * To use double dispatch in {@code equals}
     *
     * @param hNumber a {@code HNumber}
     */
    @Override
    public HBool equalsWithNumber(HNumber hNumber) {
        return HTypeFactory.createHiddenBool(hNumber.compareTo(getValue()) == 0);
    }

    /**
     * To use double dispatch in {@code equals}
     *
     * @param hNumber a {@code HNumber}
     */
    @Override
    public HBool greaterEqualsWithNumber(HNumber hNumber) {
        return HTypeFactory.createHiddenBool(hNumber.compareTo(getValue()) >= 0);
    }

    /**
     * To use double dispatch in {@code equals}
     *
     * @param hNumber a {@code HNumber}
     */
    @Override
    public HBool greaterThanWithNumber(HNumber hNumber) {
        return HTypeFactory.createHiddenBool(hNumber.compareTo(getValue()) > 0);
    }

    /**
     * To use double dispatch in {@code equals}
     *
     * @param hNumber a {@code HNumber}
     */
    @Override
    public HBool lowerEqualsWithNumber(HNumber hNumber) {
        return HTypeFactory.createHiddenBool(hNumber.compareTo(getValue()) <= 0);
    }

    /**
     * To use double dispatch in {@code equals}
     *
     * @param hNumber a {@code HNumber}
     */
    @Override
    public HBool lowerThanWithNumber(HNumber hNumber) {
        return HTypeFactory.createHiddenBool(hNumber.compareTo(getValue()) < 0);
    }
}
