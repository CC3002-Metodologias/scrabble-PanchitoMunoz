package cl.uchile.dcc.scrabble.model.ast.control_flow;

import cl.uchile.dcc.scrabble.model.ast.AST;
import cl.uchile.dcc.scrabble.model.ast.ASTComponent;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_control_flow.HiddenControlFlow;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_control_flow.HiddenIf;

/**
 * A class that represents an If control flow.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/08/05 11:39
 */
public class If extends AbstractControlFlow {

    /**
     * Constructor.
     *
     * @param condition the condition.
     * @param ifBody    the If body.
     */
    public If(
        ASTComponent condition,
        AST ifBody) {
        super(new HiddenIf(condition.asHiddenAST(), ifBody.asHiddenAST()));
    }

    /**
     * Generic constructor.
     *
     * @param adaptee a class to be adapted.
     */
    protected If(HiddenControlFlow adaptee) {
        super(adaptee);
    }
}
