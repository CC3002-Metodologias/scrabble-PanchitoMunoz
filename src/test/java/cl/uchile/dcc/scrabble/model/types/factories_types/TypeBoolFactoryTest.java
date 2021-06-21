package cl.uchile.dcc.scrabble.model.types.factories_types;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import cl.uchile.dcc.scrabble.model.types.BaseTypeTest;
import cl.uchile.dcc.scrabble.model.types.TypeBool;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

class TypeBoolFactoryTest extends BaseTypeTest {

    private TypeBoolFactory factory;

    @BeforeEach
    public void setUp() {
        super.setUp();
        factory = TypeBoolFactory.getInstance();
    }

    @AfterEach
    void tearDown() {
        factory.clear();
    }

    @RepeatedTest(20)
    void testGetInstance() {
        factory.getTypeBool(trueBoolean);
        TypeBoolFactory otherFactory = TypeBoolFactory.getInstance();
        assertEquals(otherFactory.getHashMapCache(), factory.getHashMapCache(),
            "Singleton pattern does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testGetTypeBool() {
        var expected = new TypeBool(trueBoolean);
        assertEquals(expected, factory.getTypeBool(trueBoolean),
            "Method getTypeBool does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testClear() {
        factory.getTypeBool(trueBoolean);
        assertFalse(factory.getHashMapCache().isEmpty());
        factory.clear();
        assertTrue(factory.getHashMapCache().isEmpty());
    }
}