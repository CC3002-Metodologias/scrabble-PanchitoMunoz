package cl.uchile.dcc.scrabble.model.factories.hidden_factories;

import static org.junit.jupiter.api.Assertions.*;

import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.BaseHTypeTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

class HiddenFloatFactoryTest extends BaseHTypeTest {

    private final HiddenFloatFactory FloatFactory = HiddenFloatFactory.getInstance();

    @BeforeEach
    protected void setUp() {
        super.setUp();
    }

    @AfterEach
    protected void tearDown() {
        FloatFactory.clear();
    }

    @RepeatedTest(20)
    void testCreate() {
        assertEquals(hiddenFloat1, FloatFactory.create(hiddenFloat1),
            "Method create does not works with hidden instance." + messageSeed);
        assertEquals(hiddenFloat1, FloatFactory.create(typeFloat1),
            "Method create does not works with SType instance." + messageSeed);
        assertEquals(hiddenFloat1, FloatFactory.create(aFloat1),
            "Method create does not works with normal value." + messageSeed);
    }

    @RepeatedTest(20)
    void testIsEmpty() {
        assertTrue(FloatFactory.isEmpty(),
            "Method isEmpty does not works when is empty." + messageSeed);
        FloatFactory.create(hiddenFloat1);
        assertFalse(FloatFactory.isEmpty(),
            "Method isEmpty does not works when is not empty." + messageSeed);
    }

    @RepeatedTest(20)
    void testClear() {
        FloatFactory.create(hiddenFloat1);
        assertFalse(FloatFactory.isEmpty());
        FloatFactory.clear();
        assertTrue(FloatFactory.isEmpty(),
            "Method clear does not works." + messageSeed);
    }

}