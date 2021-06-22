package cl.uchile.dcc.scrabble.model;

import static cl.uchile.dcc.scrabble.model.utils.BinaryUtilities.binaryEqual;

import java.util.Random;
import org.apache.commons.lang3.RandomStringUtils;

/**
 * Abstract class that has random values and a method that instance its attributes randomly.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/13 15:45
 */
public abstract class AbstractRandomValues {

    // Zero numbers
    protected final double aFloatZero = 0.0;
    protected final int anIntZero = 0;
    protected final String aBinaryZero = "0000";
    // Booleans
    protected final boolean trueBoolean = true;
    protected final boolean falseBoolean = false;
    // Random settings
    protected int seed;
    protected Random rng;
    protected String messageSeed;
    // Binaries
    protected String aBinary1;
    protected String aBinary2;
    // Floats
    protected double aFloat1;
    protected double aFloat2;
    // Ints
    protected int anInt1;
    protected int anInt2;
    // Strings
    protected String aString1;
    protected String aString2;

    /**
     * Generates a random binary.
     *
     * @param rng     random generator
     * @param minBits min bits
     * @param maxBits max bits
     * @return a binary
     */
    protected static String generateABinaryRandom(Random rng, int minBits, int maxBits) {
        int nBits = rng.nextInt(maxBits - minBits + 1) + minBits;
        char[] characters = {'0', '1'};
        return RandomStringUtils.random(nBits, 0, 2,
            false, true, characters, rng);
    }

    /**
     * Generates a random float.
     *
     * @param rng         random generator
     * @param maxExponent max exponent
     * @return a random float
     */
    protected static double generateAFloatRandom(Random rng, int maxExponent) {
        int randomExponent = rng.nextInt(maxExponent + 1);
        int maxSize = rng.nextInt((int) Math.pow(10, randomExponent));
        int sgn = (int) Math.pow(-1, rng.nextInt(2));
        return sgn * rng.nextDouble() * maxSize;
    }

    /**
     * Generates a random int.
     *
     * @param rng         random generator
     * @param maxExponent max exponent
     * @return a random int
     */
    protected static int generateAnIntRandom(Random rng, int maxExponent) {
        int randomExponent = rng.nextInt(maxExponent + 1);
        int maxSize = rng.nextInt((int) Math.pow(10, randomExponent)) + 1;
        int sgn = (int) Math.pow(-1, rng.nextInt(2));
        return sgn * rng.nextInt(maxSize);
    }

    /**
     * Generates a random string.
     *
     * @param rng       random generator
     * @param maxLength max length
     * @return a random string
     */
    protected static String generateAStringRandom(Random rng, int maxLength) {
        int strSize = rng.nextInt(maxLength + 1);
        return RandomStringUtils.random(strSize, 0, Character.MAX_CODE_POINT,
            true, true, null, rng);
    }

    /**
     * To change the seed in case it is needed. Method to adapt in case you wish to use template
     * pattern. Every random value will be generated with this seed.
     *
     * @param aSeed A seed as an int.
     */
    protected void setSeed(int aSeed) {
        this.seed = aSeed;
    }

    private void setSettings() {
        // Initialize a random seed and a random rng
        setSeed(new Random().nextInt());
        messageSeed = " Seed: " + seed;
        rng = new Random(seed);
    }

    protected void setRandomValues() {
        setSettings();
        // Generate 2 binaries random
        aBinary1 = generateABinaryRandom(rng, 1, 32);
        do {
            aBinary2 = generateABinaryRandom(rng, 2, 31);
        } while (binaryEqual(aBinary1, aBinary2));
        // Generate 2 floats random
        aFloat1 = generateAFloatRandom(rng, 10);
        do {
            aFloat2 = generateAFloatRandom(rng, 9);
        } while (aFloat2 == aFloat1);
        // Generate 2 ints random
        anInt1 = generateAnIntRandom(rng, 10);
        do {
            anInt2 = generateAnIntRandom(rng, 9);
        } while (anInt2 == anInt1);
        // Generate 2 strings random
        aString1 = generateAStringRandom(rng, 20);
        do {
            aString2 = generateAStringRandom(rng, 19);
        } while (aString2.equals(aString1));
    }
}
