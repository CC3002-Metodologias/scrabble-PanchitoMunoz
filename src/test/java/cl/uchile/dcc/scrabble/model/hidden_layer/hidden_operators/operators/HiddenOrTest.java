package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.operators;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

class HiddenOrTest extends BaseHiddenOperationTest {

    @BeforeEach
    protected void setUp() {
        super.setUp();
    }

    @RepeatedTest(20)
    void testTestToString() {
        String templateString = (
            "Or(\n"
                + "  %s or\n"
                + "  %s\n"
                + ")"
        );
        for (HType hType1 : hTypeList2) {
            for (HType hType2 : hTypeList2) {
                String expected = String.format(templateString,
                    hType1.asString(0), hType2.asString(0));
                assertEquals(expected, new HiddenOr(hType1, hType2).toString(),
                    "Method toString does not works." + messageSeed);
            }
        }
    }

    @RepeatedTest(20)
    void testCalculate() {
        // Or with String
        for (HType hType : hTypeList2) {
            assertEquals(hiddenNull, new HiddenOr(hiddenString1, hType).calculate(),
                "Method or does not works with string type." + messageSeed);
        }
        // Or with bool
        for (HType hType : hLogicalList) {
            HType expected1 = trueHiddenBool.or(hType);
            HType expected2 = falseHiddenBool.or(hType);
            assertEquals(expected1, new HiddenOr(trueHiddenBool, hType).calculate(),
                "Method or does not works with bool type." + messageSeed);
            assertEquals(expected2, new HiddenOr(falseHiddenBool, hType).calculate(),
                "Method or does not works with bool type." + messageSeed);
        }
        for (HType hType : hLogicalCList) {
            assertEquals(hiddenNull, new HiddenOr(trueHiddenBool, hType).calculate(),
                "Method or does not works with bool type." + messageSeed);
            assertEquals(hiddenNull, new HiddenOr(falseHiddenBool, hType).calculate(),
                "Method or does not works with bool type." + messageSeed);
        }
        // Or with float
        for (HType hType : hTypeList2) {
            assertEquals(hiddenNull, new HiddenOr(hiddenFloat1, hType).calculate(),
                "Method or does not works with float type." + messageSeed);
        }
        // Or with int
        for (HType hType : hTypeList2) {
            assertEquals(hiddenNull, new HiddenOr(hiddenInt1, hType).calculate(),
                "Method or does not works with int type." + messageSeed);
        }
        // Or with binary
        for (HType hType : hLogicalList) {
            HType expected = hiddenBinary1.or(hType);
            assertEquals(expected, new HiddenOr(hiddenBinary1, hType).calculate(),
                "Method or does not works with binary type." + messageSeed);
        }
        for (HType hType : hLogicalCList) {
            assertEquals(hiddenNull, new HiddenOr(hiddenBinary1, hType).calculate(),
                "Method or does not works with binary type." + messageSeed);
        }
    }

    @RepeatedTest(20)
    void testTestEquals() {
        HiddenOr hiddenOr = new HiddenOr(hiddenBinary1, trueHiddenBool);
        HiddenOr equalsHiddenOr = new HiddenOr(hiddenBinary1, trueHiddenBool);
        HiddenOr differentHiddenOr = new HiddenOr(hiddenBinary1, falseHiddenBool);
        HiddenSub otherNode = new HiddenSub(hiddenFloat1, hiddenFloat2);
        assertEquals(hiddenOr, hiddenOr,
            "Method equals does not works." + messageSeed);
        assertEquals(equalsHiddenOr, hiddenOr,
            "Method equals does not works." + messageSeed);
        assertNotEquals(differentHiddenOr, hiddenOr,
            "Method equals does not works." + messageSeed);
        assertNotEquals(otherNode, hiddenOr,
            "Method equals does not works." + messageSeed);
        assertNotEquals(hiddenOr, hiddenBinary1,
            "Method equals does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testTestHashCode() {
        HiddenOr hiddenOr = new HiddenOr(hiddenBinary1, trueHiddenBool);
        HiddenOr equalsHiddenOr = new HiddenOr(hiddenBinary1, trueHiddenBool);
        HiddenOr differentHiddenOr = new HiddenOr(hiddenBinary1, falseHiddenBool);
        HiddenSub otherNode = new HiddenSub(hiddenFloat1, hiddenFloat2);
        assertEquals(equalsHiddenOr.hashCode(), hiddenOr.hashCode(),
            "Method hashCode does not works." + messageSeed);
        assertNotEquals(differentHiddenOr.hashCode(), hiddenOr.hashCode(),
            "Method hashCode does not works." + messageSeed);
        assertNotEquals(otherNode.hashCode(), hiddenOr.hashCode(),
            "Method hashCode does not works." + messageSeed);
        assertNotEquals(hiddenString1.hashCode(), hiddenOr.hashCode(),
            "Method hashCode does not works." + messageSeed);
    }
}