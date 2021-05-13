package cl.uchile.dcc.scrabble.model.utils;

/**
 * Class that provides the utilities for the transformation between int and binary.
 * @author Francisco Muñoz Guajardo.
 */
public final class BinaryUtilities {
    /**
     * Private constructor to avoid instance of this class.
     */
    private BinaryUtilities() {}

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
        for (int i = binary.length() - 1, j = 0; i > 0; i--, j++) {
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
        int n = binary.length() - 1 ;
        int w = -bitToInt(binary.charAt(0)) * (int) Math.pow(2, n);
        for (int i = n, j = 0; i > 0; i--, j++) {
            w += (int) Math.pow(2, j) * (binary.charAt(i) == '1' ? 1 : 0);
        }
        return w;
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
        String oppositeBinary = oneComplement(binary);
        // The following code adds 1 in binary to the oppositeBinary
        StringBuilder copyOppositeBinary = new StringBuilder(oppositeBinary);
        int i = oppositeBinary.length() - 1;
        while (i >= 0) {
            if (oppositeBinary.charAt(i) == '1') {
                copyOppositeBinary.setCharAt(i, '0');
                i--;
            } else {
                copyOppositeBinary.setCharAt(i, '1');
                i = -1;
            }
        }
        return copyOppositeBinary.toString();
    }

    /**
     * Returns the binary representation of the number 'intNumber'
     * @param intNumber An integer as a number.
     * @return The binary representation of 'intNumber'.
     */
    private static String positiveIntToBinary(int intNumber) {
        if (intNumber == 0) return "0";
        int nBits = (int) (Math.floor(Math.log(intNumber) / Math.log(2)) + 1);
        int[] binary = new int[nBits];
        int id = 0;
        while (intNumber > 0) {
            binary[id] = intNumber % 2;
            intNumber = intNumber / 2;
            id++;
        }
        StringBuilder binaryString = new StringBuilder();
        for (int i = binary.length - 1; i >= 0; i--) {
            binaryString.append(binary[i]);
        }
        return "0" + binaryString;
    }

    /**
     * Returns the sum of the binary number 'binary1' and the binary number 'binary2' as another binary number.
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
        String  binaryNum = positiveIntToBinary(absNumber);
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
        if (binary.equals("0")) return 0;
        if (bitToInt(binary.charAt(0)) == 0) {
            return positiveBinaryToInt(binary);
        } else {
            return negativeBinaryToInt(binary);
        }
    }

    public static boolean binaryEqual(String binary1, String binary2) {
        Integer binary1AsInt = binaryToInt(binary1);
        Integer binary2AsInt = binaryToInt(binary2);
        return binary1AsInt.equals(binary2AsInt);
    }
}
