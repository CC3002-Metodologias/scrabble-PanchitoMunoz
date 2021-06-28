package cl.uchile.dcc.scrabble.model.factories.hidden_factories;

import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HiddenBinary;
import cl.uchile.dcc.scrabble.model.types.TypeBinary;
import cl.uchile.dcc.scrabble.model.factories.GeneralTypeFactory;
import java.util.HashMap;

/**
 * Factory of {@code HiddenBinary}. In order to save RAM memory, use this factory. Only exists an
 * unique instance of this factory, to centralize the created instances.
 *
 * @see HiddenBinary
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
    private final HashMap<Integer, HiddenBinary> hashMapCache = new HashMap<>();

    /**
     * Constructor.
     */
    private HiddenBinaryFactory() { }

    /**
     * Returns the unique instance of the factory.
     *
     * @return the instance of the factory
     */
    public static HiddenBinaryFactory getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new HiddenBinaryFactory();
        }
        return uniqueInstance;
    }

    /**
     * Returns a {@code HiddenBinary} with the same value in {@code instance}.
     *
     * @param instance an instance of {@code HiddenBinary}.
     * @return a {@code HiddenBinary} instance.
     */
    public HiddenBinary create(HiddenBinary instance) {
        int keyValue = instance.toSType().getValueAsInt();
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
