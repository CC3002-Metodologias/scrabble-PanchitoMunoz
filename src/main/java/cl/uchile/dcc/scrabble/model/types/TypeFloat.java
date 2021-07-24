package cl.uchile.dcc.scrabble.model.types;

import cl.uchile.dcc.scrabble.model.builders.interfaces.FloatASTBuilder;
import cl.uchile.dcc.scrabble.model.factories.hidden_factories.HTypeFactory;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HiddenFloat;
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
    private final HiddenFloat adaptee;

    /**
     * Constructor for the TypeFloat.
     * @param value A double number as a value.
     */
    public TypeFloat(double value) {
        this.value = value;
        this.adaptee = HTypeFactory.createHiddenFloat(value);
    }

    /**
     * Returns the current value of the instance.
     *
     * @return The value in the instance
     */
    public double getValue() {
        return this.asHType().getValueAsDouble();
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
        return this.asHType().sTypeAsString();
    }

    /**
     * Returns the value as {@code String}.
     *
     * @return the current value as {@code String}
     */
    @Override
    public String getValueAsString() {
        return this.asHType().getValueAsString();
    }

    /**
     * Returns the value as {@code double}.
     *
     * @return the current value as {@code double}
     */
    @Override
    public double getValueAsDouble() {
        return this.asHType().getValueAsDouble();
    }

    /**
     * Method that returns the sum between a TypeFloat and another type.
     * Returns the dominant type if possible.
     * @param otherType Another type that will be added to the current type.
     * @return The sum between the two types, returning the dominant type.
     */
    @Override
    public TypeFloat add(@NotNull SNumber otherType) {
        return this.asHType().add(otherType.asHType()).asTypeFloat();
    }

    /**
     * Method that returns the subtraction between a TypeFloat and another type.
     * Returns the dominant type if possible.
     * @param otherType Another type that will be added to the current type.
     * @return The subtraction between the two types, returning the dominant type.
     */
    @Override
    public TypeFloat sub(@NotNull SNumber otherType) {
        return this.asHType().sub(otherType.asHType()).asTypeFloat();
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
        return this.asHType().mult(otherType.asHType()).asTypeFloat();
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
        return this.asHType().div(otherType.asHType()).asTypeFloat();
    }

    /**
     * Transform the current {@code SType} as a {@code HType}.
     *
     * @return a transformation
     */
    @Override
    public HiddenFloat asHType() {
        return adaptee;
    }
}
