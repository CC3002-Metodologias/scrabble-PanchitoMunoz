package cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.operations;

import cl.uchile.dcc.scrabble.model.ast.hidden_ast.interfaces.HType;

/**
 * TODO: DOCUMENTAR
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/20 12:01
 */
public interface HNeg {

    /**
     * Returns the negation of the current instance
     *
     * @return the negation.
     */
    default HType neg() {
        return null;
    }
}
