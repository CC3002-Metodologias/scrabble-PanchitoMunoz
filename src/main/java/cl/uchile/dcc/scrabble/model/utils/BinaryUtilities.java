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
        return addTwoBinaries(oppositeBinary, "01");
    }

    /**
     * Returns the binary representation of the number 'num'
     * @param num An integer as a number.
     * @return The binary representation of 'num'.
     */
    private static String positiveIntToBinary(int num) {
        if (num == 0) return "0";
        int nBits = (int) (Math.floor(Math.log(num) / Math.log(2)) + 1);
        int[] binary = new int[nBits];
        int id = 0;
        while (num > 0) {
            binary[id] = num % 2;
            num = num / 2;
            id++;
        }
        StringBuilder binaryString = new StringBuilder();
        for (int i = binary.length - 1; i >= 0; i--) {
            binaryString.append(binary[i]);
        }
        return "0" + binaryString;
    }

    /**
     * Returns the sum of the binary number 'a' and the binary number 'b' as another binary number.
     * @param a A binary number.
     * @param b Another binary number.
     * @return The sum between 'a' and 'b'.
     */
    public static String addTwoBinaries(String a, String b) {
        StringBuilder result = new StringBuilder();
        int s = 0;
        int i = a.length() - 1, j = b.length() - 1;
        while (i >= 0 || j >= 0 || s == 1){
            s += ((i >= 0)? a.charAt(i) - '0': 0);
            s += ((j >= 0)? b.charAt(j) - '0': 0);
            result.insert(0, (char) (s % 2 + '0'));
            s /= 2;
            i--; j--;
        }
        // Case where a negative is added to a positive
        if (result.length() > Math.max(a.length(), b.length())) {
            result.deleteCharAt(0);
        }
        // Case where two positives overload the binary representation and it is represented as a negative
        if (binaryToInt(a) + binaryToInt(b) > 0 && result.charAt(0) == '1') {
            result.insert(0, '0');
        }
        return result.toString();
    }

    /**
     * Returns the binary representation of any integer 'num'.
     * @param num An integer number.
     * @return The representation of the number as a binary.
     */
    public static String intToBinary(int num) {
        int absNum = Math.abs(num);
        String  binaryNum = positiveIntToBinary(absNum);
        if (num < 0) {
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
        if (bitToInt(binary.charAt(0)) == 0) {
            return positiveBinaryToInt(binary);
        } else {
            return negativeBinaryToInt(binary);
        }
    }
}
