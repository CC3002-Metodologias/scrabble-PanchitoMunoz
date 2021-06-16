package cl.uchile.dcc.scrabble.model.utils;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Class that provides functionalities for binaries.
 * @author Francisco Muñoz Guajardo.
 */
public final class BinaryUtilities {
    /**
     * Private constructor to avoid instance of this class.
     */
    private BinaryUtilities() {}

    /**
     * Add one to the current binary.
     * @param binary A binary as String
     * @return Binary plus one
     */
    private static String addOne(String binary) {
        StringBuilder copyBinary = new StringBuilder(binary);
        int i = binary.length() - 1;
        while (i >= 0) {
            if (binary.charAt(i) == '1') {
                copyBinary.setCharAt(i, '0');
                i--;
            } else {
                copyBinary.setCharAt(i, '1');
                i = -1;
            }
        }
        return copyBinary.toString();
    }

    /**
     * Subtract one to the current binary.
     * @param binary A binary as String
     * @return Binary minus one
     */
    private static String subOne(String binary) {
        StringBuilder copyBinary = new StringBuilder(binary);
        int i = binary.length() - 1;
        while (i >= 0) {
            if (binary.charAt(i) == '0') {
                copyBinary.setCharAt(i, '1');
                i--;
            } else {
                copyBinary.setCharAt(i, '0');
                i = -1;
            }
        }
        return copyBinary.toString();
    }

    /**
     * Transform a bit to an int.
     * @param bit A bit as a character.
     * @return An int as the representation of the bit.
     */
    private static int bitToInt(char bit) {
        return bit == '0' ? 0 : 1;
    }

    /**
     * Returns a positive binary as an int.
     * @param binary A binary number as a String.
     * @return The representation of the binary number as an integer.
     */
    private static int positiveBinaryToInt(String binary) {
        int w =  0;
        for (int i = binary.length() - 1, j = 0; i >= 0; i--, j++) {
            w += (int) Math.pow(2, j) * bitToInt(binary.charAt(i));
        }
        return w;
    }

    /**
     * Returns a negative binary as an int.
     * @param binary A binary number as a String.
     * @return The representation of the binary number as an integer.
     */
    private static int negativeBinaryToInt(String binary) {
        String binaryToReturn = subOne(binary);
        binaryToReturn = oneComplement(binaryToReturn);
        return -positiveBinaryToInt(binaryToReturn);
    }

    /**
     * Returns the one complement of the binary number 'binary'.
     * @param binary A binary number.
     * @return The one complement of 'binary'.
     */
    public static String oneComplement(String binary) {
        StringBuilder oppositeBinary = new StringBuilder();
        for (int i = 0; i < binary.length(); i++) {
            oppositeBinary.append(binary.charAt(i) == '0' ? '1' : '0');
        }
        return oppositeBinary.toString();
    }

    /**
     * Returns the two complement of the binary number 'binary'.
     * @param binary A binary number as a String.
     * @return The two complements of 'binary'.
     */
    private static String twosComplement(String binary) {
        String binaryToReturn  = oneComplement(binary);
        binaryToReturn = addOne(binaryToReturn);
        return binaryToReturn;
    }

    /**
     * Returns the binary representation of the number 'intNumber'
     * @param intNumber An integer as a number.
     * @return The binary representation of 'intNumber'.
     */
    private static String positiveIntToBinary(int intNumber) {
        // If the number is 0, return 0 in binary
        if (intNumber == 0) {
            return "0000";
        }
        // Calculate the number of bits necessary
        int nBitsAtLeast = Math.max((int) Math.floor(Math.log(intNumber) / Math.log(2)) + 1, 4);
        int j = 0;
        int nBits;
        do {
            j++;
            nBits = (int) Math.pow(2, j);
        } while (nBitsAtLeast > (int) Math.pow(2, j - 1));
        // Generate an array with the numbers of bits necessary
        int[] binary = new int[nBits];
        int id = nBits - 1;
        while (intNumber > 0) {
            binary[id] = intNumber % 2;
            intNumber = intNumber / 2;
            id--;
        }
        // Make the binary array as a string
        String stringToReturn = IntStream.range(0, nBits).mapToObj(i -> String.valueOf(binary[i]))
            .collect(Collectors.joining());
        // Cleans the binary
        stringToReturn = cleanBinary(stringToReturn);
        return stringToReturn;
    }

    /**
     * Cleans the redundant symbols in the binary. E.g.: "00010110" clears to "010110".
     *
     * @param aBinary a binary to clean
     * @return the binary cleaned
     */
    private static String cleanBinary(String aBinary) {
        if (aBinary.length() <= 4) {
            return aBinary;
        }
        StringBuilder newBinary = new StringBuilder(aBinary);
        char principalChar = newBinary.charAt(0);
        for (int i = 1; i < aBinary.length() - 4; i++) {
            char secondaryChar = newBinary.charAt(1);
            if (principalChar == secondaryChar) {
                newBinary.deleteCharAt(0);
            } else {
                break;
            }
        }
        return newBinary.toString();
    }

