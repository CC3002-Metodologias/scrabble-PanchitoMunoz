package cl.uchile.dcc.scrabble.model.types;

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
    private final String aBinary = "01010";
    private final double aFloat = 3.141592;
    private final String aString = "Hola mundo!";

    @BeforeEach
    void setUp() {
        // Initialize a random seed and a random rng
        int seed = new Random().nextInt();
        messageSeed = " Seed: " + seed;
        Random rng = new Random(seed);
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
        var typeBinary = new TypeBinary(aBinary);
        var expectedTypeInt = new TypeInt(aNumber1 + binaryToInt(aBinary));
        assertEquals(expectedTypeInt, typeInt1.add(typeBinary),
                "Method add does not works with typeBinary." + messageSeed);
        // Test add with float
        var typeFloat = new TypeFloat(aFloat);
        var expectedTypeFloat = new TypeFloat(aNumber1 + aFloat);
        assertEquals(expectedTypeFloat, typeInt1.add(typeFloat),
                "Method add does not works with typeFloat." + messageSeed);
        // Test add with int
        var typeInt = new TypeInt(aNumber2);
        expectedTypeInt = new TypeInt(aNumber1 + aNumber2);
        assertEquals(expectedTypeInt, typeInt1.add(typeInt),
                "Method add does not works with typeInt." + messageSeed);
    }

    @RepeatedTest(20)
    void addWithString() {
        var aTypeString = new TypeString(aString);
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
        var aTypeFloat = new TypeFloat(aFloat);
        var expected = new TypeFloat(aFloat + aNumber1);
        assertEquals(expected, typeInt1.addWithFloat(aTypeFloat),
                "Method addWithFloat does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void addWithBinary() {
        var typeBinary = new TypeBinary(aBinary);
        var expected = new TypeBinary(intToBinary(aNumber1 + 10));
        assertEquals(expected, typeInt1.addWithBinary(typeBinary),
                "Method addWithBinary does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void subWithFloat() {
        var typeFloat = new TypeFloat(aFloat);
        var expected = new TypeFloat(aFloat - aNumber1);
        assertEquals(expected, typeInt1.subWithFloat(typeFloat),
                "Method subWithFloat does not Works." + messageSeed);
    }
}