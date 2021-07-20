package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.types_bridge;

import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HiddenString;

/**
 * A class to define the auxiliary methods for a Hidden String to use double dispatch. The purpose of this class is to use Bridge Pattern.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/07/13 18:19
 */
public class HiddenStringBridge extends AbstractHiddenTypeBridge {

    /**
     * Constructor.
     *
     * @param value an {@code HType}
     */
    public HiddenStringBridge(
        HiddenString value) {
        super(value);
    }

    /**
     * Returns the value in the bridge
     *
     * @return the value in the bridge
     */
    @Override
    public HiddenString getValue() {
        return (HiddenString) super.getValue();
    }
}
