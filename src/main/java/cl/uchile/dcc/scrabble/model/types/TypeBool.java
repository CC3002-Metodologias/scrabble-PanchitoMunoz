package cl.uchile.dcc.scrabble.model.types;

import java.util.Objects;

/**
 * A class for the boolean type.
 * @author Francisco Muñoz Guajardo
 */
public class TypeBool extends AbstractType {
    private final boolean value;

    /**
     * Constructor for the BoolType.
     * @param value A boolean as a value.
     */
    public TypeBool(boolean value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TypeBool)) return false;
        TypeBool typeBool = (TypeBool) o;
        return Objects.equals(value, typeBool.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "TypeBool{"
                + "value=" + value
                + "}";
    }

    /**
     * Transforms the current type to a TypeString.
     *
     * @return TypeString with a value equivalent to the current type.
     */
    @Override
    public TypeString toTypeString() {
        return new TypeString(Boolean.toString(this.value));
    }

    /**
     * Transforms the current type to a TypeBool.
     *
     * @return TypeBool with a value equivalent to the current type.
     */
    public TypeBool toTypeBool() {
        return new TypeBool(this.value);
    }
}
