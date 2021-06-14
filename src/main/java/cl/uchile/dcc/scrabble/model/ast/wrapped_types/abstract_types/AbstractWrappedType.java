package cl.uchile.dcc.scrabble.model.ast.wrapped_types.abstract_types;

import cl.uchile.dcc.scrabble.model.ast.AST;
import cl.uchile.dcc.scrabble.model.ast.wrapped_types.WType;
import cl.uchile.dcc.scrabble.model.ast.wrapped_types.WrappedBinary;
import cl.uchile.dcc.scrabble.model.ast.wrapped_types.WrappedBool;
import cl.uchile.dcc.scrabble.model.ast.wrapped_types.WrappedFloat;
import cl.uchile.dcc.scrabble.model.ast.wrapped_types.WrappedInt;
import cl.uchile.dcc.scrabble.model.ast.wrapped_types.WrappedString;
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
    public AST toWrapType() {
        return this;
    }

    /**
     * To use double dispatch in {@code add}
     */
    @Override
    public WType addWithString(WrappedString wString) {
        return null;
    }

    /**
     * To use double dispatch in {@code add}
     *
     */
    @Override
    public WType addWithBool(WrappedBool wBool) {
        return null;
    }

    /**
     * To use double dispatch in {@code add}
     *
     */
    @Override
    public WType addWithBinary(WrappedBinary wBinary) {
        return null;
    }

    /**
     * To use double dispatch in {@code add}
     *
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

    /**
     * To use double dispatch in {@code and}
     */
    @Override
    public WType andWithString(WrappedString wrappedString) {
        return null;
    }

    /**
     * To use double dispatch in {@code and}
     */
    @Override
    public WType andWithBool(WrappedBool wBool) {
        return null;
    }

    /**
     * To use double dispatch in {@code and}
     */
    @Override
    public WType andWithBinary(WrappedBinary wBinary) {
        return null;
    }

    /**
     * To use double dispatch in {@code and}
     */
    @Override
    public WType andWithFloat(WrappedFloat wrappedFloat) {
        return null;
    }

    /**
     * To use double dispatch in {@code and}
     */
    @Override
    public WType andWithInt(WrappedInt wrappedInt) {
        return null;
    }

    /**
     * To use double dispatch in {@code div}
     */
    @Override
    public WType divWithString(WrappedString wrappedString) {
        return null;
    }

    /**
     * To use double dispatch in {@code div}
     */
    @Override
    public WType divWithBool(WrappedBool wrappedBool) {
        return null;
    }

    /**
     * To use double dispatch in {@code div}
     */
    @Override
    public WType divWithBinary(WrappedBinary wBinary) {
        return null;
    }

    /**
     * To use double dispatch in {@code div}
     */
    @Override
    public WType divWithFloat(WrappedFloat wFloat) {
        return null;
    }

    /**
     * To use double dispatch in {@code div}
     */
    @Override
    public WType divWithInt(WrappedInt wInt) {
        return null;
    }

    /**
     * To use double dispatch in {@code mult}
     */
    @Override
    public WType multWithString(WrappedString wrappedString) {
        return null;
    }

    /**
     * To use double dispatch in {@code mult}
     */
    @Override
    public WType multWithBool(WrappedBool wrappedBool) {
        return null;
    }

    /**
     * To use double dispatch in {@code mult}
     */
    @Override
    public WType multWithBinary(WrappedBinary wBinary) {
        return null;
    }

    /**
     * To use double dispatch in {@code mult}
     */
    @Override
    public WType multWithFloat(WrappedFloat wFloat) {
        return null;
    }

    /**
     * To use double dispatch in {@code mult}
     */
    @Override
    public WType multWithInt(WrappedInt wInt) {
        return null;
    }

    /**
     * To use double dispatch in {@code or}
     */
    @Override
    public WType orWithString(WrappedString wrappedString) {
        return null;
    }

    /**
     * To use double dispatch in {@code or}
     */
    @Override
    public WType orWithBool(WrappedBool wBool) {
        return null;
    }

    /**
     * To use double dispatch in {@code or}
     */
    @Override
    public WType orWithBinary(WrappedBinary wBinary) {
        return null;
    }

    /**
     * To use double dispatch in {@code or}
     */
    @Override
    public WType orWithFloat(WrappedFloat wrappedFloat) {
        return null;
    }

    /**
     * To use double dispatch in {@code or}
     */
    @Override
    public WType orWithInt(WrappedInt wrappedInt) {
        return null;
    }

    /**
     * To use double dispatch in {@code sub}
     */
    @Override
    public WType subWithString(WrappedString wrappedString) {
        return null;
    }

    /**
     * To use double dispatch in {@code sub}
     */
    @Override
    public WType subWithBool(WrappedBool wrappedBool) {
        return null;
    }

    /**
     * To use double dispatch in {@code sub}
     */
    @Override
    public WType subWithBinary(WrappedBinary wBinary) {
        return null;
    }

    /**
     * To use double dispatch in {@code sub}
     */
    @Override
    public WType subWithFloat(WrappedFloat wFloat) {
        return null;
    }

    /**
     * To use double dispatch in {@code sub}
     */
    @Override
    public WType subWithInt(WrappedInt wInt) {
        return null;
    }
}
