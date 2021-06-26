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
        TypeFloat typeFloat = ((SNumber) o).toTypeFloat();
        TypeFloat thisTypeFloat = this.toTypeFloat();
        return Double.compare(typeFloat.getValue(), thisTypeFloat.getValue()) == 0;
    }

    /**
     * Returns the value as {@code double}.
     *
     * @return the current value as {@code double}
     */
    abstract protected double getValueAsDouble();

    /**
     * Transforms the current type to a {@code TypeFloat}.
     *
     * @return {@code TypeFloat} with a value equivalent to the current type.
     */
    @Override
    public TypeFloat toTypeFloat() {
        return STypeFactory.createTypeFloat(this.getValueAsDouble());
    }
}
