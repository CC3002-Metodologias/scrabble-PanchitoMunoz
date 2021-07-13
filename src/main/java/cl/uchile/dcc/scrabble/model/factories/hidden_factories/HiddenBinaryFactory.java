package cl.uchile.dcc.scrabble.model.factories.hidden_factories;

import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HiddenBinary;
import cl.uchile.dcc.scrabble.model.types.TypeBinary;
import java.util.HashMap;

/**
 * Factory of {@code HiddenBinary}. In order to save RAM memory, use this factory. Only exists an
 * unique instance of this factory, to centralize the created instances.
 *
 * @see HiddenBinary
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/22 22:02
 */
public class HiddenBinaryFactory extends AbstractHTypeFactory {

    /**
     * To use singleton pattern
     */
    private static HiddenBinaryFactory uniqueInstance;

    /**
     * Constructor.
     */
    private HiddenBinaryFactory() {
        super(new HashMap<>());
    }

    /**
     * Returns the unique instance of the factory.
     *
     * @return the instance of the factory
     */
    public static HiddenBinaryFactory getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new HiddenBinaryFactory();
        }
        return uniqueInstance;
    }

    /**
     * Returns a {@code HiddenBinary} with the same value in {@code instance}.
     *
     * @param instance an instance of {@code HiddenBinary}.
     * @return a {@code HiddenBinary} instance.
     */
    public HiddenBinary create(HiddenBinary instance) {
        return (HiddenBinary) super.createWithKey(instance.toSType().getValueAsInt(), instance);
    }

    /**
     * Returns a {@code HiddenBinary} with the same value in {@code instance}.
     *
     * @param instance an instance of {@code TypeBinary}.
     * @return a {@code HiddenBinary} instance.
     */
    public HiddenBinary create(TypeBinary instance) {
        return create(new HiddenBinary(instance));
    }

    /**
     * Returns a {@code HiddenBinary} with the same {@code value} as value.
     *
     * @param value a value.
     * @return a {@code HiddenBinary} instance.
     */
    public HiddenBinary create(String value) {
        return create(new HiddenBinary(value));
    }

}
