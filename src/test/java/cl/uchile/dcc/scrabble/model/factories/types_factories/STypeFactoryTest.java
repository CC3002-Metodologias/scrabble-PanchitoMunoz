package cl.uchile.dcc.scrabble.model.factories.types_factories;

import static org.junit.jupiter.api.Assertions.*;

import cl.uchile.dcc.scrabble.model.types.BaseTypeTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class STypeFactoryTest extends BaseTypeTest {

    @BeforeEach
    public void setUp() {
        super.setUp();
    }

    @RepeatedTest(20)
    void testCreateTypeBinary() {
        assertEquals(typeBinary1, STypeFactory.createTypeBinary(typeBinary1),
            "Method createTypeBinary does not works with SType instance." + messageSeed);
        assertEquals(typeBinary1, STypeFactory.createTypeBinary(aBinary1),
            "Method createTypeBinary does not works with normal value." + messageSeed);
    }

    @RepeatedTest(20)
    void testCreateTypeBool() {
        assertEquals(trueTypeBool, STypeFactory.createTypeBool(trueTypeBool),
            "Method createTypeBool does not works with SType instance." + messageSeed);
        assertEquals(trueTypeBool, STypeFactory.createTypeBool(true),
            "Method createTypeBool does not works with normal value." + messageSeed);
    }

    @RepeatedTest(20)
    void testCreateTypeFloat() {
        assertEquals(typeFloat1, STypeFactory.createTypeFloat(typeFloat1),
            "Method createTypeFloat does not works with SType instance." + messageSeed);
        assertEquals(typeFloat1, STypeFactory.createTypeFloat(aFloat1),
            "Method createTypeFloat does not works with normal value." + messageSeed);
    }

    @RepeatedTest(20)
    void testCreateTypeInt() {
        assertEquals(typeInt1, STypeFactory.createTypeInt(typeInt1),
            "Method createTypeInt does not works with SType instance." + messageSeed);
        assertEquals(typeInt1, STypeFactory.createTypeInt(anInt1),
            "Method createTypeInt does not works with normal value." + messageSeed);
    }

    @RepeatedTest(20)
    void testCreateTypeString() {
        assertEquals(typeString1, STypeFactory.createTypeString(typeString1),
            "Method createTypeString does not works with SType instance." + messageSeed);
        assertEquals(typeString1, STypeFactory.createTypeString(aString1),
            "Method createTypeString does not works with normal value." + messageSeed);
    }
}