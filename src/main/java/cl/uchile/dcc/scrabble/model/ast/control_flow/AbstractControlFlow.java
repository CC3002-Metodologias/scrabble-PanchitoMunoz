package cl.uchile.dcc.scrabble.model.ast.control_flow;

import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_control_flow.HiddenControlFlow;
import org.jetbrains.annotations.NotNull;

/**
 * An abstract class to represent a generic control flow
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/08/05 11:25
 */
public abstract class AbstractControlFlow implements ControlFlow {

    private final HiddenControlFlow adaptee;

    /**
     * Generic constructor.
     *
     * @param adaptee A class to be adapted
     */
    public AbstractControlFlow(HiddenControlFlow adaptee) {
        this.adaptee = adaptee;
    }

    /**
     * Transform an {@code AST} into its equivalent {@code HiddenASTComponent}.
     *
     * @return a transformation
     */
    @Override
    public @NotNull HiddenControlFlow asHiddenAST() {
        return adaptee;
    }

    /**
     * A string representation.
     *
     * @return the string representation.
     */
    @Override
    public String toString() {
        return adaptee.asString();
    }
}
