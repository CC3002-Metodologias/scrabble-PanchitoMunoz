package cl.uchile.dcc.scrabble.model.hidden_layer;

import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_visitors.HiddenVisitor;

/**
 * todo: doc
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/07/25 22:55
 */
public interface HiddenAST {

    /**
     * Returns the {@code String} representation of the current {@code HiddenASTComponent}.
     *
     * @param space number of spaces to ident
     * @return the current {@code HiddenASTComponent} as {@code String}
     */
    String asString(int space);

    /**
     * Return the current instance as string.
     *
     * @return the current instance as string.
     */
    default String asString() {
        return asString(0);
    }

    /**
     * Method that accepts a {@code HiddenVisitor}.
     *
     * @param visitor a {@code HiddenVisitor}.
     */
    void accept(HiddenVisitor visitor);

    /**
     * Returns the code representation.
     *
     * @param space the number of space of indentation.
     * @return a code representation
     */
    String asCode(int space);

    /**
     * Returns the code representation.
     *
     * @return a code representation.
     */
    default String asCode() {
        return asCode(0);
    }

    /**
     * Creates and returns a copy of this object.
     *
     * @return a clone of this instance.
     */
    HiddenAST copy();
}
