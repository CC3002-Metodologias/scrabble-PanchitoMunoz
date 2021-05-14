package cl.uchile.dcc.scrabble.model.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryUtilitiesTest {
    String[] binaryArray = {"111100", "101", "110", "111", "0", "01", "00010", "0011", "0100"};
    int[] intArray = {-4, -3, -2, -1, 0, 1, 2, 3, 4};
    int anIntP6 = 6;
    int anIntM6 = -6;
    int anIntP4 = 4;
    int anIntM4 = -4;
    String aBinaryP6 = "0110";
    String aBinaryM6 = "1010";
    String aBinaryP4 = "0100";
    String aBinaryM4 = "1100";
    String aBinaryP10 = "01010";
    String aBinary0 = "0";

    @BeforeEach
    void setUp() {
    }

    @Test
    void binaryEqual() {
        assertTrue(BinaryUtilities.binaryEqual("00000110", aBinaryP6));
        assertTrue(BinaryUtilities.binaryEqual("1111010", aBinaryM6));
        assertTrue(BinaryUtilities.binaryEqual("00000", "00"));
        assertTrue(BinaryUtilities.binaryEqual("00000", "0"));
    }

    @Test
    void addTwoBinaries() {
        // 6 + 6 = 12
        assertTrue(BinaryUtilities.binaryEqual("01100", BinaryUtilities.addTwoBinaries(aBinaryP6, aBinaryP6)),
                "Expected: " + "01100" + ".Receive: " + BinaryUtilities.addTwoBinaries(aBinaryP6, aBinaryP6));
        // 6 - 4 = 2
        assertTrue(BinaryUtilities.binaryEqual("0010", BinaryUtilities.addTwoBinaries(aBinaryP6, aBinaryM4)));
        // 4 - 6 = -2
        assertTrue(BinaryUtilities.binaryEqual("1110", BinaryUtilities.addTwoBinaries(aBinaryP4, aBinaryM6)));
        // 0 + 4 = 4
        assertTrue(BinaryUtilities.binaryEqual(aBinaryP4, BinaryUtilities.addTwoBinaries(aBinary0, aBinaryP4)));
        // 0 - 4 = -4
        assertTrue(BinaryUtilities.binaryEqual(aBinaryM4, BinaryUtilities.addTwoBinaries(aBinary0, aBinaryM4)));
        // 10 - 6 = 4
        assertTrue(BinaryUtilities.binaryEqual(aBinaryP4, BinaryUtilities.addTwoBinaries(aBinaryP10, aBinaryM6)));
    }

    @Test
    void intToBinary() {
        assertTrue(BinaryUtilities.binaryEqual(aBinaryM4, BinaryUtilities.intToBinary(anIntM4)));
        assertTrue(BinaryUtilities.binaryEqual(aBinaryP4, BinaryUtilities.intToBinary(anIntP4)));
        assertTrue(BinaryUtilities.binaryEqual(aBinaryM6, BinaryUtilities.intToBinary(anIntM6)));
        assertTrue(BinaryUtilities.binaryEqual(aBinaryP6, BinaryUtilities.intToBinary(anIntP6)));
        for (int i = 0; i < binaryArray.length; i++) {
            assertTrue(BinaryUtilities.binaryEqual(binaryArray[i], BinaryUtilities.intToBinary(intArray[i])));
        }
    }

    @Test
    void binaryToInt() {
        assertEquals(anIntM4, BinaryUtilities.binaryToInt(aBinaryM4));
        assertEquals(anIntP4, BinaryUtilities.binaryToInt(aBinaryP4));
        assertEquals(anIntM6, BinaryUtilities.binaryToInt(aBinaryM6));
        assertEquals(anIntP6, BinaryUtilities.binaryToInt(aBinaryP6));
        for (int i = 0; i < binaryArray.length; i++) {
            assertEquals(intArray[i], BinaryUtilities.binaryToInt(binaryArray[i]));
        }
    }

    @Test
    void boolAndBinary() {
        for (String currentBinary : binaryArray) {
            // the binary result will be constructed to operate with false
            var expectedFalse = new StringBuilder(currentBinary);
            for (int j = 0; j < expectedFalse.length(); j++) {
                expectedFalse.setCharAt(j, '0'); // p and false == false
            }
            assertEquals(expectedFalse.toString(), BinaryUtilities.boolAndBinary(false, currentBinary));
            // the binary result will be constructed to operate with true
            assertEquals(currentBinary, BinaryUtilities.boolAndBinary(true, currentBinary)); // p and true == p
        }
    }

    @Test
    void boolOrBinary() {
        for (String currentBinary : binaryArray) {
            // the binary result will be constructed to operate with true
            var expectedTrue = new StringBuilder(currentBinary);
            for (int j = 0; j < expectedTrue.length(); j++) {
                expectedTrue.setCharAt(j, '1'); // p or true == true
            }
            assertEquals(expectedTrue.toString(), BinaryUtilities.boolOrBinary(true, currentBinary));
            // the binary result will be constructed to operate with false
            assertEquals(currentBinary, BinaryUtilities.boolOrBinary(false, currentBinary)); // p or false == p
        }
    }
}