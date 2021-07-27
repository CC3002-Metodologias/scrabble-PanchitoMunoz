package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_control_flow;

import cl.uchile.dcc.scrabble.model.factories.hidden_factories.HTypeFactory;
import cl.uchile.dcc.scrabble.model.hidden_layer.HiddenAST;
import cl.uchile.dcc.scrabble.model.hidden_layer.HiddenASTComponent;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HType;
import java.util.Stack;

/**
 * todo: doc
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/07/26 0:23
 */
public class HiddenWhile extends AbstractHiddenControlFlow {

    /**
     * Default constructor.
     *
     * @param condition A condition. It can be a {@code HiddenASTComponent}.
     * @param whileBody The body that it could be executed iff the condition holds.
     */
    protected HiddenWhile(
        HiddenASTComponent condition,
        HiddenAST whileBody) {
        super(condition, whileBody, HTypeFactory.createHiddenNull(), "While");
    }

    /**
     * Returns the {@code String} representation of the current {@code HiddenASTComponent}.
     *
     * @param space number of spaces to ident
     * @return the current {@code HiddenASTComponent} as {@code String}
     */
    @Override
    public String asString(int space) {
        return null;
    }

    /**
     * Calculate the {@code HType} result of performing all operations.
     *
     * @return {@code HType} result of operations
     */
    @Override
    public HType calculate() {
        return null;
    }

    /**
     * Updates the stack.
     *
     * @param stack the current stack.
     */
    @Override
    public void updateStack(Stack<HiddenASTComponent> stack) {

    }

    /**
     * Returns the number of vertices in the current {@code HiddenASTComponent}
     *
     * @return the number of vertices
     */
    @Override
    public int size() {
        return 0;
    }
}
