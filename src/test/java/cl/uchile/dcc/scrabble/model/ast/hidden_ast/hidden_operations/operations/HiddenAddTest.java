package cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_operations.operations;

import static org.junit.jupiter.api.Assertions.*;

import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class HiddenAddTest extends BaseHiddenOperationTest {

    @BeforeEach
    protected void setUp() {
        super.setUp();
    }

    @RepeatedTest(20)
    void testToString() {
        String templateString = (
            "Add(\n"
            + "  %s +\n"
            + "  %s\n"
            + ")"
        );
        for (HType hType1 : hTypeList2) {
            for (HType hType2 : hTypeList2) {
                String expected = String.format(templateString,
                    hType1.asString(0), hType2.asString(0));
                assertEquals(expected, new HiddenAdd(hType1, hType2).toString(),
                    "Method toString does not works." + messageSeed);
            }
        }
    }

    @RepeatedTest(20)
    void testCalculate() {
        // Add with String
        for (HType hType : hTypeList2) {
            HType expected1 = hiddenString1.add(hType);
            assertEquals(expected1, new HiddenAdd(hiddenString1, hType).calculate(),
                "Method add does not works with string type." + messageSeed);
        }
        // Add with bool
        for (HType hType : hTypeList2) {
            assertNull(new HiddenAdd(trueHiddenBool, hType).calculate(),
                "Method add does not works with bool type." + messageSeed);
            assertNull(new HiddenAdd(falseHiddenBool, hType).calculate(),
                "Method add does not works with bool type." + messageSeed);
        }
        // Add with float
        for (HType hType : hNumberList) {
            HType expected1 = hiddenFloat1.add(hType);
            assertEquals(expected1, new HiddenAdd(hiddenFloat1, hType).calculate(),
                "Method add does not works with float type." + messageSeed);
        }
        for (HType hType : hNumberCList) {
            assertNull(new HiddenAdd(hiddenFloat1, hType).calculate(),
                "Method add does not works with float type." + messageSeed);
        }
        // Add with int
        for (HType hType : hNumberList) {
            HType expected1 = hiddenInt1.add(hType);
            assertEquals(expected1, new HiddenAdd(hiddenInt1, hType).calculate(),
                "Method add does not works with int type." + messageSeed);
        }
        for (HType hType : hNumberCList) {
            assertNull(new HiddenAdd(hiddenInt1, hType).calculate(),
                "Method add does not works with int type." + messageSeed);
        }
        // Add with binary
        for (HType hType : hIntegerList) {
            HType expected1 = hiddenBinary1.add(hType);
            assertEquals(expected1, new HiddenAdd(hiddenBinary1, hType).calculate(),
                "Method add does not works with binary type." + messageSeed);
        }
        for (HType hType : hIntegerCList) {
            assertNull(new HiddenAdd(hiddenBinary1, hType).calculate(),
                "Method add does not works with binary type." + messageSeed);
        }
    }
}