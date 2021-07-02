package cl.uchile.dcc.scrabble.model.factories.types_factories;

import cl.uchile.dcc.scrabble.model.factories.AbstractGeneralTypeFactory;
import cl.uchile.dcc.scrabble.model.types.TypeString;
import java.util.HashMap;

/**
 * Factory of {@code TypeString}. In order to save RAM memory, use this factory. Only exists an
 * unique instance of this factory, to centralize the created instances.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/20 21:03
 * @see TypeString
 */
public class TypeStringFactory extends AbstractGeneralTypeFactory {

    /**
     * To use singleton pattern
     */
    private static TypeStringFactory uniqueInstance;

    /**
     * Constructor.
     */
    private TypeStringFactory() {
        super(new HashMap<>());
    }

    /**
     * Returns the unique instance of the factory.
     *
     * @return the instance of the factory
     */
    public static TypeStringFactory getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new TypeStringFactory();
        }
        return uniqueInstance;
    }

    /**
     * Returns a {@code TypeString} with the same value in {@code instance}.
     *
     * @param instance an instance.
     * @return a {@code TypeString} instance.
     */
    public TypeString create(TypeString instance) {
        return (TypeString) super.createWithKey(instance.getValue(), instance);
    }

    /**
     * Returns a {@code TypeString} with the {@code value} as value.
     *
     * @param value a value to make an instance.
     * @return a {@code TypeString}.
     */
    public TypeString create(String value) {
        return create(new TypeString(value));
    }

}
