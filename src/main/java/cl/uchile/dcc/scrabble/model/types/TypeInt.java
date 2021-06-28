package cl.uchile.dcc.scrabble.model.types;

import static cl.uchile.dcc.scrabble.model.factories.hidden_factories.HTypeFactory.createHiddenInt;
import static cl.uchile.dcc.scrabble.model.utils.BinaryUtilities.addTwoBinaries;
import static cl.uchile.dcc.scrabble.model.utils.BinaryUtilities.intToBinary;

import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HiddenInt;
import cl.uchile.dcc.scrabble.model.factories.types_factories.STypeFactory;
import cl.uchile.dcc.scrabble.model.types.abstract_types.AbstractInteger;
import cl.uchile.dcc.scrabble.model.types.interface_types.SNumber;
import cl.uchile.dcc.scrabble.model.types.operations.ArithmeticOperationsWithNumbers;
import java.util.Objects;

/**
 * A class for the integer type.
 * @author Francisco Muñoz Guajardo
 */
public class TypeInt extends AbstractInteger implements ArithmeticOperationsWithNumbers {

    /**
     * Constructor for the TypeInt.
     * @param value An int as a value.
     */
    public TypeInt(int value) {
        super(value);
    }

    /**
     * Returns the current value of the instance.
     *
     * @return The value in the instance
     */
    public int getValue() {
        return super.getValueAsInt();
    }

    /**
     * Method that returns the hash code of the current instance.
     * @return The hash code of the current instance.
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.getValue());
    }

    /**
     * Method that provides a representation of the current instance as a String.
     * @return The representation as a String.
     */
    @Override
    public String toString() {
        return "TypeInt{" +
                "value=" + this.getValue() +
                '}';
    }

    /**
     * Returns the value as {@code String}.
     *
     * @return the current value as {@code String}
     */
    @Override
    public String getValueAsString() {
        return Integer.toString(this.getValue());
    }

    /**
     * Method that returns the sum between a TypeInt and another type.
     * Returns the dominant type if possible.
     * @param otherType Another type that will be added to the current type.
     * @return The sum between the two types, returning the dominant type.
     */
    @Override
    public SNumber add(SNumber otherType) {
        return otherType.addWithInt(this);
    }

    /**
     * Returns the add between the current type and a String Type.
     *
     * @param typeString A string type who will be added to the current type.
     * @return The sum between the String type and the other type.
     */
    @Override
    public TypeString addWithString(TypeString typeString) {
        return STypeFactory.createTypeString(typeString.getValue() + this.getValue());
    }

    /**
     * Returns the add between the current type and an Int Type.
     *
     * @param typeInt An Int type who will be added to the current type.
     * @return The sum between the Int type and the other type.
     */
    @Override
    public TypeInt addWithInt(TypeInt typeInt) {
        return STypeFactory.createTypeInt(typeInt.getValue() + this.getValue());
    }

    /**
     * Returns the add between the current type and a Float Type.
     *
     * @param typeFloat A Float type who will be added to the current type.
     * @return The sum between the Float type and the other type.
     */
    @Override
    public TypeFloat addWithFloat(TypeFloat typeFloat) {
        return STypeFactory.createTypeFloat(typeFloat.getValue() + this.getValue());
    }

    /**
     * Returns the sum between the current type and a Binary Type.
     *
     * @param typeBinary A Binary type who will be added to the current type.
     * @return The sum between the Binary type and the other type.
     */
    @Override
    public TypeBinary addWithBinary(TypeBinary typeBinary) {
        return STypeFactory.createTypeBinary(addTwoBinaries(typeBinary.getValue(), this.getValueAsBinary()));
    }

    /**
     * Method that returns the subtraction between a TypeInt and another type.
     * Returns the dominant type if possible.
     * @param otherType Another type that will be added to the current type.
     * @return The subtraction between the two types, returning the dominant type.
     */
    @Override
    public SNumber sub(SNumber otherType) {
        return otherType.subWithInt(this);
    }

    /**
     * Returns the subtraction between the current type and a Float Type.
     *
     * @param typeFloat A Float type who will be subtracted to the current type.
     * @return The subtraction between the Float type and the other type.
     */
    @Override
    public TypeFloat subWithFloat(TypeFloat typeFloat) {
        return STypeFactory.createTypeFloat(typeFloat.getValue() - this.getValue());
    }

