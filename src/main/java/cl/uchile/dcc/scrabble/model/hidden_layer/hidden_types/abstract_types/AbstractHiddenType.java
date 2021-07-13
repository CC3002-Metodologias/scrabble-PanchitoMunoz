package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.abstract_types;

import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HType;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HiddenString;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_variable.HiddenASTVisitor;
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
        return tab + this.asSType().toString();
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
        return this.asSType().hashCode();
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
        return this.asSType().equals(hType.asSType());
    }

    /**
     * Method that accepts a {@code HiddenASTVisitor}.
     *
     * @param visitor a {@code HiddenASTVisitor}.
     */
    @Override
    public void accept(HiddenASTVisitor visitor) {
        visitor.visitHType(this);
    }

    /**
     * To use double dispatch in {@code add}
     * @param hiddenString a {@code HiddenString}
     */
    @Override
    public HType addWithString(HiddenString hiddenString) {
        TypeString computed = this.asSType().addWithString(
            hiddenString.asSType());
        return new HiddenString(computed);
    }

}
