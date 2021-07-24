package cl.uchile.dcc.scrabble.model.factories.types_factories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import cl.uchile.dcc.scrabble.model.types.BaseTypeTest;
import cl.uchile.dcc.scrabble.model.types.TypeFloat;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

class TypeFloatFactoryTest extends BaseTypeTest {

    private final TypeFloatFactory factory = TypeFloatFactory.getInstance();

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
        TypeFloatFactory otherFactory = TypeFloatFactory.getInstance();
        otherFactory.create(aFloat1);
        assertFalse(factory.isEmpty(),
            "Singleton pattern does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testCreate() {
        var expected = new TypeFloat(aFloat1);
        assertEquals(expected, factory.create(aFloat1),
            "Method getTypeFloat does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testClear() {
        factory.create(aFloat1);
        assertFalse(factory.isEmpty());
        factory.clear();
        assertTrue(factory.isEmpty());
    }
}