package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operations.iterators;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import cl.uchile.dcc.scrabble.model.hidden_layer.HiddenASTLeaf;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

class LeafIteratorTest extends BaseIteratorTest {

    private LeafIterator iterator;

    @BeforeEach
    protected void setUp() {
        super.setUp();
        iterator = new LeafIterator(hiddenAST);
    }

    @RepeatedTest(20)
    void testHasNext() {
        assertTrue(iterator.hasNext(),
            "Method hasNext does not works when iterator has next." + messageSeed);
        LeafIterator otherIterator = new LeafIterator(hiddenBinary1);
        assertTrue(otherIterator.hasNext());
        otherIterator.next();
        assertFalse(otherIterator.hasNext(),
            "Method hasNext does not works when iterator has not had next." + messageSeed);
    }

    @RepeatedTest(20)
    void testNext() {
        for (HiddenASTLeaf elem :
            hiddenASTLeaves) {
            assertSame(elem, iterator.next(),
                "Method next does not works." + messageSeed);
        }
        assertFalse(iterator.hasNext(),
            "Iterator says that has next when it is false." + messageSeed);
        assertNull(iterator.next(),
            "Iterator does not return null when iterations ends." + messageSeed);
    }
}