package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_control_flow;

import cl.uchile.dcc.scrabble.model.hidden_layer.AbstractHiddenASTComposite;
import cl.uchile.dcc.scrabble.model.hidden_layer.HiddenASTComponent;

/**
 * todo: doc
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/07/25 18:31
 */
public abstract class AbstractHiddenControlFlow
    extends AbstractHiddenASTComposite
    implements HiddenControlFlow {

    protected AbstractHiddenControlFlow(
        HiddenASTComponent firstChildren,
        HiddenASTComponent secondChildren,
        HiddenASTComponent thirdChildren,
        String operatorName) {
        super(firstChildren, secondChildren, thirdChildren, operatorName);
    }
}
