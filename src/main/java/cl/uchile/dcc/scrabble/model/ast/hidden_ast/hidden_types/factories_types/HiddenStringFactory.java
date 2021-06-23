package cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.factories_types;

import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HiddenFloat;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HiddenString;
import cl.uchile.dcc.scrabble.model.types.TypeFloat;
import cl.uchile.dcc.scrabble.model.types.TypeString;
import cl.uchile.dcc.scrabble.model.types.factories_types.TypeFactory;
import java.util.HashMap;

/**
 * TODO: DOCUMENTAR
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/22 22:05
 */
public class HiddenStringFactory implements TypeFactory {

    /**
     * To use singleton pattern
     */
    private static HiddenStringFactory uniqueInstance;
    /**
     * To use Flyweight pattern
     */
    private final HashMap<String, HiddenString> hashMapCache;

    /**
     * Constructor only for tests.
     *
     * @param hashMapCache a hash map
     */
    private HiddenStringFactory(HashMap<String, HiddenString> hashMapCache) {
        this.hashMapCache = hashMapCache;
    }

    /**
     * Only for tests.
     *
     * @param hashMapCache a hash map
     * @return the instance of the factory.
     */
    private static HiddenStringFactory getInstance(HashMap<String, HiddenString> hashMapCache) {
        if (uniqueInstance == null) {
            uniqueInstance = new HiddenStringFactory(hashMapCache);
        }
        return uniqueInstance;
    }

    /**
     * Returns the unique instance of the factory.
     *
     * @return the instance of the factory
     */
    public static HiddenStringFactory getInstance() {
        return getInstance(new HashMap<>());
    }

    /**
     * Returns a {@code HiddenString} with the same value in {@code instance}.
     *
     * @param instance an instance of {@code HiddenString}.
     * @return a {@code HiddenString} instance.
     */
    public HiddenString create(HiddenString instance) {
        String keyValue = instance.getAdaptee().getValue();
        if (!hashMapCache.containsKey(keyValue)) {
            hashMapCache.put(keyValue, instance);
        }
        return hashMapCache.get(keyValue);
    }

    /**
     * Returns a {@code HiddenString} with the same value in {@code instance}.
     *
     * @param instance an instance of {@code TypeString}.
     * @return a {@code HiddenString} instance.
     */
    public HiddenString create(TypeString instance) {
        return create(new HiddenString(instance));
    }

    /**
     * Returns a {@code HiddenString} with the same {@code value} as value.
     *
     * @param value a value.
     * @return a {@code HiddenString} instance.
     */
    public HiddenString create(String value) {
        return create(new HiddenString(value));
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
