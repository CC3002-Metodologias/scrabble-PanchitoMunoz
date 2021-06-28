package cl.uchile.dcc.scrabble.model.factories.types_factories;

import cl.uchile.dcc.scrabble.model.factories.GeneralTypeFactory;
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
public class TypeStringFactory implements GeneralTypeFactory {

    /**
     * To use singleton pattern
     */
    private static TypeStringFactory uniqueInstance;
    /**
     * To use Flyweight pattern
     */
    private final HashMap<String, TypeString> hashMapCache = new HashMap<>();

    /**
     * Constructor.
     */
    private TypeStringFactory() { }

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
     * Returns a {@code TypeString} with the same value in {@code instance}.
     *
     * @param instance an instance.
     * @return a {@code TypeString} instance.
     */
    public TypeString create(TypeString instance) {
        String keyValue = instance.getValue();
        if (!hashMapCache.containsKey(keyValue)) {
            hashMapCache.put(keyValue, instance);
        }
        return hashMapCache.get(keyValue);
    }

    /**
     * Returns a {@code TypeString} with the {@code value} as value.
     *
     * @param value a value to make an instance.
     * @return a {@code TypeString}.
     */
    public TypeString create(String value) {
        return create(new TypeString(value));
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
