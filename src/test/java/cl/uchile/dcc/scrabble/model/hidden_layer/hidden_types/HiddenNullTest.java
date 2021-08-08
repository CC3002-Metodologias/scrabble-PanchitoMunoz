package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.fail;

import cl.uchile.dcc.scrabble.model.exceptions.ZeroDivisionException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HiddenNullTest extends BaseHTypeTest {

    @BeforeEach
    protected void setUp() {
        super.setUp();
    }

    @Test
    void testCalculate() {
        assertEquals(HiddenNull.getInstance(), hiddenNull.calculate(),
            "Method calculate does not works." + messageSeed);
        assertSame(HiddenNull.getInstance(), hiddenNull,
            "Same instance are not equals.");
    }

    @Test
    void testAsString() {
        assertEquals("null", hiddenNull.asString(0), "Method asString does not works." + messageSeed);
    }

    @Test
    void testHashCode() {
        assertEquals(0, hiddenNull.hashCode(),
            "Method hashCode does not works." + messageSeed);
    }

    @Test
    void testEquals() {
        assertNotEquals(hiddenFloat1, hiddenNull, "Method equals does not works." + messageSeed);
        assertEquals(HiddenNull.getInstance(), hiddenNull,
            "Method equals does not works." + messageSeed);
    }

    @Test
    void testToHiddenBinary() {
        assertEquals(hiddenNull, hiddenNull.toHiddenBinary(),
            "Method toHiddenBinary does not works." + messageSeed);
    }

    @Test
    void testToHiddenBool() {
        assertEquals(hiddenNull, hiddenNull.toHiddenBool(),
            "Method toHiddenBool does not works." + messageSeed);
    }

    @Test
    void testToHiddenFloat() {
        assertEquals(hiddenNull, hiddenNull.toHiddenFloat(),
            "Method toHiddenFloat does not works." + messageSeed);
    }

    @Test
    void testToHiddenInt() {
        assertEquals(hiddenNull, hiddenNull.toHiddenInt(),
            "Method toHiddenInt does not works." + messageSeed);
    }

    @Test
    void testToHiddenString() {
        assertEquals(hiddenNull, hiddenNull.toHiddenString(),
            "Method toHiddenString does not works." + messageSeed);
    }

    @Test
    void testAdd() {
        for (HType hType :
            hTypeList2) {
            assertEquals(hiddenNull, hiddenNull.add(hType),
                "Method add does not works." + messageSeed);
        }
    }

    @Test
    void testSub() {
        for (HType hType :
            hTypeList2) {
            assertEquals(hiddenNull, hiddenNull.sub(hType),
                "Method sub does not works." + messageSeed);
        }
    }

    @Test
    void testMult() {
        for (HType hType :
            hTypeList2) {
            assertEquals(hiddenNull, hiddenNull.mult(hType),
                "Method mult does not works." + messageSeed);
        }
    }

    @Test
    void testDiv() {
        try {
            for (HType hType :
                hTypeList2) {
                assertEquals(hiddenNull, hiddenNull.div(hType),
                    "Method div does not works." + messageSeed);
            }
        } catch (ZeroDivisionException e) {
            fail("Exception fails.");
        }
    }

    @Test
    void testAnd() {
        for (HType hType :
            hTypeList2) {
            assertEquals(hiddenNull, hiddenNull.and(hType),
                "Method and does not works." + messageSeed);
        }
    }

    @Test
    void testOr() {
        for (HType hType :
            hTypeList2) {
            assertEquals(hiddenNull, hiddenNull.or(hType),
                "Method or does not works." + messageSeed);
        }
    }

    @Test
    void testNeg() {
        assertEquals(hiddenNull, hiddenNull.neg(), "Method neg does not works." + messageSeed);
    }

    @Test
    void testToString() {
        assertEquals("HiddenNull{}", hiddenNull.toString(),
            "Method toString does not works." + messageSeed);
    }

    @Test
    void testToSType() {
        assertNull(hiddenNull.asSType(),
            "Method toSType does not works." + messageSeed);
    }
}