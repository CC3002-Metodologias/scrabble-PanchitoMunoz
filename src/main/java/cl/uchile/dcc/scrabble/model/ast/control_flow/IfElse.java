package cl.uchile.dcc.scrabble.model.ast.control_flow;

import cl.uchile.dcc.scrabble.model.ast.AST;
import cl.uchile.dcc.scrabble.model.ast.ASTComponent;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_control_flow.HiddenIfElse;

/**
 * A class that represents the If-Else control flow.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/08/05 11:42
 */
public class IfElse extends If {

    /**
     * Constructor.
     *
     * @param condition a condition to evaluate.
     * @param ifBody    the if body.
     * @param elseBody  the else body
     */
    public IfElse(
        ASTComponent condition,
        AST ifBody,
        AST elseBody) {
        super(new HiddenIfElse(
            condition.asHiddenAST(),
            ifBody.asHiddenAST(),
            elseBody.asHiddenAST()));
    }
}
