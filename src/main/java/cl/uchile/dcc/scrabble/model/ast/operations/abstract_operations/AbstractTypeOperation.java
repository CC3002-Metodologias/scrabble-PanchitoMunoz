package cl.uchile.dcc.scrabble.model.ast.operations.abstract_operations;

import cl.uchile.dcc.scrabble.model.ast.interfaces.TypeAST;

/**
 * TODO: DOCUMENTAR
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/19 16:28
 */
public abstract class AbstractTypeOperation extends AbstractOperation implements TypeAST {

    /**
     * Constructor. It can receive an {@code Operation} or a {@code SType}.
     *
     * @param leftValue  left value, it can be an {@code Operation} or a {@code SType}.
     * @param rightValue right value, it can be an {@code Operation} or a {@code SType}.
     */
    public AbstractTypeOperation(TypeAST leftValue, TypeAST rightValue) {
        super(leftValue.toAST(), rightValue.toAST());
    }
}
