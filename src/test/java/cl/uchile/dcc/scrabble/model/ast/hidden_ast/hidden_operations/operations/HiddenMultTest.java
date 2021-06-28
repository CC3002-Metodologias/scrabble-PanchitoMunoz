package cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_operations.operations;

import static org.junit.jupiter.api.Assertions.*;

import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class HiddenMultTest extends BaseHiddenOperationTest {

    @BeforeEach
    protected void setUp() {
        super.setUp();
    }

    @RepeatedTest(20)
    void testTestToString() {
        String templateString = (
            "Mult(\n"
                + "  %s *\n"
                + "  %s\n"
                + ")"
        );
        for (HType hType1 : hTypeList2) {
            for (HType hType2 : hTypeList2) {
                String expected = String.format(templateString,
                    hType1.asString(0), hType2.asString(0));
                assertEquals(expected, new HiddenMult(hType1, hType2).toString(),
                    "Method toString does not works." + messageSeed);
            }
        }
    }

    @RepeatedTest(20)
    void testCalculate() {
        // Mult with String
        for (HType hType : hTypeList2) {
            HType expected1 = hiddenString1.mult(hType);
            assertEquals(expected1, new HiddenMult(hiddenString1, hType).calculate(),
                "Method mult does not works with string type." + messageSeed);
        }
        // Mult with bool
        for (HType hType : hTypeList2) {
            assertEquals(hiddenNull, new HiddenMult(trueHiddenBool, hType).calculate(),
                "Method mult does not works with bool type." + messageSeed);
            assertEquals(hiddenNull, new HiddenMult(falseHiddenBool, hType).calculate(),
                "Method mult does not works with bool type." + messageSeed);
        }
        // Mult with float
        for (HType hType : hNumberList) {
            HType expected1 = hiddenFloat1.mult(hType);
            assertEquals(expected1, new HiddenMult(hiddenFloat1, hType).calculate(),
                "Method mult does not works with float type." + messageSeed);
        }
        for (HType hType : hNumberCList) {
            assertEquals(hiddenNull, new HiddenMult(hiddenFloat1, hType).calculate(),
                "Method mult does not works with float type." + messageSeed);
        }
        // Mult with int
        for (HType hType : hNumberList) {
            HType expected1 = hiddenInt1.mult(hType);
            assertEquals(expected1, new HiddenMult(hiddenInt1, hType).calculate(),
                "Method mult does not works with int type." + messageSeed);
        }
        for (HType hType : hNumberCList) {
            assertEquals(hiddenNull, new HiddenMult(hiddenInt1, hType).calculate(),
                "Method mult does not works with int type." + messageSeed);
        }
        // Mult with binary
        for (HType hType : hIntegerList) {
            HType expected1 = hiddenBinary1.mult(hType);
            assertEquals(expected1, new HiddenMult(hiddenBinary1, hType).calculate(),
                "Method mult does not works with binary type." + messageSeed);
        }
        for (HType hType : hIntegerCList) {
            assertEquals(hiddenNull, new HiddenMult(hiddenBinary1, hType).calculate(),
                "Method mult does not works with binary type." + messageSeed);
        }
    }

    @RepeatedTest(20)
    void testEquals() {
        HiddenMult hiddenMult = new HiddenMult(hiddenInt1, hiddenFloat2);
        HiddenMult equalsHiddenMult = new HiddenMult(hiddenInt1, hiddenFloat2);
        HiddenMult differentHiddenMult = new HiddenMult(hiddenInt2, hiddenBinary1);
        HiddenAdd otherNode = new HiddenAdd(hiddenFloat1, hiddenFloat2);
        assertEquals(hiddenMult, hiddenMult,
            "Method equals does not works." + messageSeed);
        assertEquals(equalsHiddenMult, hiddenMult,
            "Method equals does not works." + messageSeed);
        assertNotEquals(differentHiddenMult, hiddenMult,
            "Method equals does not works." + messageSeed);
        assertNotEquals(otherNode, hiddenMult,
            "Method equals does not works." + messageSeed);
        assertNotEquals(hiddenMult, hiddenInt1,
            "Method equals does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testTestHashCode() {
        HiddenMult hiddenMult = new HiddenMult(hiddenInt1, hiddenFloat2);
        HiddenMult equalsHiddenMult = new HiddenMult(hiddenInt1, hiddenFloat2);
        HiddenMult differentHiddenMult = new HiddenMult(hiddenInt2, hiddenBinary1);
        HiddenAdd otherNode = new HiddenAdd(hiddenFloat1, hiddenFloat2);
        assertEquals(equalsHiddenMult.hashCode(), hiddenMult.hashCode(),
            "Method hashCode does not works." + messageSeed);
        assertNotEquals(differentHiddenMult.hashCode(), hiddenMult.hashCode(),
            "Method hashCode does not works." + messageSeed);
        assertNotEquals(otherNode.hashCode(), hiddenMult.hashCode(),
            "Method hashCode does not works." + messageSeed);
        assertNotEquals(hiddenInt1.hashCode(), hiddenMult.hashCode(),
            "Method hashCode does not works." + messageSeed);
    }
}