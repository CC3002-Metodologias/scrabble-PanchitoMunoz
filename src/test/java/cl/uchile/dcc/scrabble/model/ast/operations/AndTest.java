package cl.uchile.dcc.scrabble.model.ast.operations;

import static org.junit.jupiter.api.Assertions.*;

import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_operations.operations.HiddenAnd;
import cl.uchile.dcc.scrabble.model.types.TypeBinary;
import cl.uchile.dcc.scrabble.model.types.TypeBool;
import cl.uchile.dcc.scrabble.model.types.TypeInt;
import cl.uchile.dcc.scrabble.model.types.interface_types.SInteger;
import cl.uchile.dcc.scrabble.model.types.interface_types.SLogical;
import cl.uchile.dcc.scrabble.model.types.interface_types.SNumber;
import cl.uchile.dcc.scrabble.model.types.interface_types.SType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class AndTest extends BaseOperationTest {

    private And boolResult;
    private And binaryResult;

    @BeforeEach
    protected void setUp() {
        super.setUp();
        binaryResult = new And(typeBinary1, typeBinary2);
        boolResult = new And(trueTypeBool, falseTypeBool);
    }

    @RepeatedTest(20)
    void testToHiddenAST() {
        assertEquals(new HiddenAnd(hiddenBinary1, hiddenBinary2), binaryResult.toHiddenAST(),
            "Method toHiddenAST does not works with equals hidden ast." + messageSeed);
        assertNotEquals(new HiddenAnd(trueHiddenBool, trueHiddenBool), binaryResult.toHiddenAST(),
            "Method toHiddenAST does not works with different hidden ast." + messageSeed);
    }

    @RepeatedTest(20)
    void testCalculate() {
        // And with string
        for (SType sType : sTypeList) {
            assertNull(new And(typeString1, sType).calculate(),
                "Method and does not works with string type." + messageSeed);
        }
        // And with bool
        for (SLogical sType : logicalList) {
            assertEquals(trueTypeBool.and(sType), new And(trueTypeBool, sType).calculate(),
                "Method and does not works with type bool." + messageSeed);
            assertEquals(falseTypeBool.and(sType), new And(falseTypeBool, sType).calculate(),
                "Method and does not works with type bool." + messageSeed);
        }
        for (SType sType : logicalCList) {
            assertNull(new And(trueTypeBool, sType).calculate(),
                "Method and does not works with type bool." + messageSeed);
            assertNull(new And(falseTypeBool, sType).calculate(),
                "Method and does not works with type bool." + messageSeed);
        }
        // And with float
        for (SType sType : sTypeList) {
            assertNull(new And(typeFloat1, sType).calculate(),
                "Method and does not works with float type." + messageSeed);
        }
        // And with int
        for (SType sType : sTypeList) {
            assertNull(new And(typeInt1, sType).calculate(),
                "Method and does not works with int type." + messageSeed);
        }
        // And with binary
        for (SLogical sType : logicalList) {
            SType expected = typeBinary1.and(sType);
            assertEquals(expected, new And(typeBinary1, sType).calculate(),
                "Method and does not works with binary type." + messageSeed);
        }
        for (SType sType : logicalCList) {
            assertNull(new And(typeBinary1, sType).calculate(),
                "Method and does not works with binary type." + messageSeed);
        }
    }

    @RepeatedTest(20)
    void testToString() {
        String templateString = (
            "And(\n"
                + "  %s and\n"
                + "  %s\n"
                + ")"
        );
        for (SType sType1 : sTypeList) {
            for (SType sType2 : sTypeList) {
                String expected = String.format(templateString, sType1.toString(), sType2);
                assertEquals(expected, new And(sType1, sType2).toString(),
                    "Method toString does not works." + messageSeed);
            }
        }
    }

    @RepeatedTest(20)
    void testEquals() {
        And equalsResult = new And(typeBinary1, typeBinary2);
        And differentResult = new And(typeBinary1, typeBinary1);
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
        And equalsResult = new And(typeBinary1, typeBinary2);
        And differentResult = new And(typeBinary1, typeBinary1);
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
        assertEquals(((TypeBinary) typeBinary1.and(typeBinary2)).toTypeBinary(),
            binaryResult.toTypeBinary().calculate(),
            "Method toTypeBinary does not works with binary result." + messageSeed);
    }

    @RepeatedTest(20)
    void testToTypeBool() {
        assertEquals(((TypeBool) trueTypeBool.and(falseTypeBool)).toTypeBool(),
            boolResult.toTypeBool().calculate(),
            "Method toTypeBool does not works with bool result." + messageSeed);
        assertNull(binaryResult.toTypeBool().calculate(),
            "Method toTypeBool does not works with binary result." + messageSeed);
    }

    @RepeatedTest(20)
    void testToTypeFloat() {
        assertNull(boolResult.toTypeFloat().calculate(),
            "Method toTypeFloat does not works with bool result." + messageSeed);
        assertEquals(((TypeBinary) typeBinary1.and(typeBinary2)).toTypeFloat(),
            binaryResult.toTypeFloat().calculate(),
            "Method toTypeFloat does not works with binary result." + messageSeed);
    }

    @RepeatedTest(20)
    void testToTypeInt() {
        assertNull(boolResult.toTypeInt().calculate(),
            "Method toTypeInt does not works with bool result." + messageSeed);
        assertEquals(((TypeBinary) typeBinary1.and(typeBinary2)).toTypeInt(),
            binaryResult.toTypeInt().calculate(),
            "Method toTypeInt does not works with binary result." + messageSeed);
    }

    @RepeatedTest(20)
    void testToTypeString() {
        assertEquals(trueTypeBool.and(falseTypeBool).toTypeString(),
            boolResult.toTypeString().calculate(),
        "Method toTypeString does not works with bool result." + messageSeed);
        assertEquals(typeBinary1.and(typeBinary2).toTypeString(),
            binaryResult.toTypeString().calculate(),
            "Method toTypeInt does not works with binary result." + messageSeed);
    }
}