package cl.uchile.dcc.scrabble.model.types.factories_types;

import cl.uchile.dcc.scrabble.model.types.TypeFloat;
import java.util.HashMap;

/**
 * Factory of {@code TypeFloat}. In order to save RAM memory, use this factory. Only exists an
 * unique instance of this factory, to centralize the created instances.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/20 21:03
 * @see TypeFloat
 */
public class TypeFloatFactory implements STypeFactory {

    /**
     * To use singleton pattern
     */
    private static TypeFloatFactory uniqueInstance;
    /**
     * To use Flyweight pattern
     */
    private final HashMap<Double, TypeFloat> hashMapCache;

    /**
     * Constructor only for tests.
     *
     * @param hashMapCache a hash map
     */
    private TypeFloatFactory(HashMap<Double, TypeFloat> hashMapCache) {
        this.hashMapCache = hashMapCache;
    }

    /**
     * Only for tests.
     *
     * @param hashMapCache a hash map
     * @return the instance of the factory.
     */
    private static TypeFloatFactory getInstance(HashMap<Double, TypeFloat> hashMapCache) {
        if (uniqueInstance == null) {
            uniqueInstance = new TypeFloatFactory(hashMapCache);
        }
        return uniqueInstance;
    }

    /**
     * Returns the unique instance of the factory.
     *
     * @return the instance of the factory
     */
    public static TypeFloatFactory getInstance() {
        return getInstance(new HashMap<>());
    }

    /**
     * Returns a {@code TypeFloat} with the {@code value} as value.
     *
     * @param value a value to make an instance.
     * @return a {@code TypeFloat}.
     */
    public TypeFloat create(double value) {
        if (!hashMapCache.containsKey(value)) {
            hashMapCache.put(value, new TypeFloat(value));
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
