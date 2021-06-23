package cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import cl.uchile.dcc.scrabble.model.types.TypeFloat;
import cl.uchile.dcc.scrabble.model.types.TypeInt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

class HiddenIntTest extends BaseHTypeTest {

    @BeforeEach
    public void setUp() {
        super.setUp();
    }

    @RepeatedTest(20)
    void testCalculate() {
        assertEquals(wInt1, wInt1.calculate(),
            "Method calculate does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testAsString() {
        assertEquals(typeInt1.toString(), wInt1.asString(0),
            "Method asString dos not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testHashCode() {
        assertEquals(typeInt1.hashCode(), wInt1.hashCode(),
            "Method hashCode does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testEquals() {
        assertEquals(new HiddenInt(anInt1), wInt1,
            "Method equals does not works." + messageSeed);
        assertNotEquals(wInt2, wInt1,
            "Method equals does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testToHiddenBinary() {
        assertEquals(new HiddenBinary(typeInt1.toTypeBinary()), wInt1.toHiddenBinary(),
            "Method toHiddenBinary does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testToHiddenBool() {
        assertNull(wInt1.toHiddenBool(),
            "Method toHiddenBool does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testToHiddenFloat() {
        assertEquals(new HiddenFloat(typeInt1.toTypeFloat()), wInt1.toHiddenFloat(),
            "Method toHiddenFloat does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testToHiddenInt() {
        assertEquals(wInt1, wInt1.toHiddenInt(),
            "Method toHiddenInt does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testToHiddenString() {
        assertEquals(new HiddenString(typeInt1.toTypeString()), wInt1.toHiddenString(),
            "Method toHiddenString does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testGetAdaptee() {
        assertEquals(typeInt1, wInt1.toSType(),
            "Method getAdaptee does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testToString() {
        assertEquals("HiddenInt{value=" + anInt1 + "}", wInt1.toString(),
            "Method toString does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testAdd() {
        HiddenInt expected1 = new HiddenInt((TypeInt) typeInt1.add(typeBinary1));
        assertEquals(expected1, wInt1.add(wBinary1),
            "Method add does not works with binaries." + messageSeed);

        assertNull(wInt1.add(trueWBool),
            "Method add does not works with booleans." + messageSeed);
        assertNull(wInt1.add(falseWBool),
            "Method add does not works with booleans." + messageSeed);

        HiddenFloat expected3 = new HiddenFloat((TypeFloat) typeInt1.add(typeFloat1));
        assertEquals(expected3, wInt1.add(wFloat1),
            "Method add does not works with floats." + messageSeed);

        HiddenInt expected4 = new HiddenInt((TypeInt) typeInt1.add(typeInt2));
        assertEquals(expected4, wInt1.add(wInt2),
            "Method add does not works with int." + messageSeed);

        assertNull(wInt1.add(wString1),
            "Method add does not works with strings." + messageSeed);
    }

    @RepeatedTest(20)
    void testDiv() {
        HiddenInt expected1 = new HiddenInt((TypeInt) typeInt1.div(typeBinary1));
        assertEquals(expected1, wInt1.div(wBinary1),
            "Method div does not works with binaries." + messageSeed);

        assertNull(wInt1.div(trueWBool),
            "Method div does not works with booleans." + messageSeed);
        assertNull(wInt1.div(falseWBool),
            "Method div does not works with booleans." + messageSeed);

        HiddenFloat expected3 = new HiddenFloat((TypeFloat) typeInt1.div(typeFloat1));
        assertEquals(expected3, wInt1.div(wFloat1),
            "Method div does not works with floats." + messageSeed);

        HiddenInt expected4 = new HiddenInt((TypeInt) typeInt1.div(typeInt2));
        assertEquals(expected4, wInt1.div(wInt2),
            "Method div does not works with int." + messageSeed);

        assertNull(wInt1.div(wString1),
            "Method div does not works with strings." + messageSeed);
    }

    @RepeatedTest(20)
    void testMult() {
        HiddenInt expected1 = new HiddenInt((TypeInt) typeInt1.mult(typeBinary1));
        assertEquals(expected1, wInt1.mult(wBinary1),
            "Method mult does not works with binaries." + messageSeed);

        assertNull(wInt1.mult(trueWBool),
            "Method mult does not works with booleans." + messageSeed);
        assertNull(wInt1.mult(falseWBool),
            "Method mult does not works with booleans." + messageSeed);

        HiddenFloat expected3 = new HiddenFloat((TypeFloat) typeInt1.mult(typeFloat1));
        assertEquals(expected3, wInt1.mult(wFloat1),
            "Method mult does not works with floats." + messageSeed);

        HiddenInt expected4 = new HiddenInt((TypeInt) typeInt1.mult(typeInt2));
        assertEquals(expected4, wInt1.mult(wInt2),
            "Method mult does not works with int." + messageSeed);

        assertNull(wInt1.mult(wString1),
            "Method mult does not works with strings." + messageSeed);
    }

    @RepeatedTest(20)
    void testSub() {
        HiddenInt expected1 = new HiddenInt((TypeInt) typeInt1.sub(typeBinary1));
        assertEquals(expected1, wInt1.sub(wBinary1),
            "Method sub does not works with binaries." + messageSeed);

        assertNull(wInt1.sub(trueWBool),
            "Method sub does not works with booleans." + messageSeed);
        assertNull(wInt1.sub(falseWBool),
            "Method sub does not works with booleans." + messageSeed);

        HiddenFloat expected3 = new HiddenFloat((TypeFloat) typeInt1.sub(typeFloat1));
        assertEquals(expected3, wInt1.sub(wFloat1),
            "Method sub does not works with floats." + messageSeed);

        HiddenInt expected4 = new HiddenInt((TypeInt) typeInt1.sub(typeInt2));
        assertEquals(expected4, wInt1.sub(wInt2),
            "Method sub does not works with int." + messageSeed);

        assertNull(wInt1.sub(wString1),
            "Method sub does not works with strings." + messageSeed);
    }

    @RepeatedTest(20)
    void testAnd() {
        assertNull(wInt1.and(wBinary1),
            "Method and does not works with binaries." + messageSeed);

        assertNull(wInt1.and(trueWBool),
            "Method and does not works with booleans." + messageSeed);
        assertNull(wInt1.and(falseWBool),
            "Method and does not works with booleans." + messageSeed);

        assertNull(wInt1.and(wFloat1),
            "Method and does not works with floats." + messageSeed);

        assertNull(wInt1.and(wInt2),
            "Method and does not works with int." + messageSeed);

        assertNull(wInt1.and(wString1),
            "Method and does not works with strings." + messageSeed);
    }

    @RepeatedTest(20)
    void testOr() {
        assertNull(wInt1.or(wBinary1),
            "Method or does not works with binaries." + messageSeed);

        assertNull(wInt1.or(trueWBool),
            "Method or does not works with booleans." + messageSeed);
        assertNull(wInt1.or(falseWBool),
            "Method or does not works with booleans." + messageSeed);

        assertNull(wInt1.or(wFloat1),
            "Method or does not works with floats." + messageSeed);

        assertNull(wInt1.or(wInt2),
            "Method or does not works with int." + messageSeed);

        assertNull(wInt1.or(wString1),
            "Method or does not works with strings." + messageSeed);
    }
}