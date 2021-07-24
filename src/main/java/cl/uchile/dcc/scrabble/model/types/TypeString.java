package cl.uchile.dcc.scrabble.model.types;

import cl.uchile.dcc.scrabble.model.builders.interfaces.StringASTBuilder;
import cl.uchile.dcc.scrabble.model.factories.hidden_factories.HTypeFactory;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HiddenString;
import cl.uchile.dcc.scrabble.model.types.abstract_types.AbstractType;
import cl.uchile.dcc.scrabble.model.types.interface_types.SType;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

/**
 * A class for the string type.
 * @author Francisco Muñoz Guajardo
 */
public class TypeString extends AbstractType implements StringASTBuilder {

    private final String value;
    private final HiddenString adaptee;

    /**
     * Constructor for the TypeString.
     * @param value A String as a value.
     */
    public TypeString(String value) {
        this.value = value;
        this.adaptee = HTypeFactory.createHiddenString(value);
    }

    /**
     * Returns the current value of the instance.
     *
     * @return The value in the instance
     */
    public String getValue() {
        return this.asHType().getValueAsString();
    }

    /**
     * Method that determines if the object 'o' is equals to the current instance.
     * @param o Another object that is compared to the current instance.
     * @return A boolean that determines whether the current instance are equals with 'o'.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TypeString)) return false;
        TypeString that = (TypeString) o;
        return Objects.equals(value, that.value);
    }

    /**
     * Method that returns the hash code of the current instance.
     * @return The hash code of the current instance.
     */
    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    /**
     * Method that provides a representation of the current instance as a String.
     * @return The representation as a String.
     */
    @Override
    public String toString() {
        return this.asHType().sTypeAsString();
    }

    /**
     * Returns the value as {@code String}.
     *
     * @return the current value as {@code String}
     */
    @Override
    public String getValueAsString() {
        return this.asHType().getValueAsString();
    }

    /**
     * Method that returns the sum between a TypeString and another type.
     * Returns the dominant type if possible.
     * @param otherType Another type that will be added to the current type.
     * @return The sum between the two types, returning the dominant type.
     */
    public TypeString add(@NotNull SType otherType) {
        return this.asHType().add(otherType.asHType()).asTypeString();
    }

    /**
     * Transform the current {@code SType} as a {@code HType}.
     *
     * @return a transformation
     */
    @Override
    public HiddenString asHType() {
        return adaptee;
    }
}
