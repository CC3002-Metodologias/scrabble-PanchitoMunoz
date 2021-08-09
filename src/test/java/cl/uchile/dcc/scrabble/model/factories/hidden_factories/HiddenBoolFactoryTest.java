package cl.uchile.dcc.scrabble.model.factories.hidden_factories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.BaseHTypeTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

class HiddenBoolFactoryTest extends BaseHTypeTest {

    private final HiddenBoolFactory factory = HiddenBoolFactory.getInstance();

    @BeforeEach
    protected void setUp() {
        super.setUp();
        factory.clear();
    }

    @RepeatedTest(20)
    void testCreate() {
        assertSame(trueHiddenBool, factory.create(trueHiddenBool),
            "Method create does not works with hidden instance." + messageSeed);

        factory.clear();
        var instance = factory.create(trueTypeBool);
        assertEquals(trueHiddenBool, instance,
            "Method create does not works with SType instance." + messageSeed);
        var otherInstance = factory.create(trueTypeBool);
        assertEquals(instance, otherInstance,
            "Method create does not works with SType instance." + messageSeed);

        factory.clear();
        instance = factory.create(true);
        assertEquals(trueHiddenBool, instance,
            "Method create does not works with normal value." + messageSeed);
        otherInstance = factory.create(true);
        assertSame(instance, otherInstance,
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