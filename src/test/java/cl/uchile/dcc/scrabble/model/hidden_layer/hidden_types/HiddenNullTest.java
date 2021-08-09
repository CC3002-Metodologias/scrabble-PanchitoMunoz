package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.fail;

import cl.uchile.dcc.scrabble.model.exceptions.ZeroDivisionException;
import cl.uchile.dcc.scrabble.model.factories.hidden_factories.HTypeFactory;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_visitors.HiddenSetterVisitor;
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

    @Test
    void testGetInstance() {
        assertSame(HiddenNull.getInstance(), hiddenNull,
            "Method getInstance does not works.");
    }

    @Test
    void testGetValue() {
        assertNull(hiddenNull.getValue(),
            "Method getValue does not works.");
    }

    @Test
    void testAsSType() {
        assertNull(hiddenNull.asSType(),
            "Method asSType does not works.");
    }

    @Test
    void testSTypeAsString() {
        assertNull(hiddenNull.sTypeAsString(),
            "Method sTypeAsString does not works.");
    }

    @Test
    void testAccept() {
        HiddenSetterVisitor visitor = new HiddenSetterVisitor("x", new HiddenInt(10));
        hiddenNull.accept(visitor);
        assertSame(hiddenNull, HTypeFactory.createHiddenNull());
    }

    @Test
    void testAsCode() {
        assertEquals("null", hiddenNull.asCode(),
            "Method asCode does not works.");
    }

    @Test
    void testGetValueAsBinary() {
        assertNull(hiddenNull.getValueAsBinary());
    }

    @Test
    void testGetValueAsInt() {
        assertEquals(0, hiddenNull.getValueAsInt());
    }

    @Test
    void testAsSNumber() {
        assertNull(hiddenNull.asSNumber());
    }

    @Test
    void testGetValueAsDouble() {
        assertEquals(0, hiddenNull.getValueAsDouble());
    }

    @Test
    void testGetValueAsBool() {
        assertNull(hiddenNull.getValueAsBool());
    }

    @Test
    void testGetValueAsString() {
        assertNull(hiddenNull.getValueAsString());
    }

    @Test
    void testAsTypeBinary() {
        assertNull(hiddenNull.asTypeBinary());
    }

    @Test
    void testAsSLogical() {
        assertNull(hiddenNull.asSLogical());
    }

    @Test
    void testAsTypeBool() {
        assertNull(hiddenNull.asTypeBool());
    }

    @Test
    void testAsTypeFloat() {
        assertNull(hiddenNull.asTypeFloat());
    }

    @Test
    void testAsTypeInt() {
        assertNull(hiddenNull.asTypeInt());
    }

    @Test
    void testAsTypeString() {
        assertNull(hiddenNull.asTypeString());
    }

    @Test
    void testCompareTo() {
        assertEquals(0, hiddenNull.compareTo(hiddenFloat1));
    }

    @Test
    void testCopy() {
        assertSame(hiddenNull, hiddenNull.copy());
    }

    @Test
    void testComparable() {
        assertEquals(hiddenNull, hiddenNull.equalsTo(hiddenNull));
        assertEquals(hiddenNull, hiddenNull.greaterEquals(hiddenNull));
        assertEquals(hiddenNull, hiddenNull.greaterThan(hiddenNull));
        assertEquals(hiddenNull, hiddenNull.lowerEquals(hiddenNull));
        assertEquals(hiddenNull, hiddenNull.lowerThan(hiddenNull));
    }
}