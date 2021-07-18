package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.types_bridge;

import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HiddenNull;

/**
 * todo: doc
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/07/13 18:19
 */
public class HiddenNullBridge extends AbstractHiddenTypeBridge {

    /**
     * Constructor.
     *
     * @param value an {@code HType}
     */
    public HiddenNullBridge(
        HiddenNull value) {
        super(value);
    }

    /**
     * Returns the value in the visitor
     *
     * @return the value in the visitor
     */
    @Override
    public HiddenNull getValue() {
        return (HiddenNull) super.getValue();
    }
}
