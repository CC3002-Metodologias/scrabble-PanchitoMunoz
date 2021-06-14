package cl.uchile.dcc.scrabble.model.ast;

import cl.uchile.dcc.scrabble.model.WrapTransformation;
import cl.uchile.dcc.scrabble.model.types.interface_types.SType;

/**
 * An interface that defines a "type" of Abstract Syntax Tree. This interface is for using the
 * composite pattern.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/12 22:51
 */
public interface AST extends WrapTransformation {

    /**
     * Calculate the {@code SType} result of performing all operations
     *
     * @return SType result of operations.
     */
    SType calculate();

    /**
     * Returns the {@code String} representation of the current {@code AST}.
     *
     * @param space number of spaces to ident
     * @return the current {@code AST} as {@code String}
     */
    String asString(int space);
}
