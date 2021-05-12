package cl.uchile.dcc.scrabble.model.types;

import cl.uchile.dcc.scrabble.model.operations.IOpp;

import java.util.Objects;

import static cl.uchile.dcc.scrabble.model.utils.BinaryUtilities.*;

/**
 * A class for the binary type.
 * @author Francisco Muñoz Guajardo
 */
public class TypeBinary extends AbstractInteger {
    private final String value;

    /**
     * Constructor for the TypeBinary.
     * @param value A String as a value.
     */
    public TypeBinary(String value) {
        this.value = value;
    }

    protected String getValue() {
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
        if (!(o instanceof TypeBinary)) return false;
        TypeBinary that = (TypeBinary) o;
        return Objects.equals(binaryToInt(value), binaryToInt(that.value));
    }

    /**
     * Method that returns the hash code of the current instance.
     * @return The hash code of the current instance.
     */
    @Override
    public int hashCode() {
        return Objects.hash(binaryToInt(value));
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

    /**
     * Returns the add between the current type and a String Type.
     *
     * @param typeString A string type who will be added to the current type.
     * @return The sum between the String type and the other type.
     */
    @Override
    public TypeString addWithString(TypeString typeString) {
        return new TypeString(typeString.getValue() + this.value);
    }

    /**
     * Returns the add between the current type and an Int Type.
     *
     * @param typeInt An Int type who will be added to the current type.
     * @return The sum between the Int type and the other type.
     */
    @Override
    public IType addWithInt(TypeInt typeInt) {
        return new TypeInt(typeInt.getValue() + binaryToInt(this.value));
    }

    /**
     * Returns the add between the current type and a Float Type.
     *
     * @param typeFloat A Float type who will be added to the current type.
     * @return The sum between the Float type and the other type.
     */
    @Override
    public IType addWithFloat(TypeFloat typeFloat) {
        return new TypeFloat(typeFloat.getValue() + binaryToInt(this.value));
    }
}
