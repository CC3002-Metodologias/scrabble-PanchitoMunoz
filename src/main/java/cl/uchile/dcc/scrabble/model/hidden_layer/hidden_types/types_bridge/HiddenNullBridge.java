package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.types_bridge;

import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HiddenNull;

/**
 * A class to define the auxiliary methods for a Hidden Null to use double dispatch. The purpose of this class is to use Bridge Pattern.
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
}
