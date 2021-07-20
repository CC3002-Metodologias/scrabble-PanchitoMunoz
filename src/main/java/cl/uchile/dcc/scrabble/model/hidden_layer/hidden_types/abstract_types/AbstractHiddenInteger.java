package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.abstract_types;

import cl.uchile.dcc.scrabble.model.factories.hidden_factories.HTypeFactory;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HType;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.interfaces.HInteger;
import cl.uchile.dcc.scrabble.model.types.interface_types.SInteger;
import cl.uchile.dcc.scrabble.model.types.interface_types.SNumber;

/**
 * todo: doc
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/07/13 15:33
 */
public abstract class AbstractHiddenInteger extends AbstractHiddenNumber implements HInteger {

    /**
     * Constructor
     *
     * @param adaptee a {@code SType}
     */
    protected AbstractHiddenInteger(
        SNumber adaptee) {
        super(adaptee);
    }

    /**
     * Gets the current instance in the wrapper
     *
     * @return the instance in the wrapper
     */
    @Override
    public abstract SInteger asSType();

    /**
     * Value as Int
     *
     * @return Value as Int
     */
    @Override
    public int getValueAsInt() {
        return this.asSType().getValueAsInt();
    }

    /**
     * Value as Binary
     *
     * @return Value as Binary
     */
    public String getValueAsBinary() {
        return this.asSType().getValueAsBinary();
    }

    /**
     * Transform the current instance to a {@code HiddenBinary}.
     *
     * @return a {@code HiddenBinary} equivalent
     */
    @Override
    public final HType toHiddenBinary() {
        String computed = this.getValueAsBinary();
        return HTypeFactory.createHiddenBinary(computed);
    }

    /**
     * Transform the current instance to a {@code HiddenInt}.
     *
     * @return a {@code HiddenInt} equivalent
     */
    @Override
    public final HType toHiddenInt() {
        int computed = this.getValueAsInt();
        return HTypeFactory.createHiddenInt(computed);
    }
}
