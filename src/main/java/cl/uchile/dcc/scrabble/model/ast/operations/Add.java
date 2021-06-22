package cl.uchile.dcc.scrabble.model.ast.operations;

import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_operations.HiddenAdd;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.interfaces.HiddenOperation;
import cl.uchile.dcc.scrabble.model.ast.interfaces.AST;
import cl.uchile.dcc.scrabble.model.ast.operations.abstract_operations.AbstractOperation;

/**
 * TODO: Documentar
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/14 9:54
 */
public class Add extends AbstractOperation {

    /**
     * Constructor by default.
     *
     * @param adaptee a HiddenOperation to adapt
     */
    protected Add(HiddenOperation adaptee) {
        super(adaptee);
    }

    /**
     * Constructor.
     *
     * @param leftValue  an AST. It can be an {@code Operation} or a {@code SType}.
     * @param rightValue an AST. It can be an {@code Operation} or a {@code SType}.
     */
    public Add(AST leftValue, AST rightValue) {
        this(new HiddenAdd(leftValue.toHiddenAST(), rightValue.toHiddenAST()));
    }

    /**
     * Transform a {@code SType} into its equivalent {@code HType}. If the argument is a {@code
     * HType} or an {@code HiddenAST}, it does nothing.
     *
     * @return a transformation
     */
    @Override
    public HiddenAdd toHiddenAST() {
        return new HiddenAdd(getLeftChildren(), getRightChildren());
    }
}
