package cl.uchile.dcc.scrabble.model.types.abstract_types;

import cl.uchile.dcc.scrabble.model.factories.types_factories.STypeFactory;
import cl.uchile.dcc.scrabble.model.types.TypeString;
import cl.uchile.dcc.scrabble.model.types.interface_types.SType;

/**
 * An abstract class for the general types used.
 * @author Francisco Muñoz Guajardo
 */
public abstract class AbstractType implements SType {

    /**
     * Transforms the current type to a {@code TypeString}.
     *
     * @return {@code TypeString} with a value equivalent to the current type.
     */
    @Override
    public final TypeString toTypeString() {
        return STypeFactory.createTypeString(this.getValueAsString());
    }

}
