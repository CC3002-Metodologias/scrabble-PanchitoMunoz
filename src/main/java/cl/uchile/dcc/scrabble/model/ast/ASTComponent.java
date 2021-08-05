package cl.uchile.dcc.scrabble.model.ast;

import cl.uchile.dcc.scrabble.model.hidden_layer.HiddenASTComponent;
import org.jetbrains.annotations.NotNull;

/**
 * A component of an AST
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/08/05 10:35
 */
public interface ASTComponent extends AST {

    /**
     * Transform an {@code AST} into its equivalent {@code HiddenASTComponent}.
     *
     * @return a transformation
     */
    @Override
    @NotNull HiddenASTComponent asHiddenAST();
}
