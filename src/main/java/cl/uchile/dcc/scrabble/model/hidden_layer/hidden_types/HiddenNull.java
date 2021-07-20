package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types;

import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.types_bridge.HiddenNullBridge;
import cl.uchile.dcc.scrabble.model.types.interface_types.SType;
import java.util.HashMap;

/**
 * A null type for {@code HType}. To use Null-Object pattern.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/26 14:20
 */
public class HiddenNull implements HType {

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
}
