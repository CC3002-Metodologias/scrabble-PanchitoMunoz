package cl.uchile.dcc.scrabble.model.factories.hidden_factories;

import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HiddenBinary;
import cl.uchile.dcc.scrabble.model.types.TypeBinary;
import cl.uchile.dcc.scrabble.model.factories.GeneralTypeFactory;
import java.util.HashMap;

/**
 * TODO: DOCUMENTAR
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/22 22:02
 */
public class HiddenBinaryFactory implements GeneralTypeFactory {

    /**
     * To use singleton pattern
     */
    private static HiddenBinaryFactory uniqueInstance;
    /**
     * To use Flyweight pattern
     */
    private final HashMap<Integer, HiddenBinary> hashMapCache;

    /**
     * Constructor only for tests.
     *
     * @param hashMapCache a hash map
     */
    private HiddenBinaryFactory(HashMap<Integer, HiddenBinary> hashMapCache) {
        this.hashMapCache = hashMapCache;
    }

    /**
     * Only for tests.
     *
     * @param hashMapCache a hash map
     * @return the instance of the factory.
     */
    private static HiddenBinaryFactory getInstance(HashMap<Integer, HiddenBinary> hashMapCache) {
        if (uniqueInstance == null) {
            uniqueInstance = new HiddenBinaryFactory(hashMapCache);
        }
        return uniqueInstance;
    }

    /**
     * Returns the unique instance of the factory.
     *
     * @return the instance of the factory
     */
    public static HiddenBinaryFactory getInstance() {
        return getInstance(new HashMap<>());
    }

    /**
     * Returns a {@code HiddenBinary} with the same value in {@code instance}.
     *
     * @param instance an instance of {@code HiddenBinary}.
     * @return a {@code HiddenBinary} instance.
     */
    public HiddenBinary create(HiddenBinary instance) {
        int keyValue = instance.getAdaptee().getValueAsInt();
        if (!hashMapCache.containsKey(keyValue)) {
            hashMapCache.put(keyValue, instance);
        }
        return hashMapCache.get(keyValue);
    }

    /**
     * Returns a {@code HiddenBinary} with the same value in {@code instance}.
     *
     * @param instance an instance of {@code TypeBinary}.
     * @return a {@code HiddenBinary} instance.
     */
    public HiddenBinary create(TypeBinary instance) {
        return create(new HiddenBinary(instance));
    }

    /**
     * Returns a {@code HiddenBinary} with the same {@code value} as value.
     *
     * @param value a value.
     * @return a {@code HiddenBinary} instance.
     */
    public HiddenBinary create(String value) {
        return create(new HiddenBinary(value));
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
