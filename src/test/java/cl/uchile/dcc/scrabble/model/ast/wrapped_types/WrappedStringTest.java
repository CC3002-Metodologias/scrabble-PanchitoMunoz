package cl.uchile.dcc.scrabble.model.ast.wrapped_types;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

class WrappedStringTest extends BaseWTypeTest {

    @BeforeEach
    public void setUp() {
        super.setUp();
    }

    @RepeatedTest(20)
    void testCalculate() {
        assertEquals(typeString1, wString1.calculate(),
            "Method calculate does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testAsString() {
        assertEquals(typeString1.toString(), wString1.asString(0),
            "Method asString does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testHashCode() {
        assertEquals(typeString1.hashCode(), wString1.hashCode(),
            "Method hashCode does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testEquals() {
        assertEquals(new WrappedString(typeString1), wString1,
            "Method equals does not works." + messageSeed);
        assertNotEquals(wString1, wString2,
            "Method equals does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testToWrappedBinary() {
        assertNull(wString1.toWrappedBinary(),
            "Method toWrappedBinary does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testToWrappedBool() {
        assertNull(wString1.toWrappedBool(),
            "Method toWrappedBool does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testToWrappedFloat() {
        assertNull(wString1.toWrappedFloat(),
            "Method toWrappedFloat does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testToWrappedInt() {
        assertNull(wString1.toWrappedInt(),
            "Method toWrappedInt does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testToWrappedString() {
        assertEquals(new WrappedString(aString1), wString1.toWrappedString(),
            "Method toWrappedString does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testGetAdaptee() {
        assertEquals(typeString1, wString1.getAdaptee(),
            "Method getAdaptee does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testToString() {
        assertEquals("WrappedString{value='" + aString1 + "'}", wString1.toString(),
            "Method toString does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testAdd() {
        WrappedString expected1 = new WrappedString(typeString1.add(typeBinary1));
        assertEquals(expected1, wString1.add(wBinary1),
            "Method add does not works with binaries." + messageSeed);

        WrappedString expected21 = new WrappedString(typeString1.add(trueTypeBool));
        assertEquals(expected21, wString1.add(trueWBool),
            "Method add does not works with booleans." + messageSeed);
        WrappedString expected22 = new WrappedString(typeString1.add(falseTypeBool));
        assertEquals(expected22, wString1.add(falseWBool),
            "Method add does not works with booleans." + messageSeed);

        WrappedString expected3 = new WrappedString(typeString1.add(typeFloat1));
        assertEquals(expected3, wString1.add(wFloat1),
            "Method add does not works with floats." + messageSeed);

        WrappedString expected4 = new WrappedString(typeString1.add(typeInt1));
        assertEquals(expected4, wString1.add(wInt1),
            "Method add does not works with ints." + messageSeed);

        WrappedString expected5 = new WrappedString(typeString1.add(typeString2));
        assertEquals(expected5, wString1.add(wString2),
            "Method add does not works with strings." + messageSeed);
    }

    @RepeatedTest(20)
    void testSub() {
        assertNull(wString1.sub(wBinary1),
            "Method sub does not works with binaries." + messageSeed);

        assertNull(wString1.sub(trueWBool),
            "Method sub does not works with booleans." + messageSeed);
        assertNull(wString1.sub(falseWBool),
            "Method sub does not works with booleans." + messageSeed);

        assertNull(wString1.sub(wFloat1),
            "Method sub does not works with floats." + messageSeed);

        assertNull(wString1.sub(wInt1),
            "Method sub does not works with ints." + messageSeed);

        assertNull(wString1.sub(wString2),
            "Method sub does not works with strings." + messageSeed);
    }

    @RepeatedTest(20)
    void testDiv() {
        assertNull(wString1.div(wBinary1),
            "Method div does not works with binaries." + messageSeed);

        assertNull(wString1.div(trueWBool),
            "Method div does not works with booleans." + messageSeed);
        assertNull(wString1.div(falseWBool),
            "Method div does not works with booleans." + messageSeed);

        assertNull(wString1.div(wFloat1),
            "Method div does not works with floats." + messageSeed);

        assertNull(wString1.div(wInt1),
            "Method div does not works with ints." + messageSeed);

        assertNull(wString1.div(wString2),
            "Method div does not works with strings." + messageSeed);
    }

    @RepeatedTest(20)
    void testMult() {
        assertNull(wString1.mult(wBinary1),
            "Method mult does not works with binaries." + messageSeed);

        assertNull(wString1.mult(trueWBool),
            "Method mult does not works with booleans." + messageSeed);
        assertNull(wString1.mult(falseWBool),
            "Method mult does not works with booleans." + messageSeed);

        assertNull(wString1.mult(wFloat1),
            "Method mult does not works with floats." + messageSeed);

        assertNull(wString1.mult(wInt1),
            "Method mult does not works with ints." + messageSeed);

        assertNull(wString1.mult(wString2),
            "Method mult does not works with strings." + messageSeed);
    }

    @RepeatedTest(20)
    void testAnd() {
        assertNull(wString1.and(wBinary1),
            "Method and does not works with binaries." + messageSeed);

        assertNull(wString1.and(trueWBool),
            "Method and does not works with booleans." + messageSeed);
        assertNull(wString1.and(falseWBool),
            "Method and does not works with booleans." + messageSeed);

        assertNull(wString1.and(wFloat1),
            "Method and does not works with floats." + messageSeed);

        assertNull(wString1.and(wInt1),
            "Method and does not works with ints." + messageSeed);

        assertNull(wString1.and(wString2),
            "Method and does not works with strings." + messageSeed);
    }

    @RepeatedTest(20)
    void testOr() {
        assertNull(wString1.or(wBinary1),
            "Method or does not works with binaries." + messageSeed);

        assertNull(wString1.or(trueWBool),
            "Method or does not works with booleans." + messageSeed);
        assertNull(wString1.or(falseWBool),
            "Method or does not works with booleans." + messageSeed);

        assertNull(wString1.or(wFloat1),
            "Method or does not works with floats." + messageSeed);

        assertNull(wString1.or(wInt1),
            "Method or does not works with ints." + messageSeed);

        assertNull(wString1.or(wString2),
            "Method or does not works with strings." + messageSeed);
    }
}