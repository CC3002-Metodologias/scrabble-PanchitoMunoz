package cl.uchile.dcc.scrabble.model.factories.types_factories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import cl.uchile.dcc.scrabble.model.types.BaseTypeTest;
import cl.uchile.dcc.scrabble.model.types.TypeBinary;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

class TypeBinaryFactoryTest extends BaseTypeTest {
    private final TypeBinaryFactory factory = TypeBinaryFactory.getInstance();

    @BeforeEach
    public void setUp() {
        super.setUp();
    }

    @AfterEach
    protected void tearDown() {
        factory.clear();
    }

    @RepeatedTest(20)
    void testGetInstance() {
        TypeBinaryFactory otherFactory = TypeBinaryFactory.getInstance();
        otherFactory.create(aBinary1);
        assertFalse(factory.isEmpty(),
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
        assertFalse(factory.isEmpty());
        factory.clear();
        assertTrue(factory.isEmpty());
    }
}