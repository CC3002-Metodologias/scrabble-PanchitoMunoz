package cl.uchile.dcc.scrabble.model.factories.hidden_factories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.BaseHTypeTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

class HiddenFloatFactoryTest extends BaseHTypeTest {

    private final HiddenFloatFactory factory = HiddenFloatFactory.getInstance();

    @BeforeEach
    protected void setUp() {
        super.setUp();
        factory.clear();
    }

    @RepeatedTest(20)
    void testCreate() {
        assertSame(hiddenFloat1, factory.create(hiddenFloat1),
            "Method create does not works with hidden instance." + messageSeed);

        factory.clear();
        var instance = factory.create(typeFloat1);
        assertEquals(hiddenFloat1, instance,
            "Method create does not works with SType instance." + messageSeed);
        var otherInstance = factory.create(typeFloat1);
        assertSame(instance, otherInstance,
            "Method create does not works with SType instance." + messageSeed);

        factory.clear();
        instance = factory.create(aFloat1);
        assertEquals(hiddenFloat1, instance,
            "Method create does not works with normal value." + messageSeed);
        otherInstance = factory.create(aFloat1);
        assertSame(instance, otherInstance,
            "Method create does not works with normal value." + messageSeed);
    }

    @RepeatedTest(20)
    void testIsEmpty() {
        assertTrue(factory.isEmpty(),
            "Method isEmpty does not works when is empty." + messageSeed);
        factory.create(hiddenFloat1);
        assertFalse(factory.isEmpty(),
            "Method isEmpty does not works when is not empty." + messageSeed);
    }

    @RepeatedTest(20)
    void testClear() {
        factory.create(hiddenFloat1);
        assertFalse(factory.isEmpty());
        factory.clear();
        assertTrue(factory.isEmpty(),
            "Method clear does not works." + messageSeed);
    }

}