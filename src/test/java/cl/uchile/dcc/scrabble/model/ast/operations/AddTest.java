package cl.uchile.dcc.scrabble.model.ast.operations;

import static org.junit.jupiter.api.Assertions.*;

import cl.uchile.dcc.scrabble.model.hidden_ast.hidden_operations.operations.HiddenAdd;
import cl.uchile.dcc.scrabble.model.types.TypeInt;
import cl.uchile.dcc.scrabble.model.types.interface_types.SInteger;
import cl.uchile.dcc.scrabble.model.types.interface_types.SNumber;
import cl.uchile.dcc.scrabble.model.types.interface_types.SType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

class AddTest extends BaseOperationTest {

    private Add stringResult;
    private Add floatResult;
    private Add intResult;
    private Add binaryResult;

    @BeforeEach
    protected void setUp() {
        super.setUp();
        stringResult = new Add(typeString1, typeString2);
        floatResult = new Add(typeFloat1, typeFloat2);
        intResult = new Add(typeInt1, typeInt2);
        binaryResult = new Add(typeBinary1, typeBinary2);
    }

    @RepeatedTest(20)
    void testToHiddenAST() {
        assertEquals(new HiddenAdd(hiddenString1, hiddenString2), stringResult.toHiddenAST(),
            "Method toHiddenAST does not works with equals hidden ast." + messageSeed);
        assertNotEquals(new HiddenAdd(hiddenString1, hiddenString1), stringResult.toHiddenAST(),
            "Method toHiddenAST does not works with different hidden ast." + messageSeed);
    }

    @RepeatedTest(20)
    void testCalculate() {
        // Add with string
        for (SType sType : sTypeList) {
            SType expected = typeString1.add(sType);
            assertEquals(expected, new Add(typeString1, sType).calculate(),
                "Method add does not works with string type." + messageSeed);
        }
        // Add with bool
        for (SType sType : sTypeList) {
            assertNull(new Add(trueTypeBool, sType).calculate(),
                "Method add does not works with type bool." + messageSeed);
            assertNull(new Add(falseTypeBool, sType).calculate(),
                "Method add does not works with type bool." + messageSeed);
        }
        // Add with float
        for (SNumber sType : numberList) {
            SType expected = typeFloat1.add(sType);
            assertEquals(expected, new Add(typeFloat1, sType).calculate(),
                "Method add does not works with float type." + messageSeed);
        }
        for (SType sType : numberCList) {
            assertNull(new Add(typeFloat1, sType).calculate(),
                "Method add does not works with float type." + messageSeed);
        }
        // Add with int
        for (SNumber sType : numberList) {
            SType expected = typeInt1.add(sType);
            assertEquals(expected, new Add(typeInt1, sType).calculate(),
                "Method add does not works with int type." + messageSeed);
        }
        for (SType sType : numberCList) {
            assertNull(new Add(typeInt1, sType).calculate(),
                "Method add does not works with int type." + messageSeed);
        }
        // Add with binary
        for (SInteger sType : integerList) {
            SType expected = typeBinary1.add(sType);
            assertEquals(expected, new Add(typeBinary1, sType).calculate(),
                "Method add does not works with binary type." + messageSeed);
        }
        for (SType sType : integerCList) {
            assertNull(new Add(typeBinary1, sType).calculate(),
                "Method add does not works with binary type." + messageSeed);
        }
    }

    @RepeatedTest(20)
    void testToString() {
        String templateString = (
            "Add(\n"
            + "  %s +\n"
            + "  %s\n"
            + ")"
        );
        for (SType sType1 : sTypeList) {
            for (SType sType2 : sTypeList) {
                String expected = String.format(templateString, sType1.toString(), sType2);
                assertEquals(expected, new Add(sType1, sType2).toString(),
                    "Method toString does not works." + messageSeed);
            }
        }
    }

    @RepeatedTest(20)
    void testEquals() {
        Add equalsResult = new Add(typeString1, typeString2);
        Add differentResult = new Add(typeFloat1, typeInt1);
        Sub otherNode = new Sub(typeInt1, typeBinary1);
        assertEquals(stringResult, stringResult,
            "Method equals does not works with the same instance." + messageSeed);
        assertEquals(equalsResult, stringResult,
            "Method equals does not works with the similar instance." + messageSeed);
        assertNotEquals(differentResult, stringResult,
            "Method equals does not works with different instance." + messageSeed);
        assertNotEquals(stringResult, otherNode,
            "Method equals does not works with different instance." + messageSeed);
        assertNotEquals(stringResult, typeString1,
            "Method equals does not works with different type." + messageSeed);
    }

