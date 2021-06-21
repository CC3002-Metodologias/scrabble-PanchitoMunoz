package cl.uchile.dcc.scrabble.model.ast.hidden_ast.interfaces;

import cl.uchile.dcc.scrabble.model.ast.hidden_ast.wrapped_types.WType;

/**
 * An interface that defines a "type" of Abstract Syntax Tree. This interface is for using the
 * composite pattern.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/12 22:51
 */
public interface HiddenAST {

    /**
     * Calculate the {@code WType} result of performing all operations.
     *
     * @return {@code WType} result of operations
     */
    WType calculate();

    /**
     * Returns the {@code String} representation of the current {@code HiddenAST}.
     *
     * @param space number of spaces to ident
     * @return the current {@code HiddenAST} as {@code String}
     */
    String asString(int space);
}
