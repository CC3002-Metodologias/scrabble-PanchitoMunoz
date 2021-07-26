package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.transformations;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.operators.BaseHiddenOperationTest;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

class ToHiddenFloatTest extends BaseHiddenOperationTest {

    @BeforeEach
    protected void setUp() {
        super.setUp();
    }

    @RepeatedTest(20)
    void testToString() {
        String templateString = "%s.toTypeFloat()";
        for (HType hType1 : hTypeList2) {
            String expected = String.format(templateString, hType1.asString(0));
            assertEquals(expected, new ToHiddenFloat(hType1).toString(),
                "Method toString does not works." + messageSeed);
        }
    }

    @RepeatedTest(20)
    void testCalculate() {
        // String
        assertEquals(hiddenNull, new ToHiddenFloat(hiddenString1).calculate(),
            "Method calculate does not works with string type." + messageSeed);
        // Bool
        assertEquals(hiddenNull, new ToHiddenFloat(trueHiddenBool).calculate(),
            "Method calculate does not works with bool type." + messageSeed);
        assertEquals(hiddenNull, new ToHiddenFloat(falseHiddenBool).calculate(),
            "Method calculate does not works with bool type." + messageSeed);
        // float
        assertEquals(hiddenFloat1.toHiddenFloat(), new ToHiddenFloat(hiddenFloat1).calculate(),
            "Method calculate does not works with float type." + messageSeed);
        // int
        assertEquals(hiddenInt1.toHiddenFloat(), new ToHiddenFloat(hiddenInt1).calculate(),
            "Method calculate does not works with int type." + messageSeed);
        // int
        assertEquals(hiddenBinary1.toHiddenFloat(), new ToHiddenFloat(hiddenBinary1).calculate(),
            "Method calculate does not works with binary type." + messageSeed);
    }
}