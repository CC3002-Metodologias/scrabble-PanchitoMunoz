package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_control_flow;

import cl.uchile.dcc.scrabble.model.hidden_layer.HiddenAST;
import cl.uchile.dcc.scrabble.model.hidden_layer.HiddenASTComponent;

/**
 * An interface to represent a general hidden control flow
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
}
