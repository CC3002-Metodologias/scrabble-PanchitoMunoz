package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operations.iterators;

import static org.junit.jupiter.api.Assertions.assertSame;

import cl.uchile.dcc.scrabble.model.hidden_layer.HiddenASTLeaf;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

class LeafIterableTest extends BaseIteratorTest {

    private LeafIterable iterable;

    @BeforeEach
    protected void setUp() {
        super.setUp();
        iterable = new LeafIterable(hiddenASTComponent);
    }

    @RepeatedTest(20)
    void testIteration() {
        LeafIterator iterator = new LeafIterator(hiddenASTComponent);
        for (HiddenASTLeaf elem : iterable) {
            assertSame(elem, iterator.next(),
                "Iteration in a LeafIterable does not works." + messageSeed);
        }
    }
}