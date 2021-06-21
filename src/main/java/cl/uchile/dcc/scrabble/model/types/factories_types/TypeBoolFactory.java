package cl.uchile.dcc.scrabble.model.types.factories_types;

import static java.util.Objects.hash;

import cl.uchile.dcc.scrabble.model.types.TypeBool;
import java.util.HashMap;
import java.util.Map;

/**
 * Factory of {@code TypeBool}. In order to save RAM memory, use this factory. Only exists an unique
 * instance of this factory, to centralize the created instances.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/20 21:03
 * @see TypeBool
 */
public class TypeBoolFactory implements STypeFactory {

    // To use singleton pattern
    private static TypeBoolFactory uniqueInstance;
    // To use Flyweight pattern
    private final Map<Integer, TypeBool> createdBooleans = new HashMap<>();

    /**
     * Private constructor, to use singleton pattern
     */
    private TypeBoolFactory() {
    }

    /**
     * Returns the unique instance of the factory.
     *
     * @return the instance of the factory
     */
    public static TypeBoolFactory getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new TypeBoolFactory();
        }
        return uniqueInstance;
    }

    /**
     * Returns a {@code TypeBool} with the {@code value} as value.
     *
     * @param value a value to make an instance.
     * @return a {@code TypeBool}.
     */
    public TypeBool getTypeBool(boolean value) {
        int hashValue = hash(value);
        if (!createdBooleans.containsKey(hashValue)) {
            createdBooleans.put(hashValue, new TypeBool(value));
        }
        return createdBooleans.get(hashValue);
    }
}
