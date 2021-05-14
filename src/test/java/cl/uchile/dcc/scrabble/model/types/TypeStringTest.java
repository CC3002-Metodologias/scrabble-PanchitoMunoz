package cl.uchile.dcc.scrabble.model.types;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class TypeStringTest {
    private TypeString typeString;
    private TypeString otherTypeString;
    private TypeString expectedTypeString;
    private String aString;
    private String otherString;
    private String messageSeed;
    private Random rng;

    @BeforeEach
    void setUp() {
        // Initialize a random seed and a random rng
        int seed = new Random().nextInt();
        messageSeed = " Seed: " + seed;
        rng = new Random(seed);
        // Generate two strings random
        // Initialize a random string size
        int strSize = rng.nextInt(20);
        // Initialize random strings
        aString = RandomStringUtils.random(strSize, 0, Character.MAX_CODE_POINT,
                true, true, null, rng);
        do {
            if (strSize == 0) strSize = 1;
            otherString = RandomStringUtils.random(strSize, 0, Character.MAX_CODE_POINT,
                    true, true, null, rng);
        } while (otherString.equals(aString));
        // Makes instances of TypeString
        typeString = new TypeString(aString);
        otherTypeString = new TypeString(otherString);
    }

    @RepeatedTest(20)
    void equals() {
        TypeString similarTypeString = new TypeString(aString);
        assertNotEquals(otherTypeString, typeString,
                "Two different instances are equals when it is not." + messageSeed);
        assertEquals(similarTypeString, typeString,
                "Two different instances are not equals when it is." + messageSeed);
    }

    @RepeatedTest(20)
    void TestHashCode() {
        TypeString similarTypeString = new TypeString(aString);
        assertNotEquals(otherTypeString.hashCode(), typeString.hashCode(),
                "Hash Code does not work." + messageSeed);
        assertEquals(similarTypeString.hashCode(), typeString.hashCode(),
                "Hash Code does not work." + messageSeed);
    }

    @RepeatedTest(20)
    void testToString() {
        assertEquals("TypeString{value=" + aString + "}", typeString.toString(),
                "Method toString does not works." + messageSeed);
        assertNotEquals("TypeString{value=" + otherString + "}", typeString.toString(),
                "Method toString does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void toTypeString() {
        TypeString similarTypeString = new TypeString(aString);
        assertEquals(similarTypeString, typeString.toTypeString(),
                "Method toTypeString does not work." + messageSeed);
    }

    @RepeatedTest(20)
    void addWithString() {
        expectedTypeString = new TypeString(aString + otherString);
        assertEquals(expectedTypeString, otherTypeString.addWithString(typeString),
                "Method addWithString does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void add() {
        // Test add with binary
        // Generate a binary random
        int nBits = rng.nextInt(30) + 3; // Max 32 bits, at least 3 bits to avoid pathologic cases
        char[] characters = {'0', '1'};
        var aBinary = RandomStringUtils.random(nBits, 0, 2, false,
                true, characters, rng);
        var aTypeBinary = new TypeBinary(aBinary);
        expectedTypeString = new TypeString(aString + aBinary);
        assertEquals(expectedTypeString, typeString.add(aTypeBinary),
                "Method add does not works with TypeBinary." + messageSeed);
        // Test add with bool
        var aBoolean = true;
        var aTypeBool = new TypeBool(aBoolean);
        expectedTypeString = new TypeString(aString + aBoolean);
        assertEquals(expectedTypeString, typeString.add(aTypeBool),
                "Method add does not works with TypeBool." + messageSeed);
        // Test add with float
        // Generate a float random
        int maxExponent = rng.nextInt(33);
        int maxSize = rng.nextInt((int) Math.pow(2, maxExponent));
        int sgn = (int) Math.pow(-1, rng.nextInt(2));
        var aFloat = sgn * rng.nextDouble() * maxSize;
        var aTypeFloat = new TypeFloat(aFloat);
        expectedTypeString = new TypeString(aString + aFloat);
        assertEquals(expectedTypeString, typeString.add(aTypeFloat),
                "Method add does not works with TypeFloat." + messageSeed);
        // Test add with int
        // Generate an Int random
        maxSize = rng.nextInt(100) + 1;
        sgn = (int) Math.pow(-1, rng.nextInt(2));
        var anInt = sgn * rng.nextInt(maxSize);
        var aTypeInt = new TypeInt(anInt);
        expectedTypeString = new TypeString(aString + anInt);
        assertEquals(expectedTypeString, typeString.add(aTypeInt),
                "Method add does not works with TypeInt." + messageSeed);
        // Test add with string
        expectedTypeString = new TypeString(aString + otherString);
        assertEquals(expectedTypeString, typeString.add(otherTypeString),
                "Method add does not works with TypeString." + messageSeed);
    }
}