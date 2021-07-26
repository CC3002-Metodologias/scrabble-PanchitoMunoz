package cl.uchile.dcc.scrabble.model.hidden_layer;

import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_variable.HiddenSetterVisitor;
import java.util.Stack;

/**
 * An interface to define a generic leaf in {@code HiddenASTComponent}
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/07/04 0:47
 */
public interface HiddenASTLeaf extends HiddenASTComponent {

    /**
     * Method that accepts a {@code HiddenSetterVisitor}.
     *
     * @param visitor a {@code HiddenSetterVisitor}.
     */
    void accept(HiddenSetterVisitor visitor);

    /**
     * Updates the stack.
     *
     * @param stack the current stack.
     */
    @Override
    default void updateStack(Stack<HiddenASTComponent> stack) {
        // It does nothing
    }

    /**
     * Returns the number of vertices in the current {@code HiddenASTComponent}
     *
     * @return the number of vertices
     */
    @Override
    default int size() {
        return 1;
    }
}
