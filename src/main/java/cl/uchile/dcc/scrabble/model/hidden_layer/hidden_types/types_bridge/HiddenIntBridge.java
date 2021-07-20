package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.types_bridge;

import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HiddenInt;

/**
 * A class to define the auxiliary methods for a Hidden Int to use double dispatch. The purpose of this class is to use Bridge Pattern.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/07/13 18:18
 */
public class HiddenIntBridge extends AbstractHiddenIntegerBridge {

    /**
     * Constructor.
     *
     * @param value an {@code HType}
     */
    public HiddenIntBridge(
        HiddenInt value) {
        super(value);
    }

    /**
     * Returns the value in the bridge
     *
     * @return the value in the bridge
     */
    @Override
    public HiddenInt getValue() {
        return (HiddenInt) super.getValue();
    }
}
