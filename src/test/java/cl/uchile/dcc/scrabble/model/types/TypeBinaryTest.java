package cl.uchile.dcc.scrabble.model.types;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.*;
import static cl.uchile.dcc.scrabble.model.utils.BinaryUtilities.*;

class TypeBinaryTest extends BaseTypeTest {

    @BeforeEach
    void setUp() {
        super.setUp();
    }

    @RepeatedTest(20)
    void getValue() {
        assertEquals(aBinary1, typeBinary1.getValue(),
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
        assertEquals("TypeBinary{value='" + aBinary1 + "'}", typeBinary1.toString(),
                "Method toString does not works." + messageSeed);
        assertEquals("TypeBinary{value='" + aBinary2 + "'}", typeBinary2.toString(),
                "Method toString does not works." + messageSeed);
        assertNotEquals("TypeBinary{value='" + aBinary2 + "'}", typeBinary1.toString(),
                "Method toString does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void toTypeString() {
        TypeString binaryAsTypeString = new TypeString(aBinary1);
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
    void addWithString() {
        var expectedTypeString = new TypeString(aString1 + aBinary1);
        assertEquals(expectedTypeString, typeBinary1.addWithString(typeString1),
                "Method addWithString does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void addWithInt() {
        var expected = new TypeInt(anInt1 + binaryToInt(aBinary1));
        assertEquals(expected, typeBinary1.addWithInt(typeInt1),
                "Method addWithInt does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void addWithFloat() {
        var expected = new TypeFloat(aFloat1 + binaryToInt(aBinary1));
        assertEquals(expected, typeBinary1.addWithFloat(typeFloat1),
                "Method addWithFloat does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void addWithBinary() {
        var expected = new TypeBinary(addTwoBinaries(aBinary1, aBinary2));
        assertEquals(expected, typeBinary2.addWithBinary(typeBinary1),
                "Method addWithBinary does not works." + messageSeed);
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
    void subWithFloat() {
        var expected = new TypeFloat(aFloat1 - binaryToInt(aBinary1));
        assertEquals(expected, typeBinary1.subWithFloat(typeFloat1),
                "Method subWithFloat does not Works." + messageSeed);
    }

    @RepeatedTest(20)
    void subWithInt() {
        var expected = new TypeInt(anInt1 - typeBinary1.getValueAsInt());
        assertEquals(expected, typeBinary1.subWithInt(typeInt1),
                "Method subWithInt does not Works." + messageSeed);
    }

    @RepeatedTest(20)
    void subWithBinary() {
        String binary1SubtractedWithBinary2 = intToBinary(binaryToInt(aBinary1) - binaryToInt(aBinary2));
        var expected = new TypeBinary(binary1SubtractedWithBinary2);
        assertEquals(expected, typeBinary2.subWithBinary(typeBinary1),
                "Method subWithBinary does not Works." + messageSeed);
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
    void multWithFloat() {
        var expected = new TypeFloat(aFloat1 * binaryToInt(aBinary1));
        assertEquals(expected, typeBinary1.multWithFloat(typeFloat1),
                "Method multWithFloat does not Works." + messageSeed);
    }

    @RepeatedTest(20)
    void multWithInt() {
        var expected = new TypeInt(anInt1 * binaryToInt(aBinary1));
        assertEquals(expected, typeBinary1.multWithInt(typeInt1),
                "Method multWithInt does not Works." + messageSeed);
    }

    @RepeatedTest(20)
    void multWithBinary() {
        var binary2MultWithBinary1 = intToBinary(binaryToInt(aBinary2) * binaryToInt(aBinary1));
        var expected = new TypeBinary(binary2MultWithBinary1);
        assertEquals(expected, typeBinary1.multWithBinary(typeBinary2),
                "Method multWithBinary does not Works." + messageSeed);
    }

    @RepeatedTest(20)
    void div() {
        // Test division with binary
        var expectedTypeBinary = new TypeBinary(intToBinary(
                (int) Math.round((double) binaryToInt(aBinary1) / binaryToInt(aBinary2))
        ));
        assertEquals(expectedTypeBinary, typeBinary1.div(typeBinary2),
                "Method div does not works with TypeBinary." + messageSeed);
        // Test division with int
        expectedTypeBinary = new TypeBinary(intToBinary((int) Math.round((double) binaryToInt(aBinary1) / anInt1)));
        assertEquals(expectedTypeBinary, typeBinary1.div(typeInt1),
                "Method div does not works with TypeInt." + messageSeed);
    }

    @RepeatedTest(20)
    void divWithBinary() {
        var binary2DivWithBinary1 = intToBinary(
                (int) Math.round((double) binaryToInt(aBinary2) / binaryToInt(aBinary1))
        );
        var expected = new TypeBinary(binary2DivWithBinary1);
        assertEquals(expected, typeBinary1.divWithBinary(typeBinary2),
                "Method divWithBinary does not Works." + messageSeed);
    }

    @RepeatedTest(20)
    void divWithFloat() {
        var expected = new TypeFloat(aFloat1 / binaryToInt(aBinary1));
        assertEquals(expected, typeBinary1.divWithFloat(typeFloat1),
                "Method divWithFloat does not Works." + messageSeed);
    }

    @RepeatedTest(20)
    void divWithInt() {
        var intDivWithBinary1 = (int) Math.round((double) anInt1 / binaryToInt(aBinary1));
        var expected = new TypeInt(intDivWithBinary1);
        assertEquals(expected, typeBinary1.divWithInt(typeInt1),
                "Method divWithInt does not Works." + messageSeed);
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
    }

    @RepeatedTest(20)
    void andWithBool() {
        var binaryAndTrue = boolAndBinary(trueBoolean, aBinary1);
        var expected = new TypeBinary(binaryAndTrue);
        assertEquals(expected, typeBinary1.andWithBool(trueTypeBool),
                "Method andWithBool does not works with true boolean." + messageSeed);
        var binaryAndFalse = boolAndBinary(falseBoolean, aBinary1);
        expected = new TypeBinary(binaryAndFalse);
        assertEquals(expected, typeBinary1.andWithBool(falseTypeBool),
                "Method andWithBool does not works with false boolean." + messageSeed);
    }

    @RepeatedTest(20)
    void orWithBool() {
        var binaryOrTrue = boolOrBinary(trueBoolean, aBinary1);
        var expected = new TypeBinary(binaryOrTrue);
        assertEquals(expected, typeBinary1.orWithBool(trueTypeBool),
                "Method orWithBool does not works with true boolean." + messageSeed);
        var binaryOrFalse = boolOrBinary(falseBoolean, aBinary1);
        expected = new TypeBinary(binaryOrFalse);
        assertEquals(expected, typeBinary1.orWithBool(falseTypeBool),
                "Method orWithBool does not works with false boolean." + messageSeed);
    }
}