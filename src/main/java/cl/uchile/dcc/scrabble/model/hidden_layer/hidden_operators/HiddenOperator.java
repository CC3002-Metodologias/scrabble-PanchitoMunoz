package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators;

import cl.uchile.dcc.scrabble.model.hidden_layer.HiddenASTComponent;
import cl.uchile.dcc.scrabble.model.hidden_layer.HiddenASTComposite;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.transformations.ToHiddenBinary;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.transformations.ToHiddenBool;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.transformations.ToHiddenFloat;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.transformations.ToHiddenInt;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.transformations.ToHiddenString;

/**
 * An interface to represent a general hidden operation in {@code HiddenASTComponent}. The classes
 * that implement this interface will be adapted by the {@code Operation} classes.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/21 17:14
 */
public interface HiddenOperator extends HiddenASTComposite {

    /**
     * Gets the left children.
     *
     * @return the left children
     */
    HiddenASTComponent getLeftChildren();

    /**
     * Gets the right children.
     *
     * @return the right children
     */
    HiddenASTComponent getRightChildren();

    /**
     * Sets the variable in an {@code HiddenOperator}.
     *
     * @param name  the name of the variable
     * @param value the current value to set
     */
    void setVariable(String name, HiddenASTComponent value);

    /**
     * Transform the current instance into a {@code HiddenBinary}.
     *
     * @return a {@code HiddenBinary}
     */
    default HiddenOperator toHiddenBinary() {
        return new ToHiddenBinary(this);
    }

    /**
     * Transform the current instance into a {@code HiddenBool}.
     *
     * @return a {@code HiddenBool}
     */
    default HiddenOperator toHiddenBool() {
        return new ToHiddenBool(this);
    }

    /**
     * Transform the current instance into a {@code HiddenFloat}.
     *
     * @return a {@code HiddenFloat}
     */
    default HiddenOperator toHiddenFloat() {
        return new ToHiddenFloat(this);
    }

    /**
     * Transform the current instance into a {@code HiddenInt}.
     *
     * @return a {@code HiddenInt}
     */
    default HiddenOperator toHiddenInt() {
        return new ToHiddenInt(this);
    }

    /**
     * Transform the current instance into a {@code HiddenString}.
     *
     * @return a {@code HiddenString}
     */
    default HiddenOperator toHiddenString() {
        return new ToHiddenString(this);
    }
}
