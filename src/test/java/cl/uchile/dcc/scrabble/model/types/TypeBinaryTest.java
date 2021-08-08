package cl.uchile.dcc.scrabble.model.types;

import static cl.uchile.dcc.scrabble.model.utils.BinaryUtilities.addTwoBinaries;
import static cl.uchile.dcc.scrabble.model.utils.BinaryUtilities.binaryAndBinary;
import static cl.uchile.dcc.scrabble.model.utils.BinaryUtilities.binaryOrBinary;
import static cl.uchile.dcc.scrabble.model.utils.BinaryUtilities.binaryToInt;
import static cl.uchile.dcc.scrabble.model.utils.BinaryUtilities.boolAndBinary;
import static cl.uchile.dcc.scrabble.model.utils.BinaryUtilities.boolOrBinary;
import static cl.uchile.dcc.scrabble.model.utils.BinaryUtilities.cleanBinary;
import static cl.uchile.dcc.scrabble.model.utils.BinaryUtilities.intToBinary;
import static cl.uchile.dcc.scrabble.model.utils.BinaryUtilities.oneComplement;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import cl.uchile.dcc.scrabble.model.exceptions.ZeroDivisionException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

class TypeBinaryTest extends BaseTypeTest {

    @BeforeEach
    protected void setUp() {
        super.setUp();
    }

    @AfterEach
    protected void tearDown() {
        super.tearDown();
    }

