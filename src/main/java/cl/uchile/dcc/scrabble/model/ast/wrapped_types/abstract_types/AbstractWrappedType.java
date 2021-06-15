package cl.uchile.dcc.scrabble.model.ast.wrapped_types.abstract_types;

import cl.uchile.dcc.scrabble.model.ast.AST;
import cl.uchile.dcc.scrabble.model.ast.wrapped_types.WType;
import cl.uchile.dcc.scrabble.model.ast.wrapped_types.WrappedBinary;
import cl.uchile.dcc.scrabble.model.ast.wrapped_types.WrappedBool;
import cl.uchile.dcc.scrabble.model.ast.wrapped_types.WrappedFloat;
import cl.uchile.dcc.scrabble.model.ast.wrapped_types.WrappedInt;
import cl.uchile.dcc.scrabble.model.ast.wrapped_types.WrappedString;
import cl.uchile.dcc.scrabble.model.types.TypeString;
import cl.uchile.dcc.scrabble.model.types.interface_types.SType;
import java.util.HashMap;

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
    protected String asString() {
        return this.getAdaptee().asString(0);
    }

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
     * Returns a hash code value for the object.
     *
     * @return a hash code value for this object.
     * @see Object#equals(Object)
     * @see System#identityHashCode
     */
    @Override
    public int hashCode() {
        return this.getAdaptee().hashCode();
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     *
     * @param obj the reference object with which to compare.
     * @return {@code true} if this object is the same as the obj argument; {@code false} otherwise.
     * @see #hashCode()
     * @see HashMap
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WType)) {
            return false;
        }
        WType wType = (WType) obj;
        return this.getAdaptee().equals(wType.getAdaptee());
    }

    /**
     * Transform the current instance to a {@code WrappedBinary}.
     *
     * @return a {@code WrappedBinary} equivalent
     */
    @Override
    public WrappedBinary toWrappedBinary() {
        return null;
    }

    /**
     * Transform the current instance to a {@code WrappedBool}.
     *
     * @return a {@code WrappedBool} equivalent
     */
    @Override
    public WrappedBool toWrappedBool() {
        return null;
    }

    /**
     * Transform the current instance to a {@code WrappedFloat}.
     *
     * @return a {@code WrappedFloat} equivalent
     */
    @Override
    public WrappedFloat toWrappedFloat() {
        return null;
    }

    /**
     * Transform the current instance to a {@code WrappedInt}.
     *
     * @return a {@code WrappedInt} equivalent
     */
    @Override
    public WrappedInt toWrappedInt() {
        return null;
    }

    /**
     * Transform the current instance to a {@code WrappedString}.
     *
     * @return a {@code WrappedString} equivalent
     */
    @Override
    public WrappedString toWrappedString() {
        return null;
    }

    /**
     * To use double dispatch in {@code add}
     */
    @Override
    public WType addWithString(WrappedString wString) {
        TypeString computed = this.getAdaptee().addWithString(
            (TypeString) wString.getAdaptee());
        return new WrappedString(computed);
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
