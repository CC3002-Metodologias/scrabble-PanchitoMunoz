package cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_operations.operations;

import static org.junit.jupiter.api.Assertions.*;

import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HiddenMultTest extends BaseHiddenOperationTest {

    @BeforeEach
    protected void setUp() {
        super.setUp();
    }

    @Test
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

    @Test
    void testCalculate() {
        // Mult with String
        for (HType hType : hTypeList2) {
            HType expected1 = hiddenString1.mult(hType);
            assertEquals(expected1, new HiddenMult(hiddenString1, hType).calculate(),
                "Method mult does not works with string type." + messageSeed);
        }
        // Mult with bool
        for (HType hType : hTypeList2) {
            assertNull(new HiddenMult(trueHiddenBool, hType).calculate(),
                "Method mult does not works with bool type." + messageSeed);
            assertNull(new HiddenMult(falseHiddenBool, hType).calculate(),
                "Method mult does not works with bool type." + messageSeed);
        }
        // Mult with float
        for (HType hType : hNumberList) {
            HType expected1 = hiddenFloat1.mult(hType);
            assertEquals(expected1, new HiddenMult(hiddenFloat1, hType).calculate(),
                "Method mult does not works with float type." + messageSeed);
        }
        for (HType hType : hNumberCList) {
            assertNull(new HiddenMult(hiddenFloat1, hType).calculate(),
                "Method mult does not works with float type." + messageSeed);
        }
        // Mult with int
        for (HType hType : hNumberList) {
            HType expected1 = hiddenInt1.mult(hType);
            assertEquals(expected1, new HiddenMult(hiddenInt1, hType).calculate(),
                "Method mult does not works with int type." + messageSeed);
        }
        for (HType hType : hNumberCList) {
            assertNull(new HiddenMult(hiddenInt1, hType).calculate(),
                "Method mult does not works with int type." + messageSeed);
        }
        // Mult with binary
        for (HType hType : hIntegerList) {
            HType expected1 = hiddenBinary1.mult(hType);
            assertEquals(expected1, new HiddenMult(hiddenBinary1, hType).calculate(),
                "Method mult does not works with binary type." + messageSeed);
        }
        for (HType hType : hIntegerCList) {
            assertNull(new HiddenMult(hiddenBinary1, hType).calculate(),
                "Method mult does not works with binary type." + messageSeed);
        }
    }
}