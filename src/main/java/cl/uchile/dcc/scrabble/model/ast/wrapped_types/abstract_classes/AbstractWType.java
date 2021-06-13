package cl.uchile.dcc.scrabble.model.ast.wrapped_types.abstract_classes;

import cl.uchile.dcc.scrabble.model.ast.wrapped_types.WBinary;
import cl.uchile.dcc.scrabble.model.ast.wrapped_types.WBool;
import cl.uchile.dcc.scrabble.model.ast.wrapped_types.WFloat;
import cl.uchile.dcc.scrabble.model.ast.wrapped_types.WInt;
import cl.uchile.dcc.scrabble.model.ast.wrapped_types.WString;
import cl.uchile.dcc.scrabble.model.ast.wrapped_types.WType;
import cl.uchile.dcc.scrabble.model.types.TypeString;
import cl.uchile.dcc.scrabble.model.types.interface_types.SType;

/**
 * An abstract class to wrap a generic {@code SType}. To use adapter pattern.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/12 23:54
 * @see SType
 */
public abstract class AbstractWType implements WType {

    /**
     * Calculate the {@code SType} result of performing all operations
     *
     * @return SType result of operations.
     */
    @Override
    public SType calculate() {
        return this.getAdaptee();  // Using template pattern
    }

    /**
     * Gets the current instance in the wrapper
     *
     * @return the instance in the wrapper
     */
    abstract protected SType getAdaptee();

    /**
     * The string representation.
     *
     * @return the representation of the instance
     */
    @Override
    public String toString() {
        return this.asString(0);
    }

    /**
     * Returns the {@code String} representation of the current {@code AST}.
     *
     * @param space number of spaces to ident
     * @return the current {@code AST} as {@code String}
     */
    @Override
    public String asString(int space) {
        String tab = " ".repeat(space);
        return tab + asString();
    }

    /**
     * To use template pattern in {@code asString}.
     *
     * @return the current {@code AST} as {@code String} without spaces.
     */
    abstract protected String asString();

    /**
     * To use double dispatch in {@code add}
     */
    @Override
    public WType addWithString(WString wString) {
        TypeString computed = this.getAdaptee().addWithString((TypeString) wString.getAdaptee());
        return new WString(computed);
    }

    /**
     * To use double dispatch in {@code add}
     */
    @Override
    public WType addWithBool(WBool wBool) {
        return null;
    }

    /**
     * To use double dispatch in {@code add}
     */
    @Override
    public WType addWithBinary(WBinary wBinary) {
        return null;
    }

    /**
     * To use double dispatch in {@code add}
     */
    @Override
    public WType addWithFloat(WFloat wFloat) {
        return null;
    }

    /**
     * To use double dispatch in {@code add}
     */
    @Override
    public WType addWithInt(WInt wInt) {
        return null;
    }
}
