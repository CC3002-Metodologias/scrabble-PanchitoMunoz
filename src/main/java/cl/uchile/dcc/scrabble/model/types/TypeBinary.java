package cl.uchile.dcc.scrabble.model.types;

import cl.uchile.dcc.scrabble.model.operations.IOpp;

import java.util.Objects;

import static cl.uchile.dcc.scrabble.model.utils.BinaryUtilities.*;

/**
 * A class for the binary type.
 * @author Francisco Muñoz Guajardo
 */
public class TypeBinary extends AbstractInteger implements IOpp {
    private final String value;

    /**
     * Constructor for the TypeBinary.
     * @param value A String as a value.
     */
    public TypeBinary(String value) {
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
        if (!(o instanceof TypeBinary)) return false;
        TypeBinary that = (TypeBinary) o;
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
        return "TypeBinary{" +
                "value='" + value + '\'' +
                '}';
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

    /**
     * Transforms the current type to a TypeFloat.
     *
     * @return TypeFloat with a value equivalent to the current type.
     */
    @Override
    public TypeFloat toTypeFloat() {
        return new TypeFloat(binaryToInt(this.value));
    }

    /**
     * Transforms the current type to a TypeInt.
     *
     * @return TypeInt with a value equivalent to the current type.
     */
    @Override
    public TypeInt toTypeInt() {
        return new TypeInt(binaryToInt(this.value));
    }

    /**
     * Transforms the current type to a TypeBinary.
     *
     * @return TypeBinary with a value equivalent to the current type.
     */
    @Override
    public TypeBinary toTypeBinary() {
        return new TypeBinary(this.value);
    }

    /**
     * Returns the opposite of the current instance. In binary, it is changing each 0 for 1 and each 1 for 0.
     *
     * @return The opposite of the current instance.
     */
    @Override
    public IOpp opposite() {
        return new TypeBinary(oneComplement(this.value));
    }
}
