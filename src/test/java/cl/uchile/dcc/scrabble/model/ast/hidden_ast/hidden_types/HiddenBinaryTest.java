package cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import cl.uchile.dcc.scrabble.model.types.TypeBinary;
import cl.uchile.dcc.scrabble.model.utils.BinaryUtilities;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

class HiddenBinaryTest extends BaseHTypeTest {

    @BeforeEach
    public void setUp() {
        super.setUp();
    }

    @RepeatedTest(20)
    void testGetAdaptee() {
        TypeBinary expected = wBinary1.toSType();
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
        HiddenBinary expected = new HiddenBinary(typeBinary1);
        assertEquals(expected, wBinary1, "Method equals does not works." + messageSeed);
        assertNotEquals(wBinary2, wBinary1, "Method equals does not works." + messageSeed);
        assertNotEquals(wBinary1, typeBinary1, "Method equals does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testToString() {
        String expected = "HiddenBinary{value=" + wBinary1.toSType().getValue() + "}";
        assertEquals(expected, wBinary1.toString(), "Method toString does not works."
            + messageSeed);
    }

    @RepeatedTest(20)
    void testToHiddenBinary() {
        HiddenBinary expected = new HiddenBinary(aBinary1);
        assertEquals(expected, wBinary1.toHiddenBinary(),
            "Method toHiddenBinary does not works." + messageSeed);
        assertNotEquals(expected, wBinary2.toHiddenBinary(),
            "Method toHiddenBinary does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testToHiddenBool() {
        assertNull(wBinary1.toHiddenBool(),
            "Method toHiddenBool does not works" + messageSeed);
    }

    @RepeatedTest(20)
    void testToHiddenFloat() {
        HiddenFloat expected = new HiddenFloat(typeBinary1.toTypeFloat());
        assertEquals(expected, wBinary1.toHiddenFloat(),
            "Method toHiddenFloat does not works." + messageSeed);
        assertNotEquals(expected, wBinary2.toHiddenFloat(),
            "Method toHiddenFloat does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testToHiddenInt() {
        HiddenInt expected = new HiddenInt(typeBinary1.toTypeInt());
        assertEquals(expected, wBinary1.toHiddenInt(),
            "Method toHiddenInt does not works." + messageSeed);
        assertNotEquals(expected, wBinary2.toHiddenInt(),
            "Method toHiddenInt does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testToHiddenString() {
        HiddenString expected = new HiddenString(typeBinary1.toTypeString());
        assertEquals(expected, wBinary1.toHiddenString(),
            "Method toHiddenString does not works." + messageSeed);
        assertNotEquals(expected, wBinary2.toHiddenString(),
            "Method toHiddenString does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testNeg() {
        HiddenBinary expected1 = new HiddenBinary(BinaryUtilities.oneComplement(aBinary1));
        assertEquals(expected1, wBinary1.neg(),
            "Method neg does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testAdd() {
        HiddenBinary expected1 = new HiddenBinary((TypeBinary) typeBinary1.add(typeBinary2));
        assertEquals(expected1, wBinary1.add(wBinary2),
            "Method add does not works with binaries." + messageSeed);

        assertNull(wBinary1.add(trueWBool),
            "Method add does not works with booleans." + messageSeed);
        assertNull(wBinary1.add(falseWBool),
            "Method add does not works with booleans." + messageSeed);

        assertNull(wBinary1.add(wFloat1), "Method add does not works with floats." + messageSeed);

        HiddenBinary expected4 = new HiddenBinary((TypeBinary) typeBinary1.add(typeInt1));
        assertEquals(expected4, wBinary1.add(wInt1),
            "Method add does not works with int." + messageSeed);

        assertNull(wBinary1.add(wString1), "Method add does not works with strings." + messageSeed);
    }

    @RepeatedTest(20)
    void testAnd() {
        HiddenBinary expected1 = new HiddenBinary((TypeBinary) typeBinary1.and(typeBinary2));
        assertEquals(expected1, wBinary1.and(wBinary2),
            "Method and does not works with binaries." + messageSeed);

        HiddenBinary expected2 = new HiddenBinary((TypeBinary) typeBinary1.and(trueTypeBool));
        assertEquals(expected2, wBinary1.and(trueWBool),
            "Method and does not works with booleans." + messageSeed);
        HiddenBinary expected21 = new HiddenBinary((TypeBinary) typeBinary1.and(falseTypeBool));
        assertEquals(expected21, wBinary1.and(falseWBool),
            "Method and does not works with booleans." + messageSeed);

        assertNull(wBinary1.and(wFloat1), "Method and does not works with floats." + messageSeed);

        assertNull(wBinary1.and(wInt1), "Method and does not works with ints." + messageSeed);

        assertNull(wBinary1.and(wString1), "Method and does not works with string." + messageSeed);
    }

    @RepeatedTest(20)
    void testDiv() {
        HiddenBinary expected1 = new HiddenBinary((TypeBinary) typeBinary1.div(typeBinary2));
        assertEquals(expected1, wBinary1.div(wBinary2),
            "Method div does not works with binaries." + messageSeed);

        assertNull(wBinary1.div(trueWBool),
            "Method div does not works with booleans." + messageSeed);
        assertNull(wBinary1.div(falseWBool),
            "Method div does not works with booleans." + messageSeed);

        assertNull(wBinary1.div(wFloat1), "Method div does not works with floats." + messageSeed);

        HiddenBinary expected4 = new HiddenBinary((TypeBinary) typeBinary1.div(typeInt1));
        assertEquals(expected4, wBinary1.div(wInt1),
            "Method div does not works with int." + messageSeed);

        assertNull(wBinary1.div(wString1), "Method div does not works with strings." + messageSeed);
    }

    @RepeatedTest(20)
    void testMult() {
        HiddenBinary expected1 = new HiddenBinary((TypeBinary) typeBinary1.mult(typeBinary2));
        assertEquals(expected1, wBinary1.mult(wBinary2),
            "Method mult does not works with binaries." + messageSeed);

        assertNull(wBinary1.mult(trueWBool),
            "Method mult does not works with booleans." + messageSeed);
        assertNull(wBinary1.mult(falseWBool),
            "Method mult does not works with booleans." + messageSeed);

        assertNull(wBinary1.mult(wFloat1), "Method mult does not works with floats." + messageSeed);

        HiddenBinary expected4 = new HiddenBinary((TypeBinary) typeBinary1.mult(typeInt1));
        assertEquals(expected4, wBinary1.mult(wInt1),
            "Method mult does not works with int." + messageSeed);

        assertNull(wBinary1.mult(wString1),
            "Method mult does not works with strings." + messageSeed);
    }

    @RepeatedTest(20)
    void testOr() {
        HiddenBinary expected1 = new HiddenBinary((TypeBinary) typeBinary1.or(typeBinary2));
        assertEquals(expected1, wBinary1.or(wBinary2),
            "Method or does not works with binaries." + messageSeed);

        HiddenBinary expected2 = new HiddenBinary((TypeBinary) typeBinary1.or(trueTypeBool));
        assertEquals(expected2, wBinary1.or(trueWBool),
            "Method or does not works with booleans." + messageSeed);
        HiddenBinary expected21 = new HiddenBinary((TypeBinary) typeBinary1.or(falseTypeBool));
        assertEquals(expected21, wBinary1.or(falseWBool),
            "Method or does not works with booleans." + messageSeed);

        assertNull(wBinary1.or(wFloat1), "Method or does not works with floats." + messageSeed);

        assertNull(wBinary1.or(wInt1), "Method or does not works with ints." + messageSeed);

        assertNull(wBinary1.or(wString1), "Method or does not works with string." + messageSeed);
    }

    @RepeatedTest(20)
    void testSub() {
        HiddenBinary expected1 = new HiddenBinary((TypeBinary) typeBinary1.sub(typeBinary2));
        assertEquals(expected1, wBinary1.sub(wBinary2),
            "Method sub does not works with binaries." + messageSeed);

        assertNull(wBinary1.sub(trueWBool),
            "Method sub does not works with booleans." + messageSeed);
        assertNull(wBinary1.sub(falseWBool),
            "Method sub does not works with booleans." + messageSeed);

        assertNull(wBinary1.sub(wFloat1), "Method sub does not works with floats." + messageSeed);

        HiddenBinary expected4 = new HiddenBinary((TypeBinary) typeBinary1.sub(typeInt1));
        assertEquals(expected4, wBinary1.sub(wInt1),
            "Method sub does not works with int." + messageSeed);

        assertNull(wBinary1.sub(wString1), "Method sub does not works with strings." + messageSeed);
    }
}