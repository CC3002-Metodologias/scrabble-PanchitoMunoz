package cl.uchile.dcc.scrabble.model.factories.types_factories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import cl.uchile.dcc.scrabble.model.types.BaseTypeTest;
import cl.uchile.dcc.scrabble.model.types.TypeInt;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

class TypeIntFactoryTest extends BaseTypeTest {

    private final TypeIntFactory factory = TypeIntFactory.getInstance();

    @BeforeEach
    public void setUp() {
        super.setUp();
        factory.clear();
    }

    @AfterEach
    protected void tearDown() {
        factory.clear();
    }

    @RepeatedTest(20)
    void testGetInstance() {
        TypeIntFactory otherFactory = TypeIntFactory.getInstance();
        otherFactory.create(anInt1);
        assertFalse(factory.isEmpty(),
            "Singleton pattern does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testCreate() {
        var expected = new TypeInt(anInt1);
        assertEquals(expected, factory.create(anInt1),
            "Method getTypeInt does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testClear() {
        factory.create(anInt1);
        assertFalse(factory.isEmpty());
        factory.clear();
        assertTrue(factory.isEmpty());
    }
}