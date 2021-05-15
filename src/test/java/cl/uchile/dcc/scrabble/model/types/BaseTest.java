package cl.uchile.dcc.scrabble.model.types;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static cl.uchile.dcc.scrabble.model.utils.BinaryUtilities.*;

/**
 * A base test that contains the standard set up of every test
 * @author Francisco Muñoz Guajardo
 */
public class BaseTest {
    // Randoms
    private int seed;
    private Random rng;
    private String messageSeed;
    // Binaries
    private String aBinary1;
    private TypeBinary typeBinary1;
    private String aBinary2;
    private TypeBinary typeBinary2;
    // Booleans
    private final boolean trueBoolean = true;
    private final TypeBool trueTypeBool = new TypeBool(trueBoolean);
    private final boolean falseBoolean = false;
    private final TypeBool falseTypeBool = new TypeBool(falseBoolean);
    // Floats
    private double aFloat1;
    private TypeFloat typeFloat1;
    private double aFloat2;
    private TypeFloat typeFloat2;
    // Ints
    private int anInt1;
    private TypeInt typeInt1;
    private int anInt2;
    private TypeInt typeInt2;
    // Strings
    private String aString1;
    private TypeString typeString1;
    private String aString2;
    private TypeString typeString2;

    private static String generateABinaryRandom(Random rng, int minBits, int maxBits) {
        int nBits = rng.nextInt(maxBits - minBits + 1) + minBits;
        char[] characters = {'0', '1'};
        return RandomStringUtils.random(nBits, 0, 2,
                false, true, characters, rng);
    }

    private static double generateAFloatRandom(Random rng, int maxExponent) {
        int randomExponent = rng.nextInt(maxExponent);
        int maxSize = rng.nextInt((int) Math.pow(10, randomExponent));
        int sgn = (int) Math.pow(-1, rng.nextInt(2));
        return sgn * rng.nextDouble() * maxSize;
    }

    private static int generateAnIntRandom(Random rng, int maxExponent) {
        int randomExponent = rng.nextInt(maxExponent);
        int maxSize = rng.nextInt((int) Math.pow(10, randomExponent));
        int sgn = (int) Math.pow(-1, rng.nextInt(2));
        return sgn * rng.nextInt(maxSize);
    }

    private static String generateAStringRandom(Random rng, int maxLength) {
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

    @Test
    void aTest() {
        System.out.println(aBinary1);
        System.out.println(aBinary2);
        System.out.println(typeBinary1);
        System.out.println(typeBinary2);
        System.out.println(aFloat1);
        System.out.println(aFloat2);
        System.out.println(typeFloat1);
        System.out.println(typeFloat2);
        System.out.println(anInt1);
        System.out.println(anInt2);
        System.out.println(typeInt1);
        System.out.println(typeInt2);
        System.out.println(aString1);
        System.out.println(aString2);
        System.out.println(typeString1);
        System.out.println(typeString2);
    }
}
