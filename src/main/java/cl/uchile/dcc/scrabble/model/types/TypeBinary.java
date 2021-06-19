package cl.uchile.dcc.scrabble.model.types;

import static cl.uchile.dcc.scrabble.model.utils.BinaryUtilities.addTwoBinaries;
import static cl.uchile.dcc.scrabble.model.utils.BinaryUtilities.binaryAndBinary;
import static cl.uchile.dcc.scrabble.model.utils.BinaryUtilities.binaryOrBinary;
import static cl.uchile.dcc.scrabble.model.utils.BinaryUtilities.binaryToInt;
import static cl.uchile.dcc.scrabble.model.utils.BinaryUtilities.boolAndBinary;
import static cl.uchile.dcc.scrabble.model.utils.BinaryUtilities.boolOrBinary;
import static cl.uchile.dcc.scrabble.model.utils.BinaryUtilities.intToBinary;
import static cl.uchile.dcc.scrabble.model.utils.BinaryUtilities.oneComplement;

import cl.uchile.dcc.scrabble.model.ast.AST;
import cl.uchile.dcc.scrabble.model.ast.wrapped_types.WrappedBinary;
import cl.uchile.dcc.scrabble.model.types.abstract_types.AbstractInteger;
import cl.uchile.dcc.scrabble.model.types.interface_types.SInteger;
import cl.uchile.dcc.scrabble.model.types.interface_types.SLogical;
import cl.uchile.dcc.scrabble.model.types.interface_types.SNumber;
import cl.uchile.dcc.scrabble.model.types.operations.ArithmeticOperationsWithIntegers;
import java.util.Objects;

/**
 * A class for the binary type.
 * @author Francisco Muñoz Guajardo
 */
public class TypeBinary extends AbstractInteger implements SLogical, ArithmeticOperationsWithIntegers {

    private final String value;

