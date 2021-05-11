package cl.uchile.dcc.scrabble.model.types;

import java.util.Objects;

/**
 * A class for the float type.
 * @author Francisco Muñoz Guajardo
 */
public class TypeFloat extends AbstractNumber {
    private final double value;

    /**
     * Constructor for the TypeFloat.
     * @param value A double number as a value.
     */
    public TypeFloat(double value) {
        this.value = value;
    }

    /**
     * Method that determines if the object 'o' is equals to the current instance.
     * @param o Another object that is compared to the current instance.
     * @return A boolean that determines whether the current instance are equals with 'o'.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TypeFloat)) return false;
        TypeFloat typeFloat = (TypeFloat) o;
        return Double.compare(typeFloat.value, value) == 0;
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
        return "TypeFloat{"
                + "value=" + this.value
                + "}";
    }

    /**
     * Transforms the current type to a TypeString.
     *
     * @return TypeString with a value equivalent to the current type.
     */
    @Override
    public TypeString toTypeString() {
        return new TypeString(Double.toString(this.value));
    }

    /**
     * Transforms the current type to a TypeFloat.
     *
     * @return TypeFloat with a value equivalent to the current type.
     */
    @Override
    public TypeFloat toTypeFloat() {
        return new TypeFloat(this.value);
    }
}
