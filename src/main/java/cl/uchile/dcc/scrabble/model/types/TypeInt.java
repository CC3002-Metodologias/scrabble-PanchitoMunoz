package cl.uchile.dcc.scrabble.model.types;

import java.util.Objects;

/**
 * A class for the integer type.
 * @author Francisco Muñoz Guajardo
 */
public class TypeInt extends AbstractNumber {
    private final int value;

    public TypeInt(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TypeInt)) return false;
        TypeInt typeInt = (TypeInt) o;
        return value == typeInt.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "TypeInt{" +
                "value=" + value +
                '}';
    }

    /**
     * Transforms the current type to a TypeString.
     *
     * @return TypeString with a value equivalent to the current type.
     */
    @Override
    public TypeString toTypeString() {
        return new TypeString(Integer.toString(this.value));
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

    /**
     * Transforms the current type to a TypeInt.
     *
     * @return TypeInt with a value equivalent to the current type.
     */
    public TypeInt toTypeInt() {
        return new TypeInt(this.value);
    }

    /**
     * Transforms the current type to a TypeBinary.
     *
     * @return TypeBinary with a value equivalent to the current type.
     */
    public TypeBinary toTypeBinary() {
        System.out.println("Estoy haciendo la representacion de un int como binario :)");
        return null;
    }
}
