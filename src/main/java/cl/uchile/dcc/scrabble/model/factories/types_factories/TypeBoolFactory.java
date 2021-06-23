package cl.uchile.dcc.scrabble.model.factories.types_factories;

import cl.uchile.dcc.scrabble.model.factories.GeneralTypeFactory;
import cl.uchile.dcc.scrabble.model.types.TypeBool;
import java.util.HashMap;

/**
 * Factory of {@code TypeBool}. In order to save RAM memory, use this factory. Only exists an unique
 * instance of this factory, to centralize the created instances.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/20 21:03
 * @see TypeBool
 */
public class TypeBoolFactory implements GeneralTypeFactory {

    /**
     * To use singleton pattern
     */
    private static TypeBoolFactory uniqueInstance;
    /**
     * To use Flyweight pattern
     */
    private final HashMap<Boolean, TypeBool> hashMapCache;

    /**
     * Constructor only for tests.
     *
     * @param hashMapCache a hash map
     */
    private TypeBoolFactory(HashMap<Boolean, TypeBool> hashMapCache) {
        this.hashMapCache = hashMapCache;
    }

    /**
     * Only for tests.
     *
     * @param hashMapCache a hash map
     * @return the instance of the factory.
     */
    private static TypeBoolFactory getInstance(HashMap<Boolean, TypeBool> hashMapCache) {
        if (uniqueInstance == null) {
            uniqueInstance = new TypeBoolFactory(hashMapCache);
        }
        return uniqueInstance;
    }

    /**
     * Returns the unique instance of the factory.
     *
     * @return the instance of the factory
     */
    public static TypeBoolFactory getInstance() {
        return getInstance(new HashMap<>());
    }

    /**
     * Returns a {@code TypeBool} with the same value in {@code instance}.
     *
     * @param instance an instance.
     * @return a {@code TypeBool} instance.
     */
    public TypeBool create(TypeBool instance) {
        boolean keyValue = instance.getValue();
        if (!hashMapCache.containsKey(keyValue)) {
            hashMapCache.put(keyValue, instance);
        }
        return hashMapCache.get(keyValue);
    }

    /**
     * Returns a {@code TypeBool} with the {@code value} as value.
     *
     * @param value a value to make an instance.
     * @return a {@code TypeBool}.
     */
    public TypeBool create(boolean value) {
        return create(new TypeBool(value));
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
