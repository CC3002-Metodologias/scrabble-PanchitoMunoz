package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.types_bridge;

import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HiddenString;

/**
 * todo: doc
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
     * Returns the value in the visitor
     *
     * @return the value in the visitor
     */
    @Override
    public HiddenString getValue() {
        return (HiddenString) super.getValue();
    }
}
