package cl.uchile.dcc.scrabble.model.ast.hidden_ast.interfaces;

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
    HiddenOperation toHiddenBinary();

    /**
     * Transform the current instance into a {@code HiddenBool}.
     *
     * @return a {@code HiddenBool}
     */
    HiddenOperation toHiddenBool();

    /**
     * Transform the current instance into a {@code HiddenFloat}.
     *
     * @return a {@code HiddenFloat}
     */
    HiddenOperation toHiddenFloat();

    /**
     * Transform the current instance into a {@code HiddenInt}.
     *
     * @return a {@code HiddenInt}
     */
    HiddenOperation toHiddenInt();

    /**
     * Transform the current instance into a {@code HiddenString}.
     *
     * @return a {@code HiddenString}
     */
    HiddenOperation toHiddenString();
}
