package cl.uchile.dcc.scrabble.model.ast.control_flow;

import cl.uchile.dcc.scrabble.model.ast.AST;
import cl.uchile.dcc.scrabble.model.ast.ASTComponent;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_control_flow.HiddenFor;
import cl.uchile.dcc.scrabble.model.variables.Variable;

/**
 * A class that represents a for cycle
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/08/05 11:34
 */
public class For extends AbstractControlFlow {

    /**
     * Constructor.
     *
     * @param initializer a initializer. It initialize the cycle.
     * @param condition   a condition. The cycle holds while the condition holds.
     * @param increase    an increase. For each cycle the variable increase.
     * @param forFody     The for body.
     */
    public For(
        Variable initializer,
        ASTComponent condition,
        Variable increase,
        AST forFody) {
        super(new HiddenFor(initializer.asHiddenAST(), condition.asHiddenAST(),
            increase.asHiddenAST(), forFody.asHiddenAST()));
    }
}
