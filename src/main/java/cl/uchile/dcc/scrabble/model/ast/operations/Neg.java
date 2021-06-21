package cl.uchile.dcc.scrabble.model.ast.operations;

import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_operations.HiddenNeg;
import cl.uchile.dcc.scrabble.model.ast.interfaces.AST;
import cl.uchile.dcc.scrabble.model.ast.operations.abstract_operations.AbstractOperation;

/**
 * TODO: DOCUMENTAR
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/20 11:53
 */
public class Neg extends AbstractOperation {

    /**
     * Constructor.
     *
     * @param value an AST. It can be an {@code Operation} or a {@code SType}.
     */
    public Neg(AST value) {
        HiddenNeg adapteeToSet = new HiddenNeg(value.toHiddenAST());
        setAdaptee(adapteeToSet);
    }

    /**
     * Transform a {@code SType} into its equivalent {@code HType}. If the argument is a {@code
     * HType} or an {@code HiddenAST}, it does nothing.
     *
     * @return a transformation
     */
    @Override
    public HiddenNeg toHiddenAST() {
        return new HiddenNeg(getLeftChildren());
    }
}
