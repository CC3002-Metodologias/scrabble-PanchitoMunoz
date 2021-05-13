package cl.uchile.dcc.scrabble.model.types;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static cl.uchile.dcc.scrabble.model.utils.BinaryUtilities.*;
import static org.junit.jupiter.api.Assertions.*;

class TypeIntTest {
    private TypeInt typeInt1;
    private TypeInt typeInt2;
    private int aNumber1;
    private int aNumber2;
    private String messageSeed;
    private String aBinary;
    private TypeBinary aTypeBinary;
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
        // Generate two Ints random
        // Initialize the length of the number
        int maxExponent = rng.nextInt(33);
        int sgn = (int) Math.pow(-1, rng.nextInt(2));
        aNumber1 = sgn * rng.nextInt((int) Math.pow(2, maxExponent));
        do {
            if (maxExponent == 0) maxExponent = 1;
            sgn = (int) Math.pow(-1, rng.nextInt(2));
            aNumber2 = sgn * rng.nextInt((int) Math.pow(2, maxExponent));
        } while (aNumber2 == aNumber1);
        typeInt1 = new TypeInt(aNumber1);
        typeInt2 = new TypeInt(aNumber2);
        // Generate a binary random
        int nBits = rng.nextInt(64) + 1; // Max 64 bits
        char[] characters = {'0', '1'};
        aBinary = RandomStringUtils.random(nBits, 0, 2, false,
                true, characters, rng);
        aTypeBinary = new TypeBinary(aBinary);
        // Generate a float random
        maxExponent = rng.nextInt(33);
        int maxSize = rng.nextInt((int) Math.pow(2, maxExponent));
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
        assertEquals(aNumber1, typeInt1.getValue(),
                "Method getValue does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testEquals() {
        TypeInt otherTypeInt1 = new TypeInt(aNumber1);
        assertEquals(otherTypeInt1, typeInt1,
                "Two TypeInts with the same value are different." + messageSeed);
        assertNotEquals(typeInt2, typeInt1,
                "Two TypeInts with different values are equals." + messageSeed);
    }

    @RepeatedTest(20)
    void testHashCode() {
        TypeInt otherTypeInt1 = new TypeInt(aNumber1);
        assertEquals(otherTypeInt1.hashCode(), typeInt1.hashCode(),
                "Two TypeInts with the same value have different hash code." + messageSeed);
        assertNotEquals(typeInt2.hashCode(), typeInt1.hashCode(),
                "Two TypeInts with different values have equals hash code." + messageSeed);
    }

