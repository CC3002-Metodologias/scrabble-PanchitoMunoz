package cl.uchile.dcc.scrabble.model.types.factories_types;

import static cl.uchile.dcc.scrabble.model.utils.BinaryUtilities.binaryToInt;
import static java.util.Objects.hash;

import cl.uchile.dcc.scrabble.model.types.TypeBinary;
import java.util.HashMap;
import java.util.Map;

/**
 * Factory of {@code TypeBinary}. In order to save RAM memory, use this factory. Only exists an
 * unique instance of this factory, to centralize the created instances.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/20 21:02
 * @see TypeBinary
 */
public class TypeBinaryFactory implements STypeFactory {

    // To use singleton pattern
    private static TypeBinaryFactory uniqueInstance;
    // To use Flyweight pattern
    private final Map<Integer, TypeBinary> createdBinaries = new HashMap<>();

    /**
     * Private constructor, to use singleton pattern
     */
    private TypeBinaryFactory() {
    }

    /**
     * Returns the unique instance of the factory.
     *
     * @return the instance of the factory
     */
    public static TypeBinaryFactory getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new TypeBinaryFactory();
        }
        return uniqueInstance;
    }

    /**
     * Returns a {@code TypeBinary} with the {@code value} as value.
     *
     * @param value a value to make an instance.
     * @return a {@code TypeBinary}.
     */
    public TypeBinary getTypeBinary(String value) {
        int hashValue = hash(binaryToInt(value));
        if (!createdBinaries.containsKey(hashValue)) {
            createdBinaries.put(hashValue, new TypeBinary(value));
        }
        return createdBinaries.get(hashValue);
    }
}
