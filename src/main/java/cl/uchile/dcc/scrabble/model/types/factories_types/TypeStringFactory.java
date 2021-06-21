package cl.uchile.dcc.scrabble.model.types.factories_types;

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
    private final HashMap<String, TypeString> hashMapCache;

    /**
     * Constructor only for tests.
     *
     * @param hashMapCache a hash map
     */
    private TypeStringFactory(HashMap<String, TypeString> hashMapCache) {
        this.hashMapCache = hashMapCache;
    }

    /**
     * Only for tests.
     *
     * @param hashMapCache a hash map
     * @return the instance of the factory.
     */
    private static TypeStringFactory getInstance(HashMap<String, TypeString> hashMapCache) {
        if (uniqueInstance == null) {
            uniqueInstance = new TypeStringFactory(hashMapCache);
        }
        return uniqueInstance;
    }

    /**
     * Returns the unique instance of the factory.
     *
     * @return the instance of the factory
     */
    public static TypeStringFactory getInstance() {
        return getInstance(new HashMap<>());
    }

    /**
     * Returns a {@code TypeString} with the {@code value} as value.
     *
     * @param value a value to make an instance.
     * @return a {@code TypeString}.
     */
    public TypeString create(String value) {
        if (!hashMapCache.containsKey(value)) {
            hashMapCache.put(value, new TypeString(value));
        }
        return hashMapCache.get(value);
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
