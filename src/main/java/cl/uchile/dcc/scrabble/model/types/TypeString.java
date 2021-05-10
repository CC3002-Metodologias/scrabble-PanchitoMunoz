package cl.uchile.dcc.scrabble.model.types;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TypeString)) return false;
        TypeString that = (TypeString) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "TypeString{"
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
        return new TypeString(this.value);
    }
}
