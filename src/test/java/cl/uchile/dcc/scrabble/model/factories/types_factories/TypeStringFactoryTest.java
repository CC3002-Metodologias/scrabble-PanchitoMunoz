package cl.uchile.dcc.scrabble.model.factories.types_factories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import cl.uchile.dcc.scrabble.model.types.BaseTypeTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

class TypeStringFactoryTest extends BaseTypeTest {

    private final TypeStringFactory factory = TypeStringFactory.getInstance();

    @BeforeEach
    public void setUp() {
        super.setUp();
        factory.clear();
    }

    @RepeatedTest(20)
    void testGetInstance() {
        TypeStringFactory otherFactory = TypeStringFactory.getInstance();
        otherFactory.create(aString1);
        assertFalse(factory.isEmpty(),
            "Singleton pattern does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testCreate() {
        assertSame(typeString1, factory.create(typeString1),
            "Method create does not works given an instance" + messageSeed);

        factory.clear();
        var instance = factory.create(aString1);
        assertEquals(typeString1, instance,
            "Method create does not works given a value" + messageSeed);
        var otherInstance = factory.create(aString1);
        assertSame(instance, otherInstance,
            "Method create does not works given a value" + messageSeed);
    }

    @RepeatedTest(20)
    void testClear() {
        factory.create(aString1);
        assertFalse(factory.isEmpty());
        factory.clear();
        assertTrue(factory.isEmpty());
    }
}