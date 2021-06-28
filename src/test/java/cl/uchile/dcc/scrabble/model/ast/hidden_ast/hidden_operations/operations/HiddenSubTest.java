package cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_operations.operations;

import static org.junit.jupiter.api.Assertions.*;

import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class HiddenSubTest extends BaseHiddenOperationTest {

    @BeforeEach
    protected void setUp() {
        super.setUp();
    }

    @RepeatedTest(20)
    void testToString() {
        String templateString = (
            "Sub(\n"
                + "  %s -\n"
                + "  %s\n"
                + ")"
        );
        for (HType hType1 : hTypeList2) {
            for (HType hType2 : hTypeList2) {
                String expected = String.format(templateString,
                    hType1.asString(0), hType2.asString(0));
                assertEquals(expected, new HiddenSub(hType1, hType2).toString(),
                    "Method toString does not works." + messageSeed);
            }
        }
    }

    @RepeatedTest(20)
    void testCalculate() {
        // Sub with String
        for (HType hType : hTypeList2) {
            HType expected1 = hiddenString1.sub(hType);
            assertEquals(expected1, new HiddenSub(hiddenString1, hType).calculate(),
                "Method sub does not works with string type." + messageSeed);
        }
        // Sub with bool
        for (HType hType : hTypeList2) {
            assertEquals(hiddenNull, new HiddenSub(trueHiddenBool, hType).calculate(),
                "Method sub does not works with bool type." + messageSeed);
            assertEquals(hiddenNull, new HiddenSub(falseHiddenBool, hType).calculate(),
                "Method sub does not works with bool type." + messageSeed);
        }
        // Sub with float
        for (HType hType : hNumberList) {
            HType expected1 = hiddenFloat1.sub(hType);
            assertEquals(expected1, new HiddenSub(hiddenFloat1, hType).calculate(),
                "Method sub does not works with float type." + messageSeed);
        }
        for (HType hType : hNumberCList) {
            assertEquals(hiddenNull, new HiddenSub(hiddenFloat1, hType).calculate(),
                "Method sub does not works with float type." + messageSeed);
        }
        // Sub with int
        for (HType hType : hNumberList) {
            HType expected1 = hiddenInt1.sub(hType);
            assertEquals(expected1, new HiddenSub(hiddenInt1, hType).calculate(),
                "Method sub does not works with int type." + messageSeed);
        }
        for (HType hType : hNumberCList) {
            assertEquals(hiddenNull, new HiddenSub(hiddenInt1, hType).calculate(),
                "Method sub does not works with int type." + messageSeed);
        }
        // Sub with binary
        for (HType hType : hIntegerList) {
            HType expected1 = hiddenBinary1.sub(hType);
            assertEquals(expected1, new HiddenSub(hiddenBinary1, hType).calculate(),
                "Method sub does not works with binary type." + messageSeed);
        }
        for (HType hType : hIntegerCList) {
            assertEquals(hiddenNull, new HiddenSub(hiddenBinary1, hType).calculate(),
                "Method sub does not works with binary type." + messageSeed);
        }
    }

    @RepeatedTest(20)
    void testEquals() {
        HiddenSub hiddenSub = new HiddenSub(hiddenInt1, hiddenFloat2);
        HiddenSub equalsHiddenSub = new HiddenSub(hiddenInt1, hiddenFloat2);
        HiddenSub differentHiddenSub = new HiddenSub(hiddenInt2, hiddenBinary1);
        HiddenMult otherNode = new HiddenMult(hiddenFloat1, hiddenFloat2);
        assertEquals(hiddenSub, hiddenSub,
            "Method equals does not works." + messageSeed);
        assertEquals(equalsHiddenSub, hiddenSub,
            "Method equals does not works." + messageSeed);
        assertNotEquals(differentHiddenSub, hiddenSub,
            "Method equals does not works." + messageSeed);
        assertNotEquals(otherNode, hiddenSub,
            "Method equals does not works." + messageSeed);
        assertNotEquals(hiddenSub, hiddenInt1,
            "Method equals does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testTestHashCode() {
        HiddenSub hiddenSub = new HiddenSub(hiddenInt1, hiddenFloat2);
        HiddenSub equalsHiddenSub = new HiddenSub(hiddenInt1, hiddenFloat2);
        HiddenSub differentHiddenSub = new HiddenSub(hiddenInt2, hiddenBinary1);
        HiddenMult otherNode = new HiddenMult(hiddenFloat1, hiddenFloat2);
        assertEquals(equalsHiddenSub.hashCode(), hiddenSub.hashCode(),
            "Method hashCode does not works with similar instances." + messageSeed);
        assertNotEquals(differentHiddenSub.hashCode(), hiddenSub.hashCode(),
            "Method hashCode does not works with different instances." + messageSeed);
        assertNotEquals(otherNode.hashCode(), hiddenSub.hashCode(),
            "Method hashCode does not works with different hidden ast." + messageSeed);
        assertNotEquals(hiddenInt1.hashCode(), hiddenSub.hashCode(),
            "Method hashCode does not works with other types." + messageSeed);
    }
}