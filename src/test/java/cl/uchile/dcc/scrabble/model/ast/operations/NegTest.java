package cl.uchile.dcc.scrabble.model.ast.operations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.operators.HiddenNeg;
import cl.uchile.dcc.scrabble.model.types.interface_types.SType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

class NegTest extends BaseOperationTest {

    private Neg boolResult;
    private Neg binaryResult;

    @BeforeEach
    protected void setUp() {
        super.setUp();
        binaryResult = new Neg(typeBinary1);
        boolResult = new Neg(trueTypeBool);
    }

    @RepeatedTest(20)
    void testToHiddenAST() {
        assertEquals(new HiddenNeg(hiddenBinary1), binaryResult.asHiddenAST(),
            "Method toHiddenAST does not works with equals hidden ast." + messageSeed);
        assertNotEquals(new HiddenNeg(trueHiddenBool), binaryResult.asHiddenAST(),
            "Method toHiddenAST does not works with different hidden ast." + messageSeed);
    }

    @RepeatedTest(20)
    void testCalculate() {
        // Neg with string
        assertNull(new Neg(typeString1).calculate(),
            "Method neg does not works with string type." + messageSeed);
        // Neg with bool
        assertEquals(trueTypeBool.neg(), new Neg(trueTypeBool).calculate(),
            "Method neg does not works with type bool." + messageSeed);
        assertEquals(falseTypeBool.neg(), new Neg(falseTypeBool).calculate(),
            "Method neg does not works with type bool." + messageSeed);
        // Neg with float
        assertNull(new Neg(typeFloat1).calculate(),
            "Method neg does not works with float type." + messageSeed);
        // Neg with int
        assertNull(new Neg(typeInt1).calculate(),
            "Method neg does not works with int type." + messageSeed);
        // Neg with binary
        SType expected = typeBinary1.neg();
        assertEquals(expected, new Neg(typeBinary1).calculate(),
            "Method neg does not works with binary type." + messageSeed);
    }

    @RepeatedTest(20)
    void testToString() {
        String templateString = (
            "Neg(\n"
                + "  %s\n"
                + ")"
        );
        for (SType sType1 : sTypeList) {
            String expected = String.format(templateString, sType1.toString());
            assertEquals(expected, new Neg(sType1).toString(),
                "Method toString does not works." + messageSeed);
        }
    }

    @RepeatedTest(20)
    void testEquals() {
        Neg equalsResult = new Neg(typeBinary1);
        Neg differentResult = new Neg(typeBinary2);
        Sub otherNode = new Sub(typeInt1, typeBinary1);
        assertEquals(binaryResult, binaryResult,
            "Method equals does not works with the same instance." + messageSeed);
        assertEquals(equalsResult, binaryResult,
            "Method equals does not works with the similar instance." + messageSeed);
        assertNotEquals(differentResult, binaryResult,
            "Method equals does not works with different instance." + messageSeed);
        assertNotEquals(binaryResult, otherNode,
            "Method equals does not works with different instance." + messageSeed);
        assertNotEquals(binaryResult, typeString1,
            "Method equals does not works with different type." + messageSeed);
    }

    @RepeatedTest(20)
    void testHashCode() {
        Neg equalsResult = new Neg(typeBinary1);
        Neg differentResult = new Neg(typeBinary2);
        Sub otherNode = new Sub(typeInt1, typeBinary1);
        assertEquals(binaryResult.hashCode(), binaryResult.hashCode(),
            "Method equals does not works with the same instance." + messageSeed);
        assertEquals(equalsResult.hashCode(), binaryResult.hashCode(),
            "Method equals does not works with the similar instance." + messageSeed);
        assertNotEquals(differentResult.hashCode(), binaryResult.hashCode(),
            "Method equals does not works with different instance." + messageSeed);
        assertNotEquals(binaryResult.hashCode(), otherNode.hashCode(),
            "Method equals does not works with different instance." + messageSeed);
        assertNotEquals(binaryResult.hashCode(), typeString1.hashCode(),
            "Method equals does not works with different type." + messageSeed);
    }

    @RepeatedTest(20)
    void testToTypeBinary() {
        assertNull(boolResult.toTypeBinary().calculate(),
            "Method toTypeBinary does not works with bool result." + messageSeed);
        assertEquals(typeBinary1.neg().toTypeBinary(),
            binaryResult.toTypeBinary().calculate(),
            "Method toTypeBinary does not works with binary result." + messageSeed);
    }

    @RepeatedTest(20)
    void testToTypeBool() {
        assertEquals(trueTypeBool.neg().toTypeBool(),
            boolResult.toTypeBool().calculate(),
            "Method toTypeBool does not works with bool result." + messageSeed);
        assertNull(binaryResult.toTypeBool().calculate(),
            "Method toTypeBool does not works with binary result." + messageSeed);
    }

    @RepeatedTest(20)
    void testToTypeFloat() {
        assertNull(boolResult.toTypeFloat().calculate(),
            "Method toTypeFloat does not works with bool result." + messageSeed);
        assertEquals(typeBinary1.neg().toTypeFloat(),
            binaryResult.toTypeFloat().calculate(),
            "Method toTypeFloat does not works with binary result." + messageSeed);
    }

    @RepeatedTest(20)
    void testToTypeInt() {
        assertNull(boolResult.toTypeInt().calculate(),
            "Method toTypeInt does not works with bool result." + messageSeed);
        assertEquals(typeBinary1.neg().toTypeInt(),
            binaryResult.toTypeInt().calculate(),
            "Method toTypeInt does not works with binary result." + messageSeed);
    }

    @RepeatedTest(20)
    void testToTypeString() {
        assertEquals(trueTypeBool.neg().toTypeString(),
            boolResult.toTypeString().calculate(),
            "Method toTypeString does not works with bool result." + messageSeed);
        assertEquals(typeBinary1.neg().toTypeString(),
            binaryResult.toTypeString().calculate(),
            "Method toTypeInt does not works with binary result." + messageSeed);
    }

}