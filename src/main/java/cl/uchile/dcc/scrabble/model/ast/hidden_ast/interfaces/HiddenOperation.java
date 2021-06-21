package cl.uchile.dcc.scrabble.model.ast.hidden_ast.interfaces;

import cl.uchile.dcc.scrabble.model.ast.hidden_ast.wrapped_types.WrappedBinary;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.wrapped_types.WrappedBool;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.wrapped_types.WrappedFloat;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.wrapped_types.WrappedInt;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.wrapped_types.WrappedString;

/**
 * TODO: DOCUMENTAR
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/21 17:14
 */
public interface HiddenOperation extends HiddenAST {

    /**
     * Get the left children.
     *
     * @return an HiddenAST
     */
    HiddenAST getLeftChildren();

    /**
     * Get the right children.
     *
     * @return an HiddenAST
     */
    HiddenAST getRightChildren();

    /**
     * Transform the current instance into a {@code WrappedBinary}.
     *
     * @return a {@code WrappedBinary}
     */
    WrappedBinary toWrappedBinary();

    /**
     * Transform the current instance into a {@code WrappedBool}.
     *
     * @return a {@code WrappedBool}
     */
    WrappedBool toWrappedBool();

    /**
     * Transform the current instance into a {@code WrappedFloat}.
     *
     * @return a {@code WrappedFloat}
     */
    WrappedFloat toWrappedFloat();

    /**
     * Transform the current instance into a {@code WrappedInt}.
     *
     * @return a {@code WrappedInt}
     */
    WrappedInt toWrappedInt();

    /**
     * Transform the current instance into a {@code WrappedString}.
     *
     * @return a {@code WrappedString}
     */
    WrappedString toWrappedString();
}
