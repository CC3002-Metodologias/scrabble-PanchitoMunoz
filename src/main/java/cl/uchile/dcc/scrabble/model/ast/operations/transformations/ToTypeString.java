package cl.uchile.dcc.scrabble.model.ast.operations.transformations;

import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_operations.transformations.ToHiddenBinary;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_operations.transformations.ToHiddenString;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.interfaces.HiddenOperation;
import cl.uchile.dcc.scrabble.model.ast.interfaces.AST;
import cl.uchile.dcc.scrabble.model.ast.operations.abstract_operations.AbstractOperation;

/**
 * TODO: DOCUMENTAR
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/22 23:58
 */
public class ToTypeString extends AbstractOperation {

    /**
     * Constructor.
     *
     * @param value an AST. It can be an {@code Operation} or a {@code SType}.
     */
    public ToTypeString(AST value) {
        super(new ToHiddenString(value.toHiddenAST()));
    }
}
