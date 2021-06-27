package cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_operations.operations;

import static org.junit.jupiter.api.Assertions.*;

import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HiddenOrTest extends BaseHiddenOperationTest {

    @BeforeEach
    protected void setUp() {
        super.setUp();
    }

    @Test
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

    @Test
    void testCalculate() {
        // Or with String
        for (HType hType : hTypeList2) {
            assertNull(new HiddenOr(hiddenString1, hType).calculate(),
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
            assertNull(new HiddenOr(trueHiddenBool, hType).calculate(),
                "Method or does not works with bool type." + messageSeed);
            assertNull(new HiddenOr(falseHiddenBool, hType).calculate(),
                "Method or does not works with bool type." + messageSeed);
        }
        // Or with float
        for (HType hType : hTypeList2) {
            assertNull(new HiddenOr(hiddenFloat1, hType).calculate(),
                "Method or does not works with float type." + messageSeed);
        }
        // Or with int
        for (HType hType : hTypeList2) {
            assertNull(new HiddenOr(hiddenInt1, hType).calculate(),
                "Method or does not works with int type." + messageSeed);
        }
        // Or with binary
        for (HType hType : hLogicalList) {
            HType expected = hiddenBinary1.or(hType);
            assertEquals(expected, new HiddenOr(hiddenBinary1, hType).calculate(),
                "Method or does not works with binary type." + messageSeed);
        }
        for (HType hType : hLogicalCList) {
            assertNull(new HiddenOr(hiddenBinary1, hType).calculate(),
                "Method or does not works with binary type." + messageSeed);
        }
    }
}