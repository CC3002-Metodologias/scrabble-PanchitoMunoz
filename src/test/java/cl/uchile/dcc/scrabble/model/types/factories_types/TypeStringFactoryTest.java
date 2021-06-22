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

    private final TypeStringFactory factory = TypeStringFactory.getInstance();

    @BeforeEach
    public void setUp() {
        super.setUp();
    }

    @AfterEach
    void tearDown() {
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
        var expected = new TypeString(aString1);
        assertEquals(expected, factory.create(aString1),
            "Method getTypeString does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testClear() {
        factory.create(aString1);
        assertFalse(factory.isEmpty());
        factory.clear();
        assertTrue(factory.isEmpty());
    }
}