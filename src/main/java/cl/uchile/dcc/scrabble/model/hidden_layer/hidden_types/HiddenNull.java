package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types;

import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.interfaces.HBinary;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.interfaces.HBool;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.interfaces.HFloat;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.interfaces.HInt;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.interfaces.HString;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.types_bridge.HiddenNullBridge;
import cl.uchile.dcc.scrabble.model.types.TypeBinary;
import cl.uchile.dcc.scrabble.model.types.TypeBool;
import cl.uchile.dcc.scrabble.model.types.TypeFloat;
import cl.uchile.dcc.scrabble.model.types.TypeInt;
import cl.uchile.dcc.scrabble.model.types.TypeString;
import cl.uchile.dcc.scrabble.model.types.interface_types.SInteger;
import cl.uchile.dcc.scrabble.model.types.interface_types.SLogical;
import cl.uchile.dcc.scrabble.model.types.interface_types.SNumber;
import cl.uchile.dcc.scrabble.model.types.interface_types.SType;
import java.util.HashMap;

/**
 * A null type for {@code HType}. To use Null-Object pattern.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/26 14:20
 */
public class HiddenNull implements HBinary, HBool, HFloat, HInt, HString {

    /**
     * To use Singleton pattern
     */
    private static HiddenNull uniqueInstance;
    private final HiddenNullBridge bridge;

    /**
     * Private constructor to avoid multiples instances
     */
    private HiddenNull() {
        this.bridge = new HiddenNullBridge(this);
    }

    @Override
    public String toString() {
        return "HiddenNull{}";
    }

    /**
     * Returns the unique {@code HiddenNull} instance.
     *
     * @return the {@code HiddenNull} instance
     */
    public static HiddenNull getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new HiddenNull();
            return uniqueInstance;
        }
        return uniqueInstance;
    }

    /**
     * Returns the visitor
     *
     * @return a visitor
     */
    @Override
    public HiddenNullBridge getBridge() {
        return bridge;
    }

    /**
     * Returns the value
     *
     * @return the value in the object
     */
    @Override
    public Object getValue() {
        return null;
    }

    /**
     * Gets the current instance in the wrapper
     *
     * @return the instance in the wrapper
     */
    @Override
    public SType asSType() {
        return null;
    }

    /**
     * Returns the {@code SType} as String
     *
     * @return the {@code SType} as String
     */
    @Override
    public String sTypeAsString() {
        return null;
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
        return 0;
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     *
     * @param obj the reference object with which to compare.
     * @return {@code true} if this object is the same as the obj argument; {@code false} otherwise.
     * @see #hashCode()
     * @see HashMap
     */
    @Override
    public boolean equals(Object obj) {
        return obj instanceof HiddenNull;
    }

    /**
     * Returns the {@code String} representation of the current {@code HiddenAST}.
     *
     * @param space number of spaces to ident
     * @return the current {@code HiddenAST} as {@code String}
     */
    @Override
    public String asString(int space) {
        String tab = " ".repeat(space);
        return tab + "null";
    }

    /**
     * Gets the value as binary
     *
     * @return the value as binary
     */
    @Override
    public String getValueAsBinary() {
        return null;
    }

    /**
     * Gets the value as a {@code SInteger}
     *
     * @return the value as a {@code SInteger}
     */
    @Override
    public SInteger asSInteger() {
        return null;
    }

    /**
     * Gets the value as int
     *
     * @return Gets the value as int
     */
    @Override
    public int getValueAsInt() {
        return 0;
    }

    /**
     * Gets the value as a {@code SNumber}
     *
     * @return the value as a {@code SNumber}
     */
    @Override
    public SNumber asSNumber() {
        return null;
    }

    /**
     * Get value as double
     *
     * @return Get value as double
     */
    @Override
    public double getValueAsDouble() {
        return 0;
    }

    /**
     * Returns the value as a {@code TypeBinary}
     *
     * @return the value as a {@code TypeBinary}
     */
    @Override
    public TypeBinary asTypeBinary() {
        return null;
    }

    /**
     * Gets the value as a {@code SLogical}
     *
     * @return the value as a {@code SLogical}
     */
    @Override
    public SLogical asSLogical() {
        return null;
    }

    /**
     * Returns the value as a {@code TypeBool}
     *
     * @return the value as a {@code TypeBool}
     */
    @Override
    public TypeBool asTypeBool() {
        return null;
    }

    /**
     * Returns the value as a {@code TypeFloat}
     *
     * @return the value as a {@code TypeFloat}
     */
    @Override
    public TypeFloat asTypeFloat() {
        return null;
    }

    /**
     * Returns the value as a {@code TypeInt}
     *
     * @return the value as a {@code TypeInt}
     */
    @Override
    public TypeInt asTypeInt() {
        return null;
    }

    /**
     * Returns the value as a {@code TypeString}
     *
     * @return the value as a {@code TypeString}
     */
    @Override
    public TypeString asTypeString() {
        return null;
    }
}
