package cl.uchile.dcc.scrabble.model.factories.types_factories;

import cl.uchile.dcc.scrabble.model.factories.AbstractGeneralTypeFactory;
import cl.uchile.dcc.scrabble.model.types.TypeBinary;
import java.util.HashMap;

/**
 * Factory of {@code TypeBinary}. In order to save RAM memory, use this factory. Only exists an
 * unique instance of this factory, to centralize the created instances.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/20 21:02
 * @see TypeBinary
 */
public class TypeBinaryFactory extends AbstractGeneralTypeFactory {

    /**
     * To use singleton pattern
     */
    private static TypeBinaryFactory uniqueInstance;

    /**
     * Constructor.
     */
    private TypeBinaryFactory() {
        super(new HashMap<>());
    }

    /**
     * Returns the unique instance of the factory.
     *
     * @return the instance of the factory
     */
    public static TypeBinaryFactory getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new TypeBinaryFactory();
        }
        return uniqueInstance;
    }

    /**
     * Returns a {@code TypeBinary} with the same value in {@code instance}.
     *
     * @param instance an instance.
     * @return a {@code TypeBinary} instance.
     */
    public TypeBinary create(TypeBinary instance) {
        return (TypeBinary) super.createWithKey(instance.getValueAsInt(), instance);
    }

    /**
     * Returns a {@code TypeBinary} with the {@code value} as value.
     *
     * @param value a value to make an instance.
     * @return a {@code TypeBinary}.
     */
    public TypeBinary create(String value) {
        return create(new TypeBinary(value));
    }
}
