package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operations.iterators;

import cl.uchile.dcc.scrabble.model.hidden_layer.HiddenASTComponent;
import cl.uchile.dcc.scrabble.model.hidden_layer.HiddenASTLeaf;
import java.util.Iterator;
import org.jetbrains.annotations.NotNull;

/**
 * A HiddenASTLeaf iterable
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/07/24 11:15
 */
public class LeafIterable implements Iterable<HiddenASTLeaf> {

    private final LeafIterator iterator;

    public LeafIterable(HiddenASTComponent iterable) {
        this.iterator = new LeafIterator(iterable);
    }

    /**
     * Returns an iterator over elements of type {@code HiddenASTLeaf}.
     *
     * @return an Iterator.
     */
    @NotNull
    @Override
    public Iterator<HiddenASTLeaf> iterator() {
        return this.iterator;
    }
}
