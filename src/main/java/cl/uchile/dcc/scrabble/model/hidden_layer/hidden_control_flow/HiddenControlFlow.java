package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_control_flow;

import cl.uchile.dcc.scrabble.model.ast.control_flow.ControlFlow;
import cl.uchile.dcc.scrabble.model.hidden_layer.HiddenAST;
import cl.uchile.dcc.scrabble.model.hidden_layer.HiddenASTComponent;
import org.jetbrains.annotations.NotNull;

/**
 * todo: doc
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/07/25 18:35
 */
public interface HiddenControlFlow extends HiddenAST {

    /**
     * Returns the condition.
     *
     * @return gets the condition
     */
    HiddenASTComponent getCondition();

    /**
     * Returns the AST equivalent.
     *
     * @return an AST equivalent.
     */
    @Override
    @NotNull ControlFlow asAST();
}
