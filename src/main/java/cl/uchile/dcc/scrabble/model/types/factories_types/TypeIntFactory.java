package cl.uchile.dcc.scrabble.model.types.factories_types;

import cl.uchile.dcc.scrabble.model.types.TypeInt;
import java.util.HashMap;

/**
 * Factory of {@code TypeInt}. In order to save RAM memory, use this factory. Only exists an unique
 * instance of this factory, to centralize the created instances.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/20 21:03
 * @see TypeInt
 */
public class TypeIntFactory implements STypeFactory {

    /**
     * To use singleton pattern
     */
    private static TypeIntFactory uniqueInstance;
    /**
     * To use Flyweight pattern
     */
    private final HashMap<Integer, TypeInt> hashMapCache;

    /**
     * Constructor only for tests.
     *
     * @param hashMapCache a hash map
     */
    private TypeIntFactory(HashMap<Integer, TypeInt> hashMapCache) {
        this.hashMapCache = hashMapCache;
    }

    /**
     * Only for tests.
     *
     * @param hashMapCache a hash map
     * @return the instance of the factory.
     */
    private static TypeIntFactory getInstance(HashMap<Integer, TypeInt> hashMapCache) {
        if (uniqueInstance == null) {
            uniqueInstance = new TypeIntFactory(hashMapCache);
        }
        return uniqueInstance;
    }

    /**
     * Returns the unique instance of the factory.
     *
     * @return the instance of the factory
     */
    public static TypeIntFactory getInstance() {
        return getInstance(new HashMap<>());
    }

    /**
     * Returns a {@code TypeInt} with the {@code value} as value.
     *
     * @param value a value to make an instance.
     * @return a {@code TypeInt}.
     */
    public TypeInt create(int value) {
        if (!hashMapCache.containsKey(value)) {
            hashMapCache.put(value, new TypeInt(value));
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
