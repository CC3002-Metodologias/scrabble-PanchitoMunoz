package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.abstract_types;

import cl.uchile.dcc.scrabble.model.types.interface_types.SNumber;
import cl.uchile.dcc.scrabble.model.types.interface_types.SType;

/**
 * todo:doc
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/07/13 15:31
 */
public abstract class AbstractHiddenNumber extends AbstractHiddenType {

    /**
     * Constructor
     *
     * @param adaptee a {@code SType}
     */
    protected AbstractHiddenNumber(SNumber adaptee) {
        super(adaptee);
    }

    /**
     * Gets the current instance in the wrapper
     *
     * @return the instance in the wrapper
     */
    @Override
    public abstract SNumber asSType();

    /**
     * Get value as double
     * @return Get value as double
     */
    public double getValueAsDouble() {
        return this.asSType().getValueAsDouble();
    }
}
