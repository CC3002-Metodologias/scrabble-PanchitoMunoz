package cl.uchile.dcc.scrabble.model.factories.hidden_factories;

import static org.junit.jupiter.api.Assertions.*;

import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.BaseHTypeTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

class HTypeFactoryTest extends BaseHTypeTest {

    @BeforeEach
    public void setUp() {
        super.setUp();
    }

    @RepeatedTest(20)
    void testCreateHiddenBinary() {
        assertEquals(hiddenBinary1, HTypeFactory.createHiddenBinary(hiddenBinary1),
            "Method createHiddenBinary does not works with hidden instance." + messageSeed);
        assertEquals(hiddenBinary1, HTypeFactory.createHiddenBinary(typeBinary1),
            "Method createHiddenBinary does not works with SType instance." + messageSeed);
        assertEquals(hiddenBinary1, HTypeFactory.createHiddenBinary(aBinary1),
            "Method createHiddenBinary does not works with normal value." + messageSeed);
    }

    @RepeatedTest(20)
    void testCreateHiddenBool() {
        assertEquals(trueHiddenBool, HTypeFactory.createHiddenBool(trueHiddenBool),
            "Method createHiddenBool does not works with hidden instance." + messageSeed);
        assertEquals(trueHiddenBool, HTypeFactory.createHiddenBool(trueTypeBool),
            "Method createHiddenBool does not works with SType instance." + messageSeed);
        assertEquals(trueHiddenBool, HTypeFactory.createHiddenBool(true),
            "Method createHiddenBool does not works with normal value." + messageSeed);
    }

    @RepeatedTest(20)
    void testCreateHiddenFloat() {
        assertEquals(hiddenFloat1, HTypeFactory.createHiddenFloat(hiddenFloat1),
            "Method createHiddenFloat does not works with hidden instance." + messageSeed);
        assertEquals(hiddenFloat1, HTypeFactory.createHiddenFloat(typeFloat1),
            "Method createHiddenFloat does not works with SType instance." + messageSeed);
        assertEquals(hiddenFloat1, HTypeFactory.createHiddenFloat(aFloat1),
            "Method createHiddenFloat does not works with normal value." + messageSeed);
    }

    @RepeatedTest(20)
    void testCreateHiddenInt() {
        assertEquals(hiddenInt1, HTypeFactory.createHiddenInt(hiddenInt1),
            "Method createHiddenInt does not works with hidden instance." + messageSeed);
        assertEquals(hiddenInt1, HTypeFactory.createHiddenInt(typeInt1),
            "Method createHiddenInt does not works with SType instance." + messageSeed);
        assertEquals(hiddenInt1, HTypeFactory.createHiddenInt(anInt1),
            "Method createHiddenInt does not works with normal value." + messageSeed);
    }

    @RepeatedTest(20)
    void testCreateHiddenString() {
        assertEquals(hiddenString1, HTypeFactory.createHiddenString(hiddenString1),
            "Method createHiddenString does not works with hidden instance." + messageSeed);
        assertEquals(hiddenString1, HTypeFactory.createHiddenString(typeString1),
            "Method createHiddenString does not works with SType instance." + messageSeed);
        assertEquals(hiddenString1, HTypeFactory.createHiddenString(aString1),
            "Method createHiddenString does not works with normal value." + messageSeed);
    }

    @RepeatedTest(20)
    void testCreateHiddenNull() {
        assertEquals(hiddenNull, HTypeFactory.createHiddenNull(),
            "Method createHiddenNull does not works." + messageSeed);
    }
}