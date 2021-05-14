package cl.uchile.dcc.scrabble.model.types;

import cl.uchile.dcc.scrabble.model.operations.IOpp;
import cl.uchile.dcc.scrabble.model.operations.and.IAndWithBinary;
import cl.uchile.dcc.scrabble.model.operations.and.IAndWithBool;
import cl.uchile.dcc.scrabble.model.operations.or.IOrWithBinary;
import cl.uchile.dcc.scrabble.model.operations.or.IOrWithBool;
import cl.uchile.dcc.scrabble.model.types.abstract_types.AbstractType;
import cl.uchile.dcc.scrabble.model.types.interface_types.SLogical;
import cl.uchile.dcc.scrabble.model.types.interface_types.SType;

import java.util.Objects;

/**
 * A class for the boolean type.
 * @author Francisco Muñoz Guajardo
 */
public class TypeBool extends AbstractType implements SLogical, IOpp, IAndWithBool, IOrWithBool, IAndWithBinary, IOrWithBinary {
    private final boolean value;

    /**
     * Constructor for the BoolType.
     * @param value A boolean as a value.
     */
    public TypeBool(boolean value) {
        this.value = value;
    }

    protected boolean getValue() {
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
        if (!(o instanceof TypeBool)) return false;
        TypeBool typeBool = (TypeBool) o;
        return Objects.equals(value, typeBool.value);
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

    /**
     * Returns the opposite of the current instance. In booleans, it is changing true for false and viceversa.
     *
     * @return The opposite of the current instance.
     */
    @Override
    public SType opposite() {
        return new TypeBool(!(this.value));
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
     * Method that returns the disjunction between the current type and the other type.
     * Returns the dominant type if possible.
     * @param otherType Another type that will be disjunct to the current type.
     * @return The disjunction between the two types, returning the dominant type.
     */
    SLogical and(IAndWithBool otherType) {
        return null;
    }

    /**
     * Method that returns the conjunction between the current type and the other type.
     * Returns the dominant type if possible.
     * @param otherType Another type that will be conjunct to the current type.
     * @return The conjunction between the two types, returning the dominant type.
     */
    SLogical or(IOrWithBool otherType) {
        return null;
    }

    /**
     * Returns the disjunction between the current type and a Bool Type.
     *
     * @param typeBool A Bool type who will be disjunct to the current type.
     * @return The disjunction between the Bool type and the other type.
     */
    @Override
    public SLogical andWithBool(TypeBool typeBool) {
        return null;
    }

    /**
     * Returns the conjunction between the current type and a Bool Type.
     *
     * @param typeBool A Bool type who will be conjunct to the current type.
     * @return The conjunction between the Bool type and the other type.
     */
    @Override
    public SLogical orWithBool(TypeBool typeBool) {
        return null;
    }

    /**
     * Returns the disjunction between the current type and a Binary Type.
     *
     * @param typeBinary A Binary type who will be disjunct to the current type.
     * @return The disjunction between the Binary type and the other type.
     */
    @Override
    public SLogical andWithBinary(TypeBinary typeBinary) {
        return null;
    }

    /**
     * Returns the conjunction between the current type and a Binary Type.
     *
     * @param typeBinary A Binary type who will be conjunct to the current type.
     * @return The conjunction between the Binary type and the other type.
     */
    @Override
    public SLogical orWithBinary(TypeBinary typeBinary) {
        return null;
    }
}
