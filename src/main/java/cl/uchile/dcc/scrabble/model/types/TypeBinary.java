package cl.uchile.dcc.scrabble.model.types;

import cl.uchile.dcc.scrabble.model.builders.interfaces.BinaryASTBuilder;
import cl.uchile.dcc.scrabble.model.factories.hidden_factories.HTypeFactory;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HiddenBinary;
import cl.uchile.dcc.scrabble.model.types.abstract_types.AbstractInteger;
import cl.uchile.dcc.scrabble.model.types.interface_types.SInteger;
import cl.uchile.dcc.scrabble.model.types.interface_types.SLogical;
import cl.uchile.dcc.scrabble.model.types.operations.ArithmeticOperationsWithIntegers;
import org.jetbrains.annotations.NotNull;

/**
 * A class for the binary type.
 *
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
        super(HTypeFactory.createHiddenBinary(value));
    }

    /**
     * Returns the current value of the instance.
     *
     * @return The value in the instance
     */
    public String getValue() {
        return this.asHType().getValueAsBinary();
    }

    /**
     * Returns the negation of the current instance.
     *
     * @return The negation of the current instance.
     */
    @Override
    public TypeBinary neg() {
        return this.asHType().neg().asTypeBinary();
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
        return this.asHType().add(otherType.asHType()).asTypeBinary();
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
        return this.asHType().sub(otherType.asHType()).asTypeBinary();
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
        return this.asHType().mult(otherType.asHType()).asTypeBinary();
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
        return this.asHType().div(otherType.asHType()).asTypeBinary();
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
        return this.asHType().and(otherType.asHType()).asTypeBinary();
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
        return this.asHType().or(otherType.asHType()).asTypeBinary();
    }

    /**
     * Transform the current {@code SType} as a {@code HType}.
     *
     * @return a transformation
     */
    @Override
    public HiddenBinary asHType() {
        return (HiddenBinary) super.asHType();
    }
}
