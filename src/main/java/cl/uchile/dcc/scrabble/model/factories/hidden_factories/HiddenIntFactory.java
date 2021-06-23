package cl.uchile.dcc.scrabble.model.factories.hidden_factories;

import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HiddenInt;
import cl.uchile.dcc.scrabble.model.types.TypeInt;
import cl.uchile.dcc.scrabble.model.factories.GeneralTypeFactory;
import java.util.HashMap;

/**
 * TODO: DOCUMENTAR
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/22 22:05
 */
public class HiddenIntFactory implements GeneralTypeFactory {

    /**
     * To use singleton pattern
     */
    private static HiddenIntFactory uniqueInstance;
    /**
     * To use Flyweight pattern
     */
    private final HashMap<Integer, HiddenInt> hashMapCache;

    /**
     * Constructor only for tests.
     *
     * @param hashMapCache a hash map
     */
    private HiddenIntFactory(HashMap<Integer, HiddenInt> hashMapCache) {
        this.hashMapCache = hashMapCache;
    }

    /**
     * Only for tests.
     *
     * @param hashMapCache a hash map
     * @return the instance of the factory.
     */
    private static HiddenIntFactory getInstance(HashMap<Integer, HiddenInt> hashMapCache) {
        if (uniqueInstance == null) {
            uniqueInstance = new HiddenIntFactory(hashMapCache);
        }
        return uniqueInstance;
    }

    /**
     * Returns the unique instance of the factory.
     *
     * @return the instance of the factory
     */
    public static HiddenIntFactory getInstance() {
        return getInstance(new HashMap<>());
    }

    /**
     * Returns a {@code HiddenInt} with the same value in {@code instance}.
     *
     * @param instance an instance of {@code HiddenInt}.
     * @return a {@code HiddenInt} instance.
     */
    public HiddenInt create(HiddenInt instance) {
        int keyValue = instance.getAdaptee().getValue();
        if (!hashMapCache.containsKey(keyValue)) {
            hashMapCache.put(keyValue, instance);
        }
        return hashMapCache.get(keyValue);
    }

    /**
     * Returns a {@code HiddenInt} with the same value in {@code instance}.
     *
     * @param instance an instance of {@code TypeInt}.
     * @return a {@code HiddenInt} instance.
     */
    public HiddenInt create(TypeInt instance) {
        return create(new HiddenInt(instance));
    }

    /**
     * Returns a {@code HiddenInt} with the same {@code value} as value.
     *
     * @param value a value.
     * @return a {@code HiddenInt} instance.
     */
    public HiddenInt create(int value) {
        return create(new HiddenInt(value));
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
