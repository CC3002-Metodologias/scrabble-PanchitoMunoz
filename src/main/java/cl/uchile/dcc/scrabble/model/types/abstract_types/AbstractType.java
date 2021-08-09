package cl.uchile.dcc.scrabble.model.types.abstract_types;

import cl.uchile.dcc.scrabble.model.factories.types_factories.STypeFactory;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HType;
import cl.uchile.dcc.scrabble.model.types.TypeString;
import cl.uchile.dcc.scrabble.model.types.interface_types.SType;
import org.jetbrains.annotations.NotNull;

/**
 * An abstract class for the general types used.
 *
 * @author Francisco Muñoz Guajardo
 */
public abstract class AbstractType implements SType {

    private final HType adaptee;

    /**
     * Constructor by default
     * @param adaptee a {@code HType}
     */
    protected AbstractType(@NotNull HType adaptee) {
        this.adaptee = adaptee;
    }

    /**
     * Method that provides a representation of the current instance as a String.
     * @return The representation as a String.
     */
    @Override
    public final String toString() {
        return this.asHType().sTypeAsString();
    }

    /**
     * Method that determines if the object 'o' is equals to the current instance.
     * @param o Another object that is compared to the current instance.
     * @return A boolean that determines whether the current instance are equals with 'o'.
     */
    @Override
    public final boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SType)) {
            return false;
        }

        SType that = (SType) o;

        return this.asHType().equals(that.asHType());
    }

    /**
     * Method that returns the hash code of the current instance.
     * @return The hash code of the current instance.
     */
    @Override
    public final int hashCode() {
        return this.asHType().hashCode();
    }

    /**
     * Transform the current {@code SType} as a {@code HType}.
     *
     * @return a transformation
     */
    @Override
    public HType asHType() {
        return adaptee;
    }

    /**
     * Returns the value as {@code String}.
     *
     * @return the current value as {@code String}
     */
    @Override
    public final String getValueAsString() {
        return this.asHType().getValueAsString();
    }

    /**
     * Transforms the current type to a {@code TypeString}.
     *
     * @return {@code TypeString} with a value equivalent to the current type.
     */
    @Override
    public final TypeString toTypeString() {
        return STypeFactory.createTypeString(this.getValueAsString());
    }

}
