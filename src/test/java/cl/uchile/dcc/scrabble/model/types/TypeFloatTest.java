package cl.uchile.dcc.scrabble.model.types;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static cl.uchile.dcc.scrabble.model.utils.BinaryUtilities.binaryToInt;
import static org.junit.jupiter.api.Assertions.*;

class TypeFloatTest {
    private TypeFloat typeFloat1;
    private TypeFloat typeFloat2;
    private double aNumber1;
    private double aNumber2;
    private String messageSeed;
    private String aBinary;
    private TypeBinary aTypeBinary;
    private int anInt;
    private TypeInt aTypeInt;
    private String aString;
    private TypeString aTypeString;

    @BeforeEach
    void setUp() {
        // Initialize a random seed and a random rng
        int seed = new Random().nextInt();
        messageSeed = " Seed. " + seed;
        Random rng = new Random(seed);
        // Generate two floats random
        // Initialize the length of the interval
        int maxExponent = rng.nextInt(33); // Choose an exponent
        int maxSize = rng.nextInt((int) Math.pow(2, maxExponent)); // Choose the length of the interval
        int sgn = (int) Math.pow(-1, rng.nextInt(2));
        // Initialize two random double between -maxSize and maxSize
        aNumber1 = sgn * rng.nextDouble() * maxSize;
        do {
            if (maxSize == 0) maxSize = 1;
            sgn = (int) Math.pow(-1, rng.nextInt(2));
            aNumber2 = sgn * rng.nextDouble() * maxSize;
        } while (aNumber2 == aNumber1);
        typeFloat1 = new TypeFloat(aNumber1);
        typeFloat2 = new TypeFloat(aNumber2);
        // Generate a binary random
        int nBits = rng.nextInt(64) + 1; // Max 64 bits
        char[] characters = {'0', '1'};
        aBinary = RandomStringUtils.random(nBits, 0, 2, false,
                true, characters, rng);
        aTypeBinary = new TypeBinary(aBinary);
        // Generate an Int random
        maxSize = rng.nextInt(100) + 1;
        sgn = (int) Math.pow(-1, rng.nextInt(2));
        anInt = sgn * rng.nextInt(maxSize);
        aTypeInt = new TypeInt(anInt);
        // Generate a String Random
        int strSize = rng.nextInt(20);
        aString = RandomStringUtils.random(strSize, 0, Character.MAX_CODE_POINT,
                true, true, null, rng);
        aTypeString = new TypeString(aString);
    }

