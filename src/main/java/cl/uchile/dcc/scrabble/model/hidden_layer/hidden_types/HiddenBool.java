package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types;

import cl.uchile.dcc.scrabble.model.factories.hidden_factories.HTypeFactory;
import cl.uchile.dcc.scrabble.model.factories.types_factories.STypeFactory;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.abstract_types.AbstractHiddenType;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.interfaces.HBool;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.interfaces.HLogical;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.types_bridge.HiddenBoolBridge;
import cl.uchile.dcc.scrabble.model.types.TypeBool;
import cl.uchile.dcc.scrabble.model.types.interface_types.SLogical;
import java.util.HashMap;

/**
 * A class to represent a Bool. To be adapted by {@code TypeBool}.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/13 0:00
 * @see TypeBool
 */
public class HiddenBool extends AbstractHiddenType implements HLogical, HBool {

    private final boolean value;
    private final HiddenBoolBridge bridge;

    public HiddenBool(boolean value) {
        this.value = value;
        this.bridge = new HiddenBoolBridge(this);
    }

    /**
     * Constructor.
     *
     * @param typeBool a type bool
     */
    public HiddenBool(TypeBool typeBool) {
        this(typeBool.getValue());
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
        if (!(o instanceof HiddenBool)) {
            return false;
        }

        HiddenBool that = (HiddenBool) o;

        return getValue() == that.getValue();
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
        return (getValue() ? 1 : 0);
    }

    /**
     * Value as Boolean
     *
     * @return Value as Boolean
     */
    public Boolean getValueAsBool() {
        return this.value;
    }

    /**
     * Value as String
     *
     * @return Value as String
     */
    @Override
    public String getValueAsString() {
        return Boolean.toString(this.getValueAsBool());
    }

    /**
     * Returns the value
     *
     * @return the value in the object
     */
    @Override
    public Boolean getValue() {
        return this.getValueAsBool();
    }

    /**
     * Returns the visitor
     *
     * @return a visitor
     */
    @Override
    public HiddenBoolBridge getBridge() {
        return bridge;
    }

    /**
     * Gets the current instance in the wrapper
     *
     * @return the instance in the wrapper
     */
    @Override
    public TypeBool asSType() {
        return STypeFactory.createTypeBool(this.getValueAsBool());
    }

    @Override
    public String toString() {
        return "HiddenBool{" +
            "value=" + this.getValueAsBool() +
            '}';
    }

    /**
     * Transform the current instance to a {@code HiddenBool}.
     *
     * @return a {@code HiddenBool} equivalent
     */
    @Override
    public HType toHiddenBool() {
        return HTypeFactory.createHiddenBool(this.getValueAsBool());
    }

    /**
     * Returns the disjunction between logicals
     *
     * @param hType another logical
     * @return the disjunction
     */
    @Override
    public HLogical and(HType hType) {
        return hType.getBridge().andWithBool(this);
    }

    /**
     * Returns the conjunction between logicals
     *
     * @param hType another logical
     * @return the conjunction
     */
    @Override
    public HLogical or(HType hType) {
        return hType.getBridge().orWithBool(this);
    }

    /**
     * Returns the negation of the current instance
     *
     * @return the negation.
     */
    @Override
    public HiddenBool neg() {
        return HTypeFactory.createHiddenBool(!this.getValueAsBool());
    }

    /**
     * Returns the {@code SType} as String
     *
     * @return the {@code SType} as String
     */
    @Override
    public String sTypeAsString() {
        return "TypeBool{value=" + this.getValueAsBool() + "}";
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

    /**
     * Returns the value as a {@code TypeBool}
     *
     * @return the value as a {@code TypeBool}
     */
    @Override
    public TypeBool asTypeBool() {
        return this.asSType();
    }
}
