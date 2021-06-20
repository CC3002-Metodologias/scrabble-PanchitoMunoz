package cl.uchile.dcc.scrabble.model.ast.operations.abstract_operations;

import cl.uchile.dcc.scrabble.model.ast.interfaces.LogicalAST;
import cl.uchile.dcc.scrabble.model.ast.wrapped_types.WrappedBool;

/**
 * TODO: DOCUMENTAR
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/20 11:44
 */
public abstract class AbstractLogicalOperation extends AbstractOperation implements LogicalAST {

    /**
     * Default constructor. It can receive an {@code Operation} or a {@code SLogical}.
     *
     * @param leftValue  left value, it can be an {@code Operation} or a {@code SLogical}.
     * @param rightValue right value, it can be an {@code Operation} or a {@code SLogical}.
     */
    protected AbstractLogicalOperation(LogicalAST leftValue, LogicalAST rightValue) {
        super(leftValue.toAST(), rightValue.toAST());
    }

    /**
     * Default constructor for unary operations. It can receive an {@code Operation} or a {@code
     * Logical AST}.
     *
     * @param value a value, it can be an {@code Operation} or a {@code SLogical}.
     */
    protected AbstractLogicalOperation(LogicalAST value) {
        super(value.toAST(), new WrappedBool(true)); // right value is a dummy variable
    }
}
