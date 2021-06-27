package cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_operations;

import static org.junit.jupiter.api.Assertions.*;

import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_operations.operations.BaseHiddenOperationTest;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_operations.operations.HiddenAdd;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_operations.operations.HiddenDiv;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_operations.operations.HiddenMult;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_operations.operations.HiddenOr;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_operations.operations.HiddenSub;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HiddenOperationTest extends BaseHiddenOperationTest {

    private HiddenOperation stringHiddenAST;
    private HiddenOperation boolHiddenAST;
    private HiddenOperation floatHiddenAST;
    private HiddenOperation intHiddenAST;
    private HiddenOperation binaryHiddenAST;
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
    void testToHiddenBinary() {
        assertNull(stringHiddenAST.toHiddenBinary().calculate(),
            "Method toHiddenBinary does not works with string type." + messageSeed);
        assertNull(boolHiddenAST.toHiddenBinary().calculate(),
            "Method toHiddenBinary does not works with bool type." + messageSeed);
        assertNull(floatHiddenAST.toHiddenBinary().calculate(),
            "Method toHiddenBinary does not works with float type." + messageSeed);
        assertEquals(intResult.toHiddenBinary(), intHiddenAST.toHiddenBinary().calculate(),
            "Method toHiddenBinary does not works with int type." + messageSeed);
        assertEquals(binaryResult.toHiddenBinary(), binaryHiddenAST.toHiddenBinary().calculate(),
            "Method toHiddenBinary does not works with binary type." + messageSeed);
    }

    @Test
    void testToHiddenBool() {
        assertNull(stringHiddenAST.toHiddenBool().calculate(),
            "Method toHiddenBool does not works with string type." + messageSeed);
        assertEquals(boolResult.toHiddenBool(), boolHiddenAST.toHiddenBool().calculate(),
            "Method toHiddenBool does not works with bool type." + messageSeed);
        assertNull(floatHiddenAST.toHiddenBool().calculate(),
            "Method toHiddenBool does not works with float type." + messageSeed);
        assertNull(intHiddenAST.toHiddenBool().calculate(),
            "Method toHiddenBool does not works with int type." + messageSeed);
        assertNull(binaryHiddenAST.toHiddenBool().calculate(),
            "Method toHiddenBool does not works with binary type." + messageSeed);
    }

    @Test
    void testToHiddenFloat() {
        assertNull(stringHiddenAST.toHiddenFloat().calculate(),
            "Method toHiddenFloat does not works with string type." + messageSeed);
        assertNull(boolHiddenAST.toHiddenFloat().calculate(),
            "Method toHiddenFloat does not works with bool type." + messageSeed);
        assertEquals(floatResult.toHiddenFloat(), floatHiddenAST.toHiddenFloat().calculate(),
            "Method toHiddenFloat does not works with float type." + messageSeed);
        assertEquals(intResult.toHiddenFloat(), intHiddenAST.toHiddenFloat().calculate(),
            "Method toHiddenFloat does not works with int type." + messageSeed);
        assertEquals(binaryResult.toHiddenFloat(), binaryHiddenAST.toHiddenFloat().calculate(),
            "Method toHiddenFloat does not works with binary type." + messageSeed);
    }

    @Test
    void testToHiddenInt() {
        assertNull(stringHiddenAST.toHiddenInt().calculate(),
            "Method toHiddenInt does not works with string type." + messageSeed);
        assertNull(boolHiddenAST.toHiddenInt().calculate(),
            "Method toHiddenInt does not works with bool type." + messageSeed);
        assertNull(floatHiddenAST.toHiddenInt().calculate(),
            "Method toHiddenInt does not works with float type." + messageSeed);
        assertEquals(intResult.toHiddenInt(), intHiddenAST.toHiddenInt().calculate(),
            "Method toHiddenInt does not works with int type." + messageSeed);
        assertEquals(binaryResult.toHiddenInt(), binaryHiddenAST.toHiddenInt().calculate(),
            "Method toHiddenInt does not works with binary type." + messageSeed);
    }

    @Test
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