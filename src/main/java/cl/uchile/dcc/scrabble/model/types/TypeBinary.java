package cl.uchile.dcc.scrabble.model.types;

import static cl.uchile.dcc.scrabble.model.factories.hidden_factories.HTypeFactory.createHiddenBinary;
import static cl.uchile.dcc.scrabble.model.utils.BinaryUtilities.addTwoBinaries;
import static cl.uchile.dcc.scrabble.model.utils.BinaryUtilities.binaryAndBinary;
import static cl.uchile.dcc.scrabble.model.utils.BinaryUtilities.binaryOrBinary;
import static cl.uchile.dcc.scrabble.model.utils.BinaryUtilities.binaryToInt;
import static cl.uchile.dcc.scrabble.model.utils.BinaryUtilities.boolAndBinary;
import static cl.uchile.dcc.scrabble.model.utils.BinaryUtilities.boolOrBinary;
import static cl.uchile.dcc.scrabble.model.utils.BinaryUtilities.intToBinary;
import static cl.uchile.dcc.scrabble.model.utils.BinaryUtilities.oneComplement;

import cl.uchile.dcc.scrabble.model.builders.interfaces.BinaryASTBuilder;
import cl.uchile.dcc.scrabble.model.hidden_ast.hidden_types.HiddenBinary;
import cl.uchile.dcc.scrabble.model.factories.types_factories.STypeFactory;
import cl.uchile.dcc.scrabble.model.types.abstract_types.AbstractInteger;
import cl.uchile.dcc.scrabble.model.types.interface_types.SInteger;
import cl.uchile.dcc.scrabble.model.types.interface_types.SLogical;
import cl.uchile.dcc.scrabble.model.types.operations.ArithmeticOperationsWithIntegers;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

/**
 * A class for the binary type.
 * @author Francisco Muñoz Guajardo
 */
