package cl.uchile.dcc.scrabble.model.types;

import static cl.uchile.dcc.scrabble.model.utils.BinaryUtilities.binaryToInt;
import static cl.uchile.dcc.scrabble.model.utils.BinaryUtilities.intToBinary;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

class TypeIntTest extends BaseTypeTest {

    @BeforeEach
    protected void setUp() {
        super.setUp();
    }

    @AfterEach
    protected void tearDown() {
        super.tearDown();
    }

    @RepeatedTest(20)
    void getValue() {
        assertEquals(anInt1, typeInt1.getValue(),
                "Method getValue does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testEquals() {
        TypeInt otherTypeInt1 = new TypeInt(anInt1);
        assertEquals(otherTypeInt1, typeInt1,
                "Two TypeInts with the same value are different." + messageSeed);
        assertNotEquals(typeInt2, typeInt1,
                "Two TypeInts with different values are equals." + messageSeed);
    }

    @RepeatedTest(20)
    void testHashCode() {
        TypeInt otherTypeInt1 = new TypeInt(anInt1);
        assertEquals(otherTypeInt1.hashCode(), typeInt1.hashCode(),
                "Two TypeInts with the same value have different hash code." + messageSeed);
        assertNotEquals(typeInt2.hashCode(), typeInt1.hashCode(),
                "Two TypeInts with different values have equals hash code." + messageSeed);
    }

    @RepeatedTest(20)
    void testToString() {
        assertEquals("TypeInt{value=" + anInt1 + "}", typeInt1.toString(),
                "Method toString does not works." + messageSeed);
        assertNotEquals("TypeInt{value=" + anInt2 + "}", typeInt1.toString(),
                "Method toString does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void toTypeString() {
        TypeString typeIntAsTypeString = new TypeString(Integer.toString(anInt1));
        assertEquals(typeIntAsTypeString, typeInt1.toTypeString(),
                "Method toTypeString does not works." + messageSeed);
        assertNotEquals(typeIntAsTypeString, typeInt2.toTypeString(),
                "Method toTypeString does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void toTypeFloat() {
        TypeFloat typeIntAsTypeFloat = new TypeFloat(anInt1);
        assertEquals(typeIntAsTypeFloat, typeInt1.toTypeFloat(),
                "Method toTypeFloat does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void toTypeInt() {
        TypeInt otherTypeInt1 = new TypeInt(anInt1);
        assertEquals(otherTypeInt1, typeInt1.toTypeInt(),
                "Method toTypeInt does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void toTypeBinary() {
        String aBinary1 = intToBinary(anInt1);
        TypeBinary anIntAsBinary = new TypeBinary(aBinary1);
        assertEquals(anIntAsBinary, typeInt1.toTypeBinary(),
                "Method toTypeBinary does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void add() {
        // Test add with binary
        var expectedTypeInt = new TypeInt(anInt1 + binaryToInt(aBinary1));
        assertEquals(expectedTypeInt, typeInt1.add(typeBinary1),
                "Method add does not works with TypeBinary." + messageSeed);
        // Test add with float
        var expectedTypeFloat = new TypeFloat(anInt1 + aFloat1);
        assertEquals(expectedTypeFloat, typeInt1.add(typeFloat1),
                "Method add does not works with TypeFloat." + messageSeed);
        // Test add with int
        expectedTypeInt = new TypeInt(anInt1 + anInt2);
        assertEquals(expectedTypeInt, typeInt1.add(typeInt2),
                "Method add does not works with TypeInt." + messageSeed);
    }

    @RepeatedTest(20)
    void sub() {
        // Test subtraction with binary
        var expectedTypeInt = new TypeInt(anInt1 - binaryToInt(aBinary1));
        assertEquals(expectedTypeInt, typeInt1.sub(typeBinary1),
                "Method sub does not works with TypeBinary." + messageSeed);
        // Test subtraction with float
        var expectedTypeFloat = new TypeFloat(anInt1 - aFloat1);
        assertEquals(expectedTypeFloat, typeInt1.sub(typeFloat1),
                "Method sub does not works with TypeFloat." + messageSeed);
        // Test subtraction with int
        expectedTypeInt = new TypeInt(anInt1 - anInt2);
        assertEquals(expectedTypeInt, typeInt1.sub(typeInt2),
                "Method sub does not works with TypeInt." + messageSeed);
    }

    @RepeatedTest(20)
    void mult() {
        // Test multiplication with binary
        var expectedTypeInt = new TypeInt(anInt1 * binaryToInt(aBinary1));
        assertEquals(expectedTypeInt, typeInt1.mult(typeBinary1),
                "Method mult does not works with TypeBinary." + messageSeed);
        // Test multiplication with float
        var expectedTypeFloat = new TypeFloat(anInt1 * aFloat1);
        assertEquals(expectedTypeFloat, typeInt1.mult(typeFloat1),
                "Method mult does not works with TypeFloat." + messageSeed);
        // Test multiplication with int
        expectedTypeInt = new TypeInt(anInt1 * anInt2);
        assertEquals(expectedTypeInt, typeInt1.mult(typeInt2),
                "Method mult does not works with TypeInt." + messageSeed);
    }

    @RepeatedTest(20)
    void div() {
        if (typeBinary1.getValueAsInt() != 0) {
            // Test division with binary
            var expectedTypeInt = new TypeInt((int) Math.round((double) anInt1 / binaryToInt(aBinary1)));
            assertEquals(expectedTypeInt, typeInt1.div(typeBinary1),
                    "Method div does not works with TypeBinary." + messageSeed);
        }
        if (aFloat1 != 0.0) {
            // Test division with float
            var expectedTypeFloat = new TypeFloat(anInt1 / aFloat1);
            assertEquals(expectedTypeFloat, typeInt1.div(typeFloat1),
                    "Method div does not works with TypeFloat." + messageSeed);
        }
        if (anInt2 != 0) {
            // Test division with int
            var expectedTypeInt = new TypeInt((int) Math.round((double) anInt1 / anInt2));
            assertEquals(expectedTypeInt, typeInt1.div(typeInt2),
                    "Method div does not works with TypeInt." + messageSeed);
        }
    }
}