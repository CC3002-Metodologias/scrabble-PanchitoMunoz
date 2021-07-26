package cl.uchile.dcc.scrabble.model.hidden_layer;

import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HType;
import java.util.Stack;

/**
 * An interface that defines a "type" of Abstract Syntax Tree. This interface is for using the
 * composite pattern. Only used as a hidden abstract layer, and is not intended for use by the
 * user.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/12 22:51
 */
public interface HiddenASTComponent extends HiddenAST {

    /**
     * Calculate the {@code HType} result of performing all operations.
     *
     * @return {@code HType} result of operations
     */
    HType calculate();

    /**
     * Updates the stack.
     *
     * @param stack the current stack.
     */
    void updateStack(Stack<HiddenASTComponent> stack);

    /**
     * Returns the number of vertices in the current {@code HiddenASTComponent}
     *
     * @return the number of vertices
     */
    int size();
}
