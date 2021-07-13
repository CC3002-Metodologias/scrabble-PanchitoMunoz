package cl.uchile.dcc.scrabble.model.factories.hidden_factories;

import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HiddenString;
import cl.uchile.dcc.scrabble.model.types.TypeString;
import java.util.HashMap;

/**
 * Factory of {@code HiddenString}. In order to save RAM memory, use this factory. Only exists an
 * unique instance of this factory, to centralize the created instances.
 *
 * @see HiddenString
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/22 22:05
 */
public class HiddenStringFactory extends AbstractHTypeFactory {

    /**
     * To use singleton pattern
     */
    private static HiddenStringFactory uniqueInstance;

    /**
     * Constructor.
     */
    private HiddenStringFactory() {
        super(new HashMap<>());
    }

    /**
     * Returns the unique instance of the factory.
     *
     * @return the instance of the factory
     */
    public static HiddenStringFactory getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new HiddenStringFactory();
        }
        return uniqueInstance;
    }

    /**
     * Returns a {@code HiddenString} with the same value in {@code instance}.
     *
     * @param instance an instance of {@code HiddenString}.
     * @return a {@code HiddenString} instance.
     */
    public HiddenString create(HiddenString instance) {
        return (HiddenString) super.createWithKey(instance.asSType().getValue(), instance);
    }

    /**
     * Returns a {@code HiddenString} with the same value in {@code instance}.
     *
     * @param instance an instance of {@code TypeString}.
     * @return a {@code HiddenString} instance.
     */
    public HiddenString create(TypeString instance) {
        return create(new HiddenString(instance));
    }

    /**
     * Returns a {@code HiddenString} with the same {@code value} as value.
     *
     * @param value a value.
     * @return a {@code HiddenString} instance.
     */
    public HiddenString create(String value) {
        return create(new HiddenString(value));
    }

}
