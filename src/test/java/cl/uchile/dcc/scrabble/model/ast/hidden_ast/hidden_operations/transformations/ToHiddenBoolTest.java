package cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_operations.transformations;

import static org.junit.jupiter.api.Assertions.*;

import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_operations.operations.BaseHiddenOperationTest;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ToHiddenBoolTest extends BaseHiddenOperationTest {

    @BeforeEach
    protected void setUp() {
        super.setUp();
    }

    @Test
    void testToString() {
        String templateString = "%s.toTypeBool()";
        for (HType hType1 : hTypeList2) {
            String expected = String.format(templateString, hType1.asString(0));
            assertEquals(expected, new ToHiddenBool(hType1).toString(),
                "Method toString does not works." + messageSeed);
        }
    }

    @Test
    void testCalculate() {
        // String
        assertNull(new ToHiddenBool(hiddenString1).calculate(),
            "Method calculate does not works with string type." + messageSeed);
        // Bool
        assertEquals(trueHiddenBool, new ToHiddenBool(trueHiddenBool).calculate(),
            "Method calculate does not works with bool type." + messageSeed);
        assertEquals(falseHiddenBool, new ToHiddenBool(falseHiddenBool).calculate(),
            "Method calculate does not works with bool type." + messageSeed);
        // float
        assertNull(new ToHiddenBool(hiddenFloat1).calculate(),
            "Method calculate does not works with float type." + messageSeed);
        // int
        assertNull(new ToHiddenBool(hiddenInt1).calculate(),
            "Method calculate does not works with int type." + messageSeed);
        // int
        assertNull(new ToHiddenBool(hiddenBinary1).calculate(),
            "Method calculate does not works with binary type." + messageSeed);
    }
}