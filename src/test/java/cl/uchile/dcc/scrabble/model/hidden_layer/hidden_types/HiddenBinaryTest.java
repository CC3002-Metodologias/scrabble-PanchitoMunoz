package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types;

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
        TypeBinary expected = hiddenBinary1.toSType();
        assertEquals(expected, typeBinary1, "Method getAdaptee does not works."
            + messageSeed);
    }

    @RepeatedTest(20)
    void testCalculate() {
        assertEquals(hiddenBinary1, hiddenBinary1.calculate(),
            "Method calculate does not works" + messageSeed);
    }

    @RepeatedTest(20)
    void testAsString() {
        assertEquals(typeBinary1.toString(), hiddenBinary1.asString(0),
            "Method asString does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testTestHashCode() {
        assertEquals(typeBinary1.hashCode(), hiddenBinary1.hashCode(),
            "Method hashCode does not works" + messageSeed);
    }

    @RepeatedTest(20)
    void testTestEquals() {
        HiddenBinary expected = new HiddenBinary(typeBinary1);
        assertEquals(expected, hiddenBinary1, "Method equals does not works." + messageSeed);
        assertNotEquals(hiddenBinary2, hiddenBinary1, "Method equals does not works." + messageSeed);
        assertNotEquals(hiddenBinary1, typeBinary1, "Method equals does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testToString() {
        String expected = "HiddenBinary{value=" + hiddenBinary1.toSType().getValue() + "}";
        assertEquals(expected, hiddenBinary1.toString(), "Method toString does not works."
            + messageSeed);
    }

    @RepeatedTest(20)
    void testToHiddenBinary() {
        HiddenBinary expected = new HiddenBinary(aBinary1);
        assertEquals(expected, hiddenBinary1.toHiddenBinary(),
            "Method toHiddenBinary does not works." + messageSeed);
        assertNotEquals(expected, hiddenBinary2.toHiddenBinary(),
            "Method toHiddenBinary does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testToHiddenBool() {
        assertEquals(hiddenNull, hiddenBinary1.toHiddenBool(),
            "Method toHiddenBool does not works" + messageSeed);
    }

    @RepeatedTest(20)
    void testToHiddenFloat() {
        HiddenFloat expected = new HiddenFloat(typeBinary1.toTypeFloat());
        assertEquals(expected, hiddenBinary1.toHiddenFloat(),
            "Method toHiddenFloat does not works." + messageSeed);
        assertNotEquals(expected, hiddenBinary2.toHiddenFloat(),
            "Method toHiddenFloat does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testToHiddenInt() {
        HiddenInt expected = new HiddenInt(typeBinary1.toTypeInt());
        assertEquals(expected, hiddenBinary1.toHiddenInt(),
            "Method toHiddenInt does not works." + messageSeed);
        assertNotEquals(expected, hiddenBinary2.toHiddenInt(),
            "Method toHiddenInt does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testToHiddenString() {
        HiddenString expected = new HiddenString(typeBinary1.toTypeString());
        assertEquals(expected, hiddenBinary1.toHiddenString(),
            "Method toHiddenString does not works." + messageSeed);
        assertNotEquals(expected, hiddenBinary2.toHiddenString(),
            "Method toHiddenString does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testNeg() {
        HiddenBinary expected1 = new HiddenBinary(BinaryUtilities.oneComplement(aBinary1));
        assertEquals(expected1, hiddenBinary1.neg(),
            "Method neg does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testAdd() {
        HiddenBinary expected1 = new HiddenBinary(typeBinary1.add(typeBinary2));
        assertEquals(expected1, hiddenBinary1.add(hiddenBinary2),
            "Method add does not works with binaries." + messageSeed);

        assertEquals(hiddenNull, hiddenBinary1.add(trueHiddenBool),
            "Method add does not works with booleans." + messageSeed);
        assertEquals(hiddenNull, hiddenBinary1.add(falseHiddenBool),
            "Method add does not works with booleans." + messageSeed);

        assertEquals(hiddenNull, hiddenBinary1.add(hiddenFloat1), "Method add does not works with floats." + messageSeed);

        HiddenBinary expected4 = new HiddenBinary(typeBinary1.add(typeInt1));
        assertEquals(expected4, hiddenBinary1.add(hiddenInt1),
            "Method add does not works with int." + messageSeed);

        assertEquals(hiddenNull, hiddenBinary1.add(hiddenString1), "Method add does not works with strings." + messageSeed);
    }

    @RepeatedTest(20)
    void testAnd() {
        HiddenBinary expected1 = new HiddenBinary(typeBinary1.and(typeBinary2));
        assertEquals(expected1, hiddenBinary1.and(hiddenBinary2),
            "Method and does not works with binaries." + messageSeed);

        HiddenBinary expected2 = new HiddenBinary(typeBinary1.and(trueTypeBool));
        assertEquals(expected2, hiddenBinary1.and(trueHiddenBool),
            "Method and does not works with booleans." + messageSeed);
        HiddenBinary expected21 = new HiddenBinary(typeBinary1.and(falseTypeBool));
        assertEquals(expected21, hiddenBinary1.and(falseHiddenBool),
            "Method and does not works with booleans." + messageSeed);

        assertEquals(hiddenNull, hiddenBinary1.and(hiddenFloat1), "Method and does not works with floats." + messageSeed);

        assertEquals(hiddenNull, hiddenBinary1.and(hiddenInt1), "Method and does not works with ints." + messageSeed);

        assertEquals(hiddenNull, hiddenBinary1.and(hiddenString1), "Method and does not works with string." + messageSeed);
    }

    @RepeatedTest(20)
    void testDiv() {
        HiddenBinary expected1 = new HiddenBinary(typeBinary1.div(typeBinary2));
        assertEquals(expected1, hiddenBinary1.div(hiddenBinary2),
            "Method div does not works with binaries." + messageSeed);

        assertEquals(hiddenNull, hiddenBinary1.div(trueHiddenBool),
            "Method div does not works with booleans." + messageSeed);
        assertEquals(hiddenNull, hiddenBinary1.div(falseHiddenBool),
            "Method div does not works with booleans." + messageSeed);

        assertEquals(hiddenNull, hiddenBinary1.div(hiddenFloat1), "Method div does not works with floats." + messageSeed);

        HiddenBinary expected4 = new HiddenBinary(typeBinary1.div(typeInt1));
        assertEquals(expected4, hiddenBinary1.div(hiddenInt1),
            "Method div does not works with int." + messageSeed);

        assertEquals(hiddenNull, hiddenBinary1.div(hiddenString1), "Method div does not works with strings." + messageSeed);
    }

    @RepeatedTest(20)
    void testMult() {
        HiddenBinary expected1 = new HiddenBinary(typeBinary1.mult(typeBinary2));
        assertEquals(expected1, hiddenBinary1.mult(hiddenBinary2),
            "Method mult does not works with binaries." + messageSeed);

        assertEquals(hiddenNull, hiddenBinary1.mult(trueHiddenBool),
            "Method mult does not works with booleans." + messageSeed);
        assertEquals(hiddenNull, hiddenBinary1.mult(falseHiddenBool),
            "Method mult does not works with booleans." + messageSeed);

        assertEquals(hiddenNull, hiddenBinary1.mult(hiddenFloat1), "Method mult does not works with floats." + messageSeed);

        HiddenBinary expected4 = new HiddenBinary(typeBinary1.mult(typeInt1));
        assertEquals(expected4, hiddenBinary1.mult(hiddenInt1),
            "Method mult does not works with int." + messageSeed);

        assertEquals(hiddenNull, hiddenBinary1.mult(hiddenString1),
            "Method mult does not works with strings." + messageSeed);
    }

    @RepeatedTest(20)
    void testOr() {
        HiddenBinary expected1 = new HiddenBinary(typeBinary1.or(typeBinary2));
        assertEquals(expected1, hiddenBinary1.or(hiddenBinary2),
            "Method or does not works with binaries." + messageSeed);

        HiddenBinary expected2 = new HiddenBinary(typeBinary1.or(trueTypeBool));
        assertEquals(expected2, hiddenBinary1.or(trueHiddenBool),
            "Method or does not works with booleans." + messageSeed);
        HiddenBinary expected21 = new HiddenBinary(typeBinary1.or(falseTypeBool));
        assertEquals(expected21, hiddenBinary1.or(falseHiddenBool),
            "Method or does not works with booleans." + messageSeed);

        assertEquals(hiddenNull, hiddenBinary1.or(hiddenFloat1), "Method or does not works with floats." + messageSeed);

        assertEquals(hiddenNull, hiddenBinary1.or(hiddenInt1), "Method or does not works with ints." + messageSeed);

        assertEquals(hiddenNull, hiddenBinary1.or(hiddenString1), "Method or does not works with string." + messageSeed);
    }

    @RepeatedTest(20)
    void testSub() {
        HiddenBinary expected1 = new HiddenBinary(typeBinary1.sub(typeBinary2));
        assertEquals(expected1, hiddenBinary1.sub(hiddenBinary2),
            "Method sub does not works with binaries." + messageSeed);

        assertEquals(hiddenNull, hiddenBinary1.sub(trueHiddenBool),
            "Method sub does not works with booleans." + messageSeed);
        assertEquals(hiddenNull, hiddenBinary1.sub(falseHiddenBool),
            "Method sub does not works with booleans." + messageSeed);

        assertEquals(hiddenNull, hiddenBinary1.sub(hiddenFloat1), "Method sub does not works with floats." + messageSeed);

        HiddenBinary expected4 = new HiddenBinary(typeBinary1.sub(typeInt1));
        assertEquals(expected4, hiddenBinary1.sub(hiddenInt1),
            "Method sub does not works with int." + messageSeed);

        assertEquals(hiddenNull, hiddenBinary1.sub(hiddenString1), "Method sub does not works with strings." + messageSeed);
    }
}