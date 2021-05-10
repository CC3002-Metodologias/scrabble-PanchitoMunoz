package cl.uchile.dcc.scrabble.model.types;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
        assertEquals(otherTrueTypeBool, trueTypeBool, "Same object are not equals.");
        assertEquals(otherFalseTypeBool, falseTypeBool, "Same objects are not equals.");
    }

    @Test
    void testHashCode() {
        TypeBool otherTrueTypeBool = new TypeBool(trueBoolean);
        TypeBool otherFalseTypeBool = new TypeBool(falseBoolean);
        assertEquals(otherTrueTypeBool.hashCode(), trueTypeBool.hashCode(), "Hash Codes are not equals.");
        assertEquals(otherFalseTypeBool.hashCode(), falseTypeBool.hashCode(), "Hash Codes are not equals.");
    }

    @Test
    void testToString() {
        assertEquals("TypeBool{value=true}", trueTypeBool.toString(), "toString method does not work with true.");
        assertEquals("TypeBool{value=false}", falseTypeBool.toString(), "toString method does not work with false.");
    }

    @Test
    void toTypeString() {
        TypeString trueTypeString = new TypeString(Boolean.toString(trueBoolean));
        TypeString falseTypeString = new TypeString(Boolean.toString(falseBoolean));
        // Case equals
        assertEquals(trueTypeString, trueTypeBool.toTypeString(), "The method toTypeString does not works.");
        assertEquals(falseTypeString, falseTypeBool.toTypeString(), "The method toTypeString does not works.");
        // Case not equals
        assertNotEquals(falseTypeString, trueTypeBool.toTypeString(), "The method toTypeString does not works.");
        assertNotEquals(trueTypeString, falseTypeBool.toTypeString(), "The method toTypeString does not works.");
    }

    @Test
    void toTypeBool() {
        TypeBool otherTrueTypeBool = new TypeBool(trueBoolean);
        TypeBool otherFalseTypeBool = new TypeBool(falseBoolean);
        assertEquals(otherTrueTypeBool, trueTypeBool.toTypeBool(), "The method toTypeBool does not works with true.");
        assertNotEquals(otherFalseTypeBool, trueTypeBool.toTypeBool(), "The method toTypeBool does not works with true.");
        assertEquals(otherFalseTypeBool, falseTypeBool.toTypeBool(), "The method toTypeBool does not works with true.");
        assertNotEquals(otherTrueTypeBool, falseTypeBool.toTypeBool(), "The method toTypeBool does not works with true.");
    }
}