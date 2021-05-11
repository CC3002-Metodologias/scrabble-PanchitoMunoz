package cl.uchile.dcc.scrabble.model.types;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class TypeBinaryTest {
    private TypeBinary typeBinary1;
    private TypeBinary typeBinary2;
    private String aBinary1;
    private String aBinary2;

    @BeforeEach
    void setUp() {
        int seed = new Random().nextInt();
        Random rng = new Random(seed);
        int nBits = rng.nextInt(65); // Max 64 bits
        char[] characters = {'0', '1'};
        aBinary1 = RandomStringUtils.random(nBits, 0, 2, false,
                true, characters, rng);
        do {
            if (nBits == 0) nBits = 1;
            aBinary2 = RandomStringUtils.random(nBits, 0, 2, false,
                    true, characters, rng);
        } while (aBinary2.equals(aBinary1));
        typeBinary1 = new TypeBinary(aBinary1);
        typeBinary2 = new TypeBinary(aBinary2);
    }

    @RepeatedTest(20)
    void testEquals() {
        TypeBinary otherTypeBinary1 = new TypeBinary(aBinary1);
        assertEquals(otherTypeBinary1, typeBinary1,
                "Two instances that have the same values are not equals.");
        assertNotEquals(typeBinary2, typeBinary1,
                "Two instances that have different values are equals.");
    }

    @RepeatedTest(20)
    void testHashCode() {
        TypeBinary otherTypeBinary1 = new TypeBinary(aBinary1);
        assertEquals(otherTypeBinary1.hashCode(), typeBinary1.hashCode(),
                "Two instances that have the same values have different hash code.");
        assertNotEquals(typeBinary2.hashCode(), typeBinary1.hashCode(),
                "Two instances that have different values have equals hash code.");
    }

    @RepeatedTest(20)
    void testToString() {
        assertEquals("TypeBinary{value='" + aBinary1 + "'}", typeBinary1.toString(),
                "Method toString does not works.");
        assertEquals("TypeBinary{value='" + aBinary2 + "'}", typeBinary2.toString(),
                "Method toString does not works.");
        assertNotEquals("TypeBinary{value='" + aBinary2 + "'}", typeBinary1.toString(),
                "Method toString does not works.");
    }

    @RepeatedTest(20)
    void toTypeString() {
        TypeString binaryAsTypeString = new TypeString(aBinary1);
        assertEquals(binaryAsTypeString, typeBinary1.toTypeString(),
                "Method toTypeString does not works.");
        assertNotEquals(binaryAsTypeString, typeBinary2.toTypeString(),
                "Method toTypeString does not works.");
    }

    @RepeatedTest(20)
    void toTypeFloat() {
        typeBinary1.toTypeFloat();
    }

    @RepeatedTest(20)
    void toTypeInt() {
        typeBinary1.toTypeInt();
    }

    @RepeatedTest(20)
    void toTypeBinary() {
        TypeBinary otherTypeBinary1 = new TypeBinary(aBinary1);
        assertEquals(otherTypeBinary1, typeBinary1.toTypeBinary(),
                "Method toTypeBinary does not works.");
        assertNotEquals(otherTypeBinary1, typeBinary2.toTypeBinary(),
                "Method toTypeBinary does not works.");
    }
}