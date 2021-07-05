package cl.uchile.dcc.scrabble.model.ast.operations;

import static org.junit.jupiter.api.Assertions.*;

import cl.uchile.dcc.scrabble.model.hidden_ast.hidden_operations.operations.HiddenMult;
import cl.uchile.dcc.scrabble.model.types.TypeInt;
import cl.uchile.dcc.scrabble.model.types.interface_types.SInteger;
import cl.uchile.dcc.scrabble.model.types.interface_types.SNumber;
import cl.uchile.dcc.scrabble.model.types.interface_types.SType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

class MultTest extends BaseOperationTest {

    private Mult floatResult;
    private Mult intResult;
    private Mult binaryResult;

    @BeforeEach
    protected void setUp() {
        super.setUp();
        floatResult = new Mult(typeFloat1, typeFloat2);
        intResult = new Mult(typeInt1, typeInt2);
        binaryResult = new Mult(typeBinary1, typeBinary2);
    }

    @RepeatedTest(20)
    void testToHiddenAST() {
        assertEquals(new HiddenMult(hiddenFloat1, hiddenFloat2), floatResult.toHiddenAST(),
            "Method toHiddenAST does not works with equals hidden ast." + messageSeed);
        assertNotEquals(new HiddenMult(hiddenFloat1, hiddenFloat1), floatResult.toHiddenAST(),
            "Method toHiddenAST does not works with different hidden ast." + messageSeed);
    }

    @RepeatedTest(20)
    void testCalculate() {
        // Mult with string
        for (SType sType : sTypeList) {
            assertNull(new Mult(typeString1, sType).calculate(),
                "Method mult does not works with string type." + messageSeed);
        }
        // Mult with bool
        for (SType sType : sTypeList) {
            assertNull(new Mult(trueTypeBool, sType).calculate(),
                "Method mult does not works with type bool." + messageSeed);
            assertNull(new Mult(falseTypeBool, sType).calculate(),
                "Method mult does not works with type bool." + messageSeed);
        }
        // Mult with float
        for (SNumber sType : numberList) {
            SType expected = typeFloat1.mult(sType);
            assertEquals(expected, new Mult(typeFloat1, sType).calculate(),
                "Method mult does not works with float type." + messageSeed);
        }
        for (SType sType : numberCList) {
            assertNull(new Mult(typeFloat1, sType).calculate(),
                "Method mult does not works with float type." + messageSeed);
        }
        // Mult with int
        for (SNumber sType : numberList) {
            SType expected = typeInt1.mult(sType);
            assertEquals(expected, new Mult(typeInt1, sType).calculate(),
                "Method mult does not works with int type." + messageSeed);
        }
        for (SType sType : numberCList) {
            assertNull(new Mult(typeInt1, sType).calculate(),
                "Method mult does not works with int type." + messageSeed);
        }
        // Mult with binary
        for (SInteger sType : integerList) {
            SType expected = typeBinary1.mult(sType);
            assertEquals(expected, new Mult(typeBinary1, sType).calculate(),
                "Method mult does not works with binary type." + messageSeed);
        }
        for (SType sType : integerCList) {
            assertNull(new Mult(typeBinary1, sType).calculate(),
                "Method mult does not works with binary type." + messageSeed);
        }
    }

    @RepeatedTest(20)
    void testToString() {
        String templateString = (
            "Mult(\n"
                + "  %s *\n"
                + "  %s\n"
                + ")"
        );
        for (SType sType1 : sTypeList) {
            for (SType sType2 : sTypeList) {
                String expected = String.format(templateString, sType1.toString(), sType2);
                assertEquals(expected, new Mult(sType1, sType2).toString(),
                    "Method toString does not works." + messageSeed);
            }
        }
    }

    @RepeatedTest(20)
    void testEquals() {
        Mult equalsResult = new Mult(typeFloat1, typeFloat2);
        Mult differentResult = new Mult(typeInt1, typeInt2);
        Sub otherNode = new Sub(typeInt1, typeBinary1);
        assertEquals(floatResult, floatResult,
            "Method equals does not works with the same instance." + messageSeed);
        assertEquals(equalsResult, floatResult,
            "Method equals does not works with the similar instance." + messageSeed);
        assertNotEquals(differentResult, floatResult,
            "Method equals does not works with different instance." + messageSeed);
        assertNotEquals(floatResult, otherNode,
            "Method equals does not works with different instance." + messageSeed);
        assertNotEquals(floatResult, typeString1,
            "Method equals does not works with different type." + messageSeed);
    }

