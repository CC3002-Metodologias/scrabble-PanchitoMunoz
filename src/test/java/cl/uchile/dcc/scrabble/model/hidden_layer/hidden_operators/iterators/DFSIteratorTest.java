package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.iterators;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import cl.uchile.dcc.scrabble.model.hidden_layer.HiddenASTComponent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

class DFSIteratorTest extends BaseIteratorTest {

    private DFSIterator iterator;

    @BeforeEach
    public void setUp() {
        super.setUp();
        iterator = new DFSIterator(hiddenASTComponent);
    }

    @RepeatedTest(20)
    void testHasNext() {
        assertTrue(iterator.hasNext(),
            "Method hasNext does not works when iterator has next." + messageSeed);
        DFSIterator otherIterator = new DFSIterator(hiddenBinary1);
        assertTrue(otherIterator.hasNext());
        otherIterator.next();
        assertFalse(otherIterator.hasNext(),
            "Method hasNext does not works when iterator has not had next." + messageSeed);
    }

    @RepeatedTest(20)
    void testNext() {
        for (HiddenASTComponent elem : hiddenASTComponentList) {
            assertSame(elem, iterator.next(),
                "Method next does not works." + messageSeed);
        }
        assertFalse(iterator.hasNext(),
            "Iterator says that has next when it is false." + messageSeed);
    }
}