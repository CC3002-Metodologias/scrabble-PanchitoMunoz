package cl.uchile.dcc.scrabble.model.ast.operations;

import static org.junit.jupiter.api.Assertions.*;

import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_operations.operations.HiddenOr;
import cl.uchile.dcc.scrabble.model.types.TypeBinary;
import cl.uchile.dcc.scrabble.model.types.TypeBool;
import cl.uchile.dcc.scrabble.model.types.interface_types.SLogical;
import cl.uchile.dcc.scrabble.model.types.interface_types.SType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

class OrTest extends BaseOperationTest {

    private Or boolResult;
    private Or binaryResult;

    @BeforeEach
    protected void setUp() {
        super.setUp();
        binaryResult = new Or(typeBinary1, typeBinary2);
        boolResult = new Or(trueTypeBool, falseTypeBool);
    }

    @RepeatedTest(20)
    void testToHiddenAST() {
        assertEquals(new HiddenOr(hiddenBinary1, hiddenBinary2), binaryResult.toHiddenAST(),
            "Method toHiddenAST does not works with equals hidden ast." + messageSeed);
        assertNotEquals(new HiddenOr(trueHiddenBool, trueHiddenBool), binaryResult.toHiddenAST(),
            "Method toHiddenAST does not works with different hidden ast." + messageSeed);
    }

    @RepeatedTest(20)
    void testCalculate() {
        // Or with string
        for (SType sType : sTypeList) {
            assertNull(new Or(typeString1, sType).calculate(),
                "Method or does not works with string type." + messageSeed);
        }
        // Or with bool
        for (SLogical sType : logicalList) {
            assertEquals(trueTypeBool.or(sType), new Or(trueTypeBool, sType).calculate(),
                "Method or does not works with type bool." + messageSeed);
            assertEquals(falseTypeBool.or(sType), new Or(falseTypeBool, sType).calculate(),
                "Method or does not works with type bool." + messageSeed);
        }
        for (SType sType : logicalCList) {
            assertNull(new Or(trueTypeBool, sType).calculate(),
                "Method or does not works with type bool." + messageSeed);
            assertNull(new Or(falseTypeBool, sType).calculate(),
                "Method or does not works with type bool." + messageSeed);
        }
        // Or with float
        for (SType sType : sTypeList) {
            assertNull(new Or(typeFloat1, sType).calculate(),
                "Method or does not works with float type." + messageSeed);
        }
        // Or with int
        for (SType sType : sTypeList) {
            assertNull(new Or(typeInt1, sType).calculate(),
                "Method or does not works with int type." + messageSeed);
        }
        // Or with binary
        for (SLogical sType : logicalList) {
            SType expected = typeBinary1.or(sType);
            assertEquals(expected, new Or(typeBinary1, sType).calculate(),
                "Method or does not works with binary type." + messageSeed);
        }
        for (SType sType : logicalCList) {
            assertNull(new Or(typeBinary1, sType).calculate(),
                "Method or does not works with binary type." + messageSeed);
        }
    }

    @RepeatedTest(20)
    void testToString() {
        String templateString = (
            "Or(\n"
                + "  %s or\n"
                + "  %s\n"
                + ")"
        );
        for (SType sType1 : sTypeList) {
            for (SType sType2 : sTypeList) {
                String expected = String.format(templateString, sType1.toString(), sType2);
                assertEquals(expected, new Or(sType1, sType2).toString(),
                    "Method toString does not works." + messageSeed);
            }
        }
    }

    @RepeatedTest(20)
    void testEquals() {
        Or equalsResult = new Or(typeBinary1, typeBinary2);
        Or differentResult = new Or(typeBinary1, typeBinary1);
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
        Or equalsResult = new Or(typeBinary1, typeBinary2);
        Or differentResult = new Or(typeBinary1, typeBinary1);
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
        assertEquals(((TypeBinary) typeBinary1.or(typeBinary2)).toTypeBinary(),
            binaryResult.toTypeBinary().calculate(),
            "Method toTypeBinary does not works with binary result." + messageSeed);
    }

    @RepeatedTest(20)
    void testToTypeBool() {
        assertEquals(((TypeBool) trueTypeBool.or(falseTypeBool)).toTypeBool(),
            boolResult.toTypeBool().calculate(),
            "Method toTypeBool does not works with bool result." + messageSeed);
        assertNull(binaryResult.toTypeBool().calculate(),
            "Method toTypeBool does not works with binary result." + messageSeed);
    }

    @RepeatedTest(20)
    void testToTypeFloat() {
        assertNull(boolResult.toTypeFloat().calculate(),
            "Method toTypeFloat does not works with bool result." + messageSeed);
        assertEquals(((TypeBinary) typeBinary1.or(typeBinary2)).toTypeFloat(),
            binaryResult.toTypeFloat().calculate(),
            "Method toTypeFloat does not works with binary result." + messageSeed);
    }

    @RepeatedTest(20)
    void testToTypeInt() {
        assertNull(boolResult.toTypeInt().calculate(),
            "Method toTypeInt does not works with bool result." + messageSeed);
        assertEquals(((TypeBinary) typeBinary1.or(typeBinary2)).toTypeInt(),
            binaryResult.toTypeInt().calculate(),
            "Method toTypeInt does not works with binary result." + messageSeed);
    }

    @RepeatedTest(20)
    void testToTypeString() {
        assertEquals(trueTypeBool.or(falseTypeBool).toTypeString(),
            boolResult.toTypeString().calculate(),
            "Method toTypeString does not works with bool result." + messageSeed);
        assertEquals(typeBinary1.or(typeBinary2).toTypeString(),
            binaryResult.toTypeString().calculate(),
            "Method toTypeInt does not works with binary result." + messageSeed);
    }

}