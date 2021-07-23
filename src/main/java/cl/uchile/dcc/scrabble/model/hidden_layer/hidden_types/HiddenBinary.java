package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types;

import cl.uchile.dcc.scrabble.model.factories.hidden_factories.HTypeFactory;
import cl.uchile.dcc.scrabble.model.factories.types_factories.STypeFactory;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.abstract_types.AbstractHiddenInteger;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.interfaces.HBinary;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.interfaces.HLogical;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.types_bridge.HiddenBinaryBridge;
import cl.uchile.dcc.scrabble.model.types.TypeBinary;
import cl.uchile.dcc.scrabble.model.types.interface_types.SLogical;
import cl.uchile.dcc.scrabble.model.utils.BinaryUtilities;
import java.util.HashMap;

/**
 * A class to represent a Binary. To be adapted by {@code TypeBinary}.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/13 0:01
 * @see TypeBinary
 */
public class HiddenBinary extends AbstractHiddenInteger implements HLogical, HBinary {

    private final HiddenBinaryBridge bridge;

    /**
     * Constructor.
     *
     * @param typeBinary a Type Binary
     */
    public HiddenBinary(TypeBinary typeBinary) {
        this(typeBinary.getValueAsBinary());
    }

    /**
     * Constructor
     *
     * @param value a string binary
     */
    public HiddenBinary(String value) {
        super(BinaryUtilities.binaryToInt(value));
        this.bridge = new HiddenBinaryBridge(this);
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     *
     * @param o the reference object with which to compare.
     * @return {@code true} if this object is the same as the obj argument; {@code false} otherwise.
     * @see #hashCode()
     * @see HashMap
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof HiddenBinary)) {
            return false;
        }

        HiddenBinary that = (HiddenBinary) o;

        return getValue().equals(that.getValue());
    }

    /**
     * Returns a hash code value for the object.
     *
     * @return a hash code value for this object.
     * @see Object#equals(Object)
     * @see System#identityHashCode
     */
    @Override
    public int hashCode() {
        return getValue().hashCode();
    }

    /**
     * Returns the visitor
     *
     * @return a visitor
     */
    @Override
    public HiddenBinaryBridge getBridge() {
        return bridge;
    }

    /**
     * Returns the value
     *
     * @return the value in the object
     */
    @Override
    public String getValue() {
        return this.getValueAsBinary();
    }

    /**
     * Value as String
     *
     * @return Value as String
     */
    @Override
    public String getValueAsString() {
        return this.getValueAsBinary();
    }

    /**
     * Gets the current instance in the wrapper
     *
     * @return the instance in the wrapper
     */
    @Override
    public TypeBinary asSType() {
        return STypeFactory.createTypeBinary(this.getValueAsBinary());
    }

    @Override
    public String toString() {
        return "HiddenBinary{" +
            "value=" + this.getValueAsBinary() +
            '}';
    }

    /**
     * Returns the sum
     *
     * @param hType other type to sum
     * @return the sum
     */
    @Override
    public HType add(HType hType) {
        return hType.getBridge().addWithBinary(this);
    }

    /**
     * Returns the disjunction between logicals
     *
     * @param hType another logical
     * @return the disjunction
     */
    @Override
    public HType and(HType hType) {
        return hType.getBridge().andWithBinary(this);
    }

    /**
     * Returns the division between numbers
     *
     * @param hType another number
     * @return the division
     */
    @Override
    public HType div(HType hType) {
        return hType.getBridge().divWithBinary(this);
    }

    /**
     * Returns the multiplication between numbers
     *
     * @param hType another number
     * @return the multiplication
     */
    @Override
    public HType mult(HType hType) {
        return hType.getBridge().multWithBinary(this);
    }

    /**
     * Returns the conjunction between logicals
     *
     * @param hType another logical
     * @return the conjunction
     */
    @Override
    public HType or(HType hType) {
        return hType.getBridge().orWithBinary(this);
    }

    /**
     * Returns the subtraction between numbers
     *
     * @param hType another number
     * @return the subtraction
     */
    @Override
    public HType sub(HType hType) {
        return hType.getBridge().subWithBinary(this);
    }

    /**
     * Returns the negation of the current instance
     *
     * @return the negation.
     */
    @Override
    public HType neg() {
        return HTypeFactory.createHiddenBinary(
            BinaryUtilities.oneComplement(this.getValueAsBinary()));
    }

    /**
     * Returns the {@code SType} as String
     *
     * @return the {@code SType} as String
     */
    @Override
    public String sTypeAsString() {
        return "TypeBinary{value=" + this.getValueAsBinary() + "}";
    }

    /**
     * Returns the value as a {@code TypeBinary}
     *
     * @return the value as a {@code TypeBinary}
     */
    @Override
    public TypeBinary asTypeBinary() {
        return this.asSType();
    }

    /**
     * Gets the value as a {@code SLogical}
     *
     * @return the value as a {@code SLogical}
     */
    @Override
    public SLogical asSLogical() {
        return this.asSType();
    }
}
