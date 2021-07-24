package cl.uchile.dcc.scrabble.model.types.abstract_types;

import cl.uchile.dcc.scrabble.model.factories.types_factories.STypeFactory;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.interfaces.HNumber;
import cl.uchile.dcc.scrabble.model.types.TypeFloat;
import cl.uchile.dcc.scrabble.model.types.interface_types.SNumber;

/**
 * An abstract class for the general numbers used.
 *
 * @author Francisco Muñoz Guajardo
 */
public abstract class AbstractNumber extends AbstractType implements SNumber {

    public AbstractNumber(HNumber adaptee) {
        super(adaptee);
    }

    /**
     * Transform the current {@code SType} as a {@code HType}.
     *
     * @return a transformation
     */
    @Override
    public HNumber asHType() {
        return (HNumber) super.asHType();
    }

    /**
     * Returns the value as {@code double}.
     *
     * @return the current value as {@code double}
     */
    @Override
    public final double getValueAsDouble() {
        return this.asHType().getValueAsDouble();
    }

    /**
     * Transforms the current type to a {@code TypeFloat}.
     *
     * @return {@code TypeFloat} with a value equivalent to the current type.
     */
    @Override
    public final TypeFloat toTypeFloat() {
        return STypeFactory.createTypeFloat(this.getValueAsDouble());
    }
}