    @RepeatedTest(20)
    void testHashCode() {
        Mult equalsResult = new Mult(typeFloat1, typeFloat2);
        Mult differentResult = new Mult(typeInt1, typeInt2);
        Sub otherNode = new Sub(typeInt1, typeBinary1);
        assertEquals(floatResult.hashCode(), floatResult.hashCode(),
            "Method equals does not works with the same instance." + messageSeed);
        assertEquals(equalsResult.hashCode(), floatResult.hashCode(),
            "Method equals does not works with the similar instance." + messageSeed);
        assertNotEquals(differentResult.hashCode(), floatResult.hashCode(),
            "Method equals does not works with different instance." + messageSeed);
        assertNotEquals(floatResult.hashCode(), otherNode.hashCode(),
            "Method equals does not works with different instance." + messageSeed);
        assertNotEquals(floatResult.hashCode(), typeString1.hashCode(),
            "Method equals does not works with different type." + messageSeed);
    }

    @RepeatedTest(20)
    void testToTypeBinary() {
        assertNull(floatResult.toTypeBinary().calculate(),
            "Method toTypeBinary does not works with float result." + messageSeed);
        assertEquals(((TypeInt) typeInt1.mult(typeInt2)).toTypeBinary(),
            intResult.toTypeBinary().calculate(),
            "Method toTypeBinary does not works with int result." + messageSeed);
        assertEquals(typeBinary1.mult(typeBinary2).toTypeBinary(),
            binaryResult.toTypeBinary().calculate(),
            "Method toTypeBinary does not works with binary result." + messageSeed);
    }

    @RepeatedTest(20)
    void testToTypeBool() {
        assertNull(floatResult.toTypeBool().calculate(),
            "Method toTypeBool does not works with float result." + messageSeed);
        assertNull(intResult.toTypeBool().calculate(),
            "Method toTypeBool does not works with int result." + messageSeed);
        assertNull(binaryResult.toTypeBool().calculate(),
            "Method toTypeBool does not works with binary result." + messageSeed);
    }

    @RepeatedTest(20)
    void testToTypeFloat() {
        assertEquals(typeFloat1.mult(typeFloat2).toTypeFloat(),
            floatResult.toTypeFloat().calculate(),
            "Method toTypeFloat does not works with float result." + messageSeed);
        assertEquals(typeInt1.mult(typeInt2).toTypeFloat(),
            intResult.toTypeFloat().calculate(),
            "Method toTypeFloat does not works with int result." + messageSeed);
        assertEquals(typeBinary1.mult(typeBinary2).toTypeFloat(),
            binaryResult.toTypeFloat().calculate(),
            "Method toTypeFloat does not works with binary result." + messageSeed);
    }

    @RepeatedTest(20)
    void testToTypeInt() {
        assertNull(floatResult.toTypeInt().calculate(),
            "Method toTypeInt does not works with float result." + messageSeed);
        assertEquals(((TypeInt) typeInt1.mult(typeInt2)).toTypeInt(),
            intResult.toTypeInt().calculate(),
            "Method toTypeInt does not works with int result." + messageSeed);
        assertEquals(typeBinary1.mult(typeBinary2).toTypeInt(),
            binaryResult.toTypeInt().calculate(),
            "Method toTypeInt does not works with binary result." + messageSeed);
    }

    @RepeatedTest(20)
    void testToTypeString() {
        assertEquals(typeFloat1.mult(typeFloat2).toTypeString(),
            floatResult.toTypeString().calculate(),
            "Method toTypeString does not works with float result." + messageSeed);
        assertEquals(typeInt1.mult(typeInt2).toTypeString(),
            intResult.toTypeString().calculate(),
            "Method toTypeString does not works with int result." + messageSeed);
        assertEquals(typeBinary1.mult(typeBinary2).toTypeString(),
            binaryResult.toTypeString().calculate(),
            "Method toTypeString does not works with binary result." + messageSeed);
    }

}