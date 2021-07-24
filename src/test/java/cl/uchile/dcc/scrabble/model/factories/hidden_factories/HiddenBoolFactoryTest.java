package cl.uchile.dcc.scrabble.model.factories.hidden_factories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.BaseHTypeTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

class HiddenBoolFactoryTest extends BaseHTypeTest {

    private final HiddenBoolFactory factory = HiddenBoolFactory.getInstance();

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
        assertEquals(trueHiddenBool, factory.create(trueHiddenBool),
            "Method create does not works with hidden instance." + messageSeed);
        assertEquals(trueHiddenBool, factory.create(trueTypeBool),
            "Method create does not works with SType instance." + messageSeed);
        assertEquals(trueHiddenBool, factory.create(true),
            "Method create does not works with normal value." + messageSeed);
    }

    @RepeatedTest(20)
    void testIsEmpty() {
        assertTrue(factory.isEmpty(),
            "Method isEmpty does not works when is empty." + messageSeed);
        factory.create(trueHiddenBool);
        assertFalse(factory.isEmpty(),
            "Method isEmpty does not works when is not empty." + messageSeed);
    }

    @RepeatedTest(20)
    void testClear() {
        factory.create(trueHiddenBool);
        assertFalse(factory.isEmpty());
        factory.clear();
        assertTrue(factory.isEmpty(),
            "Method clear does not works." + messageSeed);
    }

}