package cl.uchile.dcc.scrabble.model.ast.control_flow;

import cl.uchile.dcc.scrabble.model.ast.AST;
import cl.uchile.dcc.scrabble.model.ast.ASTComponent;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_control_flow.HiddenWhile;

/**
 * A class that represents the while's cycle
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/08/05 11:24
 */
public class While extends AbstractControlFlow {

    /**
     * Constructor.
     *
     * @param condition a condition.
     * @param whileBody the while's body.
     */
    public While(
        ASTComponent condition,
        AST whileBody) {
        super(new HiddenWhile(condition.asHiddenAST(), whileBody.asHiddenAST()));
    }
}
