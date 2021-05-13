package cl.uchile.dcc.scrabble.model.types;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static cl.uchile.dcc.scrabble.model.utils.BinaryUtilities.*;

class TypeBinaryTest {
    private TypeBinary typeBinary1;
    private TypeBinary typeBinary2;
    private String aBinary1;
    private String aBinary2;
    private String messageSeed;
    private int anInt;
    private TypeInt aTypeInt;
    private double aFloat;
    private TypeFloat aTypeFloat;
    private String aString;
    private TypeString aTypeString;

    @BeforeEach
    void setUp() {
        // Initialize a random seed and a random rng
        int seed = new Random().nextInt();
        messageSeed = " Seed: " + seed;
        Random rng = new Random(seed);
        // Generate 2 binaries random
        int nBits = rng.nextInt(64) + 1; // Max 64 bits
        char[] characters = {'0', '1'};
        aBinary1 = RandomStringUtils.random(nBits, 0, 2, false,
                true, characters, rng);
        do {
            aBinary2 = RandomStringUtils.random(nBits, 0, 2, false,
                    true, characters, rng);
        } while (aBinary2.equals(aBinary1));
        typeBinary1 = new TypeBinary(aBinary1);
        typeBinary2 = new TypeBinary(aBinary2);
        // Generate an Int random
        int maxSize = rng.nextInt(100) + 1;
        int sgn = (int) Math.pow(-1, rng.nextInt(2));
        anInt = sgn * rng.nextInt(maxSize);
        aTypeInt = new TypeInt(anInt);
        // Generate a float random
        int maxExponent = rng.nextInt(33);
        maxSize = rng.nextInt((int) Math.pow(2, maxExponent));
        sgn = (int) Math.pow(-1, rng.nextInt(2));
        aFloat = sgn * rng.nextDouble() * maxSize;
        aTypeFloat = new TypeFloat(aFloat);
        // Generate a String Random
        int strSize = rng.nextInt(20);
        aString = RandomStringUtils.random(strSize, 0, Character.MAX_CODE_POINT,
                true, true, null, rng);
        aTypeString = new TypeString(aString);
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
    void opposite() {
        // Changing each 1 for 0 and each 0 for 1 is equivalent to applying one complement.
        String aBinaryNegative1 = oneComplement(aBinary1);
        TypeBinary typeBinaryNegative1 = new TypeBinary(aBinaryNegative1);
        assertEquals(typeBinaryNegative1, typeBinary1.opposite(),
                "Method opposite does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void add() {
        // Test add with binary
        var expected = new TypeBinary(addTwoBinaries(aBinary1, aBinary2));
        assertEquals(expected, typeBinary1.add(typeBinary2),
                "Method add does not works with TypeBinary." + messageSeed);
        // Test add with int
        expected = new TypeBinary(addTwoBinaries(aBinary1, intToBinary(anInt)));
        assertEquals(expected, typeBinary1.add(aTypeInt),
                "Method add does not works with TypeInt." + messageSeed);
    }

    @RepeatedTest(20)
    void addWithString() {
        var expectedTypeString = new TypeString(aString + aBinary1);
        assertEquals(expectedTypeString, typeBinary1.addWithString(aTypeString),
                "Method addWithString does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void addWithInt() {
        var expected = new TypeInt(anInt + binaryToInt(aBinary1));
        assertEquals(expected, typeBinary1.addWithInt(aTypeInt),
                "Method addWithInt does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void addWithFloat() {
        var expected = new TypeFloat(aFloat + binaryToInt(aBinary1));
        assertEquals(expected, typeBinary1.addWithFloat(aTypeFloat),
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
        expected = new TypeBinary(intToBinary(binaryToInt(aBinary1) - anInt));
        assertEquals(expected, typeBinary1.sub(aTypeInt),
                "Method sub does not works with TypeInt." + messageSeed);
    }

    @RepeatedTest(20)
    void subWithFloat() {
        var expected = new TypeFloat(aFloat - binaryToInt(aBinary1));
        assertEquals(expected, typeBinary1.subWithFloat(aTypeFloat),
                "Method subWithFloat does not Works." + messageSeed);
    }

    @RepeatedTest(20)
    void subWithInt() {
        var expected = new TypeInt(anInt - typeBinary1.getValueAsInt());
        assertEquals(expected, typeBinary1.subWithInt(aTypeInt),
                "Method subWithInt does not Works." + messageSeed);
    }

    @RepeatedTest(20)
    void subWithBinary() {
        String binary1SubtractedWithBinary2 = intToBinary(binaryToInt(aBinary1) - binaryToInt(aBinary2));
        var expected = new TypeBinary(binary1SubtractedWithBinary2);
        assertEquals(expected, typeBinary2.subWithBinary(typeBinary1),
                "Method subWithBinary does not Works." + messageSeed);
    }
}