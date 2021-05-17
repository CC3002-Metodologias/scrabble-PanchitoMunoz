package cl.uchile.dcc.scrabble.model.types;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.*;

class TypeStringTest extends BaseTypeTest {
    private TypeString expectedTypeString;

    @BeforeEach
    void setUp() {
        super.setUp();
    }

    @RepeatedTest(20)
    void equals() {
        TypeString similarTypeString = new TypeString(aString1);
        assertNotEquals(typeString2, typeString1,
                "Two different instances are equals when it is not." + messageSeed);
        assertEquals(similarTypeString, typeString1,
                "Two different instances are not equals when it is." + messageSeed);
    }

    @RepeatedTest(20)
    void TestHashCode() {
        TypeString similarTypeString = new TypeString(aString1);
        assertNotEquals(typeString2.hashCode(), typeString1.hashCode(),
                "Hash Code does not work." + messageSeed);
        assertEquals(similarTypeString.hashCode(), typeString1.hashCode(),
                "Hash Code does not work." + messageSeed);
    }

    @RepeatedTest(20)
    void testToString() {
        assertEquals("TypeString{value='" + aString1 + "'}", typeString1.toString(),
                "Method toString does not works." + messageSeed);
        assertNotEquals("TypeString{value='" + aString2 + "'}", typeString1.toString(),
                "Method toString does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void toTypeString() {
        TypeString similarTypeString = new TypeString(aString1);
        assertEquals(similarTypeString, typeString1.toTypeString(),
                "Method toTypeString does not work." + messageSeed);
    }

    @RepeatedTest(20)
    void addWithString() {
        expectedTypeString = new TypeString(aString1 + aString2);
        assertEquals(expectedTypeString, typeString2.addWithString(typeString1),
                "Method addWithString does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void add() {
        // Test add with binary
        expectedTypeString = new TypeString(aString1 + aBinary1);
        assertEquals(expectedTypeString, typeString1.add(typeBinary1),
                "Method add does not works with TypeBinary." + messageSeed);
        // Test add with boolean
        expectedTypeString = new TypeString(aString1 + trueBoolean);
        assertEquals(expectedTypeString, typeString1.add(trueTypeBool),
                "Method add does not works with TypeBool." + messageSeed);
        // Test add with float
        expectedTypeString = new TypeString(aString1 + aFloat1);
        assertEquals(expectedTypeString, typeString1.add(typeFloat1),
                "Method add does not works with TypeFloat." + messageSeed);
        // Test add with int
        expectedTypeString = new TypeString(aString1 + anInt1);
        assertEquals(expectedTypeString, typeString1.add(typeInt1),
                "Method add does not works with TypeInt." + messageSeed);
        // Test add with string
        expectedTypeString = new TypeString(aString1 + aString2);
        assertEquals(expectedTypeString, typeString1.add(typeString2),
                "Method add does not works with TypeString." + messageSeed);
    }
}