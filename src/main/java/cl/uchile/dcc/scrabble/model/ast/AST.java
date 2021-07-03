package cl.uchile.dcc.scrabble.model.ast;

import cl.uchile.dcc.scrabble.model.ast.operations.Operation;
import cl.uchile.dcc.scrabble.model.types.interface_types.SType;

/**
 * An interface that defines the components of an AST. It can be a {@code SType} or an {@code Operation}.
 *
 * @see SType
 * @see Operation
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/19 16:29
 */
public interface AST extends HiddenASTTransformation {

    /**
     * Calculate the {@code SType} result of performing all operations
     *
     * @return SType result of operations.
     */
    SType calculate();

}
