package cl.uchile.dcc.scrabble.model.factories.hidden_factories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.BaseHTypeTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

class HiddenIntFactoryTest extends BaseHTypeTest {

    private final HiddenIntFactory factory = HiddenIntFactory.getInstance();

    @BeforeEach
    protected void setUp() {
        super.setUp();
        factory.clear();
    }

    @AfterEach
    protected void tearDown() {
        factory.clear();
    }

    @RepeatedTest(20)
    void testCreate() {
        assertEquals(hiddenInt1, factory.create(hiddenInt1),
            "Method create does not works with hidden instance." + messageSeed);
        assertEquals(hiddenInt1, factory.create(typeInt1),
            "Method create does not works with SType instance." + messageSeed);
        assertEquals(hiddenInt1, factory.create(anInt1),
            "Method create does not works with normal value." + messageSeed);
    }

    @RepeatedTest(20)
    void testIsEmpty() {
        assertTrue(factory.isEmpty(),
            "Method isEmpty does not works when is empty." + messageSeed);
        factory.create(hiddenInt1);
        assertFalse(factory.isEmpty(),
            "Method isEmpty does not works when is not empty." + messageSeed);
    }

    @RepeatedTest(20)
    void testClear() {
        factory.create(hiddenInt1);
        assertFalse(factory.isEmpty());
        factory.clear();
        assertTrue(factory.isEmpty(),
            "Method clear does not works." + messageSeed);
    }

}