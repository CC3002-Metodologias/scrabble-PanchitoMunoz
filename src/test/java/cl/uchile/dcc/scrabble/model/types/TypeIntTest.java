package cl.uchile.dcc.scrabble.model.types;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TypeIntTest {
    private TypeInt typeInt1;
    private TypeInt typeInt2;
    private int aNumber1;
    private int aNumber2;

    @BeforeEach
    void setUp() {
        aNumber1 = 42;
        aNumber2 = 73;
        typeInt1 = new TypeInt(aNumber1);
        typeInt2 = new TypeInt(aNumber2);
    }

    @Test
    void testEquals() {
        TypeInt otherTypeInt1 = new TypeInt(aNumber1);
        assertEquals(otherTypeInt1, typeInt1, "Two TypeInts with the same value are different.");
        assertNotEquals(typeInt2, typeInt1, "Two TypeInts with different values are equals.");
    }

    @Test
    void testHashCode() {
        TypeInt otherTypeInt1 = new TypeInt(aNumber1);
        assertEquals(otherTypeInt1.hashCode(), typeInt1.hashCode(),
                "Two TypeInts with the same value have different hash code.");
        assertNotEquals(typeInt2.hashCode(), typeInt1.hashCode(),
                "Two TypeInts with different values have equals hash code.");
    }

    @Test
    void testToString() {
        assertEquals("TypeInt{value=" + aNumber1 + "}", typeInt1.toString(),
                "Method toString does not works.");
        assertNotEquals("TypeInt{value=" + aNumber2 + "}", typeInt1.toString(),
                "Method toString does not works.");
    }

    @Test
    void toTypeString() {
        TypeString typeIntAsTypeString = new TypeString(Integer.toString(aNumber1));
        assertEquals(typeIntAsTypeString, typeInt1.toTypeString(), "Method toTypeString does not works.");
        assertNotEquals(typeIntAsTypeString, typeInt2.toTypeString(), "Method toTypeString does not works.");
    }

    @Test
    void toTypeFloat() {
        TypeFloat typeIntAsTypeFloat = new TypeFloat(aNumber1);
        assertEquals(typeIntAsTypeFloat, typeInt1.toTypeFloat(), "Method toTypeFloat does not works.");
    }

    @Test
    void toTypeInt() {
        TypeInt otherTypeInt1 = new TypeInt(aNumber1);
        assertEquals(otherTypeInt1, typeInt1.toTypeInt(), "Method toTypeInt does not works.");
    }

    @Test
    void toTypeBinary() {
        typeInt1.toTypeBinary();
    }
}