    /**
     * Constructor for the TypeBinary.
     *
     * @param value A String as a value.
     */
    public TypeBinary(String value) {
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
     * Returns the current value of the instance as an Int.
     *
     * @return The value in the instance
     */
    protected int getValueAsInt() {
        return binaryToInt(this.value);
    }

    /**
     * Method that returns the hash code of the current instance.
     *
     * @return The hash code of the current instance.
     */
    @Override
    public int hashCode() {
        return Objects.hash(binaryToInt(value));
    }

    /**
     * Method that provides a representation of the current instance as a String.
     *
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
        return new TypeFloat(this.getValueAsInt());
    }

    /**
     * Transforms the current type to a TypeInt.
     *
     * @return TypeInt with a value equivalent to the current type.
     */
    @Override
    public TypeInt toTypeInt() {
        return new TypeInt(this.getValueAsInt());
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
     * Returns the negation of the current instance.
     *
     * @return The negation of the current instance.
     */
    @Override
    public SLogical neg() {
        return new TypeBinary(oneComplement(this.value));
    }

    /**
     * Method that returns the sum between a TypeBinary and another type. Returns the dominant type
     * if possible.
     *
     * @param otherType Another type that will be added to the current type.
     * @return The sum between the two types, returning the dominant type.
     */
    @Override
    public SInteger add(SInteger otherType) {
        return otherType.addWithBinary(this);
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
        return new TypeInt(typeInt.getValue() + this.getValueAsInt());
    }

    /**
     * Returns the add between the current type and a Float Type.
     *
     * @param typeFloat A Float type who will be added to the current type.
     * @return The sum between the Float type and the other type.
     */
    @Override
    public SNumber addWithFloat(TypeFloat typeFloat) {
        return new TypeFloat(typeFloat.getValue() + this.getValueAsInt());
    }

    /**
     * Returns the sum between the current type and a Binary Type.
     *
     * @param typeBinary A Binary type who will be added to the current type.
     * @return The sum between the Binary type and the other type.
     */
    @Override
    public SInteger addWithBinary(TypeBinary typeBinary) {
        return new TypeBinary(addTwoBinaries(typeBinary.value, this.value));
    }

    /**
     * Method that returns the subtraction between a TypeBinary and another type. Returns the
     * dominant type if possible.
     *
     * @param otherType Another type that will be added to the current type.
     * @return The subtraction between the two types, returning the dominant type.
     */
    @Override
    public SInteger sub(SInteger otherType) {
        return otherType.subWithBinary(this);
    }

    /**
     * Returns the subtraction between the current type and a Float Type.
     *
     * @param typeFloat A Float type who will be subtracted to the current type.
     * @return The subtraction between the Float type and the other type.
     */
    @Override
    public SNumber subWithFloat(TypeFloat typeFloat) {
        return new TypeFloat(typeFloat.getValue() - this.getValueAsInt());
    }

    /**
     * Returns the subtraction between the current type and an Int Type.
     *
     * @param typeInt An Int type who will be subtracted to the current type.
     * @return The subtraction between the Int type and the other type.
     */
    @Override
    public SNumber subWithInt(TypeInt typeInt) {
        return new TypeInt(typeInt.getValue() - this.getValueAsInt());
    }

    /**
     * Returns the subtraction between the current type and a Binary Type.
     *
     * @param typeBinary A Binary type who will be subtracted to the current type.
     * @return The subtraction between the Binary type and the other type.
     */
    @Override
    public SInteger subWithBinary(TypeBinary typeBinary) {
        String subtraction = intToBinary(typeBinary.getValueAsInt() - this.getValueAsInt());
        return new TypeBinary(subtraction);
    }

    /**
     * Method that returns the multiplication between the current type and the other type. Returns
     * the dominant type if possible.
     *
     * @param otherType Another type that will be multiplied to the current type.
     * @return The multiplication between the two types, returning the dominant type.
     */
    @Override
    public SInteger mult(SInteger otherType) {
        return otherType.multWithBinary(this);
    }

    /**
     * Returns the multiplication between the current type and a Float Type.
     *
     * @param typeFloat A Float type who will be multiplied to the current type.
     * @return The multiplication between the Float type and the other type.
     */
    @Override
    public SNumber multWithFloat(TypeFloat typeFloat) {
        return new TypeFloat(typeFloat.getValue() * this.getValueAsInt());
    }

    /**
     * Returns the multiplication between the current type and an Int Type.
     *
     * @param typeInt An Int type who will be multiplied to the current type.
     * @return The multiplication between the Int type and the other type.
     */
    @Override
    public SNumber multWithInt(TypeInt typeInt) {
        return new TypeInt(typeInt.getValue() * this.getValueAsInt());
    }

    /**
     * Returns the multiplication between the current type and a Binary Type.
     *
     * @param typeBinary A Binary type who will be multiplied to the current type.
     * @return The multiplication between the Binary type and the other type.
     */
    @Override
    public SInteger multWithBinary(TypeBinary typeBinary) {
        return new TypeBinary(intToBinary(typeBinary.getValueAsInt() * this.getValueAsInt()));
    }

    /**
     * Method that returns the division between the current type and the other type. Returns the
     * dominant type if possible.
     *
     * @param otherType Another type that will be divided to the current type.
     * @return The division between the two types, returning the dominant type.
     */
    @Override
    public SInteger div(SInteger otherType) {
        return otherType.divWithBinary(this);
    }

    /**
     * Returns the division between the current type and a Binary Type.
     *
     * @param typeBinary A Binary type who will be divided to the current type.
     * @return The division between the Binary type and the other type.
     */
    @Override
    public SInteger divWithBinary(TypeBinary typeBinary) {
        // Case divide by zero
        if (this.getValueAsInt() == 0) {
            return new TypeBinary("0000");
        }
        String binaryDivision = intToBinary(
            (int) Math.round((double) typeBinary.getValueAsInt() / this.getValueAsInt())
        );
        return new TypeBinary(binaryDivision);
    }

    /**
     * Returns the division between the current type and a Float Type.
     *
     * @param typeFloat A Float type who will be divided to the current type.
     * @return The division between the Float type and the other type.
     */
    @Override
    public SNumber divWithFloat(TypeFloat typeFloat) {
        // Case divide by zero
        if (this.getValueAsInt() == 0) {
            return new TypeFloat(0.0);
        }
        return new TypeFloat(typeFloat.getValue() / this.getValueAsInt());
    }

    /**
     * Returns the division between the current type and an Int Type.
     *
     * @param typeInt An Int type who will be divided to the current type.
     * @return The division between the Int type and the other type.
     */
    @Override
    public SNumber divWithInt(TypeInt typeInt) {
        // Case divide by zero
        if (this.getValueAsInt() == 0) {
            return new TypeInt(0);
        }
        int intResult = (int) Math.round((double) typeInt.getValue() / this.getValueAsInt());
        return new TypeInt(intResult);
    }

    /**
     * Method that returns the disjunction between the current type and the other type. Returns the
     * dominant type if possible.
     *
     * @param otherType Another type that will be disjunct to the current type.
     * @return The disjunction between the two types, returning the dominant type.
     */
    @Override
    public SLogical and(SLogical otherType) {
        return otherType.andWithBinary(this);
    }

    /**
     * Method that returns the conjunction between the current type and the other type. Returns the
     * dominant type if possible.
     *
     * @param otherType Another type that will be conjunct to the current type.
     * @return The conjunction between the two types, returning the dominant type.
     */
    @Override
    public SLogical or(SLogical otherType) {
        return otherType.orWithBinary(this);
    }

    /**
     * Returns the disjunction between the current type and a Bool Type.
     *
     * @param typeBool A Bool type who will be disjunct to the current type.
     * @return The disjunction between the Bool type and the other type.
     */
    @Override
    public SLogical andWithBool(TypeBool typeBool) {
        return new TypeBinary(boolAndBinary(typeBool.getValue(), this.value));
    }

    /**
     * Returns the conjunction between the current type and a Bool Type.
     *
     * @param typeBool A Bool type who will be conjunct to the current type.
     * @return The conjunction between the Bool type and the other type.
     */
    @Override
    public SLogical orWithBool(TypeBool typeBool) {
        return new TypeBinary(boolOrBinary(typeBool.getValue(), this.value));
    }

    /**
     * Returns the disjunction between the current type and a Binary Type.
     *
     * @param typeBinary A Binary type who will be disjunct to the current type.
     * @return The disjunction between the Binary type and the other type.
     */
    @Override
    public SLogical andWithBinary(TypeBinary typeBinary) {
        return new TypeBinary(binaryAndBinary(typeBinary.value, this.value));
    }

    /**
     * Returns the conjunction between the current type and a Binary Type.
     *
     * @param typeBinary A Binary type who will be conjunct to the current type.
     * @return The conjunction between the Binary type and the other type.
     */
    @Override
    public SLogical orWithBinary(TypeBinary typeBinary) {
        return new TypeBinary(binaryOrBinary(typeBinary.value, this.value));
    }

    /**
     * Transform a {@code SType} into its equivalent {@code WType}. If the argument is a {@code
     * WType} or an {@code AST}, it does nothing.
     *
     * @return a transformation
     */
    @Override
    public AST toAST() {
        return new WrappedBinary(this);
    }
}
