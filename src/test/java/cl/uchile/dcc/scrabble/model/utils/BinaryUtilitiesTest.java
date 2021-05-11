package cl.uchile.dcc.scrabble.model.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static cl.uchile.dcc.scrabble.model.utils.BinaryUtilities.*;

class BinaryUtilitiesTest {
    int anIntP6 = 6;
    int anIntM6 = -6;
    int anIntP4 = 4;
    int anIntM4 = -4;
    int anInt0 = 0;
    String aBinaryP6 = "0110";
    String aBinaryM6 = "1010";
    String aBinaryP4 = "0100";
    String aBinaryM4 = "1100";
    String aBinary0 = "0";

    @BeforeEach
    void setUp() {

    }

    @Test
    void addTwoBinariesTest() {
        // 6 + 6 = 12
        assertEquals("01100", addTwoBinaries(aBinaryP6, aBinaryP6));
        // 6 - 4 = 2
        assertEquals("0010", addTwoBinaries(aBinaryP6, aBinaryM4));
        // 4 - 6 = -2
        assertEquals("1110", addTwoBinaries(aBinaryP4, aBinaryM6));
        // 0 + 4 = 4
        assertEquals(aBinaryP4, addTwoBinaries(aBinary0, aBinaryP4));
        // 0 - 4 = -4
        assertEquals(aBinaryM4, addTwoBinaries(aBinary0, aBinaryM4));
    }

    @Test
    void intToBinaryTest() {
        assertEquals(aBinaryM4, intToBinary(anIntM4));
        assertEquals(aBinaryP4, intToBinary(anIntP4));
        assertEquals(aBinaryM6, intToBinary(anIntM6));
        assertEquals(aBinaryP6, intToBinary(anIntP6));
    }

    @Test
    void binaryToIntTest() {
        assertEquals(anIntM4, binaryToInt(aBinaryM4));
        assertEquals(anIntP4, binaryToInt(aBinaryP4));
        assertEquals(anIntM6, binaryToInt(aBinaryM6));
        assertEquals(anIntP6, binaryToInt(aBinaryP6));
    }
}