    /**
     * Returns the subtraction between the current type and an Int Type.
     *
     * @param typeInt An Int type who will be subtracted to the current type.
     * @return The subtraction between the Int type and the other type.
     */
    @Override
    public TypeInt subWithInt(TypeInt typeInt) {
        return STypeFactory.createTypeInt(typeInt.getValue() - this.getValue());
    }

    /**
     * Returns the subtraction between the current type and a Binary Type.
     *
     * @param typeBinary A Binary type who will be subtracted to the current type.
     * @return The subtraction between the Binary type and the other type.
     */
    @Override
    public TypeBinary subWithBinary(TypeBinary typeBinary) {
        String subtraction = intToBinary(typeBinary.getValueAsInt() - this.getValue());
        return STypeFactory.createTypeBinary(subtraction);
    }

    /**
     * Method that returns the multiplication between the current type and the other type.
     * Returns the dominant type if possible.
     *
     * @param otherType Another type that will be multiplied to the current type.
     * @return The multiplication between the two types, returning the dominant type.
     */
    @Override
    public SNumber mult(SNumber otherType) {
        return otherType.multWithInt(this);
    }

    /**
     * Returns the multiplication between the current type and a Float Type.
     *
     * @param typeFloat A Float type who will be multiplied to the current type.
     * @return The multiplication between the Float type and the other type.
     */
    @Override
    public TypeFloat multWithFloat(TypeFloat typeFloat) {
        return STypeFactory.createTypeFloat(typeFloat.getValue() * this.getValue());
    }

    /**
     * Returns the multiplication between the current type and an Int Type.
     *
     * @param typeInt An Int type who will be multiplied to the current type.
     * @return The multiplication between the Int type and the other type.
     */
    @Override
    public TypeInt multWithInt(TypeInt typeInt) {
        return STypeFactory.createTypeInt(typeInt.getValue() * this.getValue());
    }

    /**
     * Returns the multiplication between the current type and a Binary Type.
     *
     * @param typeBinary A Binary type who will be multiplied to the current type.
     * @return The multiplication between the Binary type and the other type.
     */
    @Override
    public TypeBinary multWithBinary(TypeBinary typeBinary) {
        String binaryMultiplied = intToBinary(typeBinary.getValueAsInt() * this.getValue());
        return STypeFactory.createTypeBinary(binaryMultiplied);
    }

    /**
     * Method that returns the division between the current type and the other type.
     * Returns the dominant type if possible.
     *
     * @param otherType Another type that will be divided to the current type.
     * @return The division between the two types, returning the dominant type.
     */
    @Override
    public SNumber div(SNumber otherType){
        return otherType.divWithInt(this);
    }

    /**
     * Returns the division between the current type and a Binary Type.
     *
     * @param typeBinary A Binary type who will be divided to the current type.
     * @return The division between the Binary type and the other type.
     */
    @Override
    public TypeBinary divWithBinary(TypeBinary typeBinary) {
        // Case divide by zero
        if (this.getValue() == 0) return STypeFactory.createTypeBinary("0000");
        String binaryResult = intToBinary((int) Math.round((double) typeBinary.getValueAsInt() / this.getValue()));
        return STypeFactory.createTypeBinary(binaryResult);
    }

    /**
     * Returns the division between the current type and a Float Type.
     *
     * @param typeFloat A Float type who will be divided to the current type.
     * @return The division between the Float type and the other type.
     */
    @Override
    public TypeFloat divWithFloat(TypeFloat typeFloat) {
        // Case divide by zero
        if (this.getValue() == 0) return STypeFactory.createTypeFloat(0.0);
        return STypeFactory.createTypeFloat(typeFloat.getValue() / this.getValue());
    }

    /**
     * Returns the division between the current type and an Int Type.
     *
     * @param typeInt An Int type who will be divided to the current type.
     * @return The division between the Int type and the other type.
     */
    @Override
    public TypeInt divWithInt(TypeInt typeInt) {
        // Case divide by zero
        if (this.getValue() == 0) {
            return STypeFactory.createTypeInt(0);
        }
        return STypeFactory.createTypeInt((int) Math.round((double) typeInt.getValue() / this.getValue()));
    }

    /**
     * Transform an {@code AST} into its equivalent {@code HiddenAST}.
     *
     * @return a transformation
     */
    @Override
    public HiddenInt toHiddenAST() {
        return createHiddenInt(this);
    }
}
