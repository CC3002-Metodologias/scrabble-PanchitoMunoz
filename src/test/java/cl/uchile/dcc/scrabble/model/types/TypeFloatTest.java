package cl.uchile.dcc.scrabble.model.types;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TypeFloatTest {
    private TypeFloat typeFloat1;
    private TypeFloat typeFloat2;
    private double aNumber1 = 3.1416;
    private double aNumber2 = 2.7183;

    @BeforeEach
    void setUp() {
        typeFloat1 = new TypeFloat(aNumber1);
        typeFloat2 = new TypeFloat(aNumber2);
    }

    @Test
    void testEquals() {
        // Test that if two numbers with the same value are equals
        TypeFloat otherTypeFloat1 = new TypeFloat(aNumber1);
        assertEquals(otherTypeFloat1, typeFloat1, "Two TypeFloats with the same value are not equals.");
        // Test that if two numbers with different values are not equal
        assertNotEquals(typeFloat1, typeFloat2, "Two TypeFloats with a different value are equals.");
    }

    @Test
    void testHashCode() {
        // Test that if two numbers with the same value have equals hash code
        TypeFloat otherTypeFloat1 = new TypeFloat(aNumber1);
        assertEquals(otherTypeFloat1.hashCode(), typeFloat1.hashCode(), "Two TypeFloats with the same value have not equals hash code.");
        // Test that if two numbers with different values have not equals hash code
        assertNotEquals(typeFloat2.hashCode(), typeFloat1.hashCode(), "Two TypeFloats with different values have equals hash code.");
    }

    @Test
    void testToString() {
        // Test that if the string representation of a number are the correct
        assertEquals("TypeFloat{value=" + aNumber1 + "}", typeFloat1.toString(), "The string representation are not the correct.");
        assertNotEquals("TypeFloat{value=" + aNumber2 + "}", typeFloat1.toString(), "The string representation are not the correct.");
    }

    @Test
    void toTypeString() {
        TypeString floatAsTypeString = new TypeString(Double.toString(aNumber1));
        TypeString otherFloatAsTypeString = new TypeString(Double.toString(aNumber2));
        assertEquals(floatAsTypeString, typeFloat1.toTypeString(), "Method toTypeString does not works.");
        assertNotEquals(otherFloatAsTypeString, typeFloat1.toTypeString(), "Method toTypeString does not works.");
    }

    @Test
    void toTypeFloat() {
        TypeFloat typeFloat = new TypeFloat(aNumber1);
        TypeFloat otherTypeFloat = new TypeFloat(aNumber2);
        assertEquals(typeFloat, typeFloat1.toTypeFloat(), "Method toTypeFloat does not works.");
        assertNotEquals(otherTypeFloat, typeFloat1.toTypeFloat(), "Method toTypeFloat does not works.");
    }
}