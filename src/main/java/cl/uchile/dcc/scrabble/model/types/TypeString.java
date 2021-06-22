package cl.uchile.dcc.scrabble.model.types;

import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HiddenString;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.interfaces.HiddenAST;
import cl.uchile.dcc.scrabble.model.types.abstract_types.AbstractType;
import cl.uchile.dcc.scrabble.model.types.interface_types.SType;
import java.util.Objects;

/**
 * A class for the string type.
 * @author Francisco Muñoz Guajardo
 */
public class TypeString extends AbstractType {
    private final String value;

    /**
     * Constructor for the TypeString.
     * @param value A String as a value.
     */
    public TypeString(String value) {
        this.value = value;
    }

    /**
     * Returns the current value of the instance.
     *
     * @return The value in the instance
     */
    public String getValue() {
        return this.value;
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
        return "TypeString{"
                + "value='" + value + "'"
                + "}";
    }

    /**
     * Transforms the current type to a TypeString.
     *
     * @return TypeString with a value equivalent to the current type.
     */
    @Override
    public TypeString toTypeString() {
        return createString(this.value);
    }

    /**
     * Method that returns the sum between a TypeString and another type.
     * Returns the dominant type if possible.
     * @param otherType Another type that will be added to the current type.
     * @return The sum between the two types, returning the dominant type.
     */
    public TypeString add(SType otherType) {
        return otherType.addWithString(this);
    }

    /**
     * Returns the add between the current type and a String Type.
     *
     * @param typeString A string type who will be added to the current type.
     * @return The sum between the String type and the other type.
     */
    @Override
    public TypeString addWithString(TypeString typeString) {
        return createString(typeString.value + this.value);
    }

    /**
     * Transform a {@code SType} into its equivalent {@code HType}. If the argument is a {@code
     * HType} or an {@code HiddenAST}, it does nothing.
     *
     * @return a transformation
     */
    @Override
    public HiddenAST toHiddenAST() {
        return new HiddenString(this);
    }
}
