package cl.uchile.dcc.scrabble.model.factories.types_factories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import cl.uchile.dcc.scrabble.model.types.BaseTypeTest;
import cl.uchile.dcc.scrabble.model.types.TypeBool;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

class TypeBoolFactoryTest extends BaseTypeTest {
    private final TypeBoolFactory factory = TypeBoolFactory.getInstance();

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
        TypeBoolFactory otherFactory = TypeBoolFactory.getInstance();
        otherFactory.create(trueBoolean);
        assertFalse(factory.isEmpty(),
            "Singleton pattern does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testCreate() {
        var expected = new TypeBool(trueBoolean);
        assertEquals(expected, factory.create(trueBoolean),
            "Method getTypeBool does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testClear() {
        factory.create(trueBoolean);
        assertFalse(factory.isEmpty());
        factory.clear();
        assertTrue(factory.isEmpty());
    }
}