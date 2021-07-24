package cl.uchile.dcc.scrabble.model.types;

import cl.uchile.dcc.scrabble.model.builders.interfaces.BoolASTBuilder;
import cl.uchile.dcc.scrabble.model.factories.hidden_factories.HTypeFactory;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HiddenBool;
import cl.uchile.dcc.scrabble.model.types.abstract_types.AbstractType;
import cl.uchile.dcc.scrabble.model.types.interface_types.SLogical;
import org.jetbrains.annotations.NotNull;

/**
 * A class for the boolean type.
 * @author Francisco Muñoz Guajardo
 */
public class TypeBool extends AbstractType implements SLogical, BoolASTBuilder {

    /**
     * Constructor for the BoolType.
     * @param value A boolean as a value.
     */
    public TypeBool(boolean value) {
        super(HTypeFactory.createHiddenBool(value));
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
        return (HiddenBool) super.asHType();
    }
}
