package cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_operations.transformations;

import static org.junit.jupiter.api.Assertions.*;

import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_operations.operations.BaseHiddenOperationTest;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ToHiddenIntTest extends BaseHiddenOperationTest {

    @BeforeEach
    protected void setUp() {
        super.setUp();
    }

    @Test
    void testToString() {
        String templateString = "%s.toTypeInt()";
        for (HType hType1 : hTypeList2) {
            String expected = String.format(templateString, hType1.asString(0));
            assertEquals(expected, new ToHiddenInt(hType1).toString(),
                "Method toString does not works." + messageSeed);
        }
    }

    @Test
    void testCalculate() {
        // String
        assertNull(new ToHiddenInt(hiddenString1).calculate(),
            "Method calculate does not works with string type." + messageSeed);
        // Bool
        assertNull(new ToHiddenInt(trueHiddenBool).calculate(),
            "Method calculate does not works with bool type." + messageSeed);
        assertNull(new ToHiddenInt(falseHiddenBool).calculate(),
            "Method calculate does not works with bool type." + messageSeed);
        // float
        assertNull(new ToHiddenInt(hiddenFloat1).calculate(),
            "Method calculate does not works with float type." + messageSeed);
        // int
        assertEquals(hiddenInt1.toHiddenInt(), new ToHiddenInt(hiddenInt1).calculate(),
            "Method calculate does not works with int type." + messageSeed);
        // binary
        assertEquals(hiddenBinary1.toHiddenInt(), new ToHiddenInt(hiddenBinary1).calculate(),
            "Method calculate does not works with binary type." + messageSeed);
    }
}