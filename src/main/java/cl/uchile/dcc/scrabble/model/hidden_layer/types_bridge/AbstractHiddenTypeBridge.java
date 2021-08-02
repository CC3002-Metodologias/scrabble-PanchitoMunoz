package cl.uchile.dcc.scrabble.model.hidden_layer.types_bridge;

import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HType;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HiddenString;

/**
 * Abstract class for a general Type Bridge.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/07/13 17:43
 */
public abstract class AbstractHiddenTypeBridge implements HiddenTypeBridge {

    private final HType value;

    /**
     * Constructor.
     * @param value an {@code HType}
     */
    protected AbstractHiddenTypeBridge(HType value) {
        this.value = value;
    }

    /**
     * Returns the value in the bridge
     * @return the value in the bridge
     */
    @Override
    public HType getValue() {
        return value;
    }

    /**
     * Gets the value as String
     * @return the value as String
     */
    public final String getValueAsString() {
        return this.getValue().getValueAsString();
    }

    /**
     * To use double dispatch in {@code add}
     *
     * @param hiddenString a {@code HiddenString}
     */
    @Override
    public HiddenString addWithString(HiddenString hiddenString) {
        String computed = hiddenString.getValueAsString() + this.getValueAsString();
        return new HiddenString(computed);
    }
}
