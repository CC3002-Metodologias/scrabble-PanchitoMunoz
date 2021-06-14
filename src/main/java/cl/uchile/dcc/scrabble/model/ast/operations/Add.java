package cl.uchile.dcc.scrabble.model.ast.operations;

import cl.uchile.dcc.scrabble.model.ast.operations.abstract_operations.AbstractTypeOperation;
import cl.uchile.dcc.scrabble.model.types.interface_types.SType;

/**
 * TODO: Documentar
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/14 9:54
 */
public class Add extends AbstractTypeOperation {

    /**
     * Calculate the {@code SType} result of performing all operations
     *
     * @return SType result of operations.
     */
    @Override
    public SType calculate() {
        return null;
    }

    /**
     * Returns the {@code String} representation of the current {@code AST}.
     *
     * @param space number of spaces to ident
     * @return the current {@code AST} as {@code String}
     */
    @Override
    public String asString(int space) {
        return null;
    } //TODO: Quitar el abstract

}
