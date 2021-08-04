package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types;

import cl.uchile.dcc.scrabble.model.factories.types_factories.STypeFactory;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.abstract_types.AbstractHiddenType;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.interfaces.HString;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_visitors.HiddenVisitor;
import cl.uchile.dcc.scrabble.model.hidden_layer.types_bridge.HiddenStringBridge;
import cl.uchile.dcc.scrabble.model.types.TypeString;
import java.util.HashMap;

/**
 * A class to represent a String. To be adapted by {@code TypeString}.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/12 23:57
 * @see TypeString
 */
public class HiddenString extends AbstractHiddenType implements HString {

    private final String value;
    private final HiddenStringBridge bridge;

    /**
     * Constructor.
     *
     * @param typeString a type string.
     */
    public HiddenString(TypeString typeString) {
        this(typeString.getValueAsString());
    }

    /**
     * Constructor.
     *
     * @param value a string
     */
    public HiddenString(String value) {
        this.value = value;
        this.bridge = new HiddenStringBridge(this);
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
        if (!(o instanceof HiddenString)) {
            return false;
        }

        HiddenString that = (HiddenString) o;

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
     * Method that accepts a {@code HiddenVisitor}.
     *
     * @param visitor a {@code HiddenVisitor}.
     */
    @Override
    public void accept(HiddenVisitor visitor) {
        visitor.visitHiddenString(this);
    }

    /**
     * Returns the code representation.
     *
     * @param space the number of space of indentation.
     * @return a code representation
     */
    @Override
    public String asCode(int space) {
        String tab = " ".repeat(space);
        return tab + '\"' + super.asCode(0) + '\"';
    }

    /**
     * Returns the visitor
     *
     * @return a visitor
     */
    @Override
    public HiddenStringBridge getBridge() {
        return bridge;
    }

    /**
     * Returns the value
     *
     * @return the value in the object
     */
    @Override
    public String getValue() {
        return this.getValueAsString();
    }

    /**
     * Value as String
     *
     * @return Value as String
     */
    @Override
    public String getValueAsString() {
        return this.value;
    }

    /**
     * Gets the current instance in the wrapper
     *
     * @return the instance in the wrapper
     */
    @Override
    public TypeString asSType() {
        return STypeFactory.createTypeString(this.getValueAsString());
    }

    @Override
    public String toString() {
        return "HiddenString{" +
            "value='" + this.getValueAsString() + '\'' +
            '}';
    }

    /**
     * Returns the sum
     *
     * @param hType other type to sum
     * @return the sum
     */
    @Override
    public HString add(HType hType) {
        return hType.getBridge().addWithString(this);
    }

    /**
     * Returns the {@code SType} as String
     *
     * @return the {@code SType} as String
     */
    @Override
    public String sTypeAsString() {
        return "TypeString{value='" + this.getValueAsString() + "'}";
    }

    /**
     * Returns the value as a {@code TypeString}
     *
     * @return the value as a {@code TypeString}
     */
    @Override
    public TypeString asTypeString() {
        return this.asSType();
    }
}
