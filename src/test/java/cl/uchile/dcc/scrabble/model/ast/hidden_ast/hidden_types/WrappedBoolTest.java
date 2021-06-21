package cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import cl.uchile.dcc.scrabble.model.types.TypeBinary;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class WrappedBoolTest extends BaseHTypeTest {

    @BeforeEach
    public void setUp() {
        super.setUp();
    }

    @Test
    void testCalculate() {
        assertEquals(trueWBool, trueWBool.calculate(), "Method calculate does not works");
        assertEquals(falseWBool, falseWBool.calculate(), "Method calculate does not works");
    }

    @Test
    void testAsString() {
        assertEquals(trueTypeBool.toString(), trueWBool.asString(0),
            "Method asString does not works.");
        assertEquals(falseTypeBool.toString(), falseWBool.asString(0),
            "Method asString does not works.");
    }

    @Test
    void testTestHashCode() {
        assertEquals(trueTypeBool.hashCode(), trueWBool.hashCode(),
            "Method asString does not works.");
        assertEquals(falseTypeBool.hashCode(), falseWBool.hashCode(),
            "Method asString does not works.");
    }

    @Test
    void testTestEquals() {
        assertEquals(new HiddenBool(true), trueWBool, "Method equals does not works.");
        assertEquals(new HiddenBool(false), falseWBool, "Method equals does not works.");
        assertNotEquals(new HiddenBool(false), trueWBool, "Method equals does not works.");
    }

    @Test
    void testToWrappedBinary() {
        assertNull(trueWBool.toWrappedBinary(), "Method toWrappedBinary does not works.");
    }

    @Test
    void testToWrappedBool() {
        assertEquals(new HiddenBool(true), trueWBool.toWrappedBool(),
            "Method toWrappedBool does not works.");
        assertEquals(new HiddenBool(false), falseWBool.toWrappedBool(),
            "Method toWrappedBool does not works.");
    }

    @Test
    void testToWrappedFloat() {
        assertNull(trueWBool.toWrappedFloat(), "Method toWrappedFloat does not works.");
    }

    @Test
    void testToWrappedInt() {
        assertNull(trueWBool.toWrappedInt(), "Method toWrappedInt does not works.");
    }

    @Test
    void testToWrappedString() {
        HiddenString expected = new HiddenString(trueTypeBool.toTypeString());
        assertEquals(expected, trueWBool.toWrappedString(),
            "Method toWrappedString does not works.");
        HiddenString expected2 = new HiddenString(falseTypeBool.toTypeString());
        assertEquals(expected2, falseWBool.toWrappedString(),
            "Method toWrappedString does not works.");
    }

    @Test
    void testGetAdaptee() {
        assertEquals(trueTypeBool, trueWBool.getAdaptee(), "Method getAdaptee does not works.");
        assertEquals(falseTypeBool, falseWBool.getAdaptee(), "Method getAdaptee does not works.");
    }

    @Test
    void testToString() {
        assertEquals("HiddenBool{value=true}", trueWBool.toString(),
            "Method toString does not works.");
        assertEquals("HiddenBool{value=false}", falseWBool.toString(),
            "Method toString does not works.");
    }

    @Test
    void testAdd() {
        assertNull(trueWBool.add(wBinary1), "Method add does not works");

        assertNull(trueWBool.add(falseWBool), "Method add does not works");

        assertNull(trueWBool.add(wFloat1), "Method add does not works");

        assertNull(trueWBool.add(wInt1), "Method add does not works");

        assertNull(trueWBool.add(wString1), "Method add does not works");
    }

    @RepeatedTest(20)
    void testAnd() {
        HiddenBinary trueWithBinary = new HiddenBinary(
            (TypeBinary) trueTypeBool.and(typeBinary1));
        assertEquals(trueWithBinary, trueWBool.and(wBinary1), "Method and does not works");
        HiddenBinary falseWithBinary = new HiddenBinary(
            (TypeBinary) falseTypeBool.and(typeBinary1));
        assertEquals(falseWithBinary, falseWBool.and(wBinary1), "Method and does not works");

        assertEquals(new HiddenBool(true), trueWBool.and(trueWBool), "Method and does not works");
        assertEquals(new HiddenBool(false), falseWBool.and(trueWBool),
            "Method and does not works");
        assertEquals(new HiddenBool(false), trueWBool.and(falseWBool),
            "Method and does not works");
        assertEquals(new HiddenBool(false), falseWBool.and(falseWBool),
            "Method and does not works");

        assertNull(trueWBool.and(wFloat1), "Method and does not works.");

        assertNull(trueWBool.and(wInt1), "Method and does not works.");

        assertNull(trueWBool.and(wString1), "Method and does not works.");
    }

    @RepeatedTest(20)
    void testOr() {
        HiddenBinary trueWithBinary = new HiddenBinary((TypeBinary) trueTypeBool.or(typeBinary1));
        assertEquals(trueWithBinary, trueWBool.or(wBinary1), "Method or does not works");
        HiddenBinary falseWithBinary = new HiddenBinary(
            (TypeBinary) falseTypeBool.or(typeBinary1));
        assertEquals(falseWithBinary, falseWBool.or(wBinary1), "Method or does not works");

        assertEquals(new HiddenBool(true), trueWBool.or(trueWBool), "Method or does not works");
        assertEquals(new HiddenBool(true), falseWBool.or(trueWBool), "Method or does not works");
        assertEquals(new HiddenBool(true), trueWBool.or(falseWBool), "Method or does not works");
        assertEquals(new HiddenBool(false), falseWBool.or(falseWBool), "Method or does not works");

        assertNull(trueWBool.or(wFloat1), "Method or does not works.");

        assertNull(trueWBool.or(wInt1), "Method or does not works.");

        assertNull(trueWBool.or(wString1), "Method or does not works.");
    }

    @Test
    void testDiv() {
        assertNull(trueWBool.div(wBinary1), "Method div does not works");

        assertNull(trueWBool.div(falseWBool), "Method div does not works");

        assertNull(trueWBool.div(wFloat1), "Method div does not works");

        assertNull(trueWBool.div(wInt1), "Method div does not works");

        assertNull(trueWBool.div(wString1), "Method div does not works");
    }

    @Test
    void testMult() {
        assertNull(trueWBool.mult(wBinary1), "Method mult does not works");

        assertNull(trueWBool.mult(falseWBool), "Method mult does not works");

        assertNull(trueWBool.mult(wFloat1), "Method mult does not works");

        assertNull(trueWBool.mult(wInt1), "Method mult does not works");

        assertNull(trueWBool.mult(wString1), "Method mult does not works");
    }

    @Test
    void testSub() {
        assertNull(trueWBool.sub(wBinary1), "Method sub does not works");

        assertNull(trueWBool.sub(falseWBool), "Method sub does not works");

        assertNull(trueWBool.sub(wFloat1), "Method sub does not works");

        assertNull(trueWBool.sub(wInt1), "Method sub does not works");

        assertNull(trueWBool.sub(wString1), "Method sub does not works");
    }
}