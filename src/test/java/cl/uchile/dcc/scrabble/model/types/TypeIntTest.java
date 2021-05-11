package cl.uchile.dcc.scrabble.model.types;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class TypeIntTest {
    private TypeInt typeInt1;
    private TypeInt typeInt2;
    private int aNumber1;
    private int aNumber2;

    @BeforeEach
    void setUp() {
        // Initialize a random seed and a random rng
        int seed = new Random().nextInt();
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
                "Two TypeInts with the same value are different.");
        assertNotEquals(typeInt2, typeInt1,
                "Two TypeInts with different values are equals.");
    }

    @RepeatedTest(20)
    void testHashCode() {
        TypeInt otherTypeInt1 = new TypeInt(aNumber1);
        assertEquals(otherTypeInt1.hashCode(), typeInt1.hashCode(),
                "Two TypeInts with the same value have different hash code.");
        assertNotEquals(typeInt2.hashCode(), typeInt1.hashCode(),
                "Two TypeInts with different values have equals hash code.");
    }

    @RepeatedTest(20)
    void testToString() {
        assertEquals("TypeInt{value=" + aNumber1 + "}", typeInt1.toString(),
                "Method toString does not works.");
        assertNotEquals("TypeInt{value=" + aNumber2 + "}", typeInt1.toString(),
                "Method toString does not works.");
    }

    @RepeatedTest(20)
    void toTypeString() {
        TypeString typeIntAsTypeString = new TypeString(Integer.toString(aNumber1));
        assertEquals(typeIntAsTypeString, typeInt1.toTypeString(),
                "Method toTypeString does not works.");
        assertNotEquals(typeIntAsTypeString, typeInt2.toTypeString(),
                "Method toTypeString does not works.");
    }

    @RepeatedTest(20)
    void toTypeFloat() {
        TypeFloat typeIntAsTypeFloat = new TypeFloat(aNumber1);
        assertEquals(typeIntAsTypeFloat, typeInt1.toTypeFloat(),
                "Method toTypeFloat does not works.");
    }

    @RepeatedTest(20)
    void toTypeInt() {
        TypeInt otherTypeInt1 = new TypeInt(aNumber1);
        assertEquals(otherTypeInt1, typeInt1.toTypeInt(), "Method toTypeInt does not works.");
    }

    @RepeatedTest(20)
    void toTypeBinary() {
        typeInt1.toTypeBinary();
    }
}