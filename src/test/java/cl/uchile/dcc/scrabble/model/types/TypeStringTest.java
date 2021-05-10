package cl.uchile.dcc.scrabble.model.types;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class TypeStringTest {
    private TypeString typeString;
    private TypeString otherTypeString;
    private String aString;
    private String otherString;

    @BeforeEach
    void setUp() {
        // Initialize a random seed and a random rng
        int seed = new Random().nextInt();
        Random rng = new Random(seed);
        // Initialize a random string size
        int strSize = rng.nextInt(20);
        // Initialize random strings
        aString = RandomStringUtils.random(strSize, 0, Character.MAX_CODE_POINT, true, true, null, rng);
        do {
            if (strSize == 0) strSize = 1;
            otherString = RandomStringUtils.random(strSize, 0, Character.MAX_CODE_POINT, true, true, null, rng);
        } while (otherString.equals(aString));
        // Makes instances of TypeString
        typeString = new TypeString(aString);
        otherTypeString = new TypeString(otherString);
    }

    @RepeatedTest(20)
    void testEquals() {
        TypeString similarTypeString = new TypeString(aString);
        assertNotEquals(otherTypeString, typeString, "Two different instances are equals when it is not.");
        assertEquals(similarTypeString, typeString, "Two different instances are not equals when it is.");
    }

    @RepeatedTest(20)
    void testHashCode() {
        TypeString similarTypeString = new TypeString(aString);
        assertNotEquals(otherTypeString.hashCode(), typeString.hashCode(), "Hash Code does not work.");
        assertEquals(similarTypeString.hashCode(), typeString.hashCode(), "Hash Code does not work.");
    }

    @RepeatedTest(20)
    void testToString() {
        assertEquals("TypeString{value=" + aString + "}", typeString.toString(), "Method toString does not works.");
        assertNotEquals("TypeString{value=" + otherString + "}", typeString.toString(), "Method toString does not works.");
    }

    @RepeatedTest(20)
    void testToTypeString() {
        TypeString similarTypeString = new TypeString(aString);
        assertEquals(similarTypeString, typeString.toTypeString(), "Method toTypeString does not work.");
    }
}