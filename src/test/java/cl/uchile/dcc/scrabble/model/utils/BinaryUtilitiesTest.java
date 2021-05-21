package cl.uchile.dcc.scrabble.model.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static cl.uchile.dcc.scrabble.model.utils.BinaryUtilities.*;
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
    int aStrangerInt1 = -1310239983;
    int aStrangerInt2 = -83937223;
    String aStrangeBinary1 = "10110001111001110101001100010001";
    String aStrangeBinary2 = "11111010111111110011100000111001";

    @BeforeEach
    void setUp() {
    }

    @Test
    void testBinaryEqual() {
        assertTrue(binaryEqual("00000110", aBinaryP6));
        assertTrue(binaryEqual("1111010", aBinaryM6));
        assertTrue(binaryEqual("00000", "00"));
        assertTrue(binaryEqual("00000", "0"));
    }

    @Test
    void testAddTwoBinaries() {
        // 6 + 6 = 12
        assertTrue(binaryEqual("01100", addTwoBinaries(aBinaryP6, aBinaryP6)),
                "Expected: " + "01100" + ".Receive: " + addTwoBinaries(aBinaryP6, aBinaryP6));
        // 6 - 4 = 2
        assertTrue(binaryEqual("0010", addTwoBinaries(aBinaryP6, aBinaryM4)));
        // 4 - 6 = -2
        assertTrue(binaryEqual("1110", addTwoBinaries(aBinaryP4, aBinaryM6)));
        // 0 + 4 = 4
        assertTrue(binaryEqual(aBinaryP4, addTwoBinaries(aBinary0, aBinaryP4)));
        // 0 - 4 = -4
        assertTrue(binaryEqual(aBinaryM4, addTwoBinaries(aBinary0, aBinaryM4)));
        // 10 - 6 = 4
        assertTrue(binaryEqual(aBinaryP4, addTwoBinaries(aBinaryP10, aBinaryM6)));
        // An edge case thrown in TypeIntTest
        var expectedBinary = "10101100111001101000101101001010";
        var binary1 = intToBinary(aStrangerInt1);
        var binary2 = intToBinary(aStrangerInt2);
        var resultBinary = addTwoBinaries(binary1, binary2);
        assertTrue(binaryEqual(expectedBinary, resultBinary),
                "expected: " + expectedBinary + "\nresult: " + resultBinary);
    }

    @Test
    void testIntToBinary() {
        // See if a positive binary works
        var binary1 = intToBinary(1310239983);
        var expectedBinary1 = "01001110000110001010110011101111";
        assertTrue(binaryEqual(expectedBinary1, binary1),
                "Expected: " + expectedBinary1 + "\nResult: " + binary1);
        // An edge case thrown in TypeIntTest
        binary1 = intToBinary(aStrangerInt1);
        var binary2 = intToBinary(aStrangerInt2);
        expectedBinary1 = aStrangeBinary1;
        var expectedBinary2 = aStrangeBinary2;
        assertTrue(binaryEqual(expectedBinary1, binary1),
                "Expected: " + expectedBinary1 + "\nResult: " + binary1);
        assertTrue(binaryEqual(expectedBinary2, binary2),
                "Expected: " + expectedBinary2 + "\nResult: " + binary2);
        // Standard cases
        var expectedBinary = aBinaryM4;
        var resultBinary = intToBinary(anIntM4);
        assertTrue(binaryEqual(expectedBinary, resultBinary),
                "Expected: " + expectedBinary + "\nResult: " + resultBinary);
        expectedBinary = aBinaryP4;
        resultBinary = intToBinary(anIntP4);
        assertTrue(binaryEqual(expectedBinary, resultBinary),
                "Expected: " + expectedBinary + "\nResult: " + resultBinary);
        expectedBinary = aBinaryM6;
        resultBinary = intToBinary(anIntM6);
        assertTrue(binaryEqual(expectedBinary, resultBinary),
                "Expected: " + expectedBinary + "\nResult: " + resultBinary);
        expectedBinary = aBinaryP6;
        resultBinary = intToBinary(anIntP6);
        assertTrue(binaryEqual(expectedBinary, resultBinary),
                "Expected: " + expectedBinary + "\nResult: " + resultBinary);
        // Cases in the list
        for (int i = 0; i < binaryArray.length; i++) {
            expectedBinary = binaryArray[i];
            resultBinary = intToBinary(intArray[i]);
            assertTrue(binaryEqual(expectedBinary, resultBinary),
                    "Expected: " + expectedBinary + "\nResult: " + resultBinary);
        }
    }

    @Test
    void testBinaryToInt() {
        // An edge case thrown in TypeIntTest
        assertEquals(aStrangerInt1, binaryToInt(aStrangeBinary1));
        assertEquals(aStrangerInt2, binaryToInt(aStrangeBinary2));
        // Tests by default
        assertEquals(anIntM4, binaryToInt(aBinaryM4));
        assertEquals(anIntP4, binaryToInt(aBinaryP4));
        assertEquals(anIntM6, binaryToInt(aBinaryM6));
        assertEquals(anIntP6, binaryToInt(aBinaryP6));
        for (int i = 0; i < binaryArray.length; i++) {
            assertEquals(intArray[i], binaryToInt(binaryArray[i]));
        }
    }

    @Test
    void testBoolAndBinary() {
        for (String currentBinary : binaryArray) {
            // the binary result will be constructed to operate with false
            var expectedFalse = new StringBuilder(currentBinary);
            for (int j = 0; j < expectedFalse.length(); j++) {
                expectedFalse.setCharAt(j, '0'); // p and false == false
            }
            assertEquals(expectedFalse.toString(), boolAndBinary(false, currentBinary));
            // the binary result will be constructed to operate with true
            assertEquals(currentBinary, boolAndBinary(true, currentBinary)); // p and true == p
        }
    }

    @Test
    void testBoolOrBinary() {
        for (String currentBinary : binaryArray) {
            // the binary result will be constructed to operate with true
            var expectedTrue = new StringBuilder(currentBinary);
            for (int j = 0; j < expectedTrue.length(); j++) {
                expectedTrue.setCharAt(j, '1'); // p or true == true
            }
            assertEquals(expectedTrue.toString(), boolOrBinary(true, currentBinary));
            // the binary result will be constructed to operate with false
            assertEquals(currentBinary, BinaryUtilities.boolOrBinary(false, currentBinary)); // p or false == p
        }
    }
}