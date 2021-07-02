package cl.uchile.dcc.scrabble.model.factories.types_factories;

import cl.uchile.dcc.scrabble.model.factories.AbstractGeneralTypeFactory;
import cl.uchile.dcc.scrabble.model.types.TypeInt;
import java.util.HashMap;

/**
 * Factory of {@code TypeInt}. In order to save RAM memory, use this factory. Only exists an unique
 * instance of this factory, to centralize the created instances.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/20 21:03
 * @see TypeInt
 */
public class TypeIntFactory extends AbstractGeneralTypeFactory {

    /**
     * To use singleton pattern
     */
    private static TypeIntFactory uniqueInstance;

    /**
     * Constructor.
     */
    private TypeIntFactory() {
        super(new HashMap<>());
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
     * Returns a {@code TypeInt} with the same value in {@code instance}.
     *
     * @param instance an instance.
     * @return a {@code TypeInt} instance.
     */
    public TypeInt create(TypeInt instance) {
        return (TypeInt) super.createWithKey(instance.getValue(), instance);
    }

    /**
     * Returns a {@code TypeInt} with the {@code value} as value.
     *
     * @param value a value to make an instance.
     * @return a {@code TypeInt}.
     */
    public TypeInt create(int value) {
        return create(new TypeInt(value));
    }

}