    /**
     * Returns the sum of the binary number 'binary1' and the binary number 'binary2' as another
     * binary number.
     *
     * @param binary1 A binary number.
     * @param binary2 Another binary number.
     * @return The sum between 'binary1' and 'binary2'.
     */
    public static String addTwoBinaries(String binary1, String binary2) {
        int binary1AsNumber = binaryToInt(binary1);
        int binary2AsNumber = binaryToInt(binary2);
        return intToBinary(binary1AsNumber + binary2AsNumber);
    }

    /**
     * Returns the binary representation of any integer 'intNumber'.
     * @param intNumber An integer number.
     * @return The representation of the number as a binary.
     */
    public static String intToBinary(int intNumber) {
        int absNumber = Math.abs(intNumber);
        String binaryNum = positiveIntToBinary(absNumber);
        if (intNumber < 0) {
            binaryNum = twosComplement(binaryNum);
        }
        return binaryNum;
    }

    /**
     * Returns the representation of a binary string. Whatever if a positive integer or a negative one.
     * @param binary A binary number as a String.
     * @return The representation of the binary number as an integer.
     */
    public static int binaryToInt(String binary) {
        // Pathologic cases
        if ("1".equals(binary)) return 1;
        if (bitToInt(binary.charAt(0)) == 0) {
            return positiveBinaryToInt(binary);
        } else {
            return negativeBinaryToInt(binary);
        }
    }

    /**
     * Returns true if the value of 'binary1' is equals to 'binary2'. Otherwise, false.
     * @param binary1 First binary to compare.
     * @param binary2 Second binary to compare.
     * @return true if the binaries are equals, otherwise false.
     */
    public static boolean binaryEqual(String binary1, String binary2) {
        Integer binary1AsInt = binaryToInt(binary1);
        Integer binary2AsInt = binaryToInt(binary2);
        return binary1AsInt.equals(binary2AsInt);
    }

    /**
     * Operate the boolean 'bool' element by element in the binary 'binary' using the 'and' operator.
     * @param bool A boolean to operate with 'binary'.
     * @param binary A binary that will be operated by 'bool'.
     * @return The binary operated by 'bool'.
     */
    public static String boolAndBinary(boolean bool, String binary) {
        StringBuilder binaryToReturn = new StringBuilder(binary);
        for (int i = 0; i < binary.length(); i++) {
            binaryToReturn.setCharAt(i, binary.charAt(i) == '1' && bool ? '1' : '0');
        }
        return binaryToReturn.toString();
    }

    /**
     * Operate the boolean 'bool' element by element in the binary 'binary' using the 'or' operator.
     * @param bool A boolean to operate with 'binary'.
     * @param binary A binary that will be operated by 'bool'.
     * @return The binary operated by 'bool'.
     */
    public static String boolOrBinary(boolean bool, String binary) {
        StringBuilder binaryToReturn = new StringBuilder(binary);
        for (int i = 0; i < binary.length(); i++) {
            binaryToReturn.setCharAt(i, binary.charAt(i) == '1' || bool ? '1' : '0');
        }
        return binaryToReturn.toString();
    }

    /**
     * Fill the current binary with ones or zeros in order to keep the original value.
     * @param maxBits Maximum number of bits.
     * @param binary A binary to fill.
     * @return A binary with an equivalent but larger value.
     */
    private static String fillMaxBits(int maxBits, String binary) {
        StringBuilder binaryToReturn = new StringBuilder(binary);
        while (maxBits > binaryToReturn.length()) {
            binaryToReturn.insert(0, binary.charAt(0));
        }
        return binaryToReturn.toString();
    }

    /**
     * Makes the comparison between two binaries with the operator 'and'. If one binary is smaller than another,
     * fill it with zeros and ones to get an equivalent value.
     * @param binary1 First binary.
     * @param binary2 Second binary.
     * @return A binary result to operate with 'and'
     */
    public static String binaryAndBinary(String binary1, String binary2) {
        if (binary1.length() > binary2.length()) {
            binary2 = fillMaxBits(binary1.length(), binary2);
        } else {
            binary1 = fillMaxBits(binary2.length(), binary1);
        }
        StringBuilder binaryToReturn = new StringBuilder(binary1);
        for (int i = 0; i < binary1.length(); i++) {
            binaryToReturn.setCharAt(i, binary1.charAt(i) == '1' && binary2.charAt(i) == '1' ? '1' : '0');
        }
        return binaryToReturn.toString();
    }

    /**
     * Makes the comparison between two binaries with the operator 'or'. If one binary is smaller than another,
     * fill it with zeros and ones to get an equivalent value.
     * @param binary1 First binary.
     * @param binary2 Second binary.
     * @return A binary result to operate with 'or'
     */
    public static String binaryOrBinary(String binary1, String binary2) {
        if (binary1.length() > binary2.length()) {
            binary2 = fillMaxBits(binary1.length(), binary2);
        } else {
            binary1 = fillMaxBits(binary2.length(), binary1);
        }
        StringBuilder binaryToReturn = new StringBuilder(binary1);
        for (int i = 0; i < binary1.length(); i++) {
            binaryToReturn.setCharAt(i, binary1.charAt(i) == '1' || binary2.charAt(i) == '1' ? '1' : '0');
        }
        return binaryToReturn.toString();
    }
}
