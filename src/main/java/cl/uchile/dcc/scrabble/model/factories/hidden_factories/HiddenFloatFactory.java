package cl.uchile.dcc.scrabble.model.factories.hidden_factories;

import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HiddenFloat;
import cl.uchile.dcc.scrabble.model.types.TypeFloat;
import cl.uchile.dcc.scrabble.model.factories.GeneralTypeFactory;
import java.util.HashMap;

/**
 * TODO: DOCUMENTAR
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/22 22:04
 */
public class HiddenFloatFactory implements GeneralTypeFactory {

    /**
     * To use singleton pattern
     */
    private static HiddenFloatFactory uniqueInstance;
    /**
     * To use Flyweight pattern
     */
    private final HashMap<Double, HiddenFloat> hashMapCache;

    /**
     * Constructor only for tests.
     *
     * @param hashMapCache a hash map
     */
    private HiddenFloatFactory(HashMap<Double, HiddenFloat> hashMapCache) {
        this.hashMapCache = hashMapCache;
    }

    /**
     * Only for tests.
     *
     * @param hashMapCache a hash map
     * @return the instance of the factory.
     */
    private static HiddenFloatFactory getInstance(HashMap<Double, HiddenFloat> hashMapCache) {
        if (uniqueInstance == null) {
            uniqueInstance = new HiddenFloatFactory(hashMapCache);
        }
        return uniqueInstance;
    }

    /**
     * Returns the unique instance of the factory.
     *
     * @return the instance of the factory
     */
    public static HiddenFloatFactory getInstance() {
        return getInstance(new HashMap<>());
    }

    /**
     * Returns a {@code HiddenFloat} with the same value in {@code instance}.
     *
     * @param instance an instance of {@code HiddenFloat}.
     * @return a {@code HiddenFloat} instance.
     */
    public HiddenFloat create(HiddenFloat instance) {
        double keyValue = instance.getAdaptee().getValue();
        if (!hashMapCache.containsKey(keyValue)) {
            hashMapCache.put(keyValue, instance);
        }
        return hashMapCache.get(keyValue);
    }

    /**
     * Returns a {@code HiddenFloat} with the same value in {@code instance}.
     *
     * @param instance an instance of {@code TypeFloat}.
     * @return a {@code HiddenFloat} instance.
     */
    public HiddenFloat create(TypeFloat instance) {
        return create(new HiddenFloat(instance));
    }

    /**
     * Returns a {@code HiddenFloat} with the same {@code value} as value.
     *
     * @param value a value.
     * @return a {@code HiddenFloat} instance.
     */
    public HiddenFloat create(double value) {
        return create(new HiddenFloat(value));
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
