package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.abstract_types;

import cl.uchile.dcc.scrabble.model.factories.hidden_factories.HTypeFactory;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.interfaces.HBinary;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.interfaces.HInt;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.interfaces.HInteger;
import cl.uchile.dcc.scrabble.model.types.interface_types.SInteger;
import cl.uchile.dcc.scrabble.model.utils.BinaryUtilities;

/**
 * An abstract class for a general Integer.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/07/13 15:33
 */
public abstract class AbstractHiddenInteger extends AbstractHiddenNumber implements HInteger {

    private final int valueAsInt;
    private final String valueAsBinary;

    /**
     * Constructor
     *
     * @param value a value as int
     */
    public AbstractHiddenInteger(int value) {
        super(value);
        this.valueAsInt = value;
        this.valueAsBinary = BinaryUtilities.intToBinary(value);
    }

    /**
     * Value as Int
     *
     * @return Value as Int
     */
    @Override
    public int getValueAsInt() {
        return this.valueAsInt;
    }

    /**
     * Value as Binary
     *
     * @return Value as Binary
     */
    public String getValueAsBinary() {
        return this.valueAsBinary;
    }

    /**
     * Transform the current instance to a {@code HiddenBinary}.
     *
     * @return a {@code HiddenBinary} equivalent
     */
    @Override
    public final HBinary toHiddenBinary() {
        String computed = this.getValueAsBinary();
        return HTypeFactory.createHiddenBinary(computed);
    }

    /**
     * Transform the current instance to a {@code HiddenInt}.
     *
     * @return a {@code HiddenInt} equivalent
     */
    @Override
    public final HInt toHiddenInt() {
        int computed = this.getValueAsInt();
        return HTypeFactory.createHiddenInt(computed);
    }

    /**
     * Gets the value as a {@code SInteger}
     *
     * @return the value as a {@code SInteger}
     */
    @Override
    public SInteger asSInteger() {
        return (SInteger) this.asSNumber();
    }
}
