package cl.uchile.dcc.scrabble.model.types.factories_types;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import cl.uchile.dcc.scrabble.model.types.BaseTypeTest;
import cl.uchile.dcc.scrabble.model.types.TypeString;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

class TypeStringFactoryTest extends BaseTypeTest {

    private TypeStringFactory factory;

    @BeforeEach
    public void setUp() {
        super.setUp();
        factory = TypeStringFactory.getInstance();
    }

    @AfterEach
    void tearDown() {
        factory.clear();
    }

    @RepeatedTest(20)
    void testGetInstance() {
        factory.getTypeString(aString1);
        TypeStringFactory otherFactory = TypeStringFactory.getInstance();
        assertEquals(otherFactory.getHashMapCache(), factory.getHashMapCache(),
            "Singleton pattern does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testGetTypeString() {
        var expected = new TypeString(aString1);
        assertEquals(expected, factory.getTypeString(aString1),
            "Method getTypeString does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testClear() {
        factory.getTypeString(aString1);
        assertFalse(factory.getHashMapCache().isEmpty());
        factory.clear();
        assertTrue(factory.getHashMapCache().isEmpty());
    }
}