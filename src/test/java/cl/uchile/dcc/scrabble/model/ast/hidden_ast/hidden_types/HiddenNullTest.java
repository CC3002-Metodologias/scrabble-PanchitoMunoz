package cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types;

import static org.junit.jupiter.api.Assertions.*;

import cl.uchile.dcc.scrabble.model.factories.hidden_factories.HiddenFloatFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HiddenNullTest extends BaseHTypeTest {
    private final HiddenNull hiddenNull = HiddenNull.getInstance();

    @BeforeEach
    protected void setUp() {
        super.setUp();
    }

    @Test
    void testCalculate() {
        assertEquals(HiddenNull.getInstance(), hiddenNull.calculate(),
            "Method calculate does not works." + messageSeed);
    }

    @Test
    void testAsString() {
        assertNull(hiddenNull.asString(0), "Method asString does not works." + messageSeed);
    }

    @Test
    void testTestHashCode() {
        assertEquals(0, hiddenNull.hashCode(),
            "Method hashCode does not works." + messageSeed);
    }

    @Test
    void testTestEquals() {
        assertNotEquals(wFloat1, hiddenNull, "Method equals does not works." + messageSeed);
        assertEquals(HiddenNull.getInstance(), hiddenNull,
            "Method equals does not works." + messageSeed);
    }

    @Test
    void testToHiddenBinary() {
        assertNull(hiddenNull.toHiddenBinary(),
            "Method toHiddenBinary does not works." + messageSeed);
    }

    @Test
    void testToHiddenBool() {
        assertNull(hiddenNull.toHiddenBool(),
            "Method toHiddenBool does not works." + messageSeed);
    }

    @Test
    void testToHiddenFloat() {
        assertNull(hiddenNull.toHiddenFloat(),
            "Method toHiddenFloat does not works." + messageSeed);
    }

    @Test
    void testToHiddenInt() {
        assertNull(hiddenNull.toHiddenInt(),
            "Method toHiddenInt does not works." + messageSeed);
    }

    @Test
    void testToHiddenString() {
        assertNull(hiddenNull.toHiddenString(),
            "Method toHiddenString does not works." + messageSeed);
    }

    @Test
    void testAdd() {
        for (HType hType :
            hTypeList) {
            assertNull(hiddenNull.add(hType),
                "Method add does not works." + messageSeed);
        }
    }

    @Test
    void testSub() {
        for (HType hType :
            hTypeList) {
            assertNull(hiddenNull.sub(hType),
                "Method sub does not works." + messageSeed);
        }
    }

    @Test
    void testMult() {
        for (HType hType :
            hTypeList) {
            assertNull(hiddenNull.mult(hType),
                "Method mult does not works." + messageSeed);
        }
    }

    @Test
    void testDiv() {
        for (HType hType :
            hTypeList) {
            assertNull(hiddenNull.div(hType),
                "Method div does not works." + messageSeed);
        }
    }

    @Test
    void testAnd() {
        for (HType hType :
            hTypeList) {
            assertNull(hiddenNull.and(hType),
                "Method and does not works." + messageSeed);
        }
    }

    @Test
    void testOr() {
        for (HType hType :
            hTypeList) {
            assertNull(hiddenNull.or(hType),
                "Method or does not works." + messageSeed);
        }
    }

    @Test
    void testNeg() {
        assertNull(hiddenNull.neg(), "Method neg does not works." + messageSeed);
    }
}