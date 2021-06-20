package cl.uchile.dcc.scrabble.model.ast.operations.abstract_operations;

import cl.uchile.dcc.scrabble.model.ast.interfaces.NumberAST;

/**
 * TODO: DOCUMENTAR
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/20 11:39
 */
public abstract class AbstractNumberOperation extends AbstractOperation implements NumberAST {

    /**
     * Constructor. It can receive an {@code Operation} or a {@code SNumber}.
     *
     * @param leftValue  left value, it can be an {@code Operation} or a {@code SNumber}.
     * @param rightValue right value, it can be an {@code Operation} or a {@code SNumber}.
     */
    protected AbstractNumberOperation(NumberAST leftValue, NumberAST rightValue) {
        super(leftValue.toAST(), rightValue.toAST());
    }
}
