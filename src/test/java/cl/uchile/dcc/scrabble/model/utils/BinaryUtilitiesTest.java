package cl.uchile.dcc.scrabble.model.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static cl.uchile.dcc.scrabble.model.utils.BinaryUtilities.*;

class BinaryUtilitiesTest {
    String[] binaryArray = {"111100", "101", "110", "111", "0", "01", "00010", "0011", "0100"};
    int[] intArray = {-4, -3, -2, -1, 0, 1, 2, 3, 4};
    int anIntP6 = 6;
    int anIntM6 = -6;
    int anIntP4 = 4;
    int anIntM4 = -4;
    int anIntP10 = 10;
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
    void binaryEqualTest() {
        assertTrue(binaryEqual("00000110", aBinaryP6));
        assertTrue(binaryEqual("1111010", aBinaryM6));
        assertTrue(binaryEqual("00000", "00"));
        assertTrue(binaryEqual("00000", "0"));
    }

    @Test
    void addTwoBinariesTest() {
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
    }

    @Test
    void intToBinaryTest() {
        assertTrue(binaryEqual(aBinaryM4, intToBinary(anIntM4)));
        assertTrue(binaryEqual(aBinaryP4, intToBinary(anIntP4)));
        assertTrue(binaryEqual(aBinaryM6, intToBinary(anIntM6)));
        assertTrue(binaryEqual(aBinaryP6, intToBinary(anIntP6)));
        for (int i = 0; i < binaryArray.length; i++) {
            assertTrue(binaryEqual(binaryArray[i], intToBinary(intArray[i])));
        }
    }

    @Test
    void binaryToIntTest() {
        assertEquals(anIntM4, binaryToInt(aBinaryM4));
        assertEquals(anIntP4, binaryToInt(aBinaryP4));
        assertEquals(anIntM6, binaryToInt(aBinaryM6));
        assertEquals(anIntP6, binaryToInt(aBinaryP6));
        for (int i = 0; i < binaryArray.length; i++) {
            assertEquals(intArray[i], binaryToInt(binaryArray[i]));
        }
    }
}