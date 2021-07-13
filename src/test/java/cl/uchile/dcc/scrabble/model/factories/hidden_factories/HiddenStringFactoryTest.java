package cl.uchile.dcc.scrabble.model.factories.hidden_factories;

import static org.junit.jupiter.api.Assertions.*;

import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.BaseHTypeTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

class HiddenStringFactoryTest extends BaseHTypeTest {

    private final HiddenStringFactory StringFactory = HiddenStringFactory.getInstance();

    @BeforeEach
    protected void setUp() {
        super.setUp();
    }

    @AfterEach
    protected void tearDown() {
        StringFactory.clear();
    }

    @RepeatedTest(20)
    void testCreate() {
        assertEquals(hiddenString1, StringFactory.create(hiddenString1),
            "Method create does not works with hidden instance." + messageSeed);
        assertEquals(hiddenString1, StringFactory.create(typeString1),
            "Method create does not works with SType instance." + messageSeed);
        assertEquals(hiddenString1, StringFactory.create(aString1),
            "Method create does not works with normal value." + messageSeed);
    }

    @RepeatedTest(20)
    void testIsEmpty() {
        assertTrue(StringFactory.isEmpty(),
            "Method isEmpty does not works when is empty." + messageSeed);
        StringFactory.create(hiddenString1);
        assertFalse(StringFactory.isEmpty(),
            "Method isEmpty does not works when is not empty." + messageSeed);
    }

    @RepeatedTest(20)
    void testClear() {
        StringFactory.create(hiddenString1);
        assertFalse(StringFactory.isEmpty());
        StringFactory.clear();
        assertTrue(StringFactory.isEmpty(),
            "Method clear does not works." + messageSeed);
    }

}