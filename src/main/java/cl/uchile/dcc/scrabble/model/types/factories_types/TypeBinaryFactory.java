package cl.uchile.dcc.scrabble.model.types.factories_types;

import static cl.uchile.dcc.scrabble.model.utils.BinaryUtilities.binaryToInt;

import cl.uchile.dcc.scrabble.model.types.TypeBinary;
import java.util.HashMap;

/**
 * Factory of {@code TypeBinary}. In order to save RAM memory, use this factory. Only exists an
 * unique instance of this factory, to centralize the created instances.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/20 21:02
 * @see TypeBinary
 */
public class TypeBinaryFactory implements STypeFactory {

    /**
     * To use singleton pattern
     */
    private static TypeBinaryFactory uniqueInstance;
    /**
     * To use Flyweight pattern
     */
    private final HashMap<Integer, TypeBinary> hashMapCache;

    /**
     * Constructor only for tests.
     *
     * @param hashMapCache a hash map
     */
    private TypeBinaryFactory(HashMap<Integer, TypeBinary> hashMapCache) {
        this.hashMapCache = hashMapCache;
    }

    /**
     * Only for tests.
     *
     * @param hashMapCache a hash map
     * @return the instance of the factory.
     */
    private static TypeBinaryFactory getInstance(HashMap<Integer, TypeBinary> hashMapCache) {
        if (uniqueInstance == null) {
            uniqueInstance = new TypeBinaryFactory(hashMapCache);
        }
        return uniqueInstance;
    }

    /**
     * Returns the unique instance of the factory.
     *
     * @return the instance of the factory
     */
    public static TypeBinaryFactory getInstance() {
        return getInstance(new HashMap<>());
    }

    /**
     * Returns a {@code TypeBinary} with the {@code value} as value.
     *
     * @param value a value to make an instance.
     * @return a {@code TypeBinary}.
     */
    public TypeBinary create(String value) {
        int keyValue = binaryToInt(value);
        if (!hashMapCache.containsKey(keyValue)) {
            hashMapCache.put(keyValue, new TypeBinary(value));
        }
        return hashMapCache.get(keyValue);
    }

    /**
     * Clear the current caché.
     */
    @Override
    public void clear() {
        hashMapCache.clear();
    }

    /**
     * Returns {@code true} if the caché is empty, {@code false} otherwise.
     *
     * @return a boolean
     */
    @Override
    public boolean isEmpty() {
        return hashMapCache.isEmpty();
    }
}