    @RepeatedTest(20)
    void testHashCode() {
        Add equalsResult = new Add(typeString1, typeString2);
        Add differentResult = new Add(typeFloat1, typeInt1);
        Sub otherNode = new Sub(typeInt1, typeBinary1);
        assertEquals(stringResult.hashCode(), stringResult.hashCode(),
            "Method equals does not works with the same instance." + messageSeed);
        assertEquals(equalsResult.hashCode(), stringResult.hashCode(),
            "Method equals does not works with the similar instance." + messageSeed);
        assertNotEquals(differentResult.hashCode(), stringResult.hashCode(),
            "Method equals does not works with different instance." + messageSeed);
        assertNotEquals(stringResult.hashCode(), otherNode.hashCode(),
            "Method equals does not works with different instance." + messageSeed);
        assertNotEquals(stringResult.hashCode(), typeString1.hashCode(),
            "Method equals does not works with different type." + messageSeed);
    }

    @RepeatedTest(20)
    void testToTypeBinary() {
        assertNull(stringResult.toTypeBinary().calculate(),
            "Method toTypeBinary does not works with string result." + messageSeed);
        assertNull(floatResult.toTypeBinary().calculate(),
            "Method toTypeBinary does not works with float result." + messageSeed);
        assertEquals(((TypeInt) typeInt1.add(typeInt2)).toTypeBinary(),
            intResult.toTypeBinary().calculate(),
            "Method toTypeBinary does not works with int result." + messageSeed);
        assertEquals(typeBinary1.add(typeBinary2).toTypeBinary(),
            binaryResult.toTypeBinary().calculate(),
            "Method toTypeBinary does not works with binary result." + messageSeed);
    }

    @RepeatedTest(20)
    void testToTypeBool() {
        assertNull(stringResult.toTypeBool().calculate(),
            "Method toTypeBool does not works with string result." + messageSeed);
        assertNull(floatResult.toTypeBool().calculate(),
            "Method toTypeBool does not works with float result." + messageSeed);
        assertNull(intResult.toTypeBool().calculate(),
            "Method toTypeBool does not works with int result." + messageSeed);
        assertNull(binaryResult.toTypeBool().calculate(),
            "Method toTypeBool does not works with binary result." + messageSeed);
    }

    @RepeatedTest(20)
    void testToTypeFloat() {
        assertNull(stringResult.toTypeFloat().calculate(),
            "Method toTypeFloat does not works with string result." + messageSeed);
        assertEquals(typeFloat1.add(typeFloat2).toTypeFloat(),
            floatResult.toTypeFloat().calculate(),
            "Method toTypeFloat does not works with float result." + messageSeed);
        assertEquals(typeInt1.add(typeInt2).toTypeFloat(),
            intResult.toTypeFloat().calculate(),
            "Method toTypeFloat does not works with int result." + messageSeed);
        assertEquals(typeBinary1.add(typeBinary2).toTypeFloat(),
            binaryResult.toTypeFloat().calculate(),
            "Method toTypeFloat does not works with binary result." + messageSeed);
    }

    @RepeatedTest(20)
    void testToTypeInt() {
        assertNull(stringResult.toTypeInt().calculate(),
            "Method toTypeInt does not works with string result." + messageSeed);
        assertNull(floatResult.toTypeInt().calculate(),
            "Method toTypeInt does not works with float result." + messageSeed);
        assertEquals(((TypeInt) typeInt1.add(typeInt2)).toTypeInt(),
            intResult.toTypeInt().calculate(),
            "Method toTypeInt does not works with int result." + messageSeed);
        assertEquals(typeBinary1.add(typeBinary2).toTypeInt(),
            binaryResult.toTypeInt().calculate(),
            "Method toTypeInt does not works with binary result." + messageSeed);
    }

    @RepeatedTest(20)
    void testToTypeString() {
        assertEquals(typeString1.add(typeString2).toTypeString(),
            stringResult.toTypeString().calculate(),
            "Method toTypeString does not works with string result." + messageSeed);
        assertEquals(typeFloat1.add(typeFloat2).toTypeString(),
            floatResult.toTypeString().calculate(),
            "Method toTypeString does not works with float result." + messageSeed);
        assertEquals(typeInt1.add(typeInt2).toTypeString(),
            intResult.toTypeString().calculate(),
            "Method toTypeString does not works with int result." + messageSeed);
        assertEquals(typeBinary1.add(typeBinary2).toTypeString(),
            binaryResult.toTypeString().calculate(),
            "Method toTypeString does not works with binary result." + messageSeed);
    }
}