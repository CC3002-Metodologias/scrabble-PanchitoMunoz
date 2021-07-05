package cl.uchile.dcc.scrabble.model.types.abstract_types;

import cl.uchile.dcc.scrabble.model.factories.types_factories.STypeFactory;
import cl.uchile.dcc.scrabble.model.types.TypeFloat;
import cl.uchile.dcc.scrabble.model.types.interface_types.SNumber;

/**
 * An abstract class for the general numbers used.
 * @author Francisco Muñoz Guajardo
 */
public abstract class AbstractNumber extends AbstractType implements SNumber {

    /**
     * Method that determines if the object 'o' is equals to the current instance.
     *
     * @param o Another object that is compared to the current instance.
     * @return A boolean that determines whether the current instance are equals with 'o'.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SNumber)) {
            return false;
        }
        SNumber that = (SNumber) o;
        return Double.compare(this.getValueAsDouble(), that.getValueAsDouble()) == 0;
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
