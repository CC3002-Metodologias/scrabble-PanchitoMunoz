package cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_operations.transformations;

import static org.junit.jupiter.api.Assertions.*;

import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_operations.operations.BaseHiddenOperationTest;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ToHiddenStringTest extends BaseHiddenOperationTest {

    @BeforeEach
    protected void setUp() {
        super.setUp();
    }

    @Test
    void testToString() {
        String templateString = "%s.toTypeString()";
        for (HType hType1 : hTypeList2) {
            String expected = String.format(templateString, hType1.asString(0));
            assertEquals(expected, new ToHiddenString(hType1).toString(),
                "Method toString does not works." + messageSeed);
        }
    }

    @Test
    void testCalculate() {
        // String
        assertEquals(hiddenString1.toHiddenString(), new ToHiddenString(hiddenString1).calculate(),
            "Method calculate does not works with string type." + messageSeed);
        // Bool
        assertEquals(trueHiddenBool.toHiddenString(), new ToHiddenString(trueHiddenBool).calculate(),
            "Method calculate does not works with bool type." + messageSeed);
        assertEquals(falseHiddenBool.toHiddenString(), new ToHiddenString(falseHiddenBool).calculate(),
            "Method calculate does not works with bool type." + messageSeed);
        // float
        assertEquals(hiddenFloat1.toHiddenString(), new ToHiddenString(hiddenFloat1).calculate(),
            "Method calculate does not works with float type." + messageSeed);
        // int
        assertEquals(hiddenInt1.toHiddenString(), new ToHiddenString(hiddenInt1).calculate(),
            "Method calculate does not works with int type." + messageSeed);
        // binary
        assertEquals(hiddenBinary1.toHiddenString(), new ToHiddenString(hiddenBinary1).calculate(),
            "Method calculate does not works with binary type." + messageSeed);
    }
}