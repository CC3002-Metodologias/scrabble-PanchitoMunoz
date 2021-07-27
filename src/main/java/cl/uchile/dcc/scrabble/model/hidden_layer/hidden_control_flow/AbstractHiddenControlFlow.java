package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_control_flow;

import cl.uchile.dcc.scrabble.model.hidden_layer.AbstractHiddenASTComposite;
import cl.uchile.dcc.scrabble.model.hidden_layer.HiddenAST;

/**
 * todo: doc
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/07/25 18:31
 */
public abstract class AbstractHiddenControlFlow
    extends AbstractHiddenASTComposite
    implements HiddenControlFlow {

    /**
     * Default constructor.
     *
     * @param firstChildren  the first children.
     * @param secondChildren the second children.
     * @param thirdChildren  the third children.
     * @param operatorName   the operator name.
     */
    protected AbstractHiddenControlFlow(
        HiddenAST firstChildren, HiddenAST secondChildren,
        HiddenAST thirdChildren, String operatorName) {
        super(firstChildren, secondChildren, thirdChildren, operatorName);
    }
}
