package cl.uchile.dcc.scrabble.model.types;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * A class for the binary type.
 * @author Francisco Muñoz Guajardo
 */
public class TypeBinary extends AbstractNumber {
    private final String value;

    /**
     * Constructor for the TypeBinary.
     * @param value A String as a value.
     */
    public TypeBinary(String value) {
        this.value = value;
    }

    /**
     * Method that determines if the object 'o' is equals to the current instance.
     * @param o Another object that is compared to the current instance.
     * @return A boolean that determines whether the current instance are equals with 'o'.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TypeBinary)) return false;
        TypeBinary that = (TypeBinary) o;
        return Objects.equals(value, that.value);
    }

    /**
     * Method that returns the hash code of the current instance.
     * @return The hash code of the current instance.
     */
    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    /**
     * Method that provides a representation of the current instance as a String.
     * @return The representation as a String.
     */
    @Override
    public String toString() {
        return "TypeBinary{" +
                "value='" + value + '\'' +
                '}';
    }

    /**
     * Transforms the current type to a TypeString.
     *
     * @return TypeString with a value equivalent to the current type.
     */
    @Override
    public TypeString toTypeString() {
        return new TypeString(this.value);
    }

    /**
     * Transforms the current type to a TypeFloat.
     *
     * @return TypeFloat with a value equivalent to the current type.
     */
    @Override
    public TypeFloat toTypeFloat() {
        System.out.println("Estoy haciendo la representacion de un binario como un float :)");
        return null;
    }

    /**
     * Transforms the current type to a TypeInt.
     *
     * @return TypeInt with a value equivalent to the current type.
     */
    public TypeInt toTypeInt() {
        System.out.println("Estoy haciendo la representacion de un binario como un int :)");
        return null;
    }

    /**
     * Transforms the current type to a TypeBinary.
     *
     * @return TypeBinary with a value equivalent to the current type.
     */
    public TypeBinary toTypeBinary() {
        return new TypeBinary(this.value);
    }

    // TODO: DE AQUI A ABAJO REFACTORIZAR
    private int bitToInt(char bit) {
        return bit == '0' ? 0 : 1;
    }

    private int positiveBinaryToInt(String binary) {
        int w = 0;
        for (int i = binary.length() - 1, j = 0; i > 0; i--, j++) {
            w += (int) Math.pow(2, j) * bitToInt(binary.charAt(i));
        }
        return w;
    }

    private int negativeBinaryToInt(String binary) {
        int n = binary.length() - 1 ;
        int w = -bitToInt(binary.charAt(0)) * (int) Math.pow(2, n);
        for (int i = 1, j = 0; i > 0; i--, j++) {
            w += (int) Math.pow(2, j) * (binary.charAt(i) == '1' ? 1 : 0);
        }
        return w;
    }

    public int binaryToInt(String binary) {
        if (bitToInt(binary.charAt(0)) == 0) {
            return positiveBinaryToInt(binary);
        } else {
            return negativeBinaryToInt(binary);
        }
    }

    public String addTwoBinaries(String a, String b) {
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
        return result.toString();
    }

    public String oneComplement(String binary) {
        StringBuilder oppositeBinary = new StringBuilder();
        for (int i = 0; i < binary.length(); i++) {
            oppositeBinary.append(binary.charAt(i) == '0' ? '1' : '0');
        }
        return oppositeBinary.toString();
    }

    public String oneBinary(int maxLength) {
        StringBuilder oneBinaryString = new StringBuilder();
        for (int i = 0; i < maxLength; i++) {
            oneBinaryString.append(i == maxLength - 1 ? '1' : '0');
        }
        return oneBinaryString.toString();
    }

    public String twosComplement(String binary) {
        String oppositeBinary = oneComplement(binary);
        String oneBinary = oneBinary(binary.length());
        return addTwoBinaries(oppositeBinary, oneBinary);
    }

    public String positiveIntToBinary(int num) {
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
}
