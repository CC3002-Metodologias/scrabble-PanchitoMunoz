package cl.uchile.dcc.scrabble.model.ast.interfaces;

import cl.uchile.dcc.scrabble.model.types.interface_types.SType;

/**
 * TODO: DOCUMENTAR
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/20 16:52
 */
public interface Calculate {

    /**
     * Calculate the {@code SType} result of performing all operations
     *
     * @return SType result of operations.
     */
    SType calculate();

}
