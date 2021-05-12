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

    @BeforeEach
    void setUp() {
        // Initialize a random seed and a random rng
        int seed = new Random().nextInt();
        messageSeed = " Seed: " + seed;
        Random rng = new Random(seed);
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
        var value1 = "0110";
        var typeBinary = new TypeBinary(value1);
        expectedTypeString = new TypeString(aString + value1);
        assertEquals(expectedTypeString, typeString.add(typeBinary),
                "Method add does not works with typeBinary." + messageSeed);
        // Test add with bool
        var value2 = true;
        var typeBool = new TypeBool(value2);
        expectedTypeString = new TypeString(aString + value2);
        assertEquals(expectedTypeString, typeString.add(typeBool),
                "Method add does not works with typeBool." + messageSeed);
        // Test add with float
        var value3 = 3.141592;
        var typeFloat = new TypeFloat(value3);
        expectedTypeString = new TypeString(aString + value3);
        assertEquals(expectedTypeString, typeString.add(typeFloat),
                "Method add does not works with typeFloat." + messageSeed);
        // Test add with int
        var value4 = 3;
        var typeInt = new TypeInt(value4);
        expectedTypeString = new TypeString(aString + value4);
        assertEquals(expectedTypeString, typeString.add(typeInt),
                "Method add does not works with typeInt." + messageSeed);
        // Test add with string
        expectedTypeString = new TypeString(aString + otherString);
        assertEquals(expectedTypeString, typeString.add(otherTypeString),
                "Method add does not works with typeString." + messageSeed);
    }
}