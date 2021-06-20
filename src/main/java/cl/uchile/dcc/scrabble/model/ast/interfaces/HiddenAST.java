package cl.uchile.dcc.scrabble.model.ast.interfaces;

/**
 * An interface that defines a "type" of Abstract Syntax Tree. This interface is for using the
 * composite pattern.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/12 22:51
 */
public interface HiddenAST extends Calculate {

    /**
     * Returns the {@code String} representation of the current {@code HiddenAST}.
     *
     * @param space number of spaces to ident
     * @return the current {@code HiddenAST} as {@code String}
     */
    String asString(int space);
}
