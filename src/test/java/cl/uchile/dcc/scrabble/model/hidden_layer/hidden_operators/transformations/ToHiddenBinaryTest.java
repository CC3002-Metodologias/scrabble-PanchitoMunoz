package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.transformations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;

import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.HiddenOperator;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.operators.BaseHiddenOperationTest;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.unary_operators.ToHiddenBinary;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HType;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HiddenString;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_variable.HiddenVariable;
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
        assertEquals(hiddenNull, new ToHiddenBinary(hiddenString1).calculate(),
            "Method calculate does not works with string type." + messageSeed);
        // Bool
        assertEquals(hiddenNull, new ToHiddenBinary(trueHiddenBool).calculate(),
            "Method calculate does not works with bool type." + messageSeed);
        assertEquals(hiddenNull, new ToHiddenBinary(falseHiddenBool).calculate(),
            "Method calculate does not works with bool type." + messageSeed);
        // float
        assertEquals(hiddenNull, new ToHiddenBinary(hiddenFloat1).calculate(),
            "Method calculate does not works with float type." + messageSeed);
        // int
        assertEquals(hiddenInt1.toHiddenBinary(), new ToHiddenBinary(hiddenInt1).calculate(),
            "Method calculate does not works with int type." + messageSeed);
        // binary
        assertEquals(hiddenBinary1.toHiddenBinary(), new ToHiddenBinary(hiddenBinary1).calculate(),
            "Method calculate does not works with binary type." + messageSeed);
    }

    @RepeatedTest(20)
    void testCopy() {
        ToHiddenBinary operation = new ToHiddenBinary(hiddenFloat1);
        HiddenOperator other = operation.copy();
        assertNotSame(other, operation);
        assertSame(other.getFirstChildren(), operation.getFirstChildren());
    }

    @Test
    void testAsCode() {
        HiddenOperator operator = new ToHiddenBinary(new HiddenString("Hola Mundo"));
        String expected = "\"Hola Mundo\".toTypeBinary()";
        assertEquals(expected, operator.asCode(),
            "Method asCode does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testAccept() {
        HiddenOperator operator = new ToHiddenBinary(
            new HiddenVariable("x")
        );
        operator.setVariable("x", hiddenBinary1);
        assertEquals(hiddenBinary1, operator.calculate(),
            "Method accept does not works." + messageSeed);
    }
}