package cl.uchile.dcc.scrabble.model.types.factories_types;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import cl.uchile.dcc.scrabble.model.types.BaseTypeTest;
import cl.uchile.dcc.scrabble.model.types.TypeFloat;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

class TypeFloatFactoryTest extends BaseTypeTest {

    private TypeFloatFactory factory;

    @BeforeEach
    public void setUp() {
        super.setUp();
        factory = TypeFloatFactory.getInstance();
    }

    @AfterEach
    void tearDown() {
        factory.clear();
    }

    @RepeatedTest(20)
    void testGetInstance() {
        factory.getTypeFloat(aFloat1);
        TypeFloatFactory otherFactory = TypeFloatFactory.getInstance();
        assertEquals(otherFactory.getHashMapCache(), factory.getHashMapCache(),
            "Singleton pattern does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testGetTypeFloat() {
        var expected = new TypeFloat(aFloat1);
        assertEquals(expected, factory.getTypeFloat(aFloat1),
            "Method getTypeFloat does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testClear() {
        factory.getTypeFloat(aFloat1);
        assertFalse(factory.getHashMapCache().isEmpty());
        factory.clear();
        assertTrue(factory.getHashMapCache().isEmpty());
    }
}