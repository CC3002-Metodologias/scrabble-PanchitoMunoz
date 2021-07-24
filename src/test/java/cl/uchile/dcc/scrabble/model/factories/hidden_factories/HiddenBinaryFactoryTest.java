package cl.uchile.dcc.scrabble.model.factories.hidden_factories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.BaseHTypeTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

class HiddenBinaryFactoryTest extends BaseHTypeTest {

    private final HiddenBinaryFactory binaryFactory = HiddenBinaryFactory.getInstance();

    @BeforeEach
    protected void setUp() {
        super.setUp();
        binaryFactory.clear();
    }

    @AfterEach
    protected void tearDown() {
        binaryFactory.clear();
    }

    @RepeatedTest(20)
    void testCreate() {
        assertEquals(hiddenBinary1, binaryFactory.create(hiddenBinary1),
            "Method create does not works with hidden instance." + messageSeed);
        assertEquals(hiddenBinary1, binaryFactory.create(typeBinary1),
            "Method create does not works with SType instance." + messageSeed);
        assertEquals(hiddenBinary1, binaryFactory.create(aBinary1),
            "Method create does not works with normal value." + messageSeed);
    }

    @RepeatedTest(20)
    void testIsEmpty() {
        assertTrue(binaryFactory.isEmpty(),
            "Method isEmpty does not works when is empty." + messageSeed);
        binaryFactory.create(hiddenBinary1);
        assertFalse(binaryFactory.isEmpty(),
            "Method isEmpty does not works when is not empty." + messageSeed);
    }

    @RepeatedTest(20)
    void testClear() {
        binaryFactory.create(hiddenBinary1);
        assertFalse(binaryFactory.isEmpty());
        binaryFactory.clear();
        assertTrue(binaryFactory.isEmpty(),
            "Method clear does not works." + messageSeed);
    }
}