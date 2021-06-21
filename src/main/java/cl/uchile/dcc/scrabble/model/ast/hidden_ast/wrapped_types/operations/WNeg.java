package cl.uchile.dcc.scrabble.model.ast.hidden_ast.wrapped_types.operations;

import cl.uchile.dcc.scrabble.model.ast.hidden_ast.wrapped_types.WType;

/**
 * TODO: DOCUMENTAR
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/20 12:01
 */
public interface WNeg {

    /**
     * Returns the negation of the current instance
     *
     * @return the negation.
     */
    WType neg();
}
