package cl.uchile.dcc.scrabble.model.ast.hidden_ast.interfaces;

import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HiddenBinary;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HiddenBool;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HiddenFloat;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HiddenInt;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HiddenString;

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
     * Transform the current instance into a {@code HiddenBinary}.
     *
     * @return a {@code HiddenBinary}
     */
    HiddenBinary toWrappedBinary();

    /**
     * Transform the current instance into a {@code HiddenBool}.
     *
     * @return a {@code HiddenBool}
     */
    HiddenBool toWrappedBool();

    /**
     * Transform the current instance into a {@code HiddenFloat}.
     *
     * @return a {@code HiddenFloat}
     */
    HiddenFloat toWrappedFloat();

    /**
     * Transform the current instance into a {@code HiddenInt}.
     *
     * @return a {@code HiddenInt}
     */
    HiddenInt toWrappedInt();

    /**
     * Transform the current instance into a {@code HiddenString}.
     *
     * @return a {@code HiddenString}
     */
    HiddenString toWrappedString();
}
