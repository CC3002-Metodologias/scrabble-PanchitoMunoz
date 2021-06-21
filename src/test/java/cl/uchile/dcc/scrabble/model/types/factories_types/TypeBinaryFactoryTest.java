package cl.uchile.dcc.scrabble.model.types.factories_types;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import cl.uchile.dcc.scrabble.model.types.BaseTypeTest;
import cl.uchile.dcc.scrabble.model.types.TypeBinary;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

class TypeBinaryFactoryTest extends BaseTypeTest {

    private TypeBinaryFactory factory;

    @BeforeEach
    public void setUp() {
        super.setUp();
        factory = TypeBinaryFactory.getInstance();
    }

    @AfterEach
    void tearDown() {
        factory.clear();
    }

    @RepeatedTest(20)
    void testGetInstance() {
        factory.create(aBinary1);
        TypeBinaryFactory otherFactory = TypeBinaryFactory.getInstance();
        assertEquals(otherFactory.getHashMapCache(), factory.getHashMapCache(),
            "Singleton pattern does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testCreate() {
        var expected = new TypeBinary(aBinary1);
        assertEquals(expected, factory.create(aBinary1),
            "Method getTypeBinary does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testClear() {
        factory.create(aBinary1);
        assertFalse(factory.getHashMapCache().isEmpty());
        factory.clear();
        assertTrue(factory.getHashMapCache().isEmpty());
    }
}