    @Test
    void getValue() {
        assertEquals(aNumber1, typeFloat1.getValue(),
                "Method getValue does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testEquals() {
        // Test that if two numbers with the same value are equals
        TypeFloat otherTypeFloat1 = new TypeFloat(aNumber1);
        assertEquals(otherTypeFloat1, typeFloat1,
                "Two TypeFloats with the same value are not equals." + messageSeed);
        // Test that if two numbers with different values are not equal
        assertNotEquals(typeFloat1, typeFloat2,
                "Two TypeFloats with a different value are equals." + messageSeed);
    }

    @RepeatedTest(20)
    void testHashCode() {
        // Test that if two numbers with the same value have equals hash code
        TypeFloat otherTypeFloat1 = new TypeFloat(aNumber1);
        assertEquals(otherTypeFloat1.hashCode(), typeFloat1.hashCode(),
                "Two TypeFloats with the same value have not equals hash code." + messageSeed);
        // Test that if two numbers with different values have not equals hash code
        assertNotEquals(typeFloat2.hashCode(), typeFloat1.hashCode(),
                "Two TypeFloats with different values have equals hash code." + messageSeed);
    }

    @RepeatedTest(20)
    void testToString() {
        // Test that if the string representation of a number are the correct
        assertEquals("TypeFloat{value=" + aNumber1 + "}", typeFloat1.toString(),
                "The string representation are not the correct." + messageSeed);
        assertNotEquals("TypeFloat{value=" + aNumber2 + "}", typeFloat1.toString(),
                "The string representation are not the correct." + messageSeed);
    }

    @RepeatedTest(20)
    void toTypeString() {
        TypeString floatAsTypeString = new TypeString(Double.toString(aNumber1));
        TypeString otherFloatAsTypeString = new TypeString(Double.toString(aNumber2));
        assertEquals(floatAsTypeString, typeFloat1.toTypeString(),
                "Method toTypeString does not works." + messageSeed);
        assertNotEquals(otherFloatAsTypeString, typeFloat1.toTypeString(),
                "Method toTypeString does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void toTypeFloat() {
        TypeFloat typeFloat = new TypeFloat(aNumber1);
        TypeFloat otherTypeFloat = new TypeFloat(aNumber2);
        assertEquals(typeFloat, typeFloat1.toTypeFloat(),
                "Method toTypeFloat does not works." + messageSeed);
        assertNotEquals(otherTypeFloat, typeFloat1.toTypeFloat(),
                "Method toTypeFloat does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void opposite() {
        double aNumberNegative1 = - aNumber1;
        TypeFloat typeFloatNegative1 = new TypeFloat(aNumberNegative1);
        assertEquals(typeFloatNegative1, typeFloat1.opposite(),
                "Method opposite does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void add() {
        // Test add with binary
        var expectedTypeFloat = new TypeFloat(aNumber1 + binaryToInt(aBinary));
        assertEquals(expectedTypeFloat, typeFloat1.add(aTypeBinary),
                "Method add does not works with typeBinary." + messageSeed);
        // Test add with float
        expectedTypeFloat = new TypeFloat(aNumber1 + aNumber2);
        assertEquals(expectedTypeFloat, typeFloat1.add(typeFloat2),
                "Method add does not works with typeFloat." + messageSeed);
        // Test add with int
        expectedTypeFloat = new TypeFloat(aNumber1 + anInt);
        assertEquals(expectedTypeFloat, typeFloat1.add(aTypeInt),
                "Method add does not works with typeInt." + messageSeed);
    }

    @RepeatedTest(20)
    void addWithString() {
        var expectedTypeString = new TypeString(aString + aNumber1);
        assertEquals(expectedTypeString, typeFloat1.addWithString(aTypeString),
                "Method addWithString does not works." + messageSeed);
    }

    @Test
    void addWithInt() {
        var expected = new TypeFloat(anInt + aNumber1);
        assertEquals(expected, typeFloat1.addWithInt(aTypeInt),
                "Method addWithInt does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void addWithFloat() {
        var expected = new TypeFloat(aNumber1 + aNumber2);
        assertEquals(expected, typeFloat2.addWithFloat(typeFloat1),
                "Method addWithFloat does not works." + messageSeed);
    }

    @Test
    void sub() {
        // Test subtraction with binary
        var expectedTypeFloat = new TypeFloat(aNumber1 - binaryToInt(aBinary));
        assertEquals(expectedTypeFloat, typeFloat1.sub(aTypeBinary),
                "Method sub does not works with TypeBinary." + messageSeed);
        // Test subtraction with float
        expectedTypeFloat = new TypeFloat(aNumber1 - aNumber2);
        assertEquals(expectedTypeFloat, typeFloat1.sub(typeFloat2),
                "Method sub does not works with TypeFloat." + messageSeed);
        // Test subtraction with int
        expectedTypeFloat = new TypeFloat(aNumber1 - anInt);
        assertEquals(expectedTypeFloat, typeFloat1.sub(aTypeInt),
                "Method sub does not works with TypeInt." + messageSeed);
    }

    @RepeatedTest(20)
    void subWithFloat() {
        var expected = new TypeFloat(aNumber2 - aNumber1);
        assertEquals(expected, typeFloat1.subWithFloat(typeFloat2),
                "Method subWithFloat does not Works." + messageSeed);
    }

    @RepeatedTest(20)
    void subWithInt() {
        var expected = new TypeFloat(anInt - aNumber1);
        assertEquals(expected, typeFloat1.subWithInt(aTypeInt),
                "Method subWithInt does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void mult() {
        // Test multiplication with binary
        var expectedTypeFloat = new TypeFloat(aNumber1 * binaryToInt(aBinary));
        assertEquals(expectedTypeFloat, typeFloat1.mult(aTypeBinary),
                "Method mult does not works with TypeBinary." + messageSeed);
        // Test multiplication with float
        expectedTypeFloat = new TypeFloat(aNumber1 * aNumber2);
        assertEquals(expectedTypeFloat, typeFloat1.mult(typeFloat2),
                "Method mult does not works with TypeFloat." + messageSeed);
        // Test multiplication with int
        expectedTypeFloat = new TypeFloat(aNumber1 * anInt);
        assertEquals(expectedTypeFloat, typeFloat1.mult(aTypeInt),
                "Method mult does not works with TypeInt." + messageSeed);
    }

    @RepeatedTest(20)
    void multWithFloat() {
        var expected = new TypeFloat(aNumber1 * aNumber2);
        assertEquals(expected, typeFloat2.multWithFloat(typeFloat1),
                "Method multWithFloat does not Works." + messageSeed);
    }

    @RepeatedTest(20)
    void multWithInt() {
        var expected = new TypeFloat(anInt * aNumber1);
        assertEquals(expected, typeFloat1.multWithInt(aTypeInt),
                "Method multWithInt does not Works." + messageSeed);
    }

    @RepeatedTest(20)
    void div() {
        // Test division with binary
        var expectedTypeFloat = new TypeFloat(aNumber1 / binaryToInt(aBinary));
        assertEquals(expectedTypeFloat, typeFloat1.div(aTypeBinary),
                "Method div does not works with TypeBinary." + messageSeed);
        // Test division with float
        expectedTypeFloat = new TypeFloat(aNumber1 / aNumber2);
        assertEquals(expectedTypeFloat, typeFloat1.div(typeFloat2),
                "Method div does not works with TypeFloat." + messageSeed);
        // Test division with int
        expectedTypeFloat = new TypeFloat(aNumber1 / anInt);
        assertEquals(expectedTypeFloat, typeFloat1.div(aTypeInt),
                "Method div does not works with TypeInt." + messageSeed);
    }

    @RepeatedTest(20)
    void divWithFloat() {
        var expected = new TypeFloat(aNumber1 / aNumber2);
        assertEquals(expected, typeFloat2.divWithFloat(typeFloat1),
                "Method divWithFloat does not Works." + messageSeed);
    }

    @RepeatedTest(20)
    void divWithInt() {
        var expected = new TypeFloat(anInt / aNumber1);
        assertEquals(expected, typeFloat1.divWithInt(aTypeInt),
                "Method divWithInt does not Works." + messageSeed);
    }
}