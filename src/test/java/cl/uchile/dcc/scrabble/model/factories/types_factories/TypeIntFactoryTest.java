package cl.uchile.dcc.scrabble.model.factories.types_factories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import cl.uchile.dcc.scrabble.model.types.BaseTypeTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

class TypeIntFactoryTest extends BaseTypeTest {

    private final TypeIntFactory factory = TypeIntFactory.getInstance();

    @BeforeEach
    public void setUp() {
        super.setUp();
        factory.clear();
    }

    @RepeatedTest(20)
    void testGetInstance() {
        TypeIntFactory otherFactory = TypeIntFactory.getInstance();
        otherFactory.create(anInt1);
        assertFalse(factory.isEmpty(),
            "Singleton pattern does not works." + messageSeed);
        assertSame(factory, otherFactory,
            "Singleton pattern does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testCreate() {
        assertSame(typeInt1, factory.create(typeInt1),
            "Method create does not works given an instance" + messageSeed);

        factory.clear();
        var instance = factory.create(anInt1);
        assertEquals(typeInt1, instance,
            "Method create does not works given a value" + messageSeed);
        var otherInstance = factory.create(anInt1);
        assertSame(instance, otherInstance,
            "Method create does not works given a value" + messageSeed);
    }

    @RepeatedTest(20)
    void testClear() {
        factory.create(anInt1);
        assertFalse(factory.isEmpty());
        factory.clear();
        assertTrue(factory.isEmpty());
    }
}