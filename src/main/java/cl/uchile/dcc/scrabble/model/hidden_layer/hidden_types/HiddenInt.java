package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types;

import cl.uchile.dcc.scrabble.model.factories.types_factories.STypeFactory;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.abstract_types.AbstractHiddenInteger;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.types_bridge.HiddenIntBridge;
import cl.uchile.dcc.scrabble.model.types.TypeInt;
import java.util.HashMap;

// TODO: trasladar la lógica de las operaciones aquí y dejar SType como un adaptador
/**
 * A class to wrap a {@code TypeInt}. To use adapter pattern.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/13 0:02
 * @see TypeInt
 */
public class HiddenInt extends AbstractHiddenInteger {

    private final HiddenIntBridge bridge;

    /**
     * Constructor.
     *
     * @param typeInt a type int
     */
    public HiddenInt(TypeInt typeInt) {
        this(typeInt.getValueAsInt());
    }

    /**
     * Constructor.
     *
     * @param value an int
     */
    public HiddenInt(int value) {
        super(value);
        this.bridge = new HiddenIntBridge(this);
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
        if (!(o instanceof HiddenInt)) {
            return false;
        }

        HiddenInt hiddenInt = (HiddenInt) o;

        return getValue().equals(hiddenInt.getValue());
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
        return getValue();
    }

    /**
     * Returns the visitor
     *
     * @return a visitor
     */
    @Override
    public HiddenIntBridge getBridge() {
        return bridge;
    }

    /**
     * Returns the value
     *
     * @return the value in the object
     */
    @Override
    public Integer getValue() {
        return this.getValueAsInt();
    }

    /**
     * Value as String
     *
     * @return Value as String
     */
    @Override
    public String getValueAsString() {
        return Integer.toString(this.getValueAsInt());
    }

    /**
     * Gets the current instance in the wrapper
     *
     * @return the instance in the wrapper
     */
    @Override
    public TypeInt asSType() {
        return STypeFactory.createTypeInt(this.getValueAsInt());
    }

    @Override
    public String toString() {
        return "HiddenInt{" +
            "value=" + this.getValueAsInt() +
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
        return hType.getBridge().addWithInt(this);
    }

    /**
     * Returns the division between numbers
     *
     * @param hType another number
     * @return the division
     */
    @Override
    public HType div(HType hType) {
        return hType.getBridge().divWithInt(this);
    }

    /**
     * Returns the multiplication between numbers
     *
     * @param hType another number
     * @return the multiplication
     */
    @Override
    public HType mult(HType hType) {
        return hType.getBridge().multWithInt(this);
    }

    /**
     * Returns the subtraction between numbers
     *
     * @param hType another number
     * @return the subtraction
     */
    @Override
    public HType sub(HType hType) {
        return hType.getBridge().subWithInt(this);
    }
}
