package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.types_bridge;

import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HType;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HiddenString;
import cl.uchile.dcc.scrabble.model.types.TypeString;

/**
 * An abstract class for the Type Visitors.
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
     * Returns the value in the visitor
     * @return the value in the visitor
     */
    @Override
    public HType getValue() {
        return value;
    }

    /**
     * To use double dispatch in {@code add}
     * @param hiddenString a {@code HiddenString}
     */
    @Override
    public HType addWithString(HiddenString hiddenString) {
        TypeString computed = this.getValue().asSType().addWithString(
            hiddenString.asSType());
        return new HiddenString(computed);
    }
}
