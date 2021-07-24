package cl.uchile.dcc.scrabble.model.types;

import cl.uchile.dcc.scrabble.model.builders.interfaces.IntASTBuilder;
import cl.uchile.dcc.scrabble.model.factories.hidden_factories.HTypeFactory;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HiddenInt;
import cl.uchile.dcc.scrabble.model.types.abstract_types.AbstractInteger;
import cl.uchile.dcc.scrabble.model.types.interface_types.SNumber;
import cl.uchile.dcc.scrabble.model.types.operations.ArithmeticOperationsWithNumbers;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

/**
 * A class for the integer type.
 *
 * @author Francisco Muñoz Guajardo
 */
public class TypeInt extends AbstractInteger
    implements ArithmeticOperationsWithNumbers, IntASTBuilder {

    private final HiddenInt adaptee;

    /**
     * Constructor for the TypeInt.
     * @param value An int as a value.
     */
    public TypeInt(int value) {
        super(value);
        this.adaptee = HTypeFactory.createHiddenInt(value);
    }

    /**
     * Returns the current value of the instance.
     *
     * @return The value in the instance
     */
    public int getValue() {
        return this.asHType().getValueAsInt();
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
        return this.asHType().getValueAsString();
    }

    /**
     * Method that returns the sum between a TypeInt and another type.
     * Returns the dominant type if possible.
     * @param otherType Another type that will be added to the current type.
     * @return The sum between the two types, returning the dominant type.
     */
    @Override
    public SNumber add(@NotNull SNumber otherType) {
        return this.asHType().add(otherType.asHType()).asSNumber();
    }

    /**
     * Method that returns the subtraction between a TypeInt and another type.
     * Returns the dominant type if possible.
     * @param otherType Another type that will be added to the current type.
     * @return The subtraction between the two types, returning the dominant type.
     */
    @Override
    public SNumber sub(@NotNull SNumber otherType) {
        return this.asHType().sub(otherType.asHType()).asSNumber();
    }

    /**
     * Method that returns the multiplication between the current type and the other type.
     * Returns the dominant type if possible.
     *
     * @param otherType Another type that will be multiplied to the current type.
     * @return The multiplication between the two types, returning the dominant type.
     */
    @Override
    public SNumber mult(@NotNull SNumber otherType) {
        return this.asHType().mult(otherType.asHType()).asSNumber();
    }

    /**
     * Method that returns the division between the current type and the other type.
     * Returns the dominant type if possible.
     *
     * @param otherType Another type that will be divided to the current type.
     * @return The division between the two types, returning the dominant type.
     */
    @Override
    public SNumber div(@NotNull SNumber otherType){
        return this.asHType().div(otherType.asHType()).asSNumber();
    }

    /**
     * Transform the current {@code SType} as a {@code HType}.
     *
     * @return a transformation
     */
    @Override
    public HiddenInt asHType() {
        return adaptee;
    }
}
