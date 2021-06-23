package cl.uchile.dcc.scrabble.model.factories.hidden_factories;

import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HiddenBool;
import cl.uchile.dcc.scrabble.model.types.TypeBool;
import cl.uchile.dcc.scrabble.model.factories.GeneralTypeFactory;
import java.util.HashMap;

/**
 * TODO: DOCUMENTAR
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/22 22:03
 */
public class HiddenBoolFactory implements GeneralTypeFactory {

    /**
     * To use singleton pattern
     */
    private static HiddenBoolFactory uniqueInstance;
    /**
     * To use Flyweight pattern
     */
    private final HashMap<Boolean, HiddenBool> hashMapCache;

    /**
     * Constructor only for tests.
     *
     * @param hashMapCache a hash map
     */
    private HiddenBoolFactory(HashMap<Boolean, HiddenBool> hashMapCache) {
        this.hashMapCache = hashMapCache;
    }

    /**
     * Only for tests.
     *
     * @param hashMapCache a hash map
     * @return the instance of the factory.
     */
    private static HiddenBoolFactory getInstance(HashMap<Boolean, HiddenBool> hashMapCache) {
        if (uniqueInstance == null) {
            uniqueInstance = new HiddenBoolFactory(hashMapCache);
        }
        return uniqueInstance;
    }

    /**
     * Returns the unique instance of the factory.
     *
     * @return the instance of the factory
     */
    public static HiddenBoolFactory getInstance() {
        return getInstance(new HashMap<>());
    }

    /**
     * Returns a {@code HiddenBool} with the same value in {@code instance}.
     *
     * @param instance an instance of {@code HiddenBool}.
     * @return a {@code HiddenBool} instance.
     */
    public HiddenBool create(HiddenBool instance) {
        boolean keyValue = instance.getAdaptee().getValue();
        if (!hashMapCache.containsKey(keyValue)) {
            hashMapCache.put(keyValue, instance);
        }
        return hashMapCache.get(keyValue);
    }

    /**
     * Returns a {@code HiddenBool} with the same value in {@code instance}.
     *
     * @param instance an instance of {@code TypeBool}.
     * @return a {@code HiddenBool} instance.
     */
    public HiddenBool create(TypeBool instance) {
        return create(new HiddenBool(instance));
    }

    /**
     * Returns a {@code HiddenBool} with the same {@code value} as value.
     *
     * @param value a value.
     * @return a {@code HiddenBool} instance.
     */
    public HiddenBool create(boolean value) {
        return create(new HiddenBool(value));
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
