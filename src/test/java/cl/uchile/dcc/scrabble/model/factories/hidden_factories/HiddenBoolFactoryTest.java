package cl.uchile.dcc.scrabble.model.factories.hidden_factories;

import static org.junit.jupiter.api.Assertions.*;

import cl.uchile.dcc.scrabble.model.hidden_ast.hidden_types.BaseHTypeTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

class HiddenBoolFactoryTest extends BaseHTypeTest {

    private final HiddenBoolFactory BoolFactory = HiddenBoolFactory.getInstance();

    @BeforeEach
    protected void setUp() {
        super.setUp();
    }

    @AfterEach
    protected void tearDown() {
        BoolFactory.clear();
    }

    @RepeatedTest(20)
    void testCreate() {
        assertEquals(trueHiddenBool, BoolFactory.create(trueHiddenBool),
            "Method create does not works with hidden instance." + messageSeed);
        assertEquals(trueHiddenBool, BoolFactory.create(trueTypeBool),
            "Method create does not works with SType instance." + messageSeed);
        assertEquals(trueHiddenBool, BoolFactory.create(true),
            "Method create does not works with normal value." + messageSeed);
    }

    @RepeatedTest(20)
    void testIsEmpty() {
        assertTrue(BoolFactory.isEmpty(),
            "Method isEmpty does not works when is empty." + messageSeed);
        BoolFactory.create(trueHiddenBool);
        assertFalse(BoolFactory.isEmpty(),
            "Method isEmpty does not works when is not empty." + messageSeed);
    }

    @RepeatedTest(20)
    void testClear() {
        BoolFactory.create(trueHiddenBool);
        assertFalse(BoolFactory.isEmpty());
        BoolFactory.clear();
        assertTrue(BoolFactory.isEmpty(),
            "Method clear does not works." + messageSeed);
    }

}