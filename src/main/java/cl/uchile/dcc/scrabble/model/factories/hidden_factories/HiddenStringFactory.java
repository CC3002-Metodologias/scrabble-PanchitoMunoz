package cl.uchile.dcc.scrabble.model.factories.hidden_factories;

import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HiddenString;
import cl.uchile.dcc.scrabble.model.types.TypeString;
import cl.uchile.dcc.scrabble.model.factories.GeneralTypeFactory;
import java.util.HashMap;

/**
 * TODO: DOCUMENTAR
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/22 22:05
 */
public class HiddenStringFactory implements GeneralTypeFactory {

    /**
     * To use singleton pattern
     */
    private static HiddenStringFactory uniqueInstance;
    /**
     * To use Flyweight pattern
     */
    private final HashMap<String, HiddenString> hashMapCache = new HashMap<>();

    /**
     * Constructor.
     */
    private HiddenStringFactory() { }

    /**
     * Returns the unique instance of the factory.
     *
     * @return the instance of the factory
     */
    public static HiddenStringFactory getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new HiddenStringFactory();
        }
        return uniqueInstance;
    }

    /**
     * Returns a {@code HiddenString} with the same value in {@code instance}.
     *
     * @param instance an instance of {@code HiddenString}.
     * @return a {@code HiddenString} instance.
     */
    public HiddenString create(HiddenString instance) {
        String keyValue = instance.toSType().getValue();
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
