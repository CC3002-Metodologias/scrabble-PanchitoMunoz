package cl.uchile.dcc.scrabble.model.ast.builders.interfaces;

import cl.uchile.dcc.scrabble.model.ast.AST;
import cl.uchile.dcc.scrabble.model.types.interface_types.SType;

/**
 * Generic interface for general types that will return any {@code SType}.
 *
 * @see SType
 * @author Francisco Muñoz Guajardo
 * @create 2021/07/02 19:31
 */
public interface TypeASTBuilder {

    /**
     * Builds the {@code AST}.
     *
     * @return the {@code AST} built.
     */
    AST build();
}
