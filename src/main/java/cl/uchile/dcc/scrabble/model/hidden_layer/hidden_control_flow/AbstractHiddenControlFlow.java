package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_control_flow;

import cl.uchile.dcc.scrabble.model.hidden_layer.HiddenAST;
import cl.uchile.dcc.scrabble.model.hidden_layer.HiddenASTComposite;

/**
 * todo: doc
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/07/25 18:31
 */
public abstract class AbstractHiddenControlFlow
    implements HiddenControlFlow {

    private final HiddenASTComposite condition;
    private final HiddenAST firstBody;
    private final String operatorName;

    /**
     * Default constructor.
     *
     * @param condition    the condition.
     * @param firstBody    the first body to execute.
     * @param operatorName the operator name.
     */
    protected AbstractHiddenControlFlow(
        HiddenASTComposite condition, HiddenAST firstBody,
        String operatorName) {
        this.condition = condition;
        this.firstBody = firstBody;
        this.operatorName = operatorName;
    }

    public HiddenASTComposite getCondition() {
        return condition;
    }

    public HiddenAST getFirstBody() {
        return firstBody;
    }

    public String getOperatorName() {
        return operatorName;
    }
}
