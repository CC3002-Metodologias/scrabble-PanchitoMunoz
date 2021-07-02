package cl.uchile.dcc.scrabble.model.factories;

import java.util.HashMap;

/**
 * An abstract class for the general types factories
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/07/02 12:32
 */
public class AbstractGeneralTypeFactory implements GeneralTypeFactory {

    /**
     * To use Flyweight pattern
     */
    private final HashMap<Object, Object> hashMapCache;

    /**
     * General constructor
     * @param hashMapCache a {@code HashMap}
     */
    protected AbstractGeneralTypeFactory(
        HashMap<Object, Object> hashMapCache) {
        this.hashMapCache = hashMapCache;
    }

    /**
     * Generalized way to create an {@code Object}.
     *
     * @param key a key to create the {@code Object}.
     * @param value a value to save in the {@code HashMap}
     * @return the {@code value} in the cache
     */
    protected final Object createWithKey(Object key, Object value) {
        if (!hashMapCache.containsKey(key)) {
            hashMapCache.put(key, value);
        }
        return hashMapCache.get(key);
    }

    /**
     * Clear the current caché.
     */
    @Override
    public final void clear() {
        hashMapCache.clear();
    }

    /**
     * Returns {@code true} if the caché is empty, {@code false} otherwise.
     *
     * @return a boolean
     */
    @Override
    public final boolean isEmpty() {
        return hashMapCache.isEmpty();
    }
}
