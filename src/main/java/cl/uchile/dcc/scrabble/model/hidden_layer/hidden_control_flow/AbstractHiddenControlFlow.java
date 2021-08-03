package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_control_flow;

import cl.uchile.dcc.scrabble.model.hidden_layer.HiddenAST;
import cl.uchile.dcc.scrabble.model.hidden_layer.HiddenASTComponent;

/**
 * todo: doc
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/07/25 18:31
 */
public abstract class AbstractHiddenControlFlow
    implements HiddenControlFlow {

    private final HiddenASTComponent condition;
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
        HiddenASTComponent condition, HiddenAST firstBody,
        String operatorName) {
        this.condition = condition;
        this.firstBody = firstBody;
        this.operatorName = operatorName;
    }

    /**
     * Returns the condition.
     *
     * @return gets the condition
     */
    public HiddenASTComponent getCondition() {
        return condition;
    }

    /**
     * Gets the first body.
     *
     * @return the first body
     */
    public HiddenAST getFirstBody() {
        return firstBody;
    }

    /**
     * Gets the operator's name
     *
     * @return the operator's name
     */
    public String getOperatorName() {
        return operatorName;
    }

    /**
     * A String representation of the current instance.
     *
     * @return a string representation
     */
    @Override
    public final String toString() {
        return asString(0);
    }
}
