package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.abstract_types;

import cl.uchile.dcc.scrabble.model.factories.hidden_factories.HTypeFactory;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HType;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.interfaces.HNumber;
import cl.uchile.dcc.scrabble.model.types.interface_types.SNumber;

/**
 * todo:doc
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/07/13 15:31
 */
public abstract class AbstractHiddenNumber extends AbstractHiddenType implements HNumber {

    private final double valueAsDouble;

    /**
     * Constructor.
     *
     * @param valueAsDouble a value as double
     */
    protected AbstractHiddenNumber(double valueAsDouble) {
        this.valueAsDouble = valueAsDouble;
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
     *
     * @return Get value as double
     */
    public double getValueAsDouble() {
        return this.valueAsDouble;
    }

    /**
     * Transform the current instance to a {@code HiddenFloat}.
     *
     * @return a {@code HiddenFloat} equivalent
     */
    @Override
    public final HType toHiddenFloat() {
        double computed = this.getValueAsDouble();
        return HTypeFactory.createHiddenFloat(computed);
    }
}
