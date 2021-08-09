package cl.uchile.dcc.scrabble.model.factories.hidden_factories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.BaseHTypeTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

class HiddenStringFactoryTest extends BaseHTypeTest {

    private final HiddenStringFactory factory = HiddenStringFactory.getInstance();

    @BeforeEach
    protected void setUp() {
        super.setUp();
        factory.clear();
    }

    @RepeatedTest(20)
    void testCreate() {
        assertSame(hiddenString1, factory.create(hiddenString1),
            "Method create does not works with hidden instance." + messageSeed);

        factory.clear();
        var instance = factory.create(typeString1);
        assertEquals(hiddenString1, instance,
            "Method create does not works with SType instance." + messageSeed);
        var otherInstance = factory.create(typeString1);
        assertSame(instance, otherInstance,
            "Method create does not works with SType instance." + messageSeed);

        factory.clear();
        instance = factory.create(aString1);
        assertEquals(hiddenString1, instance,
            "Method create does not works with normal value." + messageSeed);
        otherInstance = factory.create(aString1);
        assertSame(instance, otherInstance,
            "Method create does not works with normal value." + messageSeed);
    }

    @RepeatedTest(20)
    void testIsEmpty() {
        assertTrue(factory.isEmpty(),
            "Method isEmpty does not works when is empty." + messageSeed);
        factory.create(hiddenString1);
        assertFalse(factory.isEmpty(),
            "Method isEmpty does not works when is not empty." + messageSeed);
    }

    @RepeatedTest(20)
    void testClear() {
        factory.create(hiddenString1);
        assertFalse(factory.isEmpty());
        factory.clear();
        assertTrue(factory.isEmpty(),
            "Method clear does not works." + messageSeed);
    }

}