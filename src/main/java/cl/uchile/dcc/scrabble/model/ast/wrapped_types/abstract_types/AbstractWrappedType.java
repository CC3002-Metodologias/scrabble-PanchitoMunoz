package cl.uchile.dcc.scrabble.model.ast.wrapped_types.abstract_types;

import cl.uchile.dcc.scrabble.model.WrapTransformation;
import cl.uchile.dcc.scrabble.model.ast.wrapped_types.WType;
import cl.uchile.dcc.scrabble.model.ast.wrapped_types.WrappedBinary;
import cl.uchile.dcc.scrabble.model.ast.wrapped_types.WrappedBool;
import cl.uchile.dcc.scrabble.model.ast.wrapped_types.WrappedFloat;
import cl.uchile.dcc.scrabble.model.ast.wrapped_types.WrappedInt;
import cl.uchile.dcc.scrabble.model.ast.wrapped_types.WrappedString;
import cl.uchile.dcc.scrabble.model.types.TypeString;
import cl.uchile.dcc.scrabble.model.types.interface_types.SType;

/**
 * An abstract class to wrap a generic {@code SType}. To use adapter pattern.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/12 23:54
 * @see SType
 */
public abstract class AbstractWrappedType implements WType {

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
     * Transform a {@code SType} into its equivalent {@code WType}. If the argument is a {@code
     * WType} or an {@code AST}, it does nothing.
     *
     * @return a transformation
     */
    @Override
    public WrapTransformation toWrapType() {
        return this;
    }

    /**
     * To use double dispatch in {@code add}
     */
    @Override
    public WType addWithString(WrappedString wString) {
        TypeString computed = this.getAdaptee().addWithString((TypeString) wString.getAdaptee());
        return new WrappedString(computed);
    }

    /**
     * To use double dispatch in {@code add}
     */
    @Override
    public WType addWithBool(WrappedBool wBool) {
        return null;
    }

    /**
     * To use double dispatch in {@code add}
     */
    @Override
    public WType addWithBinary(WrappedBinary wBinary) {
        return null;
    }

    /**
     * To use double dispatch in {@code add}
     */
    @Override
    public WType addWithFloat(WrappedFloat wFloat) {
        return null;
    }

    /**
     * To use double dispatch in {@code add}
     */
    @Override
    public WType addWithInt(WrappedInt wInt) {
        return null;
    }
}
