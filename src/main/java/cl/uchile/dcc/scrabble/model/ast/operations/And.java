package cl.uchile.dcc.scrabble.model.ast.operations;

import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_operations.HiddenAnd;
import cl.uchile.dcc.scrabble.model.ast.interfaces.AST;
import cl.uchile.dcc.scrabble.model.ast.operations.abstract_operations.AbstractOperation;

/**
 * TODO: Documentar
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/15 11:49
 */
public class And extends AbstractOperation {

    /**
     * Constructor.
     *
     * @param leftValue  an AST. It can be an {@code Operation} or a {@code SType}.
     * @param rightValue an AST. It can be an {@code Operation} or a {@code SType}.
     */
    public And(AST leftValue, AST rightValue) {
        HiddenAnd adapteeToSet = new HiddenAnd(leftValue.toHiddenAST(), rightValue.toHiddenAST());
        setAdaptee(adapteeToSet);
    }

    /**
     * Transform a {@code SType} into its equivalent {@code WType}. If the argument is a {@code
     * WType} or an {@code HiddenAST}, it does nothing.
     *
     * @return a transformation
     */
    @Override
    public HiddenAnd toHiddenAST() {
        return new HiddenAnd(getLeftChildren(), getRightChildren());
    }
}
