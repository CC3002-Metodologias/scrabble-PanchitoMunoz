package cl.uchile.dcc.scrabble.model.types;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import java.util.Random;

import static cl.uchile.dcc.scrabble.model.utils.BinaryUtilities.*;
import static org.junit.jupiter.api.Assertions.*;

class TypeIntTest {
    private TypeInt typeInt1;
    private TypeInt typeInt2;
    private int aNumber1;
    private int aNumber2;
    private String messageSeed;

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
        var value1 = "01010"; // = 10
        var typeBinary = new TypeBinary(value1);
        var expectedTypeInt = new TypeInt(aNumber1 + 10);
        assertEquals(expectedTypeInt, typeInt1.add(typeBinary),
                "Method add does not works with typeBinary." + messageSeed);
        // Test add with float
        var value2 = 3.141592;
        var typeFloat = new TypeFloat(value2);
        var expectedTypeFloat = new TypeFloat(aNumber1 + value2);
        assertEquals(expectedTypeFloat, typeInt1.add(typeFloat),
                "Method add does not works with typeFloat." + messageSeed);
        // Test add with int
        var value3 = 42;
        var typeInt = new TypeInt(value3);
        expectedTypeInt = new TypeInt(aNumber1 + value3);
        assertEquals(expectedTypeInt, typeInt1.add(typeInt),
                "Method add does not works with typeInt." + messageSeed);
    }

    @RepeatedTest(20)
    void addWithString() {
        var aString = "Hola mundo!";
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
}