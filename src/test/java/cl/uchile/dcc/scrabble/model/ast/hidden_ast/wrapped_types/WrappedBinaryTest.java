package cl.uchile.dcc.scrabble.model.ast.hidden_ast.wrapped_types;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import cl.uchile.dcc.scrabble.model.types.TypeBinary;
import cl.uchile.dcc.scrabble.model.types.interface_types.SType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

class WrappedBinaryTest extends BaseWTypeTest {

    @BeforeEach
    public void setUp() {
        super.setUp();
    }

    @RepeatedTest(20)
    void testGetAdaptee() {
        SType expected = wBinary1.getAdaptee();
        assertEquals(expected, typeBinary1, "Method getAdaptee does not works."
            + messageSeed);
    }

    @RepeatedTest(20)
    void testCalculate() {
        assertEquals(wBinary1, wBinary1.calculate(),
            "Method calculate does not works" + messageSeed);
    }

    @RepeatedTest(20)
    void testAsString() {
        assertEquals(typeBinary1.toString(), wBinary1.asString(0),
            "Method asString does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testTestHashCode() {
        assertEquals(typeBinary1.hashCode(), wBinary1.hashCode(),
            "Method hashCode does not works" + messageSeed);
    }

    @RepeatedTest(20)
    void testTestEquals() {
        WrappedBinary expected = new WrappedBinary(typeBinary1);
        assertEquals(expected, wBinary1, "Method equals does not works." + messageSeed);
        assertNotEquals(wBinary2, wBinary1, "Method equals does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testToString() {
        String expected = "WrappedBinary{value=" + wBinary1.getAdaptee().getValue() + "}";
        assertEquals(expected, wBinary1.toString(), "Method toString does not works."
            + messageSeed);
    }

    @RepeatedTest(20)
    void testToWrappedBinary() {
        WrappedBinary expected = new WrappedBinary(aBinary1);
        assertEquals(expected, wBinary1.toWrappedBinary(),
            "Method toWrappedBinary does not works." + messageSeed);
        assertNotEquals(expected, wBinary2.toWrappedBinary(),
            "Method toWrappedBinary does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testToWrappedBool() {
        assertNull(wBinary1.toWrappedBool(),
            "Method toWrappedBool does not works" + messageSeed);
    }

    @RepeatedTest(20)
    void testToWrappedFloat() {
        WrappedFloat expected = new WrappedFloat(typeBinary1.toTypeFloat());
        assertEquals(expected, wBinary1.toWrappedFloat(),
            "Method toWrappedFloat does not works." + messageSeed);
        assertNotEquals(expected, wBinary2.toWrappedFloat(),
            "Method toWrappedFloat does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testToWrappedInt() {
        WrappedInt expected = new WrappedInt(typeBinary1.toTypeInt());
        assertEquals(expected, wBinary1.toWrappedInt(),
            "Method toWrappedInt does not works." + messageSeed);
        assertNotEquals(expected, wBinary2.toWrappedInt(),
            "Method toWrappedInt does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testToWrappedString() {
        WrappedString expected = new WrappedString(typeBinary1.toTypeString());
        assertEquals(expected, wBinary1.toWrappedString(),
            "Method toWrappedString does not works." + messageSeed);
        assertNotEquals(expected, wBinary2.toWrappedString(),
            "Method toWrappedString does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testAdd() {
        WrappedBinary expected1 = new WrappedBinary((TypeBinary) typeBinary1.add(typeBinary2));
        assertEquals(expected1, wBinary1.add(wBinary2),
            "Method add does not works with binaries." + messageSeed);

        assertNull(wBinary1.add(trueWBool),
            "Method add does not works with booleans." + messageSeed);
        assertNull(wBinary1.add(falseWBool),
            "Method add does not works with booleans." + messageSeed);

        assertNull(wBinary1.add(wFloat1), "Method add does not works with floats." + messageSeed);

        WrappedBinary expected4 = new WrappedBinary((TypeBinary) typeBinary1.add(typeInt1));
        assertEquals(expected4, wBinary1.add(wInt1),
            "Method add does not works with int." + messageSeed);

        assertNull(wBinary1.add(wString1), "Method add does not works with strings." + messageSeed);
    }

    @RepeatedTest(20)
    void testAnd() {
        WrappedBinary expected1 = new WrappedBinary((TypeBinary) typeBinary1.and(typeBinary2));
        assertEquals(expected1, wBinary1.and(wBinary2),
            "Method and does not works with binaries." + messageSeed);

        WrappedBinary expected2 = new WrappedBinary((TypeBinary) typeBinary1.and(trueTypeBool));
        assertEquals(expected2, wBinary1.and(trueWBool),
            "Method and does not works with booleans." + messageSeed);
        WrappedBinary expected21 = new WrappedBinary((TypeBinary) typeBinary1.and(falseTypeBool));
        assertEquals(expected21, wBinary1.and(falseWBool),
            "Method and does not works with booleans." + messageSeed);

        assertNull(wBinary1.and(wFloat1), "Method and does not works with floats." + messageSeed);

        assertNull(wBinary1.and(wInt1), "Method and does not works with ints." + messageSeed);

        assertNull(wBinary1.and(wString1), "Method and does not works with string." + messageSeed);
    }

    @RepeatedTest(20)
    void testDiv() {
        WrappedBinary expected1 = new WrappedBinary((TypeBinary) typeBinary1.div(typeBinary2));
        assertEquals(expected1, wBinary1.div(wBinary2),
            "Method div does not works with binaries." + messageSeed);

        assertNull(wBinary1.div(trueWBool),
            "Method div does not works with booleans." + messageSeed);
        assertNull(wBinary1.div(falseWBool),
            "Method div does not works with booleans." + messageSeed);

        assertNull(wBinary1.div(wFloat1), "Method div does not works with floats." + messageSeed);

        WrappedBinary expected4 = new WrappedBinary((TypeBinary) typeBinary1.div(typeInt1));
        assertEquals(expected4, wBinary1.div(wInt1),
            "Method div does not works with int." + messageSeed);

        assertNull(wBinary1.div(wString1), "Method div does not works with strings." + messageSeed);
    }

    @RepeatedTest(20)
    void testMult() {
        WrappedBinary expected1 = new WrappedBinary((TypeBinary) typeBinary1.mult(typeBinary2));
        assertEquals(expected1, wBinary1.mult(wBinary2),
            "Method mult does not works with binaries." + messageSeed);

        assertNull(wBinary1.mult(trueWBool),
            "Method mult does not works with booleans." + messageSeed);
        assertNull(wBinary1.mult(falseWBool),
            "Method mult does not works with booleans." + messageSeed);

        assertNull(wBinary1.mult(wFloat1), "Method mult does not works with floats." + messageSeed);

        WrappedBinary expected4 = new WrappedBinary((TypeBinary) typeBinary1.mult(typeInt1));
        assertEquals(expected4, wBinary1.mult(wInt1),
            "Method mult does not works with int." + messageSeed);

        assertNull(wBinary1.mult(wString1),
            "Method mult does not works with strings." + messageSeed);
    }

    @RepeatedTest(20)
    void testOr() {
        WrappedBinary expected1 = new WrappedBinary((TypeBinary) typeBinary1.or(typeBinary2));
        assertEquals(expected1, wBinary1.or(wBinary2),
            "Method or does not works with binaries." + messageSeed);

        WrappedBinary expected2 = new WrappedBinary((TypeBinary) typeBinary1.or(trueTypeBool));
        assertEquals(expected2, wBinary1.or(trueWBool),
            "Method or does not works with booleans." + messageSeed);
        WrappedBinary expected21 = new WrappedBinary((TypeBinary) typeBinary1.or(falseTypeBool));
        assertEquals(expected21, wBinary1.or(falseWBool),
            "Method or does not works with booleans." + messageSeed);

        assertNull(wBinary1.or(wFloat1), "Method or does not works with floats." + messageSeed);

        assertNull(wBinary1.or(wInt1), "Method or does not works with ints." + messageSeed);

        assertNull(wBinary1.or(wString1), "Method or does not works with string." + messageSeed);
    }

    @RepeatedTest(20)
    void testSub() {
        WrappedBinary expected1 = new WrappedBinary((TypeBinary) typeBinary1.sub(typeBinary2));
        assertEquals(expected1, wBinary1.sub(wBinary2),
            "Method sub does not works with binaries." + messageSeed);

        assertNull(wBinary1.sub(trueWBool),
            "Method sub does not works with booleans." + messageSeed);
        assertNull(wBinary1.sub(falseWBool),
            "Method sub does not works with booleans." + messageSeed);

        assertNull(wBinary1.sub(wFloat1), "Method sub does not works with floats." + messageSeed);

        WrappedBinary expected4 = new WrappedBinary((TypeBinary) typeBinary1.sub(typeInt1));
        assertEquals(expected4, wBinary1.sub(wInt1),
            "Method sub does not works with int." + messageSeed);

        assertNull(wBinary1.sub(wString1), "Method sub does not works with strings." + messageSeed);
    }
}