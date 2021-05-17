package cl.uchile.dcc.scrabble.model.types;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static cl.uchile.dcc.scrabble.model.utils.BinaryUtilities.binaryToInt;
import static org.junit.jupiter.api.Assertions.*;

class TypeFloatTest extends BaseTypeTest {

    @BeforeEach
    void setUp() {
        super.setUp();
    }

    @Test
    void getValue() {
        assertEquals(aFloat1, typeFloat1.getValue(),
                "Method getValue does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testEquals() {
        // Test that if two numbers with the same value are equals
        TypeFloat otherTypeFloat1 = new TypeFloat(aFloat1);
        assertEquals(otherTypeFloat1, typeFloat1,
                "Two TypeFloats with the same value are not equals." + messageSeed);
        // Test that if two numbers with different values are not equal
        assertNotEquals(typeFloat1, typeFloat2,
                "Two TypeFloats with a different value are equals." + messageSeed);
    }

    @RepeatedTest(20)
    void testHashCode() {
        // Test that if two numbers with the same value have equals hash code
        TypeFloat otherTypeFloat1 = new TypeFloat(aFloat1);
        assertEquals(otherTypeFloat1.hashCode(), typeFloat1.hashCode(),
                "Two TypeFloats with the same value have not equals hash code." + messageSeed);
        // Test that if two numbers with different values have not equals hash code
        assertNotEquals(typeFloat2.hashCode(), typeFloat1.hashCode(),
                "Two TypeFloats with different values have equals hash code." + messageSeed);
    }

    @RepeatedTest(20)
    void testToString() {
        // Test that if the string representation of a number are the correct
        assertEquals("TypeFloat{value=" + aFloat1 + "}", typeFloat1.toString(),
                "The string representation are not the correct." + messageSeed);
        assertNotEquals("TypeFloat{value=" + aFloat2 + "}", typeFloat1.toString(),
                "The string representation are not the correct." + messageSeed);
    }

    @RepeatedTest(20)
    void toTypeString() {
        TypeString floatAsTypeString = new TypeString(Double.toString(aFloat1));
        TypeString otherFloatAsTypeString = new TypeString(Double.toString(aFloat2));
        assertEquals(floatAsTypeString, typeFloat1.toTypeString(),
                "Method toTypeString does not works." + messageSeed);
        assertNotEquals(otherFloatAsTypeString, typeFloat1.toTypeString(),
                "Method toTypeString does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void toTypeFloat() {
        TypeFloat typeFloat = new TypeFloat(aFloat1);
        TypeFloat otherTypeFloat = new TypeFloat(aFloat2);
        assertEquals(typeFloat, typeFloat1.toTypeFloat(),
                "Method toTypeFloat does not works." + messageSeed);
        assertNotEquals(otherTypeFloat, typeFloat1.toTypeFloat(),
                "Method toTypeFloat does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void add() {
        // Test add with binary
        var expectedTypeFloat = new TypeFloat(aFloat1 + binaryToInt(aBinary1));
        assertEquals(expectedTypeFloat, typeFloat1.add(typeBinary1),
                "Method add does not works with typeBinary." + messageSeed);
        // Test add with float
        expectedTypeFloat = new TypeFloat(aFloat1 + aFloat2);
        assertEquals(expectedTypeFloat, typeFloat1.add(typeFloat2),
                "Method add does not works with typeFloat." + messageSeed);
        // Test add with int
        expectedTypeFloat = new TypeFloat(aFloat1 + anInt1);
        assertEquals(expectedTypeFloat, typeFloat1.add(typeInt1),
                "Method add does not works with typeInt." + messageSeed);
    }

    @RepeatedTest(20)
    void addWithString() {
        var expectedTypeString = new TypeString(aString1 + aFloat1);
        assertEquals(expectedTypeString, typeFloat1.addWithString(typeString1),
                "Method addWithString does not works." + messageSeed);
    }

    @Test
    void addWithInt() {
        var expected = new TypeFloat(anInt1 + aFloat1);
        assertEquals(expected, typeFloat1.addWithInt(typeInt1),
                "Method addWithInt does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void addWithFloat() {
        var expected = new TypeFloat(aFloat1 + aFloat2);
        assertEquals(expected, typeFloat2.addWithFloat(typeFloat1),
                "Method addWithFloat does not works." + messageSeed);
    }

    @Test
    void sub() {
        // Test subtraction with binary
        var expectedTypeFloat = new TypeFloat(aFloat1 - binaryToInt(aBinary1));
        assertEquals(expectedTypeFloat, typeFloat1.sub(typeBinary1),
                "Method sub does not works with TypeBinary." + messageSeed);
        // Test subtraction with float
        expectedTypeFloat = new TypeFloat(aFloat1 - aFloat2);
        assertEquals(expectedTypeFloat, typeFloat1.sub(typeFloat2),
                "Method sub does not works with TypeFloat." + messageSeed);
        // Test subtraction with int
        expectedTypeFloat = new TypeFloat(aFloat1 - anInt1);
        assertEquals(expectedTypeFloat, typeFloat1.sub(typeInt1),
                "Method sub does not works with TypeInt." + messageSeed);
    }

    @RepeatedTest(20)
    void subWithFloat() {
        var expected = new TypeFloat(aFloat2 - aFloat1);
        assertEquals(expected, typeFloat1.subWithFloat(typeFloat2),
                "Method subWithFloat does not Works." + messageSeed);
    }

    @RepeatedTest(20)
    void subWithInt() {
        var expected = new TypeFloat(anInt1 - aFloat1);
        assertEquals(expected, typeFloat1.subWithInt(typeInt1),
                "Method subWithInt does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void mult() {
        // Test multiplication with binary
        var expectedTypeFloat = new TypeFloat(aFloat1 * binaryToInt(aBinary1));
        assertEquals(expectedTypeFloat, typeFloat1.mult(typeBinary1),
                "Method mult does not works with TypeBinary." + messageSeed);
        // Test multiplication with float
        expectedTypeFloat = new TypeFloat(aFloat1 * aFloat2);
        assertEquals(expectedTypeFloat, typeFloat1.mult(typeFloat2),
                "Method mult does not works with TypeFloat." + messageSeed);
        // Test multiplication with int
        expectedTypeFloat = new TypeFloat(aFloat1 * anInt1);
        assertEquals(expectedTypeFloat, typeFloat1.mult(typeInt1),
                "Method mult does not works with TypeInt." + messageSeed);
    }

    @RepeatedTest(20)
    void multWithFloat() {
        var expected = new TypeFloat(aFloat1 * aFloat2);
        assertEquals(expected, typeFloat2.multWithFloat(typeFloat1),
                "Method multWithFloat does not Works." + messageSeed);
    }

    @RepeatedTest(20)
    void multWithInt() {
        var expected = new TypeFloat(anInt1 * aFloat1);
        assertEquals(expected, typeFloat1.multWithInt(typeInt1),
                "Method multWithInt does not Works." + messageSeed);
    }

    @RepeatedTest(20)
    void div() {
        // Test division with binary
        var expectedTypeFloat = new TypeFloat(aFloat1 / binaryToInt(aBinary1));
        assertEquals(expectedTypeFloat, typeFloat1.div(typeBinary1),
                "Method div does not works with TypeBinary." + messageSeed);
        // Test division with float
        expectedTypeFloat = new TypeFloat(aFloat1 / aFloat2);
        assertEquals(expectedTypeFloat, typeFloat1.div(typeFloat2),
                "Method div does not works with TypeFloat." + messageSeed);
        // Test division with int
        expectedTypeFloat = new TypeFloat(aFloat1 / anInt1);
        assertEquals(expectedTypeFloat, typeFloat1.div(typeInt1),
                "Method div does not works with TypeInt." + messageSeed);
    }

    @RepeatedTest(20)
    void divWithFloat() {
        var expected = new TypeFloat(aFloat1 / aFloat2);
        assertEquals(expected, typeFloat2.divWithFloat(typeFloat1),
                "Method divWithFloat does not Works." + messageSeed);
    }

    @RepeatedTest(20)
    void divWithInt() {
        var expected = new TypeFloat(anInt1 / aFloat1);
        assertEquals(expected, typeFloat1.divWithInt(typeInt1),
                "Method divWithInt does not Works." + messageSeed);
    }
}