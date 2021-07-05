package cl.uchile.dcc.scrabble.model.factories.types_factories;

import cl.uchile.dcc.scrabble.model.factories.AbstractGeneralTypeFactory;
import cl.uchile.dcc.scrabble.model.types.TypeFloat;
import java.util.HashMap;

/**
 * Factory of {@code TypeFloat}. In order to save RAM memory, use this factory. Only exists an
 * unique instance of this factory, to centralize the created instances.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/20 21:03
 * @see TypeFloat
 */
public class TypeFloatFactory extends AbstractSTypeFactory {

    /**
     * To use singleton pattern
     */
    private static TypeFloatFactory uniqueInstance;

    /**
     * Constructor.
     */
    private TypeFloatFactory() {
        super(new HashMap<>());
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
     * Returns a {@code TypeFloat} with the same value in {@code instance}.
     *
     * @param instance an instance.
     * @return a {@code TypeFloat} instance.
     */
    public TypeFloat create(TypeFloat instance) {
        return (TypeFloat) super.createWithKey(instance.getValue(), instance);
    }

    /**
     * Returns a {@code TypeFloat} with the {@code value} as value.
     *
     * @param value a value to make an instance.
     * @return a {@code TypeFloat}.
     */
    public TypeFloat create(double value) {
        return create(new TypeFloat(value));
    }
}
