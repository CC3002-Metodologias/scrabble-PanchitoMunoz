package cl.uchile.dcc.scrabble.model.types.factories_types;

import static java.util.Objects.hash;

import cl.uchile.dcc.scrabble.model.types.TypeInt;
import java.util.HashMap;
import java.util.Map;

/**
 * Factory of {@code TypeInt}. In order to save RAM memory, use this factory. Only exists an unique
 * instance of this factory, to centralize the created instances.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/20 21:03
 * @see TypeInt
 */
public class TypeIntFactory implements STypeFactory {

    // To use singleton pattern
    private static TypeIntFactory uniqueInstance;
    // To use Flyweight pattern
    private final Map<Integer, TypeInt> createdInts = new HashMap<>();

    /**
     * Private constructor, to use singleton pattern
     */
    private TypeIntFactory() {
    }

    /**
     * Returns the unique instance of the factory.
     *
     * @return the instance of the factory
     */
    public static TypeIntFactory getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new TypeIntFactory();
        }
        return uniqueInstance;
    }

    /**
     * Returns a {@code TypeInt} with the {@code value} as value.
     *
     * @param value a value to make an instance.
     * @return a {@code TypeInt}.
     */
    public TypeInt getTypeInt(int value) {
        int hashValue = hash(value);
        if (!createdInts.containsKey(hashValue)) {
            createdInts.put(hashValue, new TypeInt(value));
        }
        return createdInts.get(hashValue);
    }

}
