package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.iterators;

import cl.uchile.dcc.scrabble.model.hidden_layer.HiddenASTComponent;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * Iterates an {@code AST} in depth-first search (DFS) in pre-order. To use Iterator pattern.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/07/24 10:05
 */
public class DFSIterator implements Iterator<HiddenASTComponent> {

    private final Stack<HiddenASTComponent> stack = new Stack<>();

    public DFSIterator(HiddenASTComponent iterable) {
        stack.push(iterable);
    }

    /**
     * Returns {@code true} if the iteration has more elements. (In other words, returns {@code
     * true} if {@link #next} would return an element rather than throwing an exception.)
     *
     * @return {@code true} if the iteration has more elements
     */
    @Override
    public boolean hasNext() {
        return !this.stack.empty();
    }

    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration
     * @throws NoSuchElementException if the iteration has no more elements
     */
    @Override
    public HiddenASTComponent next() {
        if (!hasNext()) {
            throw new NoSuchElementException("The iterator doesn't have any element.");
        }
        HiddenASTComponent currentElement = stack.pop();
        currentElement.updateStack(stack);
        return currentElement;
    }
}
