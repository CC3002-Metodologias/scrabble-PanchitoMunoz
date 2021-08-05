package cl.uchile.dcc.scrabble.model.ast.control_flow;

import cl.uchile.dcc.scrabble.model.ast.AST;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_control_flow.HiddenControlFlow;
import org.jetbrains.annotations.NotNull;

/**
 * An interface to defines a generic control flow.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/08/05 11:23
 */
public interface ControlFlow extends AST {

    /**
     * Transform an {@code AST} into its equivalent {@code HiddenASTComponent}.
     *
     * @return a transformation
     */
    @Override
    @NotNull HiddenControlFlow asHiddenAST();
}