    @RepeatedTest(20)
    void getValue() {
        assertEquals(cleanBinary(aBinary1), typeBinary1.getValue(),
            "Method getValue does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void getValueAsInt() {
        assertEquals(binaryToInt(aBinary1), typeBinary1.getValueAsInt(),
                "Method getValueAsInt does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testEquals() {
        TypeBinary otherTypeBinary1 = new TypeBinary(aBinary1);
        assertEquals(otherTypeBinary1, typeBinary1,
                "Two instances that have the same values are not equals." + messageSeed);
        assertNotEquals(typeBinary2, typeBinary1,
                "Two instances that have different values are equals." + messageSeed);
        // Case where a binary has redundant leading zeros.
        TypeBinary typeBinary = new TypeBinary("0" + aBinary1);
        TypeBinary aBinaryWithRedundantZeros = new TypeBinary("00000" + aBinary1);
        assertEquals(aBinaryWithRedundantZeros, typeBinary,
                "Method equals does not works when the binary has redundant leading zeros." + messageSeed);
    }

    @RepeatedTest(20)
    void testHashCode() {
        TypeBinary otherTypeBinary1 = new TypeBinary(aBinary1);
        assertEquals(otherTypeBinary1.hashCode(), typeBinary1.hashCode(),
                "Two instances that have the same values have different hash code." + messageSeed);
        assertNotEquals(typeBinary2.hashCode(), typeBinary1.hashCode(),
                "Two instances that have different values have equals hash code." + messageSeed);
        // Case where a binary has redundant leading zeros.
        TypeBinary typeBinary = new TypeBinary("0" + aBinary1);
        TypeBinary aBinaryWithRedundantZeros = new TypeBinary("00000" + aBinary1);
        assertEquals(aBinaryWithRedundantZeros.hashCode(), typeBinary.hashCode(),
                "Method hashCode does not works when the binary has redundant leading zeros." + messageSeed);
    }

    @RepeatedTest(20)
    void testToString() {
        assertEquals("TypeBinary{value=" + cleanBinary(aBinary1) + "}", typeBinary1.toString(),
            "Method toString does not works." + messageSeed);
        assertEquals("TypeBinary{value=" + cleanBinary(aBinary2) + "}", typeBinary2.toString(),
            "Method toString does not works." + messageSeed);
        assertNotEquals("TypeBinary{value=" + cleanBinary(aBinary2) + "}", typeBinary1.toString(),
            "Method toString does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void toTypeString() {
        TypeString binaryAsTypeString = new TypeString(cleanBinary(aBinary1));
        assertEquals(binaryAsTypeString, typeBinary1.toTypeString(),
                "Method toTypeString does not works." + messageSeed);
        assertNotEquals(binaryAsTypeString, typeBinary2.toTypeString(),
                "Method toTypeString does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void toTypeFloat() {
        // Convert aBinary1 as an int
        int aNumber1 = binaryToInt(aBinary1);
        TypeFloat binaryAsTypeFloat = new TypeFloat(aNumber1);
        assertEquals(binaryAsTypeFloat, typeBinary1.toTypeFloat(),
                "Method toTypeFloat does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void toTypeInt() {
        // Convert aBinary1 as an int
        int aNumber1 = binaryToInt(aBinary1);
        TypeInt binaryAsTypeInt = new TypeInt(aNumber1);
        assertEquals(binaryAsTypeInt, typeBinary1.toTypeInt(),
                "Method toTypeInt does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void toTypeBinary() {
        TypeBinary otherTypeBinary1 = new TypeBinary(aBinary1);
        assertEquals(otherTypeBinary1, typeBinary1.toTypeBinary(),
                "Method toTypeBinary does not works." + messageSeed);
        assertNotEquals(otherTypeBinary1, typeBinary2.toTypeBinary(),
                "Method toTypeBinary does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void neg() {
        // Changing each 1 for 0 and each 0 for 1 is equivalent to applying one complement.
        String aBinaryNegative1 = oneComplement(aBinary1);
        TypeBinary typeBinaryNegative1 = new TypeBinary(aBinaryNegative1);
        assertEquals(typeBinaryNegative1, typeBinary1.neg(),
                "Method neg does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void add() {
        // Test add with binary
        var expected = new TypeBinary(addTwoBinaries(aBinary1, aBinary2));
        assertEquals(expected, typeBinary1.add(typeBinary2),
                "Method add does not works with TypeBinary." + messageSeed);
        // Test add with int
        expected = new TypeBinary(addTwoBinaries(aBinary1, intToBinary(anInt1)));
        assertEquals(expected, typeBinary1.add(typeInt1),
                "Method add does not works with TypeInt." + messageSeed);
    }

    @RepeatedTest(20)
    void sub() {
        // Test subtraction with binary
        var expected = new TypeBinary(intToBinary(binaryToInt(aBinary1) - binaryToInt(aBinary2)));
        assertEquals(expected, typeBinary1.sub(typeBinary2),
                "Method sub does not works with TypeBinary." + messageSeed);
        // Test subtraction with int
        expected = new TypeBinary(intToBinary(binaryToInt(aBinary1) - anInt1));
        assertEquals(expected, typeBinary1.sub(typeInt1),
                "Method sub does not works with TypeInt." + messageSeed);
    }

    @RepeatedTest(20)
    void mult() {
        // Test multiplication with binary
        var expectedTypeBinary = new TypeBinary(intToBinary(binaryToInt(aBinary1) * binaryToInt(aBinary2)));
        assertEquals(expectedTypeBinary, typeBinary1.mult(typeBinary2),
                "Method mult does not works with TypeBinary." + messageSeed);
        // Test multiplication with int
        expectedTypeBinary = new TypeBinary(intToBinary(binaryToInt(aBinary1) * anInt1));
        assertEquals(expectedTypeBinary, typeBinary1.mult(typeInt1),
                "Method mult does not works with TypeInt." + messageSeed);
    }

    @RepeatedTest(20)
    void div() {
        try {
            // Test division with binary
            var expectedTypeBinary = new TypeBinary(intToBinary(
                (int) Math.round((double) binaryToInt(aBinary1) / binaryToInt(aBinary2))
            ));
            assertEquals(expectedTypeBinary, typeBinary1.div(typeBinary2),
                "Method div does not works with TypeBinary." + messageSeed);
        } catch (ZeroDivisionException e) {
            assertEquals(0, Math.abs(typeBinary2.getValueAsDouble()),
                "Exception fails.");
        }
        try {
            // Test division with int
            var expectedTypeBinary = new TypeBinary(
                intToBinary((int) Math.round((double) binaryToInt(aBinary1) / anInt1)));
            assertEquals(expectedTypeBinary, typeBinary1.div(typeInt1),
                "Method div does not works with TypeInt." + messageSeed);
        } catch (ZeroDivisionException e) {
            assertEquals(0, Math.abs(typeInt1.getValueAsDouble()),
                "Exception fails.");
        }
    }

    @RepeatedTest(20)
    void and() {
        var binaryAndTrue = boolAndBinary(trueBoolean, aBinary1);
        var expected = new TypeBinary(binaryAndTrue);
        assertEquals(expected, typeBinary1.and(trueTypeBool),
                "Method and does not works with true boolean." + messageSeed);
        var binaryAndFalse = boolAndBinary(falseBoolean, aBinary1);
        expected = new TypeBinary(binaryAndFalse);
        assertEquals(expected, typeBinary1.and(falseTypeBool),
                "Method and does not works with false boolean." + messageSeed);
        var binary1AndBinary2 = binaryAndBinary(aBinary1, aBinary2);
        expected = new TypeBinary(binary1AndBinary2);
        assertEquals(expected, typeBinary1.and(typeBinary2),
                "Method and does not works with another binary." + messageSeed);
    }

    @RepeatedTest(20)
    void or() {
        var binaryOrTrue = boolOrBinary(trueBoolean, aBinary1);
        var expected = new TypeBinary(binaryOrTrue);
        assertEquals(expected, typeBinary1.or(trueTypeBool),
                "Method or does not works with true boolean." + messageSeed);
        var binaryOrFalse = boolOrBinary(falseBoolean, aBinary1);
        expected = new TypeBinary(binaryOrFalse);
        assertEquals(expected, typeBinary1.or(falseTypeBool),
                "Method or does not works with false boolean." + messageSeed);
        var binary1OrBinary2 = binaryOrBinary(aBinary1, aBinary2);
        expected = new TypeBinary(binary1OrBinary2);
        assertEquals(expected, typeBinary1.or(typeBinary2),
                "Method or does not works with another binary." + messageSeed);
    }
}