package cl.uchile.dcc.scrabble.model.factories.types_factories;

import cl.uchile.dcc.scrabble.model.factories.GeneralTypeFactory;
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
public class TypeBinaryFactory implements GeneralTypeFactory {

    /**
     * To use singleton pattern
     */
    private static TypeBinaryFactory uniqueInstance;
    /**
     * To use Flyweight pattern
     */
    private final HashMap<Integer, TypeBinary> hashMapCache = new HashMap<>();

    /**
     * Constructor.
     */
    private TypeBinaryFactory() { }

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
     * Returns a {@code TypeBinary} with the same value in {@code instance}.
     *
     * @param instance an instance.
     * @return a {@code TypeBinary} instance.
     */
    public TypeBinary create(TypeBinary instance) {
        int keyValue = instance.getValueAsInt();
        if (!hashMapCache.containsKey(keyValue)) {
            hashMapCache.put(keyValue, instance);
        }
        return hashMapCache.get(keyValue);
    }

    /**
     * Returns a {@code TypeBinary} with the {@code value} as value.
     *
     * @param value a value to make an instance.
     * @return a {@code TypeBinary}.
     */
    public TypeBinary create(String value) {
        return create(new TypeBinary(value));
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
