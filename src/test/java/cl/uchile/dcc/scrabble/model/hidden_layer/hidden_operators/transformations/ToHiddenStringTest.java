package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.transformations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;

import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.HiddenOperator;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.operators.BaseHiddenOperationTest;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.unary_operators.ToHiddenString;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

class ToHiddenStringTest extends BaseHiddenOperationTest {

    @BeforeEach
    protected void setUp() {
        super.setUp();
    }

    @RepeatedTest(20)
    void testToString() {
        String templateString = "%s.toTypeString()";
        for (HType hType1 : hTypeList2) {
            String expected = String.format(templateString, hType1.asString(0));
            assertEquals(expected, new ToHiddenString(hType1).toString(),
                "Method toString does not works." + messageSeed);
        }
    }

    @RepeatedTest(20)
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

    @RepeatedTest(20)
    void testCopy() {
        ToHiddenString operation = new ToHiddenString(hiddenFloat1);
        HiddenOperator other = operation.copy();
        assertNotSame(other, operation);
        assertSame(other.getFirstChildren(), operation.getFirstChildren());
    }
}