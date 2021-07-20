package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.abstract_types;

import cl.uchile.dcc.scrabble.model.factories.hidden_factories.HTypeFactory;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HType;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.interfaces.HNumber;

/**
 * An abstract class for a general Number.
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
        return HTypeFactory.createHiddenFloat(this.getValueAsDouble());
    }
}
