package cl.uchile.dcc.scrabble.model.types.abstract_types;

import cl.uchile.dcc.scrabble.model.ast.builders.interfaces.IntegerASTBuilder;
import cl.uchile.dcc.scrabble.model.factories.types_factories.STypeFactory;
import cl.uchile.dcc.scrabble.model.types.TypeBinary;
import cl.uchile.dcc.scrabble.model.types.TypeInt;
import cl.uchile.dcc.scrabble.model.types.interface_types.SInteger;
import cl.uchile.dcc.scrabble.model.utils.BinaryUtilities;

/**
 * An abstract class for numbers that are like integers (e.g.: TypeInt and TypeBinary).
 * @author Francisco Muñoz Guajardo
 */
public abstract class AbstractInteger
    extends AbstractNumber implements SInteger {

    private final int valueAsInt;
    private final String valueAsBinary;

    /**
     * Default constructor.
     *
     * @param valueAsInt the current value as int.
     */
    protected AbstractInteger(int valueAsInt) {
        this.valueAsInt = valueAsInt;
        this.valueAsBinary = BinaryUtilities.intToBinary(valueAsInt);
    }

    /**
     * Returns the value as {@code int}.
     *
     * @return the current value as {@code int}
     */
    protected int getValueAsInt() {
        return this.valueAsInt;
    }

    /**
     * Returns the value as binary.
     *
     * @return the current value as binary
     */
    protected String getValueAsBinary() {
        return this.valueAsBinary;
    }

    /**
     * Returns the value as {@code double}.
     *
     * @return the current value as {@code double}
     */
    @Override
    protected final double getValueAsDouble() {
        return this.getValueAsInt();
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
