package cl.uchile.dcc.scrabble.model.types.abstract_types;

import cl.uchile.dcc.scrabble.model.factories.types_factories.STypeFactory;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.interfaces.HInteger;
import cl.uchile.dcc.scrabble.model.types.TypeBinary;
import cl.uchile.dcc.scrabble.model.types.TypeInt;
import cl.uchile.dcc.scrabble.model.types.interface_types.SInteger;

/**
 * An abstract class for numbers that are like integers (e.g.: TypeInt and TypeBinary).
 * @author Francisco Muñoz Guajardo
 */
public abstract class AbstractInteger
    extends AbstractNumber implements SInteger {

    /**
     * Default constructor.
     *
     * @param adaptee the current value as int.
     */
    protected AbstractInteger(HInteger adaptee) {
        super(adaptee);
    }

    /**
     * Transform the current {@code SType} as a {@code HType}.
     *
     * @return a transformation
     */
    @Override
    public HInteger asHType() {
        return (HInteger) super.asHType();
    }

    /**
     * Returns the value as {@code int}.
     *
     * @return the current value as {@code int}
     */
    @Override
    public final int getValueAsInt() {
        return this.asHType().getValueAsInt();
    }

    /**
     * Returns the value as binary.
     *
     * @return the current value as binary
     */
    @Override
    public final String getValueAsBinary() {
        return this.asHType().getValueAsBinary();
    }

    /**
     * Transforms the current type to a {@code TypeBinary}.
     *
     * @return {@code TypeBinary} with a value equivalent to the current type.
     */
    @Override
    public final TypeBinary toTypeBinary() {
        return STypeFactory.createTypeBinary(this.getValueAsBinary());
    }

    /**
     * Transforms the current type to a {@code TypeInt}.
     *
     * @return {@code TypeInt} with a value equivalent to the current type.
     */
    @Override
    public final TypeInt toTypeInt() {
        return STypeFactory.createTypeInt(this.getValueAsInt());
    }
}
