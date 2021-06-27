package cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import cl.uchile.dcc.scrabble.model.types.TypeFloat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

class HiddenFloatTest extends BaseHTypeTest {

    @BeforeEach
    public void setUp() {
        super.setUp();
    }

    @RepeatedTest(20)
    void testCalculate() {
        assertEquals(wFloat1, wFloat1.calculate(),
            "Method calculate does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testAsString() {
        assertEquals(typeFloat1.toString(), wFloat1.asString(0),
            "Method asString dos not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testHashCode() {
        assertEquals(typeFloat1.hashCode(), wFloat1.hashCode(),
            "Method hashCode does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testEquals() {
        assertEquals(new HiddenFloat(aFloat1), wFloat1,
            "Method equals does not works." + messageSeed);
        assertNotEquals(wFloat2, wFloat1,
            "Method equals does not works." + messageSeed);
        assertNotEquals(wFloat1, typeFloat1,
            "Method equals does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testToHiddenBinary() {
        assertNull(wFloat1.toHiddenBinary(),
            "Method toHiddenBinary does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testToHiddenBool() {
        assertNull(wFloat1.toHiddenBool(),
            "Method toHiddenBool does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testToHiddenFloat() {
        assertEquals(wFloat1, wFloat1.toHiddenFloat(),
            "Method toHiddenFloat does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testToHiddenInt() {
        assertNull(wFloat1.toHiddenInt(),
            "Method toHiddenInt does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testToHiddenString() {
        assertEquals(new HiddenString(typeFloat1.toTypeString()), wFloat1.toHiddenString(),
            "Method toHiddenString does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testGetAdaptee() {
        assertEquals(typeFloat1, wFloat1.toSType(),
            "Method getAdaptee does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testToString() {
        assertEquals("HiddenFloat{value=" + aFloat1 + "}", wFloat1.toString(),
            "Method toString does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testNeg() {
        assertNull(wFloat1.neg(), "Method neg does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testAdd() {
        HiddenFloat expected1 = new HiddenFloat((TypeFloat) typeFloat1.add(typeBinary1));
        assertEquals(expected1, wFloat1.add(wBinary1),
            "Method add does not works with binaries." + messageSeed);

        assertNull(wFloat1.add(trueWBool),
            "Method add does not works with booleans." + messageSeed);
        assertNull(wFloat1.add(falseWBool),
            "Method add does not works with booleans." + messageSeed);

        HiddenFloat expected3 = new HiddenFloat((TypeFloat) typeFloat1.add(typeFloat2));
        assertEquals(expected3, wFloat1.add(wFloat2),
            "Method add does not works with floats." + messageSeed);

        HiddenFloat expected4 = new HiddenFloat((TypeFloat) typeFloat1.add(typeInt1));
        assertEquals(expected4, wFloat1.add(wInt1),
            "Method add does not works with int." + messageSeed);

        assertNull(wFloat1.add(wString1),
            "Method add does not works with strings." + messageSeed);
    }

    @RepeatedTest(20)
    void testDiv() {
        HiddenFloat expected1 = new HiddenFloat((TypeFloat) typeFloat1.div(typeBinary1));
        assertEquals(expected1, wFloat1.div(wBinary1),
            "Method div does not works with binaries." + messageSeed);

        assertNull(wFloat1.div(trueWBool),
            "Method div does not works with booleans." + messageSeed);
        assertNull(wFloat1.div(falseWBool),
            "Method div does not works with booleans." + messageSeed);

        HiddenFloat expected3 = new HiddenFloat((TypeFloat) typeFloat1.div(typeFloat2));
        assertEquals(expected3, wFloat1.div(wFloat2),
            "Method div does not works with floats." + messageSeed);

        HiddenFloat expected4 = new HiddenFloat((TypeFloat) typeFloat1.div(typeInt1));
        assertEquals(expected4, wFloat1.div(wInt1),
            "Method div does not works with int." + messageSeed);

        assertNull(wFloat1.div(wString1),
            "Method div does not works with strings." + messageSeed);
    }

    @RepeatedTest(20)
    void testMult() {
        HiddenFloat expected1 = new HiddenFloat((TypeFloat) typeFloat1.mult(typeBinary1));
        assertEquals(expected1, wFloat1.mult(wBinary1),
            "Method mult does not works with binaries." + messageSeed);

        assertNull(wFloat1.mult(trueWBool),
            "Method mult does not works with booleans." + messageSeed);
        assertNull(wFloat1.mult(falseWBool),
            "Method mult does not works with booleans." + messageSeed);

        HiddenFloat expected3 = new HiddenFloat((TypeFloat) typeFloat1.mult(typeFloat2));
        assertEquals(expected3, wFloat1.mult(wFloat2),
            "Method mult does not works with floats." + messageSeed);

        HiddenFloat expected4 = new HiddenFloat((TypeFloat) typeFloat1.mult(typeInt1));
        assertEquals(expected4, wFloat1.mult(wInt1),
            "Method mult does not works with int." + messageSeed);

        assertNull(wFloat1.mult(wString1),
            "Method mult does not works with strings." + messageSeed);
    }

    @RepeatedTest(20)
    void testSub() {
        HiddenFloat expected1 = new HiddenFloat((TypeFloat) typeFloat1.sub(typeBinary1));
        assertEquals(expected1, wFloat1.sub(wBinary1),
            "Method sub does not works with binaries." + messageSeed);

        assertNull(wFloat1.sub(trueWBool),
            "Method sub does not works with booleans." + messageSeed);
        assertNull(wFloat1.sub(falseWBool),
            "Method sub does not works with booleans." + messageSeed);

        HiddenFloat expected3 = new HiddenFloat((TypeFloat) typeFloat1.sub(typeFloat2));
        assertEquals(expected3, wFloat1.sub(wFloat2),
            "Method sub does not works with floats." + messageSeed);

        HiddenFloat expected4 = new HiddenFloat((TypeFloat) typeFloat1.sub(typeInt1));
        assertEquals(expected4, wFloat1.sub(wInt1),
            "Method sub does not works with int." + messageSeed);

        assertNull(wFloat1.sub(wString1),
            "Method sub does not works with strings." + messageSeed);
    }

    @RepeatedTest(20)
    void testAnd() {
        assertNull(wFloat1.and(wBinary1),
            "Method and does not works with binaries." + messageSeed);

        assertNull(wFloat1.and(trueWBool),
            "Method and does not works with booleans." + messageSeed);
        assertNull(wFloat1.and(falseWBool),
            "Method and does not works with booleans." + messageSeed);

        assertNull(wFloat1.and(wFloat2),
            "Method and does not works with floats." + messageSeed);

        assertNull(wFloat1.and(wInt1),
            "Method and does not works with int." + messageSeed);

        assertNull(wFloat1.and(wString1),
            "Method and does not works with strings." + messageSeed);
    }

    @RepeatedTest(20)
    void testOr() {
        assertNull(wFloat1.or(wBinary1),
            "Method or does not works with binaries." + messageSeed);

        assertNull(wFloat1.or(trueWBool),
            "Method or does not works with booleans." + messageSeed);
        assertNull(wFloat1.or(falseWBool),
            "Method or does not works with booleans." + messageSeed);

        assertNull(wFloat1.or(wFloat2),
            "Method or does not works with floats." + messageSeed);

        assertNull(wFloat1.or(wInt1),
            "Method or does not works with int." + messageSeed);

        assertNull(wFloat1.or(wString1),
            "Method or does not works with strings." + messageSeed);
    }
}