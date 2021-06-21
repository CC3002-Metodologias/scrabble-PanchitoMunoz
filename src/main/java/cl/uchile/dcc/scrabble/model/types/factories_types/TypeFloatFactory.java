package cl.uchile.dcc.scrabble.model.types.factories_types;

import static java.util.Objects.hash;

import cl.uchile.dcc.scrabble.model.types.TypeFloat;
import java.util.HashMap;
import java.util.Map;

/**
 * Factory of {@code TypeFloat}. In order to save RAM memory, use this factory. Only exists an
 * unique instance of this factory, to centralize the created instances.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/20 21:03
 * @see TypeFloat
 */
public class TypeFloatFactory implements STypeFactory {

    // To use singleton pattern
    private static TypeFloatFactory uniqueInstance;
    // To use Flyweight pattern
    private final Map<Integer, TypeFloat> createdFloats = new HashMap<>();

    /**
     * Private constructor, to use singleton pattern
     */
    private TypeFloatFactory() {
    }

    /**
     * Returns the unique instance of the factory.
     *
     * @return the instance of the factory
     */
    public static TypeFloatFactory getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new TypeFloatFactory();
        }
        return uniqueInstance;
    }

    /**
     * Returns a {@code TypeFloat} with the {@code value} as value.
     *
     * @param value a value to make an instance.
     * @return a {@code TypeFloat}.
     */
    public TypeFloat getTypeFloat(double value) {
        int hashValue = hash(value);
        if (!createdFloats.containsKey(hashValue)) {
            createdFloats.put(hashValue, new TypeFloat(value));
        }
        return createdFloats.get(hashValue);
    }

}
