package cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import cl.uchile.dcc.scrabble.model.types.TypeBinary;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class HiddenBoolTest extends BaseHTypeTest {

    @BeforeEach
    public void setUp() {
        super.setUp();
    }

    @Test
    void testCalculate() {
        assertEquals(trueHiddenBool, trueHiddenBool.calculate(), "Method calculate does not works");
        assertEquals(falseHiddenBool, falseHiddenBool.calculate(), "Method calculate does not works");
    }

    @Test
    void testAsString() {
        assertEquals(trueTypeBool.toString(), trueHiddenBool.asString(0),
            "Method asString does not works.");
        assertEquals(falseTypeBool.toString(), falseHiddenBool.asString(0),
            "Method asString does not works.");
    }

    @Test
    void testTestHashCode() {
        assertEquals(trueTypeBool.hashCode(), trueHiddenBool.hashCode(),
            "Method asString does not works.");
        assertEquals(falseTypeBool.hashCode(), falseHiddenBool.hashCode(),
            "Method asString does not works.");
    }

    @Test
    void testTestEquals() {
        assertEquals(new HiddenBool(true), trueHiddenBool, "Method equals does not works.");
        assertEquals(new HiddenBool(false), falseHiddenBool, "Method equals does not works.");
        assertNotEquals(new HiddenBool(false), trueHiddenBool, "Method equals does not works.");
        assertNotEquals(trueHiddenBool, trueTypeBool, "Method equals does not works.");
    }

    @Test
    void testToHiddenBinary() {
        assertEquals(hiddenNull, trueHiddenBool.toHiddenBinary(), "Method toHiddenBinary does not works.");
    }

    @Test
    void testToHiddenBool() {
        assertEquals(new HiddenBool(true), trueHiddenBool.toHiddenBool(),
            "Method toHiddenBool does not works.");
        assertEquals(new HiddenBool(false), falseHiddenBool.toHiddenBool(),
            "Method toHiddenBool does not works.");
    }

    @Test
    void testToHiddenFloat() {
        assertEquals(hiddenNull, trueHiddenBool.toHiddenFloat(), "Method toHiddenFloat does not works.");
    }

    @Test
    void testToHiddenInt() {
        assertEquals(hiddenNull, trueHiddenBool.toHiddenInt(), "Method toHiddenInt does not works.");
    }

    @Test
    void testToHiddenString() {
        HiddenString expected = new HiddenString(trueTypeBool.toTypeString());
        assertEquals(expected, trueHiddenBool.toHiddenString(),
            "Method toHiddenString does not works.");
        HiddenString expected2 = new HiddenString(falseTypeBool.toTypeString());
        assertEquals(expected2, falseHiddenBool.toHiddenString(),
            "Method toHiddenString does not works.");
    }

    @Test
    void testGetAdaptee() {
        assertEquals(trueTypeBool, trueHiddenBool.toSType(), "Method getAdaptee does not works.");
        assertEquals(falseTypeBool, falseHiddenBool.toSType(), "Method getAdaptee does not works.");
    }

    @Test
    void testToString() {
        assertEquals("HiddenBool{value=true}", trueHiddenBool.toString(),
            "Method toString does not works.");
        assertEquals("HiddenBool{value=false}", falseHiddenBool.toString(),
            "Method toString does not works.");
    }

    @Test
    void testNeg() {
        assertEquals(new HiddenBool(true), falseHiddenBool.neg(),
            "Method neg does not works." + messageSeed);
        assertEquals(new HiddenBool(false), trueHiddenBool.neg(),
            "Method neg does not works." + messageSeed);
    }

    @Test
    void testAdd() {
        assertEquals(hiddenNull, trueHiddenBool.add(hiddenBinary1), "Method add does not works");

        assertEquals(hiddenNull, trueHiddenBool.add(falseHiddenBool), "Method add does not works");

        assertEquals(hiddenNull, trueHiddenBool.add(hiddenFloat1), "Method add does not works");

        assertEquals(hiddenNull, trueHiddenBool.add(hiddenInt1), "Method add does not works");

        assertEquals(hiddenNull, trueHiddenBool.add(hiddenString1), "Method add does not works");
    }

    @RepeatedTest(20)
    void testAnd() {
        HiddenBinary trueWithBinary = new HiddenBinary(
            (TypeBinary) trueTypeBool.and(typeBinary1));
        assertEquals(trueWithBinary, trueHiddenBool.and(hiddenBinary1), "Method and does not works");
        HiddenBinary falseWithBinary = new HiddenBinary(
            (TypeBinary) falseTypeBool.and(typeBinary1));
        assertEquals(falseWithBinary, falseHiddenBool.and(hiddenBinary1), "Method and does not works");

        assertEquals(new HiddenBool(true), trueHiddenBool.and(trueHiddenBool), "Method and does not works");
        assertEquals(new HiddenBool(false), falseHiddenBool.and(trueHiddenBool),
            "Method and does not works");
        assertEquals(new HiddenBool(false), trueHiddenBool.and(falseHiddenBool),
            "Method and does not works");
        assertEquals(new HiddenBool(false), falseHiddenBool.and(falseHiddenBool),
            "Method and does not works");

        assertEquals(hiddenNull, trueHiddenBool.and(hiddenFloat1), "Method and does not works.");

        assertEquals(hiddenNull, trueHiddenBool.and(hiddenInt1), "Method and does not works.");

        assertEquals(hiddenNull, trueHiddenBool.and(hiddenString1), "Method and does not works.");
    }

    @RepeatedTest(20)
    void testOr() {
        HiddenBinary trueWithBinary = new HiddenBinary((TypeBinary) trueTypeBool.or(typeBinary1));
        assertEquals(trueWithBinary, trueHiddenBool.or(hiddenBinary1), "Method or does not works");
        HiddenBinary falseWithBinary = new HiddenBinary(
            (TypeBinary) falseTypeBool.or(typeBinary1));
        assertEquals(falseWithBinary, falseHiddenBool.or(hiddenBinary1), "Method or does not works");

        assertEquals(new HiddenBool(true), trueHiddenBool.or(trueHiddenBool), "Method or does not works");
        assertEquals(new HiddenBool(true), falseHiddenBool.or(trueHiddenBool), "Method or does not works");
        assertEquals(new HiddenBool(true), trueHiddenBool.or(falseHiddenBool), "Method or does not works");
        assertEquals(new HiddenBool(false), falseHiddenBool.or(falseHiddenBool), "Method or does not works");

        assertEquals(hiddenNull, trueHiddenBool.or(hiddenFloat1), "Method or does not works.");

        assertEquals(hiddenNull, trueHiddenBool.or(hiddenInt1), "Method or does not works.");

        assertEquals(hiddenNull, trueHiddenBool.or(hiddenString1), "Method or does not works.");
    }

    @Test
    void testDiv() {
        assertEquals(hiddenNull, trueHiddenBool.div(hiddenBinary1), "Method div does not works");

        assertEquals(hiddenNull, trueHiddenBool.div(falseHiddenBool), "Method div does not works");

        assertEquals(hiddenNull, trueHiddenBool.div(hiddenFloat1), "Method div does not works");

        assertEquals(hiddenNull, trueHiddenBool.div(hiddenInt1), "Method div does not works");

        assertEquals(hiddenNull, trueHiddenBool.div(hiddenString1), "Method div does not works");
    }

    @Test
    void testMult() {
        assertEquals(hiddenNull, trueHiddenBool.mult(hiddenBinary1), "Method mult does not works");

        assertEquals(hiddenNull, trueHiddenBool.mult(falseHiddenBool), "Method mult does not works");

        assertEquals(hiddenNull, trueHiddenBool.mult(hiddenFloat1), "Method mult does not works");

        assertEquals(hiddenNull, trueHiddenBool.mult(hiddenInt1), "Method mult does not works");

        assertEquals(hiddenNull, trueHiddenBool.mult(hiddenString1), "Method mult does not works");
    }

    @Test
    void testSub() {
        assertEquals(hiddenNull, trueHiddenBool.sub(hiddenBinary1), "Method sub does not works");

        assertEquals(hiddenNull, trueHiddenBool.sub(falseHiddenBool), "Method sub does not works");

        assertEquals(hiddenNull, trueHiddenBool.sub(hiddenFloat1), "Method sub does not works");

        assertEquals(hiddenNull, trueHiddenBool.sub(hiddenInt1), "Method sub does not works");

        assertEquals(hiddenNull, trueHiddenBool.sub(hiddenString1), "Method sub does not works");
    }
}