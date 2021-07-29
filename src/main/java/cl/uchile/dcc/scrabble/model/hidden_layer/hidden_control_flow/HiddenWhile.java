package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_control_flow;

import cl.uchile.dcc.scrabble.model.hidden_layer.HiddenAST;
import cl.uchile.dcc.scrabble.model.hidden_layer.HiddenASTComposite;

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
        HiddenASTComposite condition,
        HiddenAST whileBody) {
        super(condition, whileBody, "While");
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
