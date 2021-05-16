package cl.uchile.dcc.scrabble.model.types;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;

import java.util.Random;

import static cl.uchile.dcc.scrabble.model.utils.BinaryUtilities.*;

/**
 * A base test that contains the standard set up of every test
 * @author Francisco Muñoz Guajardo
 */
public class BaseTest {
    // Randoms
    protected int seed;
    protected Random rng;
    protected String messageSeed;
    // Binaries
    protected String aBinary1;
    protected TypeBinary typeBinary1;
    protected String aBinary2;
    protected TypeBinary typeBinary2;
    // Booleans
    protected final boolean trueBoolean = true;
    protected final TypeBool trueTypeBool = new TypeBool(trueBoolean);
    protected final boolean falseBoolean = false;
    protected final TypeBool falseTypeBool = new TypeBool(falseBoolean);
    // Floats
    protected double aFloat1;
    protected TypeFloat typeFloat1;
    protected double aFloat2;
    protected TypeFloat typeFloat2;
    // Ints
    protected int anInt1;
    protected TypeInt typeInt1;
    protected int anInt2;
    protected TypeInt typeInt2;
    // Strings
    protected String aString1;
    protected TypeString typeString1;
    protected String aString2;
    protected TypeString typeString2;

    protected static String generateABinaryRandom(Random rng, int minBits, int maxBits) {
        int nBits = rng.nextInt(maxBits - minBits + 1) + minBits;
        char[] characters = {'0', '1'};
        return RandomStringUtils.random(nBits, 0, 2,
                false, true, characters, rng);
    }

    protected static double generateAFloatRandom(Random rng, int maxExponent) {
        int randomExponent = rng.nextInt(maxExponent);
        int maxSize = rng.nextInt((int) Math.pow(10, randomExponent));
        int sgn = (int) Math.pow(-1, rng.nextInt(2));
        return sgn * rng.nextDouble() * maxSize;
    }

    protected static int generateAnIntRandom(Random rng, int maxExponent) {
        int randomExponent = rng.nextInt(maxExponent);
        int maxSize = rng.nextInt((int) Math.pow(10, randomExponent)) + 1;
        int sgn = (int) Math.pow(-1, rng.nextInt(2));
        return sgn * rng.nextInt(maxSize);
    }

    protected static String generateAStringRandom(Random rng, int maxLength) {
        int strSize = rng.nextInt(maxLength);
        return RandomStringUtils.random(strSize, 0, Character.MAX_CODE_POINT,
                true, true, null, rng);
    }

    @BeforeEach
    void setUp() {
        // Initialize a random seed and a random rng
        seed = new Random().nextInt();
        messageSeed = " Seed: " + seed;
        rng = new Random(seed);
        // Generate 2 binaries random
        aBinary1 = generateABinaryRandom(rng, 3, 32);
        do {
            aBinary2 = generateABinaryRandom(rng, 3, 32);
        } while (binaryEqual(aBinary1, aBinary2));
        typeBinary1 = new TypeBinary(aBinary1);
        typeBinary2 = new TypeBinary(aBinary2);
        // Generate 2 floats random
        aFloat1 = generateAFloatRandom(rng, 10);
        do {
            aFloat2 = generateAFloatRandom(rng, 10);
        } while (aFloat2 == aFloat1);
        typeFloat1 = new TypeFloat(aFloat1);
        typeFloat2 = new TypeFloat(aFloat2);
        // Generate 2 ints random
        anInt1 = generateAnIntRandom(rng, 10);
        do {
            anInt2 = generateAnIntRandom(rng, 10);
        } while (anInt2 == anInt1);
        typeInt1 = new TypeInt(anInt1);
        typeInt2 = new TypeInt(anInt2);
        // Generate 2 strings random
        aString1 = generateAStringRandom(rng, 20);
        do {
            aString2 = generateAStringRandom(rng, 20);
        } while (aString2.equals(aString1));
        typeString1 = new TypeString(aString1);
        typeString2 = new TypeString(aString2);
    }
}
