package cl.uchile.dcc.scrabble.model.types;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class TypeFloatTest {
    private TypeFloat typeFloat1;
    private TypeFloat typeFloat2;
    private double aNumber1;
    private double aNumber2;
    private String messageSeed;

    @BeforeEach
    void setUp() {
        // Initialize a random seed and a random rng
        int seed = new Random().nextInt();
        messageSeed = " Seed. " + seed;
        Random rng = new Random(seed);
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
    void addWithString() {
        var aString = "Hola mundo!";
        var aTypeString = new TypeString(aString);
        var expectedTypeString = new TypeString(aString + aNumber1);
        assertEquals(expectedTypeString, typeFloat1.addWithString(aTypeString),
                "Method addWithString does not works." + messageSeed);
    }

    @Test
    void addWithInt() {
        var anInt = 42;
        var aTypeInt = new TypeInt(anInt);
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

    @RepeatedTest(20)
    void add() {
        // Test add with binary
        var value1 = "01010"; // = 10
        var typeBinary = new TypeBinary(value1);
        var expectedTypeFloat = new TypeFloat(aNumber1 + 10);
        assertEquals(expectedTypeFloat, typeFloat1.add(typeBinary),
                "Method add does not works with typeBinary." + messageSeed);
        // Test add with float
        var value2 = 3.141592;
        var typeFloat = new TypeFloat(value2);
        expectedTypeFloat = new TypeFloat(aNumber1 + value2);
        assertEquals(expectedTypeFloat, typeFloat1.add(typeFloat),
                "Method add does not works with typeFloat." + messageSeed);
        // Test add with int
        var value3 = 42;
        var typeInt = new TypeInt(value3);
        expectedTypeFloat = new TypeFloat(aNumber1 + value3);
        assertEquals(expectedTypeFloat, typeFloat1.add(typeInt),
                "Method add does not works with typeInt." + messageSeed);
    }
}