package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.abstract_types;

import cl.uchile.dcc.scrabble.model.factories.hidden_factories.HTypeFactory;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HType;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HiddenString;
import cl.uchile.dcc.scrabble.model.types.interface_types.SType;

/**
 * An abstract class to represent a general Type
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/12 23:54
 * @see SType
 */
public abstract class AbstractHiddenType implements HType {

    /**
     * Transform the current instance to a {@code HiddenString}.
     *
     * @return a {@code HiddenString} equivalent
     */
    @Override
    public final HiddenString toHiddenString() {
        String computed = this.getValueAsString();
        return HTypeFactory.createHiddenString(computed);
    }

    /**
     * Returns the {@code String} representation of the current {@code HiddenAST}.
     *
     * @param space number of spaces to ident
     * @return the current {@code HiddenAST} as {@code String}
     */
    @Override
    public final String asString(int space) {
        String tab = " ".repeat(space);
        return tab + this.sTypeAsString();
    }

    /**
     * Returns the {@code SType} as String
     *
     * @return the {@code SType} as String
     */
    public abstract String sTypeAsString();

}
