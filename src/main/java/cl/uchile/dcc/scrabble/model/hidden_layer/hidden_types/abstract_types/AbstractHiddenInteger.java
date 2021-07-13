package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.abstract_types;

import cl.uchile.dcc.scrabble.model.types.interface_types.SInteger;
import cl.uchile.dcc.scrabble.model.types.interface_types.SNumber;
import cl.uchile.dcc.scrabble.model.types.interface_types.SType;

/**
 * todo: doc
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/07/13 15:33
 */
public abstract class AbstractHiddenInteger extends AbstractHiddenNumber {

    /**
     * Constructor
     *
     * @param adaptee a {@code SType}
     */
    protected AbstractHiddenInteger(
        SNumber adaptee) {
        super(adaptee);
    }

    /**
     * Gets the current instance in the wrapper
     *
     * @return the instance in the wrapper
     */
    @Override
    public abstract SInteger asSType();

    /**
     * Value as Int
     * @return Value as Int
     */
    public Integer getValueAsInt() {
        return this.asSType().getValueAsInt();
    }

    /**
     * Value as Binary
     * @return Value as Binary
     */
    public String getValueAsBinary() {
        return this.asSType().getValueAsBinary();
    }
}
