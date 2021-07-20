package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types;

import cl.uchile.dcc.scrabble.model.factories.types_factories.STypeFactory;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.abstract_types.AbstractHiddenType;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.types_bridge.HiddenStringBridge;
import cl.uchile.dcc.scrabble.model.types.TypeString;
import java.util.HashMap;

// TODO: trasladar la lógica de las operaciones aquí y dejar SType como un adaptador
/**
 * A class to wrap a {@code TypeString}. To use adapter pattern.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/12 23:57
 * @see TypeString
 */
public class HiddenString extends AbstractHiddenType {

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
    public HType add(HType hType) {
        return hType.getBridge().addWithString(this);
    }
}
