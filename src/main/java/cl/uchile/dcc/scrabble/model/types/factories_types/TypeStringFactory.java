package cl.uchile.dcc.scrabble.model.types.factories_types;

import static java.util.Objects.hash;

import cl.uchile.dcc.scrabble.model.types.TypeString;
import java.util.HashMap;

/**
 * Factory of {@code TypeString}. In order to save RAM memory, use this factory. Only exists an
 * unique instance of this factory, to centralize the created instances.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/20 21:03
 * @see TypeString
 */
public class TypeStringFactory implements STypeFactory {

    /**
     * To use singleton pattern
     */
    private static TypeStringFactory uniqueInstance;
    /**
     * To use Flyweight pattern
     */
    private final HashMap<Integer, TypeString> hashMapCache = new HashMap<>();

    /**
     * Private constructor, to use singleton pattern
     */
    private TypeStringFactory() {
    }

    /**
     * Returns the unique instance of the factory.
     *
     * @return the instance of the factory
     */
    public static TypeStringFactory getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new TypeStringFactory();
        }
        return uniqueInstance;
    }

    /**
     * Returns a {@code TypeString} with the {@code value} as value.
     *
     * @param value a value to make an instance.
     * @return a {@code TypeString}.
     */
    public TypeString getTypeString(String value) {
        int hashValue = hash(value);
        if (!hashMapCache.containsKey(hashValue)) {
            hashMapCache.put(hashValue, new TypeString(value));
        }
        return hashMapCache.get(hashValue);
    }

    /**
     * Only for test.
     *
     * @return a hash map
     */
    protected HashMap<Integer, TypeString> getHashMapCache() {
        return hashMapCache;
    }

    /**
     * Clear the current caché.
     */
    @Override
    public void clear() {
        hashMapCache.clear();
    }
}
