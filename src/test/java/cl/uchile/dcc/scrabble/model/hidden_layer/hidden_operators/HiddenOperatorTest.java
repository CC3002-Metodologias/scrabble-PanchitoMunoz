package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.operators.BaseHiddenOperationTest;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.operators.HiddenAdd;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.operators.HiddenDiv;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.operators.HiddenMult;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.operators.HiddenOr;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.operators.HiddenSub;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HType;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HiddenFloat;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_variable.HiddenVariable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class HiddenOperatorTest extends BaseHiddenOperationTest {

    private HiddenOperator stringHiddenAST;
    private HiddenOperator boolHiddenAST;
    private HiddenOperator floatHiddenAST;
    private HiddenOperator intHiddenAST;
    private HiddenOperator binaryHiddenAST;
    private HType stringResult;
    private HType boolResult;
    private HType floatResult;
    private HType intResult;
    private HType binaryResult;

    @BeforeEach
    protected void setUp() {
        super.setUp();
        stringHiddenAST = new HiddenAdd(hiddenString1, hiddenBinary2);
        boolHiddenAST = new HiddenOr(trueHiddenBool, falseHiddenBool);
        floatHiddenAST = new HiddenSub(hiddenFloat1, hiddenBinary2);
        intHiddenAST = new HiddenMult(hiddenFloat1, hiddenBinary2);
        binaryHiddenAST = new HiddenDiv(hiddenBinary1, hiddenBinary2);
        stringResult = stringHiddenAST.calculate();
        boolResult = boolHiddenAST.calculate();
        floatResult = floatHiddenAST.calculate();
        intResult = intHiddenAST.calculate();
        binaryResult = binaryHiddenAST.calculate();
    }

    @Test
    void testSetVariable() {
        String name = "x";
        String otherName = "y";
        HiddenAdd operation = new HiddenAdd(
            new HiddenVariable(name), new HiddenVariable(otherName)
        );
        assertEquals(hiddenNull, operation.calculate(),
            "HiddenOperator does not works with empty leaf." + messageSeed);
        operation.setVariable(name, hiddenFloat1);
        assertEquals(hiddenNull, operation.calculate(),
            "calculate does not works with other variable." + messageSeed);
        operation.setVariable(otherName, hiddenFloat2);
        assertEquals(new HiddenFloat(aFloat1 + aFloat2), operation.calculate(),
            "calculate does not works with correct variable." + messageSeed);
    }

    @RepeatedTest(20)
    void testToHiddenBinary() {
        assertEquals(hiddenNull, stringHiddenAST.toHiddenBinary().calculate(),
            "Method toHiddenBinary does not works with string type." + messageSeed);
        assertEquals(hiddenNull, boolHiddenAST.toHiddenBinary().calculate(),
            "Method toHiddenBinary does not works with bool type." + messageSeed);
        assertEquals(hiddenNull, floatHiddenAST.toHiddenBinary().calculate(),
            "Method toHiddenBinary does not works with float type." + messageSeed);
        assertEquals(intResult.toHiddenBinary(), intHiddenAST.toHiddenBinary().calculate(),
            "Method toHiddenBinary does not works with int type." + messageSeed);
        assertEquals(binaryResult.toHiddenBinary(), binaryHiddenAST.toHiddenBinary().calculate(),
            "Method toHiddenBinary does not works with binary type." + messageSeed);
    }

    @RepeatedTest(20)
    void testToHiddenBool() {
        assertEquals(hiddenNull, stringHiddenAST.toHiddenBool().calculate(),
            "Method toHiddenBool does not works with string type." + messageSeed);
        assertEquals(boolResult.toHiddenBool(), boolHiddenAST.toHiddenBool().calculate(),
            "Method toHiddenBool does not works with bool type." + messageSeed);
        assertEquals(hiddenNull, floatHiddenAST.toHiddenBool().calculate(),
            "Method toHiddenBool does not works with float type." + messageSeed);
        assertEquals(hiddenNull, intHiddenAST.toHiddenBool().calculate(),
            "Method toHiddenBool does not works with int type." + messageSeed);
        assertEquals(hiddenNull, binaryHiddenAST.toHiddenBool().calculate(),
            "Method toHiddenBool does not works with binary type." + messageSeed);
    }

    @RepeatedTest(20)
    void testToHiddenFloat() {
        assertEquals(hiddenNull, stringHiddenAST.toHiddenFloat().calculate(),
            "Method toHiddenFloat does not works with string type." + messageSeed);
        assertEquals(hiddenNull, boolHiddenAST.toHiddenFloat().calculate(),
            "Method toHiddenFloat does not works with bool type." + messageSeed);
        assertEquals(floatResult.toHiddenFloat(), floatHiddenAST.toHiddenFloat().calculate(),
            "Method toHiddenFloat does not works with float type." + messageSeed);
        assertEquals(intResult.toHiddenFloat(), intHiddenAST.toHiddenFloat().calculate(),
            "Method toHiddenFloat does not works with int type." + messageSeed);
        assertEquals(binaryResult.toHiddenFloat(), binaryHiddenAST.toHiddenFloat().calculate(),
            "Method toHiddenFloat does not works with binary type." + messageSeed);
    }

    @RepeatedTest(20)
    void testToHiddenInt() {
        assertEquals(hiddenNull, stringHiddenAST.toHiddenInt().calculate(),
            "Method toHiddenInt does not works with string type." + messageSeed);
        assertEquals(hiddenNull, boolHiddenAST.toHiddenInt().calculate(),
            "Method toHiddenInt does not works with bool type." + messageSeed);
        assertEquals(hiddenNull, floatHiddenAST.toHiddenInt().calculate(),
            "Method toHiddenInt does not works with float type." + messageSeed);
        assertEquals(intResult.toHiddenInt(), intHiddenAST.toHiddenInt().calculate(),
            "Method toHiddenInt does not works with int type." + messageSeed);
        assertEquals(binaryResult.toHiddenInt(), binaryHiddenAST.toHiddenInt().calculate(),
            "Method toHiddenInt does not works with binary type." + messageSeed);
    }

    @RepeatedTest(20)
    void testToHiddenString() {
        assertEquals(stringResult.toHiddenString(), stringHiddenAST.toHiddenString().calculate(),
            "Method toHiddenString does not works with string type." + messageSeed);
        assertEquals(boolResult.toHiddenString(), boolHiddenAST.toHiddenString().calculate(),
            "Method toHiddenString does not works with bool type." + messageSeed);
        assertEquals(floatResult.toHiddenString(), floatHiddenAST.toHiddenString().calculate(),
            "Method toHiddenString does not works with float type." + messageSeed);
        assertEquals(intResult.toHiddenString(), intHiddenAST.toHiddenString().calculate(),
            "Method toHiddenString does not works with int type." + messageSeed);
        assertEquals(binaryResult.toHiddenString(), binaryHiddenAST.toHiddenString().calculate(),
            "Method toHiddenString does not works with binary type." + messageSeed);
    }
}