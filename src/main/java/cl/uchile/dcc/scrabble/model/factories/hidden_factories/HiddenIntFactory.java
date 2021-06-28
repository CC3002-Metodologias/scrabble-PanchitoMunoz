package cl.uchile.dcc.scrabble.model.factories.hidden_factories;

import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HiddenInt;
import cl.uchile.dcc.scrabble.model.types.TypeInt;
import cl.uchile.dcc.scrabble.model.factories.GeneralTypeFactory;
import java.util.HashMap;

/**
 * Factory of {@code HiddenInt}. In order to save RAM memory, use this factory. Only exists an
 * unique instance of this factory, to centralize the created instances.
 *
 * @see HiddenInt
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
    private final HashMap<Integer, HiddenInt> hashMapCache = new HashMap<>();

    /**
     * Constructor.
     */
    private HiddenIntFactory() { }

    /**
     * Returns the unique instance of the factory.
     *
     * @return the instance of the factory
     */
    public static HiddenIntFactory getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new HiddenIntFactory();
        }
        return uniqueInstance;
    }

    /**
     * Returns a {@code HiddenInt} with the same value in {@code instance}.
     *
     * @param instance an instance of {@code HiddenInt}.
     * @return a {@code HiddenInt} instance.
     */
    public HiddenInt create(HiddenInt instance) {
        int keyValue = instance.toSType().getValue();
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