public class TypeBinary extends AbstractInteger
    implements SLogical, ArithmeticOperationsWithIntegers, BinaryASTBuilder {

    /**
     * Constructor for the TypeBinary.
     *
     * @param value A String as a value.
     */
    public TypeBinary(String value) {
        super(binaryToInt(value));
    }

    /**
     * Returns the current value of the instance.
     *
     * @return The value in the instance
     */
    public String getValue() {
        return super.getValueAsBinary();
    }

    /**
     * Method that returns the hash code of the current instance.
     *
     * @return The hash code of the current instance.
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.getValueAsInt());
    }

    /**
     * Method that provides a representation of the current instance as a String.
     *
     * @return The representation as a String.
     */
    @Override
    public String toString() {
        return "TypeBinary{" +
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
        return this.getValue();
    }

    /**
     * Returns the negation of the current instance.
     *
     * @return The negation of the current instance.
     */
    @Override
    public TypeBinary neg() {
        return STypeFactory.createTypeBinary(oneComplement(this.getValue()));
    }

    /**
     * Method that returns the sum between a TypeBinary and another type. Returns the dominant type
     * if possible.
     *
     * @param otherType Another type that will be added to the current type.
     * @return The sum between the two types, returning the dominant type.
     */
    @Override
    public TypeBinary add(@NotNull SInteger otherType) {
        return otherType.addWithBinary(this);
    }

    /**
     * Returns the add between the current type and a String Type.
     *
     * @param typeString A string type who will be added to the current type.
     * @return The sum between the String type and the other type.
     */
    @Override
    public TypeString addWithString(@NotNull TypeString typeString) {
        return STypeFactory.createTypeString(typeString.getValue() + this.getValue());
    }

    /**
     * Returns the add between the current type and an Int Type.
     *
     * @param typeInt An Int type who will be added to the current type.
     * @return The sum between the Int type and the other type.
     */
    @Override
    public TypeInt addWithInt(@NotNull TypeInt typeInt) {
        return STypeFactory.createTypeInt(typeInt.getValue() + this.getValueAsInt());
    }

    /**
     * Returns the add between the current type and a Float Type.
     *
     * @param typeFloat A Float type who will be added to the current type.
     * @return The sum between the Float type and the other type.
     */
    @Override
    public TypeFloat addWithFloat(@NotNull TypeFloat typeFloat) {
        return STypeFactory.createTypeFloat(typeFloat.getValue() + this.getValueAsInt());
    }

    /**
     * Returns the sum between the current type and a Binary Type.
     *
     * @param typeBinary A Binary type who will be added to the current type.
     * @return The sum between the Binary type and the other type.
     */
    @Override
    public TypeBinary addWithBinary(@NotNull TypeBinary typeBinary) {
        return STypeFactory.createTypeBinary(addTwoBinaries(typeBinary.getValue(), this.getValue()));
    }

    /**
     * Method that returns the subtraction between a TypeBinary and another type. Returns the
     * dominant type if possible.
     *
     * @param otherType Another type that will be added to the current type.
     * @return The subtraction between the two types, returning the dominant type.
     */
    @Override
    public TypeBinary sub(@NotNull SInteger otherType) {
        return otherType.subWithBinary(this);
    }

    /**
     * Returns the subtraction between the current type and a Float Type.
     *
     * @param typeFloat A Float type who will be subtracted to the current type.
     * @return The subtraction between the Float type and the other type.
     */
    @Override
    public TypeFloat subWithFloat(@NotNull TypeFloat typeFloat) {
        return STypeFactory.createTypeFloat(typeFloat.getValue() - this.getValueAsInt());
    }

    /**
     * Returns the subtraction between the current type and an Int Type.
     *
     * @param typeInt An Int type who will be subtracted to the current type.
     * @return The subtraction between the Int type and the other type.
     */
    @Override
    public TypeInt subWithInt(@NotNull TypeInt typeInt) {
        return STypeFactory.createTypeInt(typeInt.getValue() - this.getValueAsInt());
    }

    /**
     * Returns the subtraction between the current type and a Binary Type.
     *
     * @param typeBinary A Binary type who will be subtracted to the current type.
     * @return The subtraction between the Binary type and the other type.
     */
    @Override
    public TypeBinary subWithBinary(@NotNull TypeBinary typeBinary) {
        String subtraction = intToBinary(typeBinary.getValueAsInt() - this.getValueAsInt());
        return STypeFactory.createTypeBinary(subtraction);
    }

    /**
     * Method that returns the multiplication between the current type and the other type. Returns
     * the dominant type if possible.
     *
     * @param otherType Another type that will be multiplied to the current type.
     * @return The multiplication between the two types, returning the dominant type.
     */
    @Override
    public TypeBinary mult(@NotNull SInteger otherType) {
        return otherType.multWithBinary(this);
    }

    /**
     * Returns the multiplication between the current type and a Float Type.
     *
     * @param typeFloat A Float type who will be multiplied to the current type.
     * @return The multiplication between the Float type and the other type.
     */
    @Override
    public TypeFloat multWithFloat(@NotNull TypeFloat typeFloat) {
        return STypeFactory.createTypeFloat(typeFloat.getValue() * this.getValueAsInt());
    }

    /**
     * Returns the multiplication between the current type and an Int Type.
     *
     * @param typeInt An Int type who will be multiplied to the current type.
     * @return The multiplication between the Int type and the other type.
     */
    @Override
    public TypeInt multWithInt(@NotNull TypeInt typeInt) {
        return STypeFactory.createTypeInt(typeInt.getValue() * this.getValueAsInt());
    }

    /**
     * Returns the multiplication between the current type and a Binary Type.
     *
     * @param typeBinary A Binary type who will be multiplied to the current type.
     * @return The multiplication between the Binary type and the other type.
     */
    @Override
    public TypeBinary multWithBinary(@NotNull TypeBinary typeBinary) {
        return STypeFactory.createTypeBinary(intToBinary(typeBinary.getValueAsInt() * this.getValueAsInt()));
    }

    /**
     * Method that returns the division between the current type and the other type. Returns the
     * dominant type if possible.
     *
     * @param otherType Another type that will be divided to the current type.
     * @return The division between the two types, returning the dominant type.
     */
    @Override
    public TypeBinary div(@NotNull SInteger otherType) {
        return otherType.divWithBinary(this);
    }

    /**
     * Returns the division between the current type and a Binary Type.
     *
     * @param typeBinary A Binary type who will be divided to the current type.
     * @return The division between the Binary type and the other type.
     */
    @Override
    public TypeBinary divWithBinary(@NotNull TypeBinary typeBinary) {
        // Case divide by zero
        if (this.getValueAsInt() == 0) {
            return STypeFactory.createTypeBinary("0000");
        }
        String binaryDivision = intToBinary(
            (int) Math.round((double) typeBinary.getValueAsInt() / this.getValueAsInt())
        );
        return STypeFactory.createTypeBinary(binaryDivision);
    }

    /**
     * Returns the division between the current type and a Float Type.
     *
     * @param typeFloat A Float type who will be divided to the current type.
     * @return The division between the Float type and the other type.
     */
    @Override
    public TypeFloat divWithFloat(@NotNull TypeFloat typeFloat) {
        // Case divide by zero
        if (this.getValueAsInt() == 0) {
            return STypeFactory.createTypeFloat(0.0);
        }
        return STypeFactory.createTypeFloat(typeFloat.getValue() / this.getValueAsInt());
    }

    /**
     * Returns the division between the current type and an Int Type.
     *
     * @param typeInt An Int type who will be divided to the current type.
     * @return The division between the Int type and the other type.
     */
    @Override
    public TypeInt divWithInt(@NotNull TypeInt typeInt) {
        // Case divide by zero
        if (this.getValueAsInt() == 0) {
            return STypeFactory.createTypeInt(0);
        }
        int intResult = (int) Math.round((double) typeInt.getValue() / this.getValueAsInt());
        return STypeFactory.createTypeInt(intResult);
    }

    /**
     * Method that returns the disjunction between the current type and the other type. Returns the
     * dominant type if possible.
     *
     * @param otherType Another type that will be disjunct to the current type.
     * @return The disjunction between the two types, returning the dominant type.
     */
    @Override
    public TypeBinary and(@NotNull SLogical otherType) {
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
    public TypeBinary or(@NotNull SLogical otherType) {
        return otherType.orWithBinary(this);
    }

    /**
     * Returns the disjunction between the current type and a Bool Type.
     *
     * @param typeBool A Bool type who will be disjunct to the current type.
     * @return The disjunction between the Bool type and the other type.
     */
    @Override
    public TypeBinary andWithBool(@NotNull TypeBool typeBool) {
        return STypeFactory.createTypeBinary(boolAndBinary(typeBool.getValue(), this.getValue()));
    }

    /**
     * Returns the conjunction between the current type and a Bool Type.
     *
     * @param typeBool A Bool type who will be conjunct to the current type.
     * @return The conjunction between the Bool type and the other type.
     */
    @Override
    public TypeBinary orWithBool(@NotNull TypeBool typeBool) {
        return STypeFactory.createTypeBinary(boolOrBinary(typeBool.getValue(), this.getValue()));
    }

    /**
     * Returns the disjunction between the current type and a Binary Type.
     *
     * @param typeBinary A Binary type who will be disjunct to the current type.
     * @return The disjunction between the Binary type and the other type.
     */
    @Override
    public TypeBinary andWithBinary(@NotNull TypeBinary typeBinary) {
        return STypeFactory.createTypeBinary(binaryAndBinary(typeBinary.getValue(), this.getValue()));
    }

    /**
     * Returns the conjunction between the current type and a Binary Type.
     *
     * @param typeBinary A Binary type who will be conjunct to the current type.
     * @return The conjunction between the Binary type and the other type.
     */
    @Override
    public TypeBinary orWithBinary(@NotNull TypeBinary typeBinary) {
        return STypeFactory.createTypeBinary(binaryOrBinary(typeBinary.getValue(), this.getValue()));
    }

    /**
     * Transform an {@code AST} into its equivalent {@code HiddenAST}.
     *
     * @return a transformation
     */
    @Override
    public HiddenBinary toHiddenAST() {
        return createHiddenBinary(this);
    }
}
