package cl.uchile.dcc.scrabble.model.types;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static cl.uchile.dcc.scrabble.model.utils.BinaryUtilities.*;

class TypeBinaryTest {
    private TypeBinary typeBinary1;
    private TypeBinary typeBinary2;
    private String aBinary1;
    private String aBinary2;
    private String messageSeed;

    @BeforeEach
    void setUp() {
        int seed = new Random().nextInt();
        messageSeed = " Seed: " + seed;
        Random rng = new Random(seed);
        int nBits = rng.nextInt(64) + 1; // Max 64 bits
        char[] characters = {'0', '1'};
        aBinary1 = RandomStringUtils.random(nBits, 0, 2, false,
                true, characters, rng);
        do {
            aBinary2 = RandomStringUtils.random(nBits, 0, 2, false,
                    true, characters, rng);
        } while (aBinary2.equals(aBinary1));
        typeBinary1 = new TypeBinary(aBinary1);
        typeBinary2 = new TypeBinary(aBinary2);
    }

    @RepeatedTest(20)
    void getValue() {
        assertEquals(aBinary1, typeBinary1.getValue(),
                "Method getValue does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testEquals() {
        TypeBinary otherTypeBinary1 = new TypeBinary(aBinary1);
        assertEquals(otherTypeBinary1, typeBinary1,
                "Two instances that have the same values are not equals." + messageSeed);
        assertNotEquals(typeBinary2, typeBinary1,
                "Two instances that have different values are equals." + messageSeed);
        // Case where a binary has redundant leading zeros.
        TypeBinary typeBinary = new TypeBinary("0" + aBinary1);
        TypeBinary aBinaryWithRedundantZeros = new TypeBinary("00000" + aBinary1);
        assertEquals(aBinaryWithRedundantZeros, typeBinary,
                "Method equals does not works when the binary has redundant leading zeros." + messageSeed);
    }

    @RepeatedTest(20)
    void testHashCode() {
        TypeBinary otherTypeBinary1 = new TypeBinary(aBinary1);
        assertEquals(otherTypeBinary1.hashCode(), typeBinary1.hashCode(),
                "Two instances that have the same values have different hash code." + messageSeed);
        assertNotEquals(typeBinary2.hashCode(), typeBinary1.hashCode(),
                "Two instances that have different values have equals hash code." + messageSeed);
        // Case where a binary has redundant leading zeros.
        TypeBinary typeBinary = new TypeBinary("0" + aBinary1);
        TypeBinary aBinaryWithRedundantZeros = new TypeBinary("00000" + aBinary1);
        assertEquals(aBinaryWithRedundantZeros.hashCode(), typeBinary.hashCode(),
                "Method hashCode does not works when the binary has redundant leading zeros." + messageSeed);
    }

    @RepeatedTest(20)
    void testToString() {
        assertEquals("TypeBinary{value='" + aBinary1 + "'}", typeBinary1.toString(),
                "Method toString does not works." + messageSeed);
        assertEquals("TypeBinary{value='" + aBinary2 + "'}", typeBinary2.toString(),
                "Method toString does not works." + messageSeed);
        assertNotEquals("TypeBinary{value='" + aBinary2 + "'}", typeBinary1.toString(),
                "Method toString does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void toTypeString() {
        TypeString binaryAsTypeString = new TypeString(aBinary1);
        assertEquals(binaryAsTypeString, typeBinary1.toTypeString(),
                "Method toTypeString does not works." + messageSeed);
        assertNotEquals(binaryAsTypeString, typeBinary2.toTypeString(),
                "Method toTypeString does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void toTypeFloat() {
        // Convert aBinary1 as an int
        int aNumber1 = binaryToInt(aBinary1);
        TypeFloat binaryAsTypeFloat = new TypeFloat(aNumber1);
        assertEquals(binaryAsTypeFloat, typeBinary1.toTypeFloat(),
                "Method toTypeFloat does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void toTypeInt() {
        // Convert aBinary1 as an int
        int aNumber1 = binaryToInt(aBinary1);
        TypeInt binaryAsTypeInt = new TypeInt(aNumber1);
        assertEquals(binaryAsTypeInt, typeBinary1.toTypeInt(),
                "Method toTypeInt does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void toTypeBinary() {
        TypeBinary otherTypeBinary1 = new TypeBinary(aBinary1);
        assertEquals(otherTypeBinary1, typeBinary1.toTypeBinary(),
                "Method toTypeBinary does not works." + messageSeed);
        assertNotEquals(otherTypeBinary1, typeBinary2.toTypeBinary(),
                "Method toTypeBinary does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void opposite() {
        // Changing each 1 for 0 and each 0 for 1 is equivalent to applying one complement.
        String aBinaryNegative1 = oneComplement(aBinary1);
        TypeBinary typeBinaryNegative1 = new TypeBinary(aBinaryNegative1);
        assertEquals(typeBinaryNegative1, typeBinary1.opposite(),
                "Method opposite does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void addWithString() {
        var aString = "Hola mundo!";
        var aTypeString = new TypeString(aString);
        var expectedTypeString = new TypeString(aString + aBinary1);
        assertEquals(expectedTypeString, typeBinary1.addWithString(aTypeString),
                "Method addWithString does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void addWithInt() {
        var anInt = 42;
        var aTypeInt = new TypeInt(anInt);
        var expected = new TypeInt(anInt + binaryToInt(aBinary1));
        assertEquals(expected, typeBinary1.addWithInt(aTypeInt),
                "Method addWithString does not works." + messageSeed);
    }
}