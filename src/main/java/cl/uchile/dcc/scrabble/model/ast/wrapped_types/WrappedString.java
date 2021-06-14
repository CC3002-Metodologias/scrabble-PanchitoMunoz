package cl.uchile.dcc.scrabble.model.ast.wrapped_types;

import cl.uchile.dcc.scrabble.model.ast.wrapped_types.abstract_types.AbstractWrappedType;
import cl.uchile.dcc.scrabble.model.types.TypeString;
import cl.uchile.dcc.scrabble.model.types.interface_types.SType;

/**
 * A class to wrap a {@code TypeString}. To use adapter pattern.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/12 23:57
 * @see TypeString
 */
public class WrappedString extends AbstractWrappedType {

    private final TypeString typeString;

    /**
     * Constructor.
     *
     * @param typeString a type string.
     */
    public WrappedString(TypeString typeString) {
        this.typeString = typeString;
    }

    /**
     * Constructor.
     *
     * @param value a string
     */
    public WrappedString(String value) {
        this.typeString = new TypeString(value);
    }

    /**
     * Gets the current instance in the wrapper
     *
     * @return the instance in the wrapper
     */
    @Override
    public SType getAdaptee() {
        return this.typeString;
    }

    /**
     * To use template pattern in {@code asString}.
     *
     * @return the current {@code AST} as {@code String} without spaces.
     */
    @Override
    protected String asString() {
        return "'" + typeString.getValue() + "'";
    }

    /**
     * Returns the sum
     *
     * @param wType other type to sum
     * @return the sum
     */
    @Override
    public WType add(WType wType) {
        return wType.addWithString(this);
    }
}
