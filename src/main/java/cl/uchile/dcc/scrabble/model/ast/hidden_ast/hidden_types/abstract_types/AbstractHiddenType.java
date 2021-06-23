package cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.abstract_types;

import cl.uchile.dcc.scrabble.model.ast.hidden_ast.interfaces.HType;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HiddenBinary;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HiddenBool;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HiddenInt;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HiddenString;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HiddenFloat;
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
public abstract class AbstractHiddenType implements HType {

    /**
     * Calculate the {@code HType} result of performing all operations
     *
     * @return HType result of operations.
     */
    @Override
    public HType calculate() {
        return this;
    }

    /**
     * Returns the {@code String} representation of the current {@code HiddenAST}.
     *
     * @param space number of spaces to ident
     * @return the current {@code HiddenAST} as {@code String}
     */
    @Override
    public String asString(int space) {
        String tab = " ".repeat(space);
        return tab + this.toSType().toString();
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
        return this.toSType().hashCode();
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
        if (!(obj instanceof HType)) {
            return false;
        }
        HType hType = (HType) obj;
        return this.toSType().equals(hType.toSType());
    }

    /**
     * Returns the negation of the current instance
     *
     * @return the negation.
     */
    @Override
    public HType neg() {
        return null;
    }

    /**
     * Transform the current instance to a {@code HiddenBinary}.
     *
     * @return a {@code HiddenBinary} equivalent
     */
    @Override
    public HiddenBinary toHiddenBinary() {
        return null;
    }

    /**
     * Transform the current instance to a {@code HiddenBool}.
     *
     * @return a {@code HiddenBool} equivalent
     */
    @Override
    public HiddenBool toHiddenBool() {
        return null;
    }

    /**
     * Transform the current instance to a {@code HiddenFloat}.
     *
     * @return a {@code HiddenFloat} equivalent
     */
    @Override
    public HiddenFloat toHiddenFloat() {
        return null;
    }

    /**
     * Transform the current instance to a {@code HiddenInt}.
     *
     * @return a {@code HiddenInt} equivalent
     */
    @Override
    public HiddenInt toHiddenInt() {
        return null;
    }

    /**
     * To use double dispatch in {@code add}
     */
    @Override
    public HType addWithString(HiddenString wString) {
        TypeString computed = this.toSType().addWithString(
            wString.toSType());
        return new HiddenString(computed);
    }

    /**
     * To use double dispatch in {@code add}
     *
     */
    @Override
    public HType addWithBool(HiddenBool wBool) {
        return null;
    }

    /**
     * To use double dispatch in {@code add}
     *
     */
    @Override
    public HType addWithBinary(HiddenBinary wBinary) {
        return null;
    }

    /**
     * To use double dispatch in {@code add}
     *
     */
    @Override
    public HType addWithFloat(HiddenFloat wFloat) {
        return null;
    }

    /**
     * To use double dispatch in {@code add}
     */
    @Override
    public HType addWithInt(HiddenInt wInt) {
        return null;
    }

    /**
     * To use double dispatch in {@code and}
     */
    @Override
    public HType andWithString(HiddenString wrappedString) {
        return null;
    }

    /**
     * To use double dispatch in {@code and}
     */
    @Override
    public HType andWithBool(HiddenBool wBool) {
        return null;
    }

    /**
     * To use double dispatch in {@code and}
     */
    @Override
    public HType andWithBinary(HiddenBinary wBinary) {
        return null;
    }

    /**
     * To use double dispatch in {@code and}
     */
    @Override
    public HType andWithFloat(HiddenFloat wrappedFloat) {
        return null;
    }

    /**
     * To use double dispatch in {@code and}
     */
    @Override
    public HType andWithInt(HiddenInt wrappedInt) {
        return null;
    }

    /**
     * To use double dispatch in {@code div}
     */
    @Override
    public HType divWithString(HiddenString wrappedString) {
        return null;
    }

    /**
     * To use double dispatch in {@code div}
     */
    @Override
    public HType divWithBool(HiddenBool wrappedBool) {
        return null;
    }

    /**
     * To use double dispatch in {@code div}
     */
    @Override
    public HType divWithBinary(HiddenBinary wBinary) {
        return null;
    }

    /**
     * To use double dispatch in {@code div}
     */
    @Override
    public HType divWithFloat(HiddenFloat wFloat) {
        return null;
    }

    /**
     * To use double dispatch in {@code div}
     */
    @Override
    public HType divWithInt(HiddenInt wInt) {
        return null;
    }

    /**
     * To use double dispatch in {@code mult}
     */
    @Override
    public HType multWithString(HiddenString wrappedString) {
        return null;
    }

    /**
     * To use double dispatch in {@code mult}
     */
    @Override
    public HType multWithBool(HiddenBool wrappedBool) {
        return null;
    }

    /**
     * To use double dispatch in {@code mult}
     */
    @Override
    public HType multWithBinary(HiddenBinary wBinary) {
        return null;
    }

    /**
     * To use double dispatch in {@code mult}
     */
    @Override
    public HType multWithFloat(HiddenFloat wFloat) {
        return null;
    }

    /**
     * To use double dispatch in {@code mult}
     */
    @Override
    public HType multWithInt(HiddenInt wInt) {
        return null;
    }

    /**
     * To use double dispatch in {@code or}
     */
    @Override
    public HType orWithString(HiddenString wrappedString) {
        return null;
    }

    /**
     * To use double dispatch in {@code or}
     */
    @Override
    public HType orWithBool(HiddenBool wBool) {
        return null;
    }

    /**
     * To use double dispatch in {@code or}
     */
    @Override
    public HType orWithBinary(HiddenBinary wBinary) {
        return null;
    }

    /**
     * To use double dispatch in {@code or}
     */
    @Override
    public HType orWithFloat(HiddenFloat wrappedFloat) {
        return null;
    }

    /**
     * To use double dispatch in {@code or}
     */
    @Override
    public HType orWithInt(HiddenInt wrappedInt) {
        return null;
    }

    /**
     * To use double dispatch in {@code sub}
     */
    @Override
    public HType subWithString(HiddenString wrappedString) {
        return null;
    }

    /**
     * To use double dispatch in {@code sub}
     */
    @Override
    public HType subWithBool(HiddenBool wrappedBool) {
        return null;
    }

    /**
     * To use double dispatch in {@code sub}
     */
    @Override
    public HType subWithBinary(HiddenBinary wBinary) {
        return null;
    }

    /**
     * To use double dispatch in {@code sub}
     */
    @Override
    public HType subWithFloat(HiddenFloat wFloat) {
        return null;
    }

    /**
     * To use double dispatch in {@code sub}
     */
    @Override
    public HType subWithInt(HiddenInt wInt) {
        return null;
    }
}
