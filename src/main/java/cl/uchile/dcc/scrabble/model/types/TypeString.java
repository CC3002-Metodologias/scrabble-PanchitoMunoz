package cl.uchile.dcc.scrabble.model.types;

import cl.uchile.dcc.scrabble.model.builders.interfaces.StringASTBuilder;
import cl.uchile.dcc.scrabble.model.factories.hidden_factories.HTypeFactory;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HiddenString;
import cl.uchile.dcc.scrabble.model.types.abstract_types.AbstractType;
import cl.uchile.dcc.scrabble.model.types.interface_types.SType;
import org.jetbrains.annotations.NotNull;

/**
 * A class for the string type.
 * @author Francisco Muñoz Guajardo
 */
public class TypeString extends AbstractType implements StringASTBuilder {

    /**
     * Constructor for the TypeString.
     * @param value A String as a value.
     */
    public TypeString(String value) {
        super(HTypeFactory.createHiddenString(value));
    }

    /**
     * Returns the current value of the instance.
     *
     * @return The value in the instance
     */
    public String getValue() {
        return this.asHType().getValueAsString();
    }

    /**
     * Method that returns the sum between a TypeString and another type.
     * Returns the dominant type if possible.
     * @param otherType Another type that will be added to the current type.
     * @return The sum between the two types, returning the dominant type.
     */
    public TypeString add(@NotNull SType otherType) {
        return this.asHType().add(otherType.asHType()).asTypeString();
    }

    /**
     * Transform the current {@code SType} as a {@code HType}.
     *
     * @return a transformation
     */
    @Override
    public HiddenString asHType() {
        return (HiddenString) super.asHType();
    }
}
