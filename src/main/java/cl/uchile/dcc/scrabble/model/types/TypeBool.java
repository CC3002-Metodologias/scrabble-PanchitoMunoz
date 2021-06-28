package cl.uchile.dcc.scrabble.model.types;

import static cl.uchile.dcc.scrabble.model.factories.hidden_factories.HTypeFactory.createHiddenBool;
import static cl.uchile.dcc.scrabble.model.utils.BinaryUtilities.boolAndBinary;
import static cl.uchile.dcc.scrabble.model.utils.BinaryUtilities.boolOrBinary;

import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HiddenBool;
import cl.uchile.dcc.scrabble.model.factories.types_factories.STypeFactory;
import cl.uchile.dcc.scrabble.model.types.abstract_types.AbstractType;
import cl.uchile.dcc.scrabble.model.types.interface_types.SLogical;
import java.util.Objects;

/**
 * A class for the boolean type.
 * @author Francisco Muñoz Guajardo
 */
public class TypeBool extends AbstractType implements SLogical {
    private final boolean value;

    /**
     * Constructor for the BoolType.
     * @param value A boolean as a value.
     */
    public TypeBool(boolean value) {
        this.value = value;
    }

    /**
     * Returns the current value of the instance.
     *
     * @return The value in the instance
     */
    public boolean getValue() {
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
     * Returns the value as {@code String}.
     *
     * @return the current value as {@code String}
     */
    @Override
    public String getValueAsString() {
        return Boolean.toString(this.value);
    }

    /**
     * Transforms the current type to a TypeBool.
     *
     * @return TypeBool with a value equivalent to the current type.
     */
    public TypeBool toTypeBool() {
        return STypeFactory.createTypeBool(this.value);
    }

    /**
     * Returns the negation of the current instance.
     * @return The negation of the current instance.
     */
    @Override
    public TypeBool neg() {
        return STypeFactory.createTypeBool(!(this.value));
    }

    /**
     * Returns the add between the current type and a String Type.
     *
     * @param typeString A string type who will be added to the current type.
     * @return The sum between the String type and the other type.
     */
    @Override
    public TypeString addWithString(TypeString typeString) {
        return STypeFactory.createTypeString(typeString.getValue() + this.value);
    }

    /**
     * Method that returns the disjunction between the current type and the other type.
     * Returns the dominant type if possible.
     * @param otherType Another type that will be disjunct to the current type.
     * @return The disjunction between the two types, returning the dominant type.
     */
    @Override
    public SLogical and(SLogical otherType) {
        return otherType.andWithBool(this);
    }

    /**
     * Method that returns the conjunction between the current type and the other type.
     * Returns the dominant type if possible.
     * @param otherType Another type that will be conjunct to the current type.
     * @return The conjunction between the two types, returning the dominant type.
     */
    @Override
    public SLogical or(SLogical otherType) {
        return otherType.orWithBool(this);
    }

    /**
     * Returns the disjunction between the current type and a Bool Type.
     *
     * @param typeBool A Bool type who will be disjunct to the current type.
     * @return The disjunction between the Bool type and the other type.
     */
    @Override
    public TypeBool andWithBool(TypeBool typeBool) {
        return STypeFactory.createTypeBool(typeBool.value && this.value);
    }

    /**
     * Returns the conjunction between the current type and a Bool Type.
     *
     * @param typeBool A Bool type who will be conjunct to the current type.
     * @return The conjunction between the Bool type and the other type.
     */
    @Override
    public TypeBool orWithBool(TypeBool typeBool) {
        return STypeFactory.createTypeBool(typeBool.value || this.value);
    }

    /**
     * Returns the disjunction between the current type and a Binary Type.
     *
     * @param typeBinary A Binary type who will be disjunct to the current type.
     * @return The disjunction between the Binary type and the other type.
     */
    @Override
    public TypeBinary andWithBinary(TypeBinary typeBinary) {
        return STypeFactory.createTypeBinary(boolAndBinary(this.value, typeBinary.getValue()));
    }

    /**
     * Returns the conjunction between the current type and a Binary Type.
     *
     * @param typeBinary A Binary type who will be conjunct to the current type.
     * @return The conjunction between the Binary type and the other type.
     */
    @Override
    public TypeBinary orWithBinary(TypeBinary typeBinary) {
        return STypeFactory.createTypeBinary(boolOrBinary(this.value, typeBinary.getValue()));
    }

    /**
     * Transform an {@code AST} into its equivalent {@code HiddenAST}.
     *
     * @return a transformation
     */
    @Override
    public HiddenBool toHiddenAST() {
        return createHiddenBool(this);
    }
}
