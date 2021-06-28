package cl.uchile.dcc.scrabble.model.factories.hidden_factories;

import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HiddenFloat;
import cl.uchile.dcc.scrabble.model.types.TypeFloat;
import cl.uchile.dcc.scrabble.model.factories.GeneralTypeFactory;
import java.util.HashMap;

/**
 * Factory of {@code HiddenFloat}. In order to save RAM memory, use this factory. Only exists an
 * unique instance of this factory, to centralize the created instances.
 *
 * @see HiddenFloat
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
    private final HashMap<Double, HiddenFloat> hashMapCache = new HashMap<>();

    /**
     * Constructor.
     */
    private HiddenFloatFactory() { }

    /**
     * Returns the unique instance of the factory.
     *
     * @return the instance of the factory
     */
    public static HiddenFloatFactory getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new HiddenFloatFactory();
        }
        return uniqueInstance;
    }

    /**
     * Returns a {@code HiddenFloat} with the same value in {@code instance}.
     *
     * @param instance an instance of {@code HiddenFloat}.
     * @return a {@code HiddenFloat} instance.
     */
    public HiddenFloat create(HiddenFloat instance) {
        double keyValue = instance.toSType().getValue();
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
