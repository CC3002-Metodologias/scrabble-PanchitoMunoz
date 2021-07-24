package cl.uchile.dcc.scrabble.model.types;

import cl.uchile.dcc.scrabble.model.builders.interfaces.BoolASTBuilder;
import cl.uchile.dcc.scrabble.model.factories.hidden_factories.HTypeFactory;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HiddenBool;
import cl.uchile.dcc.scrabble.model.types.abstract_types.AbstractType;
import cl.uchile.dcc.scrabble.model.types.interface_types.SLogical;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

/**
 * A class for the boolean type.
 * @author Francisco Muñoz Guajardo
 */
public class TypeBool extends AbstractType implements SLogical, BoolASTBuilder {

    private final boolean value;
    private final HiddenBool adaptee;

    /**
     * Constructor for the BoolType.
     * @param value A boolean as a value.
     */
    public TypeBool(boolean value) {
        this.value = value;
        this.adaptee = HTypeFactory.createHiddenBool(value);
    }

    /**
     * Returns the current value of the instance.
     *
     * @return The value in the instance
     */
    public boolean getValue() {
        return this.asHType().getValueAsBool();
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
     * Transforms the current type to a TypeBool.
     *
     * @return TypeBool with a value equivalent to the current type.
     */
    public TypeBool toTypeBool() {
        return this;
    }

    /**
     * Returns the negation of the current instance.
     * @return The negation of the current instance.
     */
    @Override
    public TypeBool neg() {
        return this.asHType().neg().asTypeBool();
    }

    /**
     * Method that returns the disjunction between the current type and the other type.
     * Returns the dominant type if possible.
     * @param otherType Another type that will be disjunct to the current type.
     * @return The disjunction between the two types, returning the dominant type.
     */
    @Override
    public SLogical and(@NotNull SLogical otherType) {
        return this.asHType().and(otherType.asHType()).asSLogical();
    }

    /**
     * Method that returns the conjunction between the current type and the other type.
     * Returns the dominant type if possible.
     * @param otherType Another type that will be conjunct to the current type.
     * @return The conjunction between the two types, returning the dominant type.
     */
    @Override
    public SLogical or(@NotNull SLogical otherType) {
        return this.asHType().or(otherType.asHType()).asSLogical();
    }

    /**
     * Transform the current {@code SType} as a {@code HType}.
     *
     * @return a transformation
     */
    @Override
    public HiddenBool asHType() {
        return adaptee;
    }
}
