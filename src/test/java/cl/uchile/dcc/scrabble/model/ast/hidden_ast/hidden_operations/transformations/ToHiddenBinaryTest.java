package cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_operations.transformations;

import static org.junit.jupiter.api.Assertions.*;

import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_operations.operations.BaseHiddenOperationTest;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_operations.operations.HiddenAdd;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HType;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HiddenBinary;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class ToHiddenBinaryTest extends BaseHiddenOperationTest {

    @BeforeEach
    protected void setUp() {
        super.setUp();
    }

    @RepeatedTest(20)
    void testToString() {
        String templateString = "%s.toTypeBinary()";
        for (HType hType1 : hTypeList2) {
            String expected = String.format(templateString, hType1.asString(0));
            assertEquals(expected, new ToHiddenBinary(hType1).toString(),
                "Method toString does not works." + messageSeed);
        }
    }

    @RepeatedTest(20)
    void testCalculate() {
        // String
        assertNull(new ToHiddenBinary(hiddenString1).calculate(),
            "Method calculate does not works with string type." + messageSeed);
        // Bool
        assertNull(new ToHiddenBinary(trueHiddenBool).calculate(),
            "Method calculate does not works with bool type." + messageSeed);
        assertNull(new ToHiddenBinary(falseHiddenBool).calculate(),
            "Method calculate does not works with bool type." + messageSeed);
        // float
        assertNull(new ToHiddenBinary(hiddenFloat1).calculate(),
            "Method calculate does not works with float type." + messageSeed);
        // int
        assertEquals(hiddenInt1.toHiddenBinary(), new ToHiddenBinary(hiddenInt1).calculate(),
            "Method calculate does not works with int type." + messageSeed);
        // binary
        assertEquals(hiddenBinary1.toHiddenBinary(), new ToHiddenBinary(hiddenBinary1).calculate(),
            "Method calculate does not works with binary type." + messageSeed);
    }
}