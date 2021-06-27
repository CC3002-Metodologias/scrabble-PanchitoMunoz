package cl.uchile.dcc.scrabble.model.ast.hidden_ast;

import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HType;

/**
 * An interface that defines a "type" of Abstract Syntax Tree. This interface is for using the
 * composite pattern. Only used as a hidden abstract layer, and is not intended for use by the user.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/12 22:51
 */
public interface HiddenAST {

    /**
     * Calculate the {@code HType} result of performing all operations.
     *
     * @return {@code HType} result of operations
     */
    HType calculate();

    /**
     * Returns the {@code String} representation of the current {@code HiddenAST}.
     *
     * @param space number of spaces to ident
     * @return the current {@code HiddenAST} as {@code String}
     */
    String asString(int space);
}
