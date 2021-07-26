package cl.uchile.dcc.scrabble.model.hidden_layer;

/**
 * todo: doc
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/07/25 22:55
 */
public interface HiddenAST {

    /**
     * Returns the {@code String} representation of the current {@code HiddenASTComponent}.
     *
     * @param space number of spaces to ident
     * @return the current {@code HiddenASTComponent} as {@code String}
     */
    String asString(int space);
}
