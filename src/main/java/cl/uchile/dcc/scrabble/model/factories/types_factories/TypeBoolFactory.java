package cl.uchile.dcc.scrabble.model.factories.types_factories;

import cl.uchile.dcc.scrabble.model.factories.AbstractGeneralTypeFactory;
import cl.uchile.dcc.scrabble.model.types.TypeBool;
import java.util.HashMap;

/**
 * Factory of {@code TypeBool}. In order to save RAM memory, use this factory. Only exists an unique
 * instance of this factory, to centralize the created instances.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/20 21:03
 * @see TypeBool
 */
public class TypeBoolFactory extends AbstractSTypeFactory {

    /**
     * To use singleton pattern
     */
    private static TypeBoolFactory uniqueInstance;

    /**
     * Constructor.
     */
    private TypeBoolFactory() {
        super(new HashMap<>());
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
     * Returns a {@code TypeBool} with the same value in {@code instance}.
     *
     * @param instance an instance.
     * @return a {@code TypeBool} instance.
     */
    public TypeBool create(TypeBool instance) {
        return (TypeBool) super.createWithKey(instance.getValue(), instance);
    }

    /**
     * Returns a {@code TypeBool} with the {@code value} as value.
     *
     * @param value a value to make an instance.
     * @return a {@code TypeBool}.
     */
    public TypeBool create(boolean value) {
        return create(new TypeBool(value));
    }
}
