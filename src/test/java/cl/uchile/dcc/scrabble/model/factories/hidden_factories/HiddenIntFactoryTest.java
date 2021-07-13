package cl.uchile.dcc.scrabble.model.factories.hidden_factories;

import static org.junit.jupiter.api.Assertions.*;

import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.BaseHTypeTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

class HiddenIntFactoryTest extends BaseHTypeTest {

    private final HiddenIntFactory IntFactory = HiddenIntFactory.getInstance();

    @BeforeEach
    protected void setUp() {
        super.setUp();
    }

    @AfterEach
    protected void tearDown() {
        IntFactory.clear();
    }

    @RepeatedTest(20)
    void testCreate() {
        assertEquals(hiddenInt1, IntFactory.create(hiddenInt1),
            "Method create does not works with hidden instance." + messageSeed);
        assertEquals(hiddenInt1, IntFactory.create(typeInt1),
            "Method create does not works with SType instance." + messageSeed);
        assertEquals(hiddenInt1, IntFactory.create(anInt1),
            "Method create does not works with normal value." + messageSeed);
    }

    @RepeatedTest(20)
    void testIsEmpty() {
        assertTrue(IntFactory.isEmpty(),
            "Method isEmpty does not works when is empty." + messageSeed);
        IntFactory.create(hiddenInt1);
        assertFalse(IntFactory.isEmpty(),
            "Method isEmpty does not works when is not empty." + messageSeed);
    }

    @RepeatedTest(20)
    void testClear() {
        IntFactory.create(hiddenInt1);
        assertFalse(IntFactory.isEmpty());
        IntFactory.clear();
        assertTrue(IntFactory.isEmpty(),
            "Method clear does not works." + messageSeed);
    }

}