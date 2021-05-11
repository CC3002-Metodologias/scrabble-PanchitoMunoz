package cl.uchile.dcc.scrabble.model.types;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TypeBoolTest {
    private TypeBool trueTypeBool;
    private TypeBool falseTypeBool;
    private final Boolean trueBoolean = true;
    private final Boolean falseBoolean = false;

    @BeforeEach
    void setUp() {
        trueTypeBool = new TypeBool(trueBoolean);
        falseTypeBool = new TypeBool(falseBoolean);
    }

    @Test
    void testEquals() {
        TypeBool otherTrueTypeBool = new TypeBool(trueBoolean);
        TypeBool otherFalseTypeBool = new TypeBool(falseBoolean);
        assertEquals(otherTrueTypeBool, trueTypeBool, "Same instances are not equals.");
        assertEquals(otherFalseTypeBool, falseTypeBool, "Same instances are not equals.");
        assertNotEquals(trueTypeBool, falseTypeBool, "Different instances are equals");
    }

    @Test
    void testHashCode() {
        TypeBool otherTrueTypeBool = new TypeBool(trueBoolean);
        TypeBool otherFalseTypeBool = new TypeBool(falseBoolean);
        assertEquals(otherTrueTypeBool.hashCode(), trueTypeBool.hashCode(),
                "Hash Codes are not equals.");
        assertEquals(otherFalseTypeBool.hashCode(), falseTypeBool.hashCode(),
                "Hash Codes are not equals.");
        assertNotEquals(trueTypeBool.hashCode(), falseTypeBool.hashCode(),
                "Hash Codes of different instances are equals.");
    }

    @Test
    void testToString() {
        assertEquals("TypeBool{value=true}", trueTypeBool.toString(),
                "toString method does not work with true.");
        assertEquals("TypeBool{value=false}", falseTypeBool.toString(),
                "toString method does not work with false.");
    }

    @Test
    void toTypeString() {
        TypeString trueTypeString = new TypeString(Boolean.toString(trueBoolean));
        TypeString falseTypeString = new TypeString(Boolean.toString(falseBoolean));
        // Case equals
        assertEquals(trueTypeString, trueTypeBool.toTypeString(),
                "The method toTypeString does not works.");
        assertEquals(falseTypeString, falseTypeBool.toTypeString(),
                "The method toTypeString does not works.");
        // Case not equals
        assertNotEquals(falseTypeString, trueTypeBool.toTypeString(),
                "The method toTypeString does not works.");
        assertNotEquals(trueTypeString, falseTypeBool.toTypeString(),
                "The method toTypeString does not works.");
    }

    @Test
    void toTypeBool() {
        TypeBool otherTrueTypeBool = new TypeBool(trueBoolean);
        TypeBool otherFalseTypeBool = new TypeBool(falseBoolean);
        assertEquals(otherTrueTypeBool, trueTypeBool.toTypeBool(),
                "The method toTypeBool does not works with true.");
        assertEquals(otherFalseTypeBool, falseTypeBool.toTypeBool(),
                "The method toTypeBool does not works with false.");
        assertNotEquals(otherFalseTypeBool, trueTypeBool.toTypeBool(),
                "The method toTypeBool does not works with different values.");
        assertNotEquals(otherTrueTypeBool, falseTypeBool.toTypeBool(),
                "The method toTypeBool does not works with different values.");
    }

    @Test
    void opposite() {
        assertEquals(falseTypeBool, trueTypeBool.opposite(),
                "Method opposite does not works with true.");
        assertEquals(trueTypeBool, falseTypeBool.opposite(),
                "Method opposite does not works with false.");
    }
}