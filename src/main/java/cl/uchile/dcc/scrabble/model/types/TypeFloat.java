package cl.uchile.dcc.scrabble.model.types;

import cl.uchile.dcc.scrabble.model.builders.interfaces.FloatASTBuilder;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HiddenFloat;
import cl.uchile.dcc.scrabble.model.factories.hidden_factories.HTypeFactory;
import cl.uchile.dcc.scrabble.model.factories.types_factories.STypeFactory;
import cl.uchile.dcc.scrabble.model.types.abstract_types.AbstractNumber;
import cl.uchile.dcc.scrabble.model.types.interface_types.SNumber;
import cl.uchile.dcc.scrabble.model.types.operations.ArithmeticOperationsWithNumbers;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

/**
 * A class for the float type.
 * @author Francisco Muñoz Guajardo
 */
public class TypeFloat extends AbstractNumber
    implements ArithmeticOperationsWithNumbers, FloatASTBuilder {

    private final double value;

    /**
     * Constructor for the TypeFloat.
     * @param value A double number as a value.
     */
    public TypeFloat(double value) {
        this.value = value;
    }

    /**
     * Returns the current value of the instance.
     *
     * @return The value in the instance
     */
    public double getValue() {
        return this.value;
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
     * Returns the value as {@code String}.
     *
     * @return the current value as {@code String}
     */
    @Override
    public String getValueAsString() {
        return Double.toString(this.value);
    }

    /**
     * Returns the value as {@code double}.
     *
     * @return the current value as {@code double}
     */
    @Override
    public double getValueAsDouble() {
        return this.value;
    }

    /**
     * Method that returns the sum between a TypeFloat and another type.
     * Returns the dominant type if possible.
     * @param otherType Another type that will be added to the current type.
     * @return The sum between the two types, returning the dominant type.
     */
    @Override
    public TypeFloat add(@NotNull SNumber otherType) {
        return otherType.addWithFloat(this);
    }

    /**
     * Returns the add between the current type and a String Type.
     *
     * @param typeString A string type who will be added to the current type.
     * @return The sum between the String type and the other type.
     */
    @Override
    public TypeString addWithString(@NotNull TypeString typeString) {
        return STypeFactory.createTypeString(typeString.getValue() + this.value);
    }

    /**
     * Returns the add between the current type and an Int Type.
     *
     * @param typeInt An Int type who will be added to the current type.
     * @return The sum between the Int type and the other type.
     */
    @Override
    public TypeFloat addWithInt(@NotNull TypeInt typeInt) {
        return STypeFactory.createTypeFloat(typeInt.getValue() + this.value);
    }

    /**
     * Returns the add between the current type and a Float Type.
     *
     * @param typeFloat A Float type who will be added to the current type.
     * @return The sum between the Float type and the other type.
     */
    @Override
    public TypeFloat addWithFloat(@NotNull TypeFloat typeFloat) {
        return STypeFactory.createTypeFloat(typeFloat.value + this.value);
    }

    /**
     * Method that returns the subtraction between a TypeFloat and another type.
     * Returns the dominant type if possible.
     * @param otherType Another type that will be added to the current type.
     * @return The subtraction between the two types, returning the dominant type.
     */
    @Override
    public TypeFloat sub(@NotNull SNumber otherType) {
        return otherType.subWithFloat(this);
    }

    /**
     * Returns the subtraction between the current type and a Float Type.
     *
     * @param typeFloat A Float type who will be subtracted to the current type.
     * @return The subtraction between the Float type and the other type.
     */
    @Override
    public TypeFloat subWithFloat(@NotNull TypeFloat typeFloat) {
        return STypeFactory.createTypeFloat(typeFloat.value - this.value);
    }

    /**
     * Returns the subtraction between the current type and an Int Type.
     *
     * @param typeInt An Int type who will be subtracted to the current type.
     * @return The subtraction between the Int type and the other type.
     */
    @Override
    public TypeFloat subWithInt(@NotNull TypeInt typeInt) {
        return STypeFactory.createTypeFloat(typeInt.getValue() - this.value);
    }

    /**
     * Method that returns the multiplication between the current type and the other type.
     * Returns the dominant type if possible.
     *
     * @param otherType Another type that will be multiplied to the current type.
     * @return The multiplication between the two types, returning the dominant type.
     */
    @Override
    public TypeFloat mult(@NotNull SNumber otherType) {
        return otherType.multWithFloat(this);
    }

    /**
     * Returns the multiplication between the current type and a Float Type.
     *
     * @param typeFloat A Float type who will be multiplied to the current type.
     * @return The multiplication between the Float type and the other type.
     */
    @Override
    public TypeFloat multWithFloat(@NotNull TypeFloat typeFloat) {
        return STypeFactory.createTypeFloat(typeFloat.value * this.value);
    }

    /**
     * Returns the multiplication between the current type and an Int Type.
     *
     * @param typeInt An Int type who will be multiplied to the current type.
     * @return The multiplication between the Int type and the other type.
     */
    @Override
    public TypeFloat multWithInt(@NotNull TypeInt typeInt) {
        return STypeFactory.createTypeFloat(typeInt.getValue() * this.value);
    }

    /**
     * Method that returns the division between the current type and the other type.
     * Returns the dominant type if possible.
     *
     * @param otherType Another type that will be divided to the current type.
     * @return The division between the two types, returning the dominant type.
     */
    @Override
    public TypeFloat div(@NotNull SNumber otherType) {
        return otherType.divWithFloat(this);
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
        if (this.value == 0.) return STypeFactory.createTypeFloat(0.0);
        return STypeFactory.createTypeFloat(typeFloat.value / this.value);
    }

    /**
     * Returns the division between the current type and an Int Type.
     *
     * @param typeInt An Int type who will be divided to the current type.
     * @return The division between the Int type and the other type.
     */
    @Override
    public TypeFloat divWithInt(@NotNull TypeInt typeInt) {
        // Case divide by zero
        if (this.value == 0.) {
            return STypeFactory.createTypeFloat(0.0);
        }
        return STypeFactory.createTypeFloat(typeInt.getValue() / this.value);
    }

    /**
     * Transform an {@code AST} into its equivalent {@code HiddenAST}.
     *
     * @return a transformation
     */
    @Override
    public HiddenFloat toHiddenAST() {
        return HTypeFactory.createHiddenFloat(this);
    }
}
