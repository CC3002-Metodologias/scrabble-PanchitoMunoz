package cl.uchile.dcc.scrabble.model.factories.hidden_factories;

import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HiddenFloat;
import cl.uchile.dcc.scrabble.model.types.TypeFloat;
import java.util.HashMap;

/**
 * Factory of {@code HiddenFloat}. In order to save RAM memory, use this factory. Only exists an
 * unique instance of this factory, to centralize the created instances.
 *
 * @see HiddenFloat
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/22 22:04
 */
public class HiddenFloatFactory extends AbstractHTypeFactory {

    /**
     * To use singleton pattern
     */
    private static HiddenFloatFactory uniqueInstance;

    /**
     * Constructor.
     */
    private HiddenFloatFactory() {
        super(new HashMap<>());
    }

    /**
     * Returns the unique instance of the factory.
     *
     * @return the instance of the factory
     */
    public static HiddenFloatFactory getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new HiddenFloatFactory();
        }
        return uniqueInstance;
    }

    /**
     * Returns a {@code HiddenFloat} with the same value in {@code instance}.
     *
     * @param instance an instance of {@code HiddenFloat}.
     * @return a {@code HiddenFloat} instance.
     */
    public HiddenFloat create(HiddenFloat instance) {
        return (HiddenFloat) super.createWithKey(instance.asSType().getValue(), instance);
    }

    /**
     * Returns a {@code HiddenFloat} with the same value in {@code instance}.
     *
     * @param instance an instance of {@code TypeFloat}.
     * @return a {@code HiddenFloat} instance.
     */
    public HiddenFloat create(TypeFloat instance) {
        return create(new HiddenFloat(instance));
    }

    /**
     * Returns a {@code HiddenFloat} with the same {@code value} as value.
     *
     * @param value a value.
     * @return a {@code HiddenFloat} instance.
     */
    public HiddenFloat create(double value) {
        return create(new HiddenFloat(value));
    }

}
