package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.fail;

import cl.uchile.dcc.scrabble.model.exceptions.ZeroDivisionException;
import cl.uchile.dcc.scrabble.model.utils.BinaryUtilities;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

class HiddenStringTest extends BaseHTypeTest {

    @BeforeEach
    public void setUp() {
        super.setUp();
    }

    @RepeatedTest(20)
    void testCalculate() {
        assertEquals(hiddenString1, hiddenString1.calculate(),
            "Method calculate does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testAsString() {
        assertEquals(typeString1.toString(), hiddenString1.asString(0),
            "Method asString does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testHashCode() {
        assertEquals(aString1.hashCode(), hiddenString1.hashCode(),
            "Method hashCode does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testEquals() {
        assertEquals(new HiddenString(typeString1), hiddenString1,
            "Method equals does not works." + messageSeed);
        assertNotEquals(hiddenString1, hiddenString2,
            "Method equals does not works." + messageSeed);
        assertNotEquals(hiddenString2, typeString1,
            "Method equals does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testToHiddenBinary() {
        assertEquals(hiddenNull, hiddenString1.toHiddenBinary(),
            "Method toHiddenBinary does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testToHiddenBool() {
        assertEquals(hiddenNull, hiddenString1.toHiddenBool(),
            "Method toHiddenBool does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testToHiddenFloat() {
        assertEquals(hiddenNull, hiddenString1.toHiddenFloat(),
            "Method toHiddenFloat does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testToHiddenInt() {
        assertEquals(hiddenNull, hiddenString1.toHiddenInt(),
            "Method toHiddenInt does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testToHiddenString() {
        assertEquals(new HiddenString(aString1), hiddenString1.toHiddenString(),
            "Method toHiddenString does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testGetAdaptee() {
        assertEquals(typeString1, hiddenString1.asSType(),
            "Method getAdaptee does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testToString() {
        assertEquals("HiddenString{value='" + aString1 + "'}", hiddenString1.toString(),
            "Method toString does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testNeg() {
        assertEquals(hiddenNull, hiddenString1.neg(), "Method neg does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testAdd() {
        HiddenString expected1 = new HiddenString(
            aString1 + BinaryUtilities.cleanBinary(aBinary1)
        );
        assertEquals(expected1, hiddenString1.add(hiddenBinary1),
            "Method add does not works with binaries." + messageSeed);

        HiddenString expected21 = new HiddenString(
            aString1 + trueBoolean
        );
        assertEquals(expected21, hiddenString1.add(trueHiddenBool),
            "Method add does not works with booleans." + messageSeed);
        HiddenString expected22 = new HiddenString(
            aString1 + falseBoolean
        );
        assertEquals(expected22, hiddenString1.add(falseHiddenBool),
            "Method add does not works with booleans." + messageSeed);

        HiddenString expected3 = new HiddenString(
            aString1 + aFloat1
        );
        assertEquals(expected3, hiddenString1.add(hiddenFloat1),
            "Method add does not works with floats." + messageSeed);

        HiddenString expected4 = new HiddenString(
            aString1 + anInt1
        );
        assertEquals(expected4, hiddenString1.add(hiddenInt1),
            "Method add does not works with ints." + messageSeed);

        HiddenString expected5 = new HiddenString(
            aString1 + aString2
        );
        assertEquals(expected5, hiddenString1.add(hiddenString2),
            "Method add does not works with strings." + messageSeed);
    }

    @RepeatedTest(20)
    void testSub() {
        assertEquals(hiddenNull, hiddenString1.sub(hiddenBinary1),
            "Method sub does not works with binaries." + messageSeed);

        assertEquals(hiddenNull, hiddenString1.sub(trueHiddenBool),
            "Method sub does not works with booleans." + messageSeed);
        assertEquals(hiddenNull, hiddenString1.sub(falseHiddenBool),
            "Method sub does not works with booleans." + messageSeed);

        assertEquals(hiddenNull, hiddenString1.sub(hiddenFloat1),
            "Method sub does not works with floats." + messageSeed);

        assertEquals(hiddenNull, hiddenString1.sub(hiddenInt1),
            "Method sub does not works with ints." + messageSeed);

        assertEquals(hiddenNull, hiddenString1.sub(hiddenString2),
            "Method sub does not works with strings." + messageSeed);
    }

    @RepeatedTest(20)
    void testDiv() {
        try {
            assertEquals(hiddenNull, hiddenString1.div(hiddenBinary1),
                "Method div does not works with binaries." + messageSeed);

            assertEquals(hiddenNull, hiddenString1.div(trueHiddenBool),
                "Method div does not works with booleans." + messageSeed);
            assertEquals(hiddenNull, hiddenString1.div(falseHiddenBool),
                "Method div does not works with booleans." + messageSeed);

            assertEquals(hiddenNull, hiddenString1.div(hiddenFloat1),
                "Method div does not works with floats." + messageSeed);

            assertEquals(hiddenNull, hiddenString1.div(hiddenInt1),
                "Method div does not works with ints." + messageSeed);

            assertEquals(hiddenNull, hiddenString1.div(hiddenString2),
                "Method div does not works with strings." + messageSeed);
        } catch (ZeroDivisionException e) {
            fail("Exception fails.");
        }
    }

    @RepeatedTest(20)
    void testMult() {
        assertEquals(hiddenNull, hiddenString1.mult(hiddenBinary1),
            "Method mult does not works with binaries." + messageSeed);

        assertEquals(hiddenNull, hiddenString1.mult(trueHiddenBool),
            "Method mult does not works with booleans." + messageSeed);
        assertEquals(hiddenNull, hiddenString1.mult(falseHiddenBool),
            "Method mult does not works with booleans." + messageSeed);

        assertEquals(hiddenNull, hiddenString1.mult(hiddenFloat1),
            "Method mult does not works with floats." + messageSeed);

        assertEquals(hiddenNull, hiddenString1.mult(hiddenInt1),
            "Method mult does not works with ints." + messageSeed);

        assertEquals(hiddenNull, hiddenString1.mult(hiddenString2),
            "Method mult does not works with strings." + messageSeed);
    }

    @RepeatedTest(20)
    void testAnd() {
        assertEquals(hiddenNull, hiddenString1.and(hiddenBinary1),
            "Method and does not works with binaries." + messageSeed);

        assertEquals(hiddenNull, hiddenString1.and(trueHiddenBool),
            "Method and does not works with booleans." + messageSeed);
        assertEquals(hiddenNull, hiddenString1.and(falseHiddenBool),
            "Method and does not works with booleans." + messageSeed);

        assertEquals(hiddenNull, hiddenString1.and(hiddenFloat1),
            "Method and does not works with floats." + messageSeed);

        assertEquals(hiddenNull, hiddenString1.and(hiddenInt1),
            "Method and does not works with ints." + messageSeed);

        assertEquals(hiddenNull, hiddenString1.and(hiddenString2),
            "Method and does not works with strings." + messageSeed);
    }

    @RepeatedTest(20)
    void testOr() {
        assertEquals(hiddenNull, hiddenString1.or(hiddenBinary1),
            "Method or does not works with binaries." + messageSeed);

        assertEquals(hiddenNull, hiddenString1.or(trueHiddenBool),
            "Method or does not works with booleans." + messageSeed);
        assertEquals(hiddenNull, hiddenString1.or(falseHiddenBool),
            "Method or does not works with booleans." + messageSeed);

        assertEquals(hiddenNull, hiddenString1.or(hiddenFloat1),
            "Method or does not works with floats." + messageSeed);

        assertEquals(hiddenNull, hiddenString1.or(hiddenInt1),
            "Method or does not works with ints." + messageSeed);

        assertEquals(hiddenNull, hiddenString1.or(hiddenString2),
            "Method or does not works with strings." + messageSeed);
    }
}