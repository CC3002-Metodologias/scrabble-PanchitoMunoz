package cl.uchile.dcc.scrabble.model.hidden_layer;

/**
 * An interface that generalize the transformations.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/08/03 8:36
 */
public interface HTransformation {

    /**
     * Transform the current instance to a {@code HiddenBinary}.
     *
     * @return a {@code HiddenBinary} equivalent
     */
    HiddenASTComponent toHiddenBinary();

    /**
     * Transform the current instance to a {@code HiddenBool}.
     *
     * @return a {@code HiddenBool} equivalent
     */
    HiddenASTComponent toHiddenBool();

    /**
     * Transform the current instance to a {@code HiddenFloat}.
     *
     * @return a {@code HiddenFloat} equivalent
     */
    HiddenASTComponent toHiddenFloat();

    /**
     * Transform the current instance to a {@code HiddenInt}.
     *
     * @return a {@code HiddenInt} equivalent
     */
    HiddenASTComponent toHiddenInt();

    /**
     * Transform the current instance to a {@code HiddenString}.
     *
     * @return a {@code HiddenString} equivalent
     */
    HiddenASTComponent toHiddenString();

}
