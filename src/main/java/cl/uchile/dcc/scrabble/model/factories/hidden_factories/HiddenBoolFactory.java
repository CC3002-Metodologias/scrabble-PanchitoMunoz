package cl.uchile.dcc.scrabble.model.factories.hidden_factories;

import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HiddenBool;
import cl.uchile.dcc.scrabble.model.types.TypeBool;
import java.util.HashMap;

/**
 * Factory of {@code HiddenBool}. In order to save RAM memory, use this factory. Only exists an
 * unique instance of this factory, to centralize the created instances.
 *
 * @see HiddenBool
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/22 22:03
 */
public class HiddenBoolFactory extends AbstractHTypeFactory {

    /**
     * To use singleton pattern
     */
    private static HiddenBoolFactory uniqueInstance;

    /**
     * Constructor.
     */
    private HiddenBoolFactory() {
        super(new HashMap<>());
    }

    /**
     * Returns the unique instance of the factory.
     *
     * @return the instance of the factory
     */
    public static HiddenBoolFactory getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new HiddenBoolFactory();
        }
        return uniqueInstance;
    }

    /**
     * Returns a {@code HiddenBool} with the same value in {@code instance}.
     *
     * @param instance an instance of {@code HiddenBool}.
     * @return a {@code HiddenBool} instance.
     */
    public HiddenBool create(HiddenBool instance) {
        return (HiddenBool) super.createWithKey(instance.asSType().getValue(), instance);
    }

    /**
     * Returns a {@code HiddenBool} with the same value in {@code instance}.
     *
     * @param instance an instance of {@code TypeBool}.
     * @return a {@code HiddenBool} instance.
     */
    public HiddenBool create(TypeBool instance) {
        return create(new HiddenBool(instance));
    }

    /**
     * Returns a {@code HiddenBool} with the same {@code value} as value.
     *
     * @param value a value.
     * @return a {@code HiddenBool} instance.
     */
    public HiddenBool create(boolean value) {
        return create(new HiddenBool(value));
    }

}
