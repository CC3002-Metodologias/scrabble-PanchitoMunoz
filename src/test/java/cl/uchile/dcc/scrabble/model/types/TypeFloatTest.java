package cl.uchile.dcc.scrabble.model.types;

import static cl.uchile.dcc.scrabble.model.utils.BinaryUtilities.binaryToInt;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class TypeFloatTest extends BaseTypeTest {

    @BeforeEach
    protected void setUp() {
        super.setUp();
    }

    @AfterEach
    protected void tearDown() {
        super.tearDown();
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
    void div() {
        if (typeBinary1.getValueAsInt() != 0) {
            // Test division with binary
            var expectedTypeFloat = new TypeFloat(aFloat1 / binaryToInt(aBinary1));
            assertEquals(expectedTypeFloat, typeFloat1.div(typeBinary1),
                    "Method div does not works with TypeBinary." + messageSeed);
        }
        if (aFloat2 != 0.0) {
            // Test division with float
            var expectedTypeFloat = new TypeFloat(aFloat1 / aFloat2);
            assertEquals(expectedTypeFloat, typeFloat1.div(typeFloat2),
                    "Method div does not works with TypeFloat." + messageSeed);
        }
        if (anInt1 != 0) {
            // Test division with int
            var expectedTypeFloat = new TypeFloat(aFloat1 / anInt1);
            assertEquals(expectedTypeFloat, typeFloat1.div(typeInt1),
                    "Method div does not works with TypeInt." + messageSeed);
        }
    }
}