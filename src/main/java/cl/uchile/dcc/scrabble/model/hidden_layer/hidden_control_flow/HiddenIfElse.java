package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_control_flow;

import cl.uchile.dcc.scrabble.model.hidden_layer.HiddenAST;
import cl.uchile.dcc.scrabble.model.hidden_layer.HiddenASTComposite;

/**
 * todo: doc
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/07/26 0:21
 */
public class HiddenIfElse extends AbstractHiddenControlFlow {

    private final HiddenAST elseBody;

    /**
     * Constructor.
     *
     * @param condition A condition. It can be a {@code HiddenASTComponent}.
     * @param ifBody    the body if the condition is true.
     * @param elseBody  the body if the condition is false.
     */
    protected HiddenIfElse(
        HiddenASTComposite condition,
        HiddenAST ifBody,
        HiddenAST elseBody) {
        super(condition, ifBody, "IfElse");
        this.elseBody = elseBody;
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
}
