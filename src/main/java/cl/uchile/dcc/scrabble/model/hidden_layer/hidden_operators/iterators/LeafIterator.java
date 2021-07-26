package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.iterators;

import cl.uchile.dcc.scrabble.model.hidden_layer.HiddenASTComponent;
import cl.uchile.dcc.scrabble.model.hidden_layer.HiddenASTLeaf;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Iterates an {@code HiddenASTComponent} by its leaves. To use iterator pattern.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/07/24 10:49
 */
public class LeafIterator implements Iterator<HiddenASTLeaf> {

    private final DFSIterator iterator;

    public LeafIterator(HiddenASTComponent iterable) {
        this.iterator = new DFSIterator(iterable);
    }

    /**
     * Returns {@code true} if the iteration has more elements. (In other words, returns {@code
     * true} if {@link #next} would return an element rather than throwing an exception.)
     *
     * @return {@code true} if the iteration has more elements
     */
    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration
     * @throws NoSuchElementException if the iteration has no more elements
     */
    @Override
    public HiddenASTLeaf next() {
        while (iterator.hasNext()) {
            HiddenASTComponent next = iterator.next();
            if (next.size() == 1) {
                return (HiddenASTLeaf) next;
            }
        }
        return null;
    }
}
