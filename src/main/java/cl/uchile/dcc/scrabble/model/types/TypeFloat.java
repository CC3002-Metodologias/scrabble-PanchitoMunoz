package cl.uchile.dcc.scrabble.model.types;

import cl.uchile.dcc.scrabble.model.operations.add.IAddWithFloat;
import cl.uchile.dcc.scrabble.model.operations.division.IDivWithFloat;
import cl.uchile.dcc.scrabble.model.operations.multiplication.IMultWithFloat;
import cl.uchile.dcc.scrabble.model.operations.subtraction.ISubWithFloat;
import cl.uchile.dcc.scrabble.model.types.abstract_types.AbstractNumber;
import cl.uchile.dcc.scrabble.model.types.interface_types.SNumber;
import cl.uchile.dcc.scrabble.model.types.interface_types.SType;

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

    protected double getValue() {
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

    /**
     * Returns the negative of the current instance.
     *
     * @return The opposite of the current instance.
     */
    @Override
    public SType opposite() {
        return new TypeFloat(-this.value);
    }

    /**
     * Method that returns the sum between a TypeFloat and another type.
     * Returns the dominant type if possible, or throws an error if the operation is undefined.
     * @param otherType Another type that will be added to the current type.
     * @return The sum between the two types, returning the dominant type.
     */
    public SNumber add(IAddWithFloat otherType) {
        return otherType.addWithFloat(this);
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
    public SNumber addWithInt(TypeInt typeInt) {
        return new TypeFloat(typeInt.getValue() + this.value);
    }

    /**
     * Returns the add between the current type and a Float Type.
     *
     * @param typeFloat A Float type who will be added to the current type.
     * @return The sum between the Float type and the other type.
     */
    @Override
    public SNumber addWithFloat(TypeFloat typeFloat) {
        return new TypeFloat(typeFloat.value + this.value);
    }

    /**
     * Method that returns the subtraction between a TypeFloat and another type.
     * Returns the dominant type if possible, or throws an error if the operation is undefined.
     * @param otherType Another type that will be added to the current type.
     * @return The subtraction between the two types, returning the dominant type.
     */
    public SNumber sub(ISubWithFloat otherType) {
        return otherType.subWithFloat(this);
    }

    /**
     * Returns the subtraction between the current type and a Float Type.
     *
     * @param typeFloat A Float type who will be subtracted to the current type.
     * @return The subtraction between the Float type and the other type.
     */
    @Override
    public SNumber subWithFloat(TypeFloat typeFloat) {
        return new TypeFloat(typeFloat.value - this.value);
    }

    /**
     * Returns the subtraction between the current type and an Int Type.
     *
     * @param typeInt An Int type who will be subtracted to the current type.
     * @return The subtraction between the Int type and the other type.
     */
    @Override
    public SNumber subWithInt(TypeInt typeInt) {
        return new TypeFloat(typeInt.getValue() - this.value);
    }

    /**
     * Method that returns the multiplication between the current type and the other type.
     * Returns the dominant type if possible, or throws an error if the operation is undefined.
     *
     * @param otherType Another type that will be multiplied to the current type.
     * @return The multiplication between the two types, returning the dominant type.
     */
    public SNumber mult(IMultWithFloat otherType) {
        return otherType.multWithFloat(this);
    }

    /**
     * Returns the multiplication between the current type and a Float Type.
     *
     * @param typeFloat A Float type who will be multiplied to the current type.
     * @return The multiplication between the Float type and the other type.
     */
    @Override
    public SNumber multWithFloat(TypeFloat typeFloat) {
        return new TypeFloat(typeFloat.value * this.value);
    }

    /**
     * Returns the multiplication between the current type and an Int Type.
     *
     * @param typeInt An Int type who will be multiplied to the current type.
     * @return The multiplication between the Int type and the other type.
     */
    @Override
    public SNumber multWithInt(TypeInt typeInt) {
        return new TypeFloat(typeInt.getValue() * this.value);
    }

    /**
     * Method that returns the division between the current type and the other type.
     * Returns the dominant type if possible, or throws an error if the operation is undefined.
     *
     * @param otherType Another type that will be divided to the current type.
     * @return The division between the two types, returning the dominant type.
     */
    public SNumber div(IDivWithFloat otherType){
        return null;
    }
}