    @RepeatedTest(20)
    void testToString() {
        assertEquals("TypeInt{value=" + aNumber1 + "}", typeInt1.toString(),
                "Method toString does not works." + messageSeed);
        assertNotEquals("TypeInt{value=" + aNumber2 + "}", typeInt1.toString(),
                "Method toString does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void toTypeString() {
        TypeString typeIntAsTypeString = new TypeString(Integer.toString(aNumber1));
        assertEquals(typeIntAsTypeString, typeInt1.toTypeString(),
                "Method toTypeString does not works." + messageSeed);
        assertNotEquals(typeIntAsTypeString, typeInt2.toTypeString(),
                "Method toTypeString does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void toTypeFloat() {
        TypeFloat typeIntAsTypeFloat = new TypeFloat(aNumber1);
        assertEquals(typeIntAsTypeFloat, typeInt1.toTypeFloat(),
                "Method toTypeFloat does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void toTypeInt() {
        TypeInt otherTypeInt1 = new TypeInt(aNumber1);
        assertEquals(otherTypeInt1, typeInt1.toTypeInt(),
                "Method toTypeInt does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void toTypeBinary() {
        String aBinary1 = intToBinary(aNumber1);
        TypeBinary anIntAsBinary = new TypeBinary(aBinary1);
        assertEquals(anIntAsBinary, typeInt1.toTypeBinary(),
                "Method toTypeBinary does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void opposite() {
        int aNumberNegative1 = -aNumber1;
        TypeInt typeIntNegative1 = new TypeInt(aNumberNegative1);
        assertEquals(typeIntNegative1, typeInt1.opposite(),
                "Method opposite does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void add() {
        // Test add with binary
        var expectedTypeInt = new TypeInt(aNumber1 + binaryToInt(aBinary));
        assertEquals(expectedTypeInt, typeInt1.add(aTypeBinary),
                "Method add does not works with TypeBinary." + messageSeed);
        // Test add with float
        var expectedTypeFloat = new TypeFloat(aNumber1 + aFloat);
        assertEquals(expectedTypeFloat, typeInt1.add(aTypeFloat),
                "Method add does not works with TypeFloat." + messageSeed);
        // Test add with int
        expectedTypeInt = new TypeInt(aNumber1 + aNumber2);
        assertEquals(expectedTypeInt, typeInt1.add(typeInt2),
                "Method add does not works with TypeInt." + messageSeed);
    }

    @RepeatedTest(20)
    void addWithString() {
        var expectedTypeString = new TypeString(aString + aNumber1);
        assertEquals(expectedTypeString, typeInt1.addWithString(aTypeString),
                "Method addWithString does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void addWithInt() {
        var expectedTypeInt = new TypeInt(aNumber1 + aNumber2);
        assertEquals(expectedTypeInt, typeInt2.addWithInt(typeInt1),
                "Method addWithInt does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void addWithFloat() {
        var expected = new TypeFloat(aFloat + aNumber1);
        assertEquals(expected, typeInt1.addWithFloat(aTypeFloat),
                "Method addWithFloat does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void addWithBinary() {
        var expected = new TypeBinary(intToBinary(aNumber1 + binaryToInt(aBinary)));
        assertEquals(expected, typeInt1.addWithBinary(aTypeBinary),
                "Method addWithBinary does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void sub() {
        // Test subtraction with binary
        var expectedTypeInt = new TypeInt(aNumber1 - binaryToInt(aBinary));
        assertEquals(expectedTypeInt, typeInt1.sub(aTypeBinary),
                "Method sub does not works with TypeBinary." + messageSeed);
        // Test subtraction with float
        var expectedTypeFloat = new TypeFloat(aNumber1 - aFloat);
        assertEquals(expectedTypeFloat, typeInt1.sub(aTypeFloat),
                "Method sub does not works with TypeFloat." + messageSeed);
        // Test subtraction with int
        expectedTypeInt = new TypeInt(aNumber1 - aNumber2);
        assertEquals(expectedTypeInt, typeInt1.sub(typeInt2),
                "Method sub does not works with TypeInt." + messageSeed);
    }

    @RepeatedTest(20)
    void subWithFloat() {
        var expected = new TypeFloat(aFloat - aNumber1);
        assertEquals(expected, typeInt1.subWithFloat(aTypeFloat),
                "Method subWithFloat does not Works." + messageSeed);
    }

    @RepeatedTest(20)
    void subWithInt() {
        var expected = new TypeInt(aNumber2 - aNumber1);
        assertEquals(expected, typeInt1.subWithInt(typeInt2),
                "Method subWithInt does not Works." + messageSeed);
    }

    @RepeatedTest(20)
    void subWithBinary() {
        var binary1SubtractedWithInt = intToBinary(binaryToInt(aBinary) - aNumber1);
        var expected = new TypeBinary(binary1SubtractedWithInt);
        assertEquals(expected, typeInt1.subWithBinary(aTypeBinary),
                "Method subWithBinary does not Works." + messageSeed);
    }

    @RepeatedTest(20)
    void mult() {
    }

    @RepeatedTest(20)
    void multWithFloat() {
        var expected = new TypeFloat(aFloat * aNumber1);
        assertEquals(expected, typeInt1.multWithFloat(aTypeFloat),
                "Method multWithFloat does not Works." + messageSeed);
    